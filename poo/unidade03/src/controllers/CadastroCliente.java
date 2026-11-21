package poo.unidade03.src.controllers;

public class CadastroCliente {

    public static void main(String[] args) {
        // Criando uma instância de Cliente
        //String nome = lerNome();
        int tipo = 0;
        while (tipo != 1 && tipo != 2) {
            System.out.print("Digite o tipo de cliente, 1 (Pessoa física) ou 2 (Pessoa jurídica): ");
            tipo = new java.util.Scanner(System.in).nextInt();
            if(tipo == 1) {
                //String tipoCliente = ""
            }
            if (tipo == 2) {
                return;
            }

            System.out.println("Tipo de cliente inválido. Por favor, digite 1 para Física ou 2 para Jurídica.");
        }

        System.out.println("Cliente cadastrado com sucesso!");
    }
}
