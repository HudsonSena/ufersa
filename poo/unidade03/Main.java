package poo.unidade03;

import poo.unidade03.src.controllers.CadastroCliente;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de estética automotiva!");
        int op = -1;
        while (op != 0) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar cliente");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Consultar ordens de serviço");
            System.out.println("0 - Sair");
            // Aqui você pode adicionar a lógica para ler a opção do usuário e chamar os métodos correspondentes
            System.out.print("Digite a opção desejada: ");
            op = new java.util.Scanner(System.in).nextInt();
            switch (op) {
                case 1: 
                System.out.println("Opção 1 selecionada: Cadastrar cliente");
                // Aqui você pode adicionar a lógica para cadastrar um cliente
                CadastroCliente.main(null); // Chama o método main da classe cadastroCliente para cadastrar um cliente
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada: Consultar cliente");
                    // Aqui você pode adicionar a lógica para consultar um cliente
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada: Atualizar cliente");
                    // Aqui você pode adicionar a lógica para atualizar um cliente
                    break;
                case 4:
                    System.out.println("Opção 4 selecionada: Consultar ordens de serviço");
                    // Aqui você pode adicionar a lógica para consultar ordens de serviço
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }

    }    
}