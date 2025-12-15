package Nota02POO;
public class Conta {
    // Atributos privados (encapsulamento)
    private Cliente cliente;
    private int numero;
    private int agencia;
    private double saldo;
    
    // Construtor que recebe todos os atributos
    public Conta(Cliente cliente, int numero, int agencia, double saldoInicial) {
        setCliente(cliente);
        setNumero(numero);
        setAgencia(agencia);
        setSaldo(saldoInicial);
    }
    
    // Métodos getters e setters
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.cliente = cliente;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getAgencia() {
        return agencia;
    }
    
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    // Saldo só pode ser alterado pelos métodos depositar e sacar
    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    // Método para depósito
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo");
        }
        this.saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }
    
    // Método para saque
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para saque");
        }
        this.saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }
    
    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente.getNome() +
                ", numero=" + numero +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }
}