package poo.unidade03.src.controllers;

import java.util.Scanner;

public class Validacoes {
    static Scanner entrada = new Scanner(System.in);

    // Nome: apenas letras (com acento) e espacos, minimo de 3 caracteres
    public static boolean nomeValido(String nome) {
        return nome.matches("[\\p{L} ]{3,}");
    }

    // Email: texto@dominio.extensao
    public static boolean emailValido(String email) {
        return email.matches("[\\w.-]+@[\\w-]+(\\.[\\w-]+)+");
    }

    public static boolean cpfValido(String cpf) {
        return cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}");      
    }

    public static boolean cnpjValido(String cnpj) {
        return cnpj.matches("\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2}");
    }

    public static String lerNome() {
        System.out.print("Nome: ");
        String nome = entrada.nextLine().trim();
        while (!nomeValido(nome)) {
            System.err.println("Nome invalido. Use apenas letras (minimo 3).");
            System.out.print("Nome: ");
            nome = entrada.nextLine().trim();
        }
        return nome;
    }

    // Pede o email ate ser valido
    static String lerEmail() {
        System.out.print("Email: ");
        String email = entrada.nextLine().trim();
        while (!emailValido(email)) {
            System.err.println("Email invalido. Exemplo: nome@email.com");
            System.out.print("Email: ");
            email = entrada.nextLine().trim();
        }
        return email;
    }

    static String lerCpf() {
        System.out.print("CPF (Digite apenas números): ");
        String cpf = entrada.nextLine().trim();
        while (!cpfValido(cpf)) {
            System.err.println("CPF invalido. Exemplo: 12345678910");
            System.out.print("CPF (Digite apenas números): ");
            cpf = entrada.nextLine().trim();
        }
        return cpf;
    }

    static String lerCnpj() {
        System.out.print("CNPJ (Digite apenas números): ");
        String cpf = entrada.nextLine().trim();
        while (!cpfValido(cpf)) {
            System.err.println("CNPJ invalido. Exemplo: 12345678912345");
            System.out.print("CNPJ (Digite apenas números): ");
            cpf = entrada.nextLine().trim();
        }
        return cpf;
    }
}
