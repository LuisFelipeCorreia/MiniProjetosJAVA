![senai_logo](./images/logo.png)
# Editor de Texto em Java (Mini Projeto 2)

Este projeto implementa um editor de texto simples utilizando a biblioteca Java Swing. O objetivo principal foi aplicar os conceitos de **Encapsulamento**, manipulação da classe **String** e tratamento de **Exceções** para garantir a integridade dos ficheiros criados.

## ⚙️ Como executar o projeto

1. Faça o clone deste repositório: `git clone https://github.com/LuisFelipeCorreia/MiniProjetosJAVA.git`
2. Abra a pasta `02_EditorTextoJava` no VS Code ou noutra IDE Java.
3. Execute o ficheiro `App.java`.
4. Utilize a barra de menus "Arquivo" para criar, renomear, limpar ou deletar ficheiros. 

## 🧪 Tabela de Testes Realizados

| Operação Testada | Ação Realizada | Resultado Obtido |
| :--- | :--- | :--- |
| **Criação Válida (Tratamento String)** | Criar arquivo "  Meu Arquivo  " | Sucesso. Espaços externos removidos, nome salvo como "MeuArquivo". |
| **Nome Inválido (Vazio/Nulo)** | Tentar criar/renomear sem digitar nada | Exceção tratada. Mensagem: "O nome do arquivo não pode estar em branco." |
| **Nome Inválido (Caracteres Especiais)**| Renomear arquivo para "@#$%" | Exceção tratada. Mensagem: "O nome do arquivo não contém caracteres válidos." |
| **Edição e Cálculo de Tamanho** | Inserir texto "Olá Mundo" e Salvar | Sucesso. Tamanho atualizado na barra de status para 9 bytes. |
| **Limpeza de Ficheiro** | Selecionar "Arquivo -> Limpar" | Sucesso. Área de texto limpa e tamanho retorna a 0 bytes. |