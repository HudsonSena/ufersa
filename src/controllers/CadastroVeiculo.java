package controllers;
import database.Banco;
import java.util.Scanner;
import models.Veiculo;

public class CadastroVeiculo {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String cpf, String placa, String[] args) {
        System.out.println("Modelo: ");
        String modelo = entrada.nextLine().trim();
        System.out.println("Marca: ");
        String marca = entrada.nextLine().trim();
        System.out.println("Placa: ");
        String placaof = placa;
        System.out.println("Placa " + placaof);
        System.out.println("Ano: ");
        String ano = entrada.nextLine();
        String vcpf = cpf;

        Banco db = new Banco();
        
        if (new Veiculo(modelo, marca, placa, ano, vcpf).cadastrarVeiculo(db)) {
            System.out.println("Veículo cadastrado com sucesso!");
        } else {
            System.err.println("Erro ao cadastrar veículo.");
        }
        modelo = entrada.nextLine();
    }        
}
