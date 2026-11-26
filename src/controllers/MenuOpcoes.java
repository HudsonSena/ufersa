package controllers;

import controllers.Validacoes;
import controllers.CadastroCliente;

public class MenuOpcoes {
    public static void main(String[] args) {
        int op = -1;
        
        while (op != 0) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Ordem de serviço");
            System.out.println("2 - Listar ordens de serviço");
            System.out.println("3 - Cadastrar cliente");
            System.out.println("4 - Listar clientes");
            System.out.println("5 - Atualizar cliente");          
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");     
            try {
                op = Validacoes.lerNumero();
                switch (op) {
                    case 1: 
                    System.out.println("Opção 1 selecionada: Cadastrar cliente");
                    CadastroCliente.main(null);
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
                        System.out.println("Opção 4 selecionada: Listar clientes");
                        // Aqui você pode adicionar a lógica para consultar ordens de serviço
                        break;
                    case 5:
                        System.err.println("Opção 5 selecionada: Consultar ordens de serviço");
                        break;
                    case 0:
                        System.out.println("Voltando para o login.");
                        break;

                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    }
            } catch (NumberFormatException e) {
                System.err.println("Digite um número válido");
            }
        }

    }    
}
