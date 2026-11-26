package models;

import database.Banco;
import models.Pessoa;

public class Cliente extends Pessoa {
    private String tipoCliente;
    private int servicosConsumidos;
    private int id;

    public Cliente(String nome, String endereco, String telefone, String email, String cpf, String tipoCliente) {
        super(nome, endereco, telefone, email, cpf);
        this.tipoCliente = tipoCliente;
    }

    public Cliente(int id, String nome, String endereco, String telefone, String email, String cpf, String tipoCliente) {
        this(nome, endereco, telefone, email, cpf, tipoCliente);
        this.id = id;
    }

    public boolean cadastrarCliente(Banco db) {
        String query = String.format("INSERT INTO clientes (nome, endereco, telefone, email, cpf, tipo_cliente) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", getNome(), getEndereco(), getTelefone(), getEmail(), getCpf(), tipoCliente);
        return db.queryUpdate(query) > 0;
    }

    public void atualizarTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void atualizarServicosConsumidos(int servicosConsumidos) {
        this.servicosConsumidos = servicosConsumidos;
    }

    public void consultarOrdens() {
        System.out.println("Serviços Consumidos: " + servicosConsumidos);
    }

    public void atualizarDados(String nome, String endereco, String telefone, String email, String cpf, String tipoCliente) {
        super.atualizarDados(nome, endereco, telefone, email, cpf);
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente() {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void consultarDados() {
        super.consultarDados();
        System.out.println("Tipo Cliente: "+ tipoCliente);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getTelefone() {
        return super.getTelefone();
    }

    @Override
    public String getEndereco() {
        return super.getEndereco();
    }

    @Override
    public String getTelefone() {
        return super.getTelefone();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getCpf() {
        return super.getCpf();
    }

}
