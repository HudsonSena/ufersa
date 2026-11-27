package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Cliente;

public class Banco {

    private Connection db = null;
    // Removido o 'private Statement statement = null;' global para evitar que fique preso!

    public Banco() {
        try {
            this.db = DriverManager.getConnection("jdbc:sqlite:sistema.db");
            
            // Configurações vitais para o SQLite gerenciar concorrência e esperar o banco liberar
            try (Statement stmtConfig = this.db.createStatement()) {
                stmtConfig.execute("PRAGMA journal_mode=WAL;");
                stmtConfig.execute("PRAGMA busy_timeout=5000;"); // Espera até 5 segundos se estiver ocupado
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (db != null && !db.isClosed()) {
                db.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar: " + e.getMessage());
        }
    }

    public boolean validarLogin(String username, String senha) {
        // Consulta que busca apenas se existe um registro com o e-mail e senha informados
        String query = "SELECT 1 FROM usuarios WHERE username = '" + username + "' AND password = '" + senha + "'";
        
        // O try-with-resources garante que o Statement e o ResultSet fecham sozinhos,
        // mesmo se a senha estiver incorreta ou ocorrer qualquer erro.
        try (Statement stmtLocal = db.createStatement();
             ResultSet rs = stmtLocal.executeQuery(query)) {
            
            // Retorna true se encontrou o usuário com essa senha, ou false se falhou
            return rs != null && rs.next();
            
        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
        }
        
        return false;
    }

    // 1. INSERT / UPDATE / DELETE SEGURO (Fecha o Statement automaticamente)
    public int queryUpdate(String query) {
        try (Statement stmt = db.createStatement()) {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Erro no banco (Update): " + e.getMessage());
            return 0;
        }
    }

    // 2. VERIFICAÇÃO DE CPF (O seu método, agora garantido que fecha tudo)
    public boolean verificarCPFExistente(String cpf) {
        String query = "SELECT 1 FROM clientes WHERE cpf = '" + cpf + "'";
        
        try (Statement stmtLocal = db.createStatement();
             ResultSet rs = stmtLocal.executeQuery(query)) {
            
            return rs != null && rs.next();
            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar cliente por CPF: " + e.getMessage());
        }
        
        return false;
    }

    // 3. VERIFICAÇÃO DE E-MAIL (Também isolada)
    public boolean verificarEmailExistente(String email) {
        String query = "SELECT 1 FROM usuarios WHERE email = '" + email + "'";
        
        try (Statement stmtLocal = db.createStatement();
             ResultSet rs = stmtLocal.executeQuery(query)) {
            
            return rs != null && rs.next();
            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar e-mail: " + e.getMessage());
        }
        
        return false;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        String query = "SELECT * FROM clientes WHERE cpf = '" + cpf + "'";
        Cliente cliente = null;
        
        // O try-with-resources garante que tanto o Statement quanto o ResultSet
        // serão fechados automaticamente assim que sairmos deste bloco (com ou sem sucesso)
        try (java.sql.Statement stmtLocal = db.createStatement();
             ResultSet rs = stmtLocal.executeQuery(query)) {
            
            if (rs != null && rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String tipoCliente = rs.getString("tipo_cliente");
                
                // Instancia o objeto na memória com os dados encontrados
                cliente = new Cliente(nome, endereco, telefone, email, cpf, tipoCliente);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por CPF: " + e.getMessage());
        }
        
        // Neste ponto, o banco já está livre e a consulta já foi fechada.
        // Retorna o objeto 'cliente' preenchido ou 'null' se não encontrar.
        return cliente;
    }

    public boolean verificarPlacaExistente(String placa, String cpf) {
        String query = "SELECT 1 FROM veiculos WHERE placa = '" + placa + "' AND cpf_cliente = '" + cpf + "'";
        
        try (Statement stmtLocal = db.createStatement();
             ResultSet rs = stmtLocal.executeQuery(query)) {
            
            return rs != null && rs.next();
            
        } catch (SQLException e) {
            System.out.println("Erro ao verificar placa: " + e.getMessage());
        }
        
        return false;
    }
}