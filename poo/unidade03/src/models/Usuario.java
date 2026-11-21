package poo.unidade03.src.models;

public class Usuario {
    private int id;
    private String nome;
    private String username;
    private String password;

    public Usuario(int id, String nome, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
    }
    
    public void atualizar(int id, String nome, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;        
    }
    
}
