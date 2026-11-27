package database;

public class criarBanco {
    public static void main(String[] args) {
        Banco db = new Banco();

        db.queryUpdate("CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "username TEXT NOT NULL, "
                + "email TEXT NOT NULL, "
                + "password TEXT NOT NULL)");

        db.queryUpdate("CREATE TABLE IF NOT EXISTS clientes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nome TEXT NOT NULL, "
                + "endereco TEXT, "
                + "telefone TEXT, "
                + "email TEXT UNIQUE NOT NULL, "
                + "cpf TEXT UNIQUE, "
                + "tipo_cliente TEXT, "
                + "cnpj TEXT, "
                + "tipo_orgao TEXT)");

        db.queryUpdate("CREATE TABLE IF NOT EXISTS veiculos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "modelo TEXT, "
                + "marca TEXT, "
                + "placa TEXT, "
                + "ano TEXT, "
                + "cpf TEXT)");

        db.queryUpdate("CREATE TABLE IF NOT EXISTS servicos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "titulo TEXT NOT NULL, "
                + "data DATETIME, "
                + "status TEXT, "
                + "valor DECIMAL(10, 2), "
                + "nome_cliente TEXT, "
                + "cpf TEXT, "
                + "placa TEXT)");
    }
    
}
