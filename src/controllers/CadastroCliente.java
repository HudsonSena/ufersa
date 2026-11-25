package controllers;

import models.Cliente;
import controllers.Validacoes;

public class CadastroCliente {

    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String endereco = Validacoes.lerEndereco();
        String telefone = Validacoes.lerTelefone();
        String email = Validacoes.lerEmail();
        String cpf = Validacoes.lerCpf();
        String tipoCliente = Validacoes.lerTipoCliente();
        Cliente cliente = new Cliente(nome, endereco, telefone, email, cpf, tipoCliente);

        cliente.consultarDados();

        System.out.println("Cliente cadastrado com sucesso!");
    }
}
