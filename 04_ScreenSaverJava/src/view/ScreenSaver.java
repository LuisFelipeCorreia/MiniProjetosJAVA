package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.*;

public class ScreenSaver extends JFrame {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int DELAY_MS = 16; 

    private ScreenSaverPanel canvas;

    public ScreenSaver() {
        super("Atividade 05 - Desafio Final: Pong Game");

        this.canvas = new ScreenSaverPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(canvas);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void start() {
        this.setVisible(true);
        this.canvas.startAnimation();
        this.canvas.requestFocusInWindow();
    }

    private class ScreenSaverPanel extends JPanel implements ActionListener {

        private Timer timer;

        // Entidades do jogo (Herança / Polimorfismo)
        private Circulo bola;
        private Retangulo raquete;

        // Controle de Estado do Jogo
        private int pontuacao = 0;
        private int vidas = 3;
        private boolean gameOver = false;

        // Teclas
        private boolean up = false;
        private boolean down = false;

        public ScreenSaverPanel() {
            this.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
            this.setBackground(Color.BLACK);
            this.setFocusable(true);

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;

                    // Reiniciar jogo se der Game Over
                    if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
                        reiniciarJogo();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
                }
            });

            this.reiniciarJogo();
            this.timer = new Timer(DELAY_MS, this);
        }

        private void reiniciarJogo() {
            this.bola = new Circulo(400, 300, 15, Color.GREEN, 5, 5);
            this.raquete = new Retangulo(30, 250, 15, 100, Color.BLUE, 7);
            this.pontuacao = 0;
            this.vidas = 3;
            this.gameOver = false;
        }

        public void startAnimation() {
            this.timer.start();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameOver) {
                // Movimenta bola
                bola.moverAutomatizado(CANVAS_WIDTH, CANVAS_HEIGHT);

                // Movimenta raquete do jogador
                raquete.moverControlado(up, down, false, false, CANVAS_WIDTH, CANVAS_HEIGHT);

                // Lógica de colisão entre bola e raquete
                if (bola.getX() <= raquete.getX() + 15 && 
                    bola.getY() + 30 >= raquete.getY() && 
                    bola.getY() <= raquete.getY() + 100) {
                    
                    bola.inverterVelocidadeX(); // Rebate a bola
                    pontuacao += 10;            // Ganha pontos
                }

                // Perdeu vida (bola passou da raquete no lado esquerdo)
                if (bola.getX() <= 0) {
                    vidas--;
                    if (vidas <= 0) {
                        gameOver = true;
                    } else {
                        // Reposiciona bola no meio
                        bola = new Circulo(400, 300, 15, Color.GREEN, 5, 5);
                    }
                }
            }

            this.repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Desenha as formas reutilizando o Polimorfismo
            this.bola.desenhar(g2d);
            this.raquete.desenhar(g2d);

            // Interface do Usuário (HUD / Feedback Visual)
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            g2d.drawString("Pontuação: " + pontuacao, 20, 30);
            g2d.drawString("Vidas: " + vidas, 680, 30);

            // Tela de Game Over
            if (gameOver) {
                g2d.setColor(Color.RED);
                g2d.setFont(new Font("Arial", Font.BOLD, 40));
                g2d.drawString("GAME OVER", 280, 280);
                
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Arial", Font.PLAIN, 20));
                g2d.drawString("Pressione 'R' para Reiniciar", 275, 330);
            }
        }
    }
}