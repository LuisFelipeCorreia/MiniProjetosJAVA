![senai_logo](./images/logo.png)

# Conversor de Temperatura em Java (Mini Projeto 3)

Este projeto é um conversor de temperaturas construído com interface gráfica em Java Swing. O principal objetivo de aprendizado foi a criação de uma **classe utilitária** (`TemperatureConverter`), aplicando métodos **estáticos** (`static`), constantes (`final`) para os limites físicos de temperatura (zero absoluto) e **validação de domínio** com tratamento de exceções.

## 🛠️ Tecnologias Utilizadas
- Java (JDK)
- Java Swing (Interface Gráfica)
- Tratamento de Exceções (`IllegalArgumentException`)

## ⚙️ Como executar o projeto

Para testar a aplicação no seu computador, siga os passos abaixo:

1. Faça o clone deste repositório: `git clone https://github.com/LuisFelipeCorreia/MiniProjetosJAVA.git`
2. Abra a pasta `03_ConversorTemperaturaJava` na sua IDE (VS Code, Eclipse, IntelliJ, etc.).
3. Certifique-se de que as dependências do Java estão configuradas.
4. Execute o ficheiro `App.java` (onde se encontra o método `main`).
5. A interface abrirá. Digite o valor numérico, selecione as escalas de origem e destino e clique em "Converter".

## 🧪 Tabela de Testes Realizados

Abaixo encontram-se os testes funcionais realizados para validar as conversões e os limites do zero absoluto:

| Entrada e Escalas | Resultado Esperado | Resultado Obtido |
| :--- | :--- | :--- |
| **100** (Celsius para Fahrenheit) | 212.00 F | 212.00 F |
| **32** (Fahrenheit para Kelvin) | 273.15 K | 273.15 K |
| **300** (Kelvin para Celsius) | 26.85 C | 26.85 C |
| **-300** (Celsius para Fahrenheit) | Erro: Valor abaixo do zero absoluto | Erro: Valor abaixo do zero absoluto! O limite em Celsius é -273,15. |
| **"abc"** (Letras em vez de números) | Erro: Valor inválido | Erro: Valor inválido |