package poo.unidade03.src.controllers;
import poo.unidade03.src.models.Usuario;

public class CadastroUsuário {
    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String username = Validacoes.lerUsername();
        String email = Validacoes.lerEmail();
        String password = Validacoes.lerPassword();

        Usuario usuario = new Usuario(nome, username, email, password);

        usuario.consultarDados();

        System.out.println("Usuario cadastrado com sucesso!");
    }        
}
