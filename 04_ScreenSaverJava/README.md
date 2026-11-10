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

mermaid
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

# Atividade 05 - Desafio Final: Jogo Pong em Java

Evolução da infraestrutura do ScreenSaver para um jogo autoral de **Pong**, aplicando POO, colisões, regras de jogo, pontuação e estado de Game Over.

## 🕹️ Controles e Como Jogar
- **Seta Para Cima (UP):** Move a raquete para cima.
- **Seta Para Baixo (DOWN):** Move a raquete para baixo.
- **Tecla 'R':** Reinicia o jogo após o Game Over.
- **Objetivo:** Rebater a bola verde com a raquete azul para acumular pontos sem perder as 3 vidas.

## 🛠️ Evoluções em Relação à Atividade 04
1. **Detecção de Colisão:** Implementada lógica matemática no laço principal que detecta a interseção entre as coordenadas da bola (`Circulo`) e da raquete (`Retangulo`).
2. **Sistema de Pontuação e Vidas:** Adicionada contagem de pontos ao rebater e desconto de vidas ao deixar a bola passar.
3. **Gerenciamento de Estado:** Adicionada tela de Game Over e suporte à reinicialização.

## 🧪 Relatório de Testes e Limitações Conhecidas
- **Testes Realizados:** Movimentação da raquete, rebatedura da bola, contagem de pontos, perda de vidas e acionamento da tecla 'R' para reinício.
- **Limitação Conhecida:** A velocidade da bola permanece constante em vez de aumentar progressivamente com o tempo.
- **Melhoria Futura:** Adicionar aceleração progressiva na bola a cada rebatedura e modo para dois jogadores.

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
        + inverterVelocidadeX()
        + desenhar(Graphics2D g2d) void
    }
    class Retangulo {
        - int largura, altura, velocidade
        + moverControlado(boolean up, boolean down, boolean left, boolean right, int limiteLargura, int limiteAltura)
        + desenhar(Graphics2D g2d) void
    }
    
    Forma <|-- Circulo
    Forma <|-- Retangulo