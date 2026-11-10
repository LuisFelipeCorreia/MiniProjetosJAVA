![senai_logo](./src/image/logo.png)

# ScreenSaver em Java (Mini Projeto 4)

Este projeto implementa um "Protetor de Tela" animado utilizando a biblioteca Java Swing. O objetivo principal foi aplicar na prática os quatro pilares da **Programação Orientada a Objetos (POO)**: Abstração, Encapsulamento, Herança e Polimorfismo, modelando formas geométricas animadas.

## 🛠️ Tecnologias Utilizadas
- Java (JDK)
- Java Swing e Graphics2D (Renderização e Interface Gráfica)

## ⚙️ Como executar o projeto

1. Faça o clone deste repositório: `git clone https://github.com/LuisFelipeCorreia/MiniProjetosJAVA.git`
2. Abra a pasta `04_ScreenSaverJava` na sua IDE (VS Code, Eclipse, IntelliJ, etc.).
3. Execute o ficheiro `App.java` (onde se encontra o método `main`).
4. A janela da animação abrirá. Utilize as **setas do teclado** (Cima, Baixo, Esquerda, Direita) para controlar o Retângulo azul, enquanto o Círculo verde se move automaticamente rebatendo nas bordas.

## 🏛️ Os Quatro Pilares da POO no Código

- **Abstração:** A classe `Forma` atua como um molde conceitual. Ela possui o método abstrato `desenhar(Graphics2D)`, que obriga cada formato geométrico específico a definir a sua própria aparência.
- **Encapsulamento:** Os atributos (como posição X/Y, cor, raio e largura) estão protegidos nas classes (usando modificadores `protected` e `private`). Eles não são modificados diretamente pelo arquivo principal, mas sim de forma segura através dos métodos de movimento e construtores.
- **Herança:** As classes `Circulo` e `Retangulo` herdam (`extends`) os atributos base de posição e cor da classe mãe `Forma`, promovendo o reaproveitamento de código.
- **Polimorfismo:** Ambas as subclasses sobrescrevem (`@Override`) o método genérico `desenhar`. Ao chamar `desenhar(g2d)` no laço de repetição do `ScreenSaver`, o Java sabe automaticamente se deve renderizar uma elipse ou um retângulo com base no objeto que está a ser processado.

## 📊 Diagrama de Classes

```mermaid
classDiagram
    class Forma {
        <<abstract>>
        # int x, y
        # Color cor
        + desenhar(Graphics2D g2d)* void
    }
    class Circulo {
        - int raio, velX, velY
        + moverAutomatizado(int limiteLargura, int limiteAltura)
        + desenhar(Graphics2D g2d) void
    }
    class Retangulo {
        - int largura, altura, velocidade
        + moverControlado(boolean up, boolean down, boolean left, boolean right, int limiteLargura, int limiteAltura)
        + desenhar(Graphics2D g2d) void
    }
    
    Forma <|-- Circulo
    Forma <|-- Retangulo