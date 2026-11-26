package controllers;

import java.util.Scanner;

public class Validacoes {
    static Scanner entrada = new Scanner(System.in);

    public static boolean nomeValido(String nome) {
        return nome.matches("[\\p{L} ]{3,}");
    }

    public static boolean tituloValido(String titulo) {
        return titulo.matches("[\\p{L} ]{3,}");
    }

    public static boolean emailValido(String email) {
        return email.matches("[\\w.-]+@[\\w-]+(\\.[\\w-]+)+");
    }

    public static boolean telefoneValido(String telefone) {
        return telefone.matches("^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$");
    }

    public static boolean cpfValido(String cpf) {
        return cpf.matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}");      
    }

    public static boolean cnpjValido(String cnpj) {
        return cnpj.matches("\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2}");
    }

    public static boolean numeroValido(String numero) {
        return numero.matches("\\d+");
    }

    public static boolean valorValido(String valor) {
        return valor.matches("^(?:R\\$\\s?)?(\\d{1,3}(?:\\.\\d{3})*|\\d+)(?:,\\d{2})?$");  
    }

    public static boolean senhaValida(String senha) {
        return senha.matches("[a-zA-Z0-9]{5,}");
    }

    public static String lerOpcaoTexto() {
        return entrada.nextLine().trim();
    }

    public static int lerNumero() {
        String numero = entrada.nextLine().trim();

        while (!numero.matches("\\d+")) {
            System.err.println("Número inválido! Digite apenas números inteiros.");
            System.out.print("Digite uma opção: ");
            numero = entrada.nextLine().trim();
        }

        return Integer.parseInt(numero);
    }

    public static Double lerValor() {
        System.out.print("Valor(Ex: 1500,00): ");
        String valorEntrada = entrada.nextLine().trim();

        while (!valorValido(valorEntrada)) {
            System.err.println("Valor inválido!");
            System.out.print("Valor: ");
            valorEntrada = entrada.nextLine().trim();
        }
        try {
            // 1. Remove o "R$", espaços e os pontos de milhar (ex: "1.500,00" vira "1500,00")
            String valorLimpo = valorEntrada.replace("R$", "").replace(" ", "").replace(".", "");
            
            // 2. Substitui a vírgula por ponto para o Java aceitar converter para Double (vira "1500.00")
            valorLimpo = valorLimpo.replace(",", ".");

            // 3. Converte para Double para você salvar no banco e fazer cálculos
            return Double.parseDouble(valorLimpo);
            
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter o valor. Tente novamente.");
            return lerValor(); // Recursão simples caso ocorra algum imprevisto na conversão
        }
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

    public static String lerTitulo() {
        System.out.print("Título: ");
        String titulo = entrada.nextLine().trim();
        while (!nomeValido(titulo)) {
            System.err.println("Título invalido. Use apenas letras (minimo 3).");
            System.out.print("Título: ");
            titulo = entrada.nextLine().trim();
        }
        return titulo;
    }

    public static String lerUsername() {
        System.out.print("Username: ");
        String username = entrada.nextLine().trim();
        while (!nomeValido(username)) {
            System.err.println("Username invalido. Use no mínimo 3 caracteres.");
            System.out.print("Username: ");
            username = entrada.nextLine().trim();
        }
        return username;
    }

    public static String lerPassword() {
        System.out.print("Senha: ");
        String senha = entrada.nextLine().trim();
        while (!senhaValida(senha)) {
            System.err.println("Senha invalida. Mínino de 5 caracteres. Letras ou números");
            System.out.print("Senha: ");
            senha = entrada.nextLine().trim();
        }
        return senha;
    }

    public static String lerEndereco() {
        System.out.print("Endereco: ");
        String nome = entrada.nextLine().trim();
        while (!nomeValido(nome)) {
            System.err.println("Endereco invalido. Use apenas letras.");
            System.out.print("Endereco: ");
            nome = entrada.nextLine().trim();
        }
        return nome;
    }

    public static String lerEmail() {
        System.out.print("Email: ");
        String email = entrada.nextLine().trim();
        while (!emailValido(email)) {
            System.err.println("Email invalido. Exemplo: nome@email.com");
            System.out.print("Email: ");
            email = entrada.nextLine().trim();
        }
        return email;
    }

    public static String lerTelefone() {
        System.out.print("Telefone: ");
        String telefone = entrada.nextLine().trim();
        while (!telefoneValido(telefone)) {
            System.err.println("Telefone invalido. Exemplo: 999999999");
            System.out.print("Telefone: ");
            telefone = entrada.nextLine().trim();
        }
        return telefone;
    }

    public static String lerCpf() {
        System.out.print("CPF (Digite apenas números): ");
        String cpf = entrada.nextLine().trim();
        while (!cpfValido(cpf)) {
            System.err.println("CPF invalido. Exemplo: 12345678910");
            System.out.print("CPF (Digite apenas números): ");
            cpf = entrada.nextLine().trim();
        }
        return cpf;
    }

    public static String lerCnpj() {
        System.out.print("CNPJ (Digite apenas números): ");
        String cnpj = entrada.nextLine().trim();
        while (!cnpjValido(cnpj)) {
            System.err.println("CNPJ invalido. Exemplo: 12345678912345");
            System.out.print("CNPJ (Digite apenas números): ");
            cnpj = entrada.nextLine().trim();
        }
        return cnpj;
    }

    public static String lerOrgao() {
        System.out.print("Tipo orgão: ");
        String tipoOrgao = entrada.nextLine().trim();
        while (!nomeValido(tipoOrgao)) {
            System.err.println("Tipo orgao invalido. Apenas letras");
            System.out.print("Tipo orgão: ");
            tipoOrgao = entrada.nextLine().trim();
        }
        return tipoOrgao;
    }

    public static String lerTipoCliente() {
        String tipoCliente = "";
        int tipo = -1;

        while (tipo != 1 && tipo != 2) {
            System.out.print("Digite o tipo de cliente, 1 (Pessoa física) ou 2 (Pessoa jurídica): ");
            tipo = entrada.nextInt();
            switch (tipo) {
            case 1:
                tipoCliente = "Pessoa fisica";                
                break;
            case 2:
                tipoCliente = "Pessoa juridica";
                break;

            default:
                System.out.println("Tipo de cliente inválido. Por favor, digite 1 para Física ou 2 para Jurídica.");
                throw new AssertionError();
            }
        }
        entrada.nextLine();
        return tipoCliente;
    }
}
