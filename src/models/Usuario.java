package models;

import database.Banco;

public class Usuario {
    private int id;
    private String nome;
    private String username;
    private String email;
    private String password;

    public Usuario(String nome, String username, String email, String password) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(int id, String nome, String username, String email, String password) {
        this(nome, username, email, password);
        this.id = id;
    }

    public boolean cadastrarUsuario(Banco db) {
        String query = String.format("INSERT INTO usuarios (nome, username, email, password) VALUES ('%s', '%s', '%s', '%s')", nome, username, email, password);
        return db.queryUpdate(query) > 0;
    }
    
    public void atualizar(int id, String nome, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;        
    }
    public void consultarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }
    
}
