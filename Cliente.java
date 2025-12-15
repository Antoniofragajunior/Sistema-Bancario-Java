package Nota02POO;
public class Cliente {
    // Atributos privados (encapsulamento)
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    
    // Construtor que recebe todos os atributos
    public Cliente(String cpf, String nome, String telefone, String email) {
        setCpf(cpf); // Usando setters para validação
        setNome(nome);
        setTelefone(telefone);
        setEmail(email);
    }
    
    // Métodos getters e setters com validações
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio");
        }
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}