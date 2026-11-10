package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Forma {
    // Encapsulamento: atributos protegidos para acesso pelas subclasses
    protected int x;
    protected int y;
    protected Color cor;

    public Forma(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    // Abstração: método que obriga as subclasses a implementarem como se desenham
    public abstract void desenhar(Graphics2D g2d);
}