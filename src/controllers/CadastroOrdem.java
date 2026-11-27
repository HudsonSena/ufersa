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
        
        System.out.println("CPF na nota? 1 - Sim | 2 - Não");
        int op = entrada.nextInt();
        while (op != 1 && op != 2) {
            System.out.println("Digite um número válido (1 - Sim | 2 - Não):");
            op = entrada.nextInt();
        }
        
        String cpf = "00000000000";
        String nomecliente = "Consumidor";
        String placa = "000000";

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
                    cpf = clienteExistente.getCpf();
                } else {
                    System.out.println("Operação cancelada pelo usuário.");
                    entrada.close();
                    db.desconectar();
                    return null;
                }
            } else {
                // Se não existe, pergunta se deseja cadastrar
                System.out.println("Cliente não encontrado no sistema.");
                System.out.println("Deseja cadastrar um novo cliente? 1 - Sim | 2 - Não");
                
                int cadastrarNovo = entrada.nextInt();
                if (cadastrarNovo == 1) {
                    CadastroCliente.main(null);
                } else {
                    System.out.println("Prosseguindo com o CPF na nota sem cadastrar na base.");
                    nomecliente = Validacoes.lerNome(); // Apenas para a nota, se necessário
                }
            }

            int o = 0;
            System.out.println("Cadastrar veículo? 1- sim | 2 - não");
            o = entrada.nextInt();
            entrada.nextLine();
            while(o != 1 && o != 2) {
                System.out.println("Opão inválida");
                System.out.println("Cadastrar veículo? 1- sim | 2 - não");
                o = entrada.nextInt();
            }
            if(o == 1){
                System.out.println("Digite a placa: ");
                placa = entrada.nextLine();

                while(db.verificarPlacaExistente(placa, cpf)) {
                    System.err.println("Erro: Este veículo ja está cadastrado.");
                    System.out.println("Placa: ");
                    placa = entrada.nextLine().trim();
                    System.out.println("Continuar? 1- não | 2 - sim");
                    o = entrada.nextInt();
                }

                CadastroVeiculo.main(cpf, placa, args);
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