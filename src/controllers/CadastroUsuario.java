package controllers;
import database.Banco;
import models.Usuario;

public class CadastroUsuario {
    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String username = Validacoes.lerUsername();
        String email = Validacoes.lerEmail();
        String password = Validacoes.lerPassword();
        Banco db = new Banco();
        
        if(new Usuario(nome, username, email, password).cadastrarUsuario(db)) {
            System.out.println("Usuario cadastrado");
        } else {
            System.err.println("Error");
        }          
    }        
}
