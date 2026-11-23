package poo.unidade03.src.controllers;

import java.util.Scanner;
import poo.unidade03.src.models.Funcionario;

public class CadatrarFuncionario{
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        String nome = Validacoes.lerNome();
        String endereco = Validacoes.lerEndereco();
        String telefone = Validacoes.lerTelefone();
        String email = Validacoes.lerEmail();
        String cpf = Validacoes.lerCpf();
        System.out.println("Cargo: ");
        String cargo = entrada.nextLine().trim();
        System.out.println("Salario: ");
        Double salario = entrada.nextDouble();
        
        Funcionario funcionario = new Funcionario(nome, endereco, telefone, email, cpf, cargo, salario);

        funcionario.consultarDados();

        System.out.println("Funcionario cadastrado com sucesso!");
    }
}
