package controllers;

import database.Banco;
import java.util.Scanner;
import models.Cliente;
import models.OrdemServico;

public class CadastroOrdem {
    static Scanner entrada = new Scanner(System.in);

    public static String main(String[] args) {
        Banco db = new Banco();
        String titulo = Validacoes.lerTitulo();
        Double valor = Validacoes.lerValor();
        String placa = "00000";
            
        System.out.println("Digite a placa: ");
        placa = entrada.nextLine();
        
        System.out.println("CPF na nota? 1 - Sim | 2 - Não");
        int op = entrada.nextInt();
        while (op != 1 && op != 2) {
            System.out.println("Digite um número válido (1 - Sim | 2 - Não):");
            op = entrada.nextInt();
        }
        
        String cpf = "00000000000";
        String nomecliente = "Consumidor";

        if (op == 1) {
            cpf = Validacoes.lerCpf();
            
            // Supondo que exista um método no seu Banco para buscar por CPF:
            Cliente clienteExistente = db.buscarClientePorCpf(cpf);
            
            if (clienteExistente != null) {
                // Se o cliente já existe, mostra quem é e pede confirmação
                System.out.println("\n--- Cliente Encontrado ---");
                System.out.println("Nome: " + clienteExistente.getNome());
                System.out.println("Telefone: " + clienteExistente.getTelefone());
                System.out.println("Deseja confirmar este cliente? 1 - Sim | 2 - Não");
                
                int confirmar = entrada.nextInt();
                if (confirmar == 1) {
                    nomecliente = clienteExistente.getNome();
                } else {
                    System.out.println("Operação cancelada pelo usuário.");
                    entrada.close();
                    db.desconectar();
                    return null;
                }
            } else {
                // Se não existe, pergunta se deseja cadastrar
                System.out.println("Cliente não encontrado no sistema.");
                db.desconectar();
                System.out.println("Deseja cadastrar um novo cliente? 1 - Sim | 2 - Não");
                
                int cadastrarNovo = entrada.nextInt();
                if (cadastrarNovo == 1) {
                    CadastroCliente.main(null);
                } else {
                    System.out.println("Prosseguindo com o CPF na nota sem cadastrar na base.");
                    nomecliente = Validacoes.lerNome(); // Apenas para a nota, se necessário
                }
            }
        }
        
        // Cadastra a ordem de serviço
        if (new OrdemServico(titulo, valor, nomecliente, cpf, placa).cadastrarOrdem(db)) {
            System.out.println("Ordem cadastrada com sucesso!");
        } else {
            System.err.println("Erro ao cadastrar ordem.");
        }
        return cpf;
    }
}