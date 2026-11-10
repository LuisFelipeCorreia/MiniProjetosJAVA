# Mini Projetos Java - Orientação a Objetos e Swing

Este repositório reúne uma coleção de 5 mini projetos práticos desenvolvidos em Java, explorando os fundamentos da Programação Orientada a Objetos (POO), tratamento de exceções, manipulação de Strings, uso de classes utilitárias estáticas e construção de interfaces gráficas com a biblioteca Java Swing e Graphics2D.

---

## Projetos Incluídos

| Projeto | Nome da Pasta | Conceitos-Chave Aplicados |
| :--- | :--- | :--- |
| **01** | `01_ContaBancariaJava` | Encapsulamento, métodos validadores, estado do objeto e GUI Swing. |
| **02** | `02_EditorTextoJava` | Manipulação de Strings (`trim`, `replaceAll`), exceções e cálculo de tamanho em bytes. |
| **03** | `03_ConversorTemperaturaJava` | Classe utilitária (`static`), constantes (`final`), validação de zero absoluto. |
| **04** | `04_ScreenSaverJava` | Os 4 Pilares da POO (Abstração, Encapsulamento, Herança e Polimorfismo), animação 2D. |
| **05** | `04_ScreenSaverJava` / `05_PongGame` | Estrutura de jogos (looping, colisões, pontuação, vidas, Game Over e reinício). |

---

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Interface Gráfica:** Java Swing (`JFrame`, `JPanel`, `JButton`, `JList`, `JComboBox`, etc.)
* **Renderização 2D:** `java.awt.Graphics2D` e `javax.swing.Timer`
* **Controle de Versão:** Git & GitHub

---

## Detalhes dos Projetos

### Projeto 01: Conta Bancária (`01_ContaBancariaJava`)
Aplicação de caixa eletrônico com interface Swing que gerencia depósitos e saques de uma conta bancária.
* **Destaques:** Proteção do atributo `saldo` via encapsulamento (`private`), impedindo saques sem saldo suficiente ou valores de depósito negativos.

### Projeto 02: Editor de Texto (`02_EditorTextoJava`)
Editor visual que gerencia arquivos de texto em memória e exibe o tamanho real ocupado em bytes.
* **Destaques:** Sanitização de nomes de arquivos (remoção de caracteres especiais e espaços extras), tratamento de exceções para nomes em branco e atualização dinâmica do painel.

### Projeto 03: Conversor de Temperatura (`03_ConversorTemperaturaJava`)
Ferramenta para conversão de temperaturas nas escalas Celsius, Fahrenheit e Kelvin.
* **Destaques:** Classe utilitária `TemperatureConverter` com métodos estáticos, construtor privado e limites físicos rigorosos baseados nas constantes de zero absoluto.

### Projeto 04: ScreenSaver com Pilares da POO (`04_ScreenSaverJava`)
Animação visual em tempo real composta por formas geométricas em um canvas `800x600`.
* **Destaques:**
  * **Abstração:** Classe abstrata `Forma` definindo o método `desenhar(Graphics2D)`.
  * **Herança:** Subclasses `Circulo` e `Retangulo` herdando de `Forma`.
  * **Polimorfismo:** Sobrescrita do método de renderização para cada forma.
  * **Controle:** Movimentação automatizada (rebatimento) e por teclado (`KeyAdapter`).

### Projeto 05: Desafio Final - Jogo Pong (`04_ScreenSaverJava` / `05_PongGame`)
Evolução da arquitetura do ScreenSaver transformada em um jogo autoral completo de Pong.
* **Destaques:** Colisão matemática entre a bola (`Circulo`) e a raquete (`Retangulo`), contagem de pontos, sistema de vidas, tela de Game Over e tecla de reinício (`R`).

---

## Como Executar o Repositório

### Pré-requisitos
* Java Development Kit (JDK 17 ou superior) instalado.
* IDE recomendada: VS Code (com a extensão *Extension Pack for Java*) ou IntelliJ IDEA.

### Passo a Passo

1. **Clone este repositório:**
   ```bash
   git clone https://github.com/LuisFelipeCorreia/MiniProjetosJAVA.git
   ```

2. **Abra a pasta raiz no VS Code ou na sua IDE de preferência.**

3. **Navegue até a pasta do projeto que deseja executar** (ex: `01_ContaBancariaJava`).

4. **Execute o arquivo principal (`App.java`):**
   * No VS Code, clique no botão **Run** acima do método `public static void main` no arquivo `App.java`.
