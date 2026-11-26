package controllers;

import database.Banco;
import java.sql.SQLException;
import controllers.Validacoes;
import controllers.MenuOpcoes;

public class Login {

    public static void main(String[] args) {
        Banco db = new Banco();

        boolean loginValido = false;
        String op = "1";

        while (!loginValido && !op.equals("0")) {

            String username = Validacoes.lerUsername();
            String password = Validacoes.lerPassword();

                // Executa a consulta no banco (supondo que seu objeto db possua um método queryRs ou similar que retorna ResultSet)
                loginValido = db.validarLogin(username, password);

                // Se houver próximo registro, significa que o usuário e a senha batem
                if (loginValido) {
                    System.out.println("Login realizado com sucesso!");
                    MenuOpcoes.main(null);
                } else {
                    System.err.println("Username ou senha incorretos!");
                
                    System.out.println("Digite 0 para sair ou qualquer outra tecla para tentar novamente.");
                    op = Validacoes.lerOpcaoTexto();
                }
        }
        db.desconectar();
    }
}