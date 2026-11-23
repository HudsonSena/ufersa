package poo.unidade03.src.controllers;

import poo.unidade03.MenuOpcoes;

public class Login {

    public static void main(String[] args) {

        boolean loginValido = false;
        String op = "1";

        while (!loginValido && !op.equals("0")) {

            String username = Validacoes.lerUsername();
            String password = Validacoes.lerPassword();

            // Exemplo de verificação
            if (username.equals("admin") && password.equals("12345")) {
                loginValido = true;
                System.out.println("Login realizado com sucesso!");

                MenuOpcoes.main(null);

            } else {
                System.err.println("Username ou senha incorretos!");
            }

            if (!loginValido) {
                System.out.println("Digite 0 para sair ou qualquer outra tecla para tentar novamente.");
                op = Validacoes.lerOpcaoTexto();
            }
        }
    }
}