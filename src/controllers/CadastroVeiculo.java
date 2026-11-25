package controllers;
import java.util.Scanner;
import models.Veiculo;

public class CadastroVeiculo {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Modelo: ");
        String modelo = entrada.nextLine().trim();
        System.out.println("Marca: ");
        String marca = entrada.nextLine().trim();
        System.out.println("Placa: ");
        String placa = entrada.nextLine().trim();
        System.out.println("Ano: ");
        int ano = entrada.nextInt();

        Veiculo usuario = new Veiculo(modelo, marca, placa, ano, idCliente);

        usuario.consultarVeiculo();

        System.out.println("Veículo cadastrado com sucesso!");
        modelo = entrada.nextLine();
    }        
}
