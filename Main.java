package Nota02POO;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCÁRIO - TESTES ===\n");
        
        // Criar instância do banco
        Banco banco = new Banco();
        
        // 1. Cadastrar clientes
        System.out.println("1. CADASTRANDO CLIENTES:");
        System.out.println("-----------------------");
        
        Cliente cliente1 = new Cliente("123.456.789-00", "Fanderson", "(11) 99999-9999", "joao@email.com");
        Cliente cliente2 = new Cliente("987.654.321-00", "Antonio JUnior", "(11) 98888-8888", "maria@email.com");
        Cliente cliente3 = new Cliente("111.222.333-44", "Carlos Fulano", "(11) 97777-7777", "carlos@email.com");
        
        try {
            banco.adicionarCliente(cliente1);
            banco.adicionarCliente(cliente2);
            banco.adicionarCliente(cliente3);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
        
        // 2. Cadastrar contas
        System.out.println("2. CADASTRANDO CONTAS:");
        System.out.println("----------------------");
        
        Conta conta1 = new Conta(cliente1, 1001, 1, 1000.00);
        Conta conta2 = new Conta(cliente2, 1002, 1, 500.00);
        Conta conta3 = new Conta(cliente3, 1003, 1, 2000.00);
        
        try {
            banco.adicionarConta(conta1);
            banco.adicionarConta(conta2);
            banco.adicionarConta(conta3);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar conta: " + e.getMessage());
        }
        
        // 3. Exibir saldos iniciais
        System.out.println("3. SALDOS INICIAIS:");
        System.out.println("-------------------");
        System.out.println(conta1);
        System.out.println(conta2);
        System.out.println(conta3);
        System.out.println();
        
        // 4. Realizar operações de depósito
        System.out.println("4. OPERAÇÕES DE DEPÓSITO:");
        System.out.println("-------------------------");
        
        try {
            conta1.depositar(500.00);
            System.out.println("Novo saldo da conta 1001: R$" + conta1.getSaldo());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no depósito: " + e.getMessage());
        }
        
        // 5. Realizar operações de saque
        System.out.println("5. OPERAÇÕES DE SAQUE:");
        System.out.println("----------------------");
        
        try {
            conta3.sacar(300.00);
            System.out.println("Novo saldo da conta 1003: R$" + conta3.getSaldo());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no saque: " + e.getMessage());
        }
        
        // 6. Tentativa de saque com saldo insuficiente
        System.out.println("6. TENTATIVA DE SAQUE COM SALDO INSUFICIENTE:");
        System.out.println("---------------------------------------------");
        
        try {
            conta2.sacar(600.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no saque: " + e.getMessage());
            System.out.println("Saldo atual da conta 1002: R$" + conta2.getSaldo());
            System.out.println();
        }
        
        // 7. Realizar transferência entre contas
        System.out.println("7. TRANSFERÊNCIA ENTRE CONTAS:");
        System.out.println("-----------------------------");
        
        try {
            banco.transferir(1001, 1002, 200.00);
            System.out.println("Saldo conta 1001 após transferência: R$" + conta1.getSaldo());
            System.out.println("Saldo conta 1002 após transferência: R$" + conta2.getSaldo());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
        
        // 8. Tentativa de transferência com saldo insuficiente
        System.out.println("8. TENTATIVA DE TRANSFERÊNCIA COM SALDO INSUFICIENTE:");
        System.out.println("-----------------------------------------------------");
        
        try {
            banco.transferir(1002, 1003, 1000.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
            System.out.println("Saldo atual da conta 1002: R$" + conta2.getSaldo());
            System.out.println();
        }
        
        // 9. Buscar cliente por CPF
        System.out.println("9. BUSCA DE CLIENTE POR CPF:");
        System.out.println("----------------------------");
        
        Cliente clienteEncontrado = banco.buscarCliente("987.654.321-00");
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado);
        } else {
            System.out.println("Cliente não encontrado");
        }
        System.out.println();
        
        // 10. Buscar conta por número e agência
        System.out.println("10. BUSCA DE CONTA POR NÚMERO E AGÊNCIA:");
        System.out.println("----------------------------------------");
        
        Conta contaEncontrada = banco.buscarConta(1003, 1);
        if (contaEncontrada != null) {
            System.out.println("Conta encontrada: " + contaEncontrada);
        } else {
            System.out.println("Conta não encontrada");
        }
        System.out.println();
        
        // 11. Tentativa de cadastrar cliente com CPF vazio (teste de validação)
        System.out.println("11. TESTE DE VALIDAÇÃO - CPF VAZIO:");
        System.out.println("-----------------------------------");
        
        try {
            Cliente clienteInvalido = new Cliente("", "Teste", "(11) 96666-6666", "teste@email.com");
            System.out.println("Cliente criado (não deveria chegar aqui)");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar cliente: " + e.getMessage());
        }
        
        // 12. Saldos finais
        System.out.println("\n12. SALDOS FINAIS:");
        System.out.println("------------------");
        System.out.println(conta1);
        System.out.println(conta2);
        System.out.println(conta3);
        
        System.out.println("\n=== FINAL ===");
    }
}