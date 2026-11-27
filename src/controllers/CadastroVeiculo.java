package controllers;
import java.util.Scanner;

import database.Banco;
import models.Usuario;
import models.Veiculo;

public class CadastroVeiculo {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String cpf, String[] args) {
        System.out.println("Modelo: ");
        String modelo = entrada.nextLine().trim();
        System.out.println("Marca: ");
        String marca = entrada.nextLine().trim();
        System.out.println("Placa: ");
        String placa = entrada.nextLine().trim();
        System.out.println("Ano: ");
        String ano = entrada.nextLine();
        String vcpf = cpf;

        Banco db = new Banco();

        while(db.verificarPlaca(placa, vcpf)) {
            System.err.println("Erro: Este veículo ja está cadastrado.");
            System.out.println("Placa: ");
            placa = entrada.nextLine().trim();
        }
        
        if (new Veiculo(modelo, marca, placa, ano, vcpf).cadastrarVeiculo(db)) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.err.println("Erro ao cadastrar usuário.");
        } 

        System.out.println("Veículo cadastrado com sucesso!");
        modelo = entrada.nextLine();
    }        
}
