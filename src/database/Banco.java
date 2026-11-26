package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Cliente;

public class Banco {

    private Connection db = null;
    private Statement statement = null;

    public Banco() {
        try {
            this.db = DriverManager.getConnection("jdbc:sqlite:sistema.db");
            this.statement = this.db.createStatement();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (db != null) {
                statement.close();
                db.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar: " + e.getMessage());
        }
    }

    public int queryUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
            return 0;
        }
    }

    public ResultSet querySearch(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Erro no banco: " + e.getMessage());
            return null;
        }
    }

    public boolean verificarEmailExistente(String email) {
        String query = "SELECT 1 FROM usuarios WHERE email = '" + email + "'";
        
        try (java.sql.Statement stmtLocal = db.createStatement();
            ResultSet rs = stmtLocal.executeQuery(query)) {
            
            return rs != null && rs.next();
            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar e-mail: " + e.getMessage());
        }
        
        return false;
    }

    public boolean verificarCPFExistente(String cpf) {
        String query = "SELECT 1 FROM clientes WHERE cpf = '" + cpf + "'";
        
        // O try-with-resources garante que o Statement e o ResultSet fecham sozinhos aqui dentro
        try (java.sql.Statement stmtLocal = db.createStatement();
             ResultSet rs = stmtLocal.executeQuery(query)) {
            
            // Se rs.next() for verdadeiro, significa que encontrou o registro no banco
            return rs != null && rs.next();
            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar cliente por CPF: " + e.getMessage());
        }
        
        return false;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        String query = "SELECT * FROM clientes WHERE cpf = '" + cpf + "'";
        Cliente cliente = null;
        
        try {
            ResultSet rs = querySearch(query);
            if (rs != null && rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String tipoCliente = rs.getString("tipo_cliente");
                
                cliente = new Cliente(nome, endereco, telefone, email, cpf, tipoCliente);
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por CPF: " + e.getMessage());
        }
        
        return cliente;
    }
}