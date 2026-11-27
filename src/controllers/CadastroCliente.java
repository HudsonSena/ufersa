package controllers;

import database.Banco;
import models.Cliente;
import models.PessoaJuridica;

public class CadastroCliente {

    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String endereco = Validacoes.lerEndereco();
        String telefone = Validacoes.lerTelefone();
        String email = Validacoes.lerEmail();
        String tipoCliente = Validacoes.lerTipoCliente();
        String cpf = "000000000";
        String cnpj = "00000000000000";
        String tipoOrgao = "Nenhum";

        Banco db = new Banco();

        if(tipoCliente == "Pessoa fisica") {
            
            cpf = Validacoes.lerCpf();

            if (db.verificarCPFExistente(cpf)) {
                System.err.println("Erro: Este CPF já está cadastrado no sistema. Por favor, tente outro.");
                return;
            }

            if (new Cliente(nome, endereco, telefone, email, cpf, tipoCliente).cadastrarCliente(db)) {
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.err.println("Erro ao cadastrar cliente.");
            } 

        } else {
            cnpj = Validacoes.lerCnpj();
            tipoOrgao = Validacoes.lerOrgao();
            if (new PessoaJuridica(nome, endereco, telefone, email, cpf, tipoCliente, cnpj, tipoOrgao).cadastrarClienteJu(db)) {
                System.out.println("Usuário cadastrado com sucesso!");
            } else {
                System.err.println("Erro ao cadastrar cliente.");
            }
        } 
    }
}
