public class ContaBancaria {
    
    // Atributos privados para garantir o encapsulamento
    private int numero;
    private double saldo;
    private String nome;

    // Construtor para inicializar a conta
    public ContaBancaria(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = 0.0; // Saldo inicializa zerado
    }

    // Getters para acessar os dados (sem Setters para saldo e numero para manter a segurança)
    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para depositar com validação
    public void depositar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor de depósito deve ser maior que zero.");
        }
        this.saldo += valor;
    }

    // Método para sacar com validação de saldo e valor negativo
    public void sacar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor de saque deve ser maior que zero.");
        }
        if (valor > this.saldo) {
            throw new Exception("Saldo insuficiente para realizar este saque.");
        }
        this.saldo -= valor;
    }
}