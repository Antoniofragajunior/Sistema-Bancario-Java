package Nota02POO;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    // Atributos privados (encapsulamento)
    private List<Cliente> clientes;
    private List<Conta> contas;
    
    // Construtor vazio que inicializa as listas
    public Banco() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }
    
    // Métodos getters
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes); // Retorna cópia para proteger a lista original
    }
    
    public List<Conta> getContas() {
        return new ArrayList<>(contas); // Retorna cópia para proteger a lista original
    }
    
    // Método para adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Cliente com CPF " + cliente.getCpf() + " já cadastrado");
        }
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
    }
    
    // Método para adicionar conta
    public void adicionarConta(Conta conta) {
        if (buscarConta(conta.getNumero(), conta.getAgencia()) != null) {
            throw new IllegalArgumentException("Conta já cadastrada");
        }
        contas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " cadastrada com sucesso.");
    }
    
    // Método para buscar cliente por CPF
    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    
    // Método para buscar conta por número e agência
    public Conta buscarConta(int numero, int agencia) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero && conta.getAgencia() == agencia) {
                return conta;
            }
        }
        return null;
    }
    
    // Método para realizar transferência entre contas
    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        Conta contaOrigem = null;
        Conta contaDestino = null;
        
        // Encontrar conta de origem
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroOrigem) {
                contaOrigem = conta;
                break;
            }
        }
        
        // Encontrar conta de destino
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroDestino) {
                contaDestino = conta;
                break;
            }
        }
        
        // Verificar se ambas as contas existem
        if (contaOrigem == null) {
            throw new IllegalArgumentException("Conta de origem não encontrada");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destino não encontrada");
        }
        
        // Verificar se há saldo suficiente
        if (contaOrigem.getSaldo() < valor) {
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }
        
        // Realizar a transferência
        contaOrigem.sacar(valor);
        contaDestino.depositar(valor);
        
        System.out.println("Transferência de R$" + valor + " realizada com sucesso da conta " + 
                          numeroOrigem + " para conta " + numeroDestino);
    }
}