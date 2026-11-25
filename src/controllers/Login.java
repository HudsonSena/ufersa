package controllers;

import database.Banco;
import java.sql.ResultSet;
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

            // Monta a query para buscar o usuário que tenha o username e a senha correspondentes
            String query = String.format(
                "SELECT * FROM usuarios WHERE username = '%s' AND password = '%s'", 
                username, password
            );

            try {
                // Executa a consulta no banco (supondo que seu objeto db possua um método queryRs ou similar que retorna ResultSet)
                ResultSet rs = db.querySearch(query);

                // Se houver próximo registro, significa que o usuário e a senha batem
                if (rs != null && rs.next()) {
                    loginValido = true;
                    System.out.println("Login realizado com sucesso!");
                    MenuOpcoes.main(null);
                } else {
                    System.err.println("Username ou senha incorretos!");
                }
            } catch (SQLException e) {
                System.err.println("Erro ao consultar o banco de dados: " + e.getMessage());
            }

            if (!loginValido) {
                System.out.println("Digite 0 para sair ou qualquer outra tecla para tentar novamente.");
                op = Validacoes.lerOpcaoTexto();
            }
        }
    }
}