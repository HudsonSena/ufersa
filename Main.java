import controllers.CadastroUsuario;
import controllers.Login;
import controllers.Validacoes;
import database.criarBanco;

public class Main {
    public static void main(String[] args) {
        criarBanco.main(null);
        System.out.println("Bem-vindo ao sistema de estética automotiva!");
        int op = -1;
        
        while (op != 0) {
            System.out.println("1 - Fazer login");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");     
            try {
                op = Validacoes.lerNumero();
                switch (op) {
                    case 1: 
                        System.out.println("Login");
                        Login.main(null);
                        break;
                    case 2:
                        System.out.println("Cadastrar usuario");
                        CadastroUsuario.main(null);
                        // Aqui você pode adicionar a lógica para consultar um cliente
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Até logo!");
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