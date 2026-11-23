package poo.unidade03.src.controllers;

public class MenuOpcoes {
    public static void main(String[] args) {
        int op = -1;
        
        while (op != 0) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Consultar cliente");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Consultar ordens de serviço");
            System.out.println("5 - Cadastrar funcionario");
            System.out.println("6 - Cadastrar fornecedor");
            System.out.println("7 - Cadastrar produto");
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
                        System.out.println("Opção 4 selecionada: Consultar ordens de serviço");
                        // Aqui você pode adicionar a lógica para consultar ordens de serviço
                        break;
                    case 5:
                        System.err.println("Opção 5 selecionada: Cadastrar Funionário");
                        break;
                    case 6:
                        System.err.println("Opção 6 selecionada: Cadastrar Fornecedor");
                        break;
                    case 7:
                        System.err.println("Opção 7 selecionada: Cadastrar produtos");
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
