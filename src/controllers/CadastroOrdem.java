package controllers;
import database.Banco;
import models.OrdemServico;

public class CadastroOrdem {
    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        Double valor = 48.00;
        String nomecliente = Validacoes.lerNome();
        int idCliente = 1;
        int idVeiculo = 2;
        Banco db = new Banco();


        if(new OrdemServico(nome, valor, nomecliente, idCliente, idVeiculo).cadastrarOrdem(db)) {
            System.out.println("Ordem cadastrada");
        } else {
            System.err.println("Error");
        }
    } 
}
