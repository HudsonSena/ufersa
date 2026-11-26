package controllers;

import database.Banco;
import models.Usuario;

public class CadastroUsuario {
    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String username = Validacoes.lerUsername();
        String email = Validacoes.lerEmail();
        
        Banco db = new Banco();

        while(db.verificarEmailExistente(email)) {
            System.err.println("Erro: Este e-mail já está cadastrado no sistema. Por favor, tente outro email.");
            email = Validacoes.lerEmail();
        }

        String password = Validacoes.lerPassword();
        
        if (new Usuario(nome, username, email, password).cadastrarUsuario(db)) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.err.println("Erro ao cadastrar usuário.");
        }          
    }        
}