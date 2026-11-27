package controllers;

import database.Banco;
import models.Usuario;

public class CadastroUsuario {
    public static void main(String[] args) {        
        Banco db = new Banco();
        boolean emailDisponivel = false;
        String op = "1";

        while(!emailDisponivel && !op.equals("0")) {
            String email = Validacoes.lerEmail();

            boolean emailExiste  = db.verificarEmailExistente(email);

            if(!emailExiste) {
                emailDisponivel = true;
                String nome = Validacoes.lerNome();                
                String username = Validacoes.lerUsername();
                String password = Validacoes.lerPassword();
        
                if (new Usuario(nome, username, email, password).cadastrarUsuario(db)) {
                    System.out.println("Usuário cadastrado com sucesso!");
                } else {
                    System.err.println("Erro ao cadastrar usuário.");
                }
            } else {
                System.err.println("Erro: Este e-mail já está cadastrado no sistema. Por favor, tente outro email.");
                op = Validacoes.lerOpcaoTexto();
            }
        } 
    }        
}