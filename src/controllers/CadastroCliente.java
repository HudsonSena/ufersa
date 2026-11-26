package controllers;

import database.Banco;
import models.Cliente;

public class CadastroCliente {

    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String endereco = Validacoes.lerEndereco();
        String telefone = Validacoes.lerTelefone();
        String email = Validacoes.lerEmail();
        String cpf = Validacoes.lerCpf();
        String tipoCliente = Validacoes.lerTipoCliente();
        Banco db = new Banco();
        
        // Verifica se o e-mail já está cadastrado no banco
        if (db.verificarCPFExistente(cpf)) {
            System.err.println("Erro: Este CPF já está cadastrado no sistema. Por favor, tente outro.");
            return;
        }
        
        // Se não existir, prossegue com a senha e o cadastro
        String password = Validacoes.lerPassword();
        
        if (new Cliente(nome, endereco, telefone, email, cpf, tipoCliente).cadastrarCliente(db)) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.err.println("Erro ao cadastrar usuário.");
        } 
    }
}
