package model;

import java.awt.Color;
import java.awt.Graphics2D;

// Herança: Retangulo herda de Forma
public class Retangulo extends Forma {
    private int largura;
    private int altura;
    private int velocidade;

    public Retangulo(int x, int y, int largura, int altura, Color cor, int velocidade) {
        super(x, y, cor);
        this.largura = largura;
        this.altura = altura;
        this.velocidade = velocidade;
    }

    public void moverControlado(boolean up, boolean down, boolean left, boolean right, int limiteLargura, int limiteAltura) {
        if (up && y > 0) y -= velocidade;
        if (down && y + altura < limiteAltura) y += velocidade;
        if (left && x > 0) x -= velocidade;
        if (right && x + largura < limiteLargura) x += velocidade;
    }

    // Polimorfismo: reescrita do método desenhar
    @Override
    public void desenhar(Graphics2D g2d) {
        g2d.setColor(cor);
        g2d.fillRect(x, y, largura, altura);
    }
}