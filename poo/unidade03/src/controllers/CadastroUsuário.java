package poo.unidade03.src.controllers;

import poo.unidade03.src.models.Cliente;

public class CadastroUsuário {
    ublic static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String username = Validacoes.lerEndereco();
        String password = Validacoes.lerPassword();
        Usuario usuario = new Usuario(nome, username, password);

        usuario.consultarDados();

        System.out.println("Usuario cadastrado com sucesso!");
    }        
}
