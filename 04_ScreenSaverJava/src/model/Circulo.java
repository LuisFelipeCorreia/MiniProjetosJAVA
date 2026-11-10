package model;

import java.awt.Color;
import java.awt.Graphics2D;

// Herança: Circulo herda de Forma
public class Circulo extends Forma {
    private int raio;
    private int velX;
    private int velY;

    public Circulo(int x, int y, int raio, Color cor, int velX, int velY) {
        super(x, y, cor);
        this.raio = raio;
        this.velX = velX;
        this.velY = velY;
    }

    public void moverAutomatizado(int limiteLargura, int limiteAltura) {
        x += velX;
        y += velY;
        
        // Rebater nas bordas
        if (x <= 0 || x + (raio * 2) >= limiteLargura) velX *= -1;
        if (y <= 0 || y + (raio * 2) >= limiteAltura) velY *= -1;
    }

    // Polimorfismo: reescrita do método desenhar
    @Override
    public void desenhar(Graphics2D g2d) {
        g2d.setColor(cor);
        g2d.fillOval(x, y, raio * 2, raio * 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void inverterVelocidadeX() {
        this.velX = Math.abs(this.velX); // Rebate para a direita
    }
}