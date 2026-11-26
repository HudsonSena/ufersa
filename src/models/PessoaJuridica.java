package models;

import database.Banco;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;
    private String tipoOrgao;
    private int id;

    public PessoaJuridica(String nome, String endereco, String telefone, String email, String cpf, String tipoCliente, String cnpj, String tipoOrgao) {
        super(nome, endereco, telefone, email, cpf, tipoCliente);
        this.cnpj = cnpj;
        this.tipoOrgao = tipoOrgao;
    }

    public PessoaJuridica(int id, String nome, String endereco, String telefone, String email, String cpf, String tipoCliente, String cnpj, String tipoOrgao) {
        this(nome, endereco, telefone, email, cpf, tipoCliente, cnpj, tipoCliente);
        this.id = id;
    }

    public boolean cadastrarClienteJu(Banco db) {
        String query = String.format("INSERT INTO clientes (nome, endereco, telefone, email, cpf, tipo_cliente, cnpj, tipo_orgao) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", getNome(), getEndereco(), getTelefone(), getEmail(), getCpf(), getTipoCliente(), cnpj, tipoOrgao);
        return db.queryUpdate(query) > 0;
    }

    public void atualizarEmpresa(String cnpj, String razaoSocial, String tipoOrgao) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.tipoOrgao = tipoOrgao;
    }

    public void validarCNPJ() {
        System.out.println("CNPJ: " + cnpj);
    }
    
    public void consultarDadosEmpresa() {
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("Tipo de Órgão: " + tipoOrgao);
    }

    @Override 
    public String getTipoCliente() {
        return super.getTipoCliente();
    }
}
