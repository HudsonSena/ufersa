package models;

public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    public Pessoa(String nome, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void atualizarDados(String nome, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public void consultarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
    }

    public void validarCPF() {
        //Método para validar o CPF (a ser implementado)
        System.out.println("CPF: " + cpf);
    }
}
