package models;

import database.Banco;

public class Veiculo {
    private String modelo;
    private String marca;
    private String placa;
    private String ano;
    private int id;
    private String cpfCliente;

    public Veiculo(String modelo, String marca, String placa, String ano, String cpfCliente) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.cpfCliente = cpfCliente;
    }

    public Veiculo(int id, String modelo, String marca, String placa, String ano, String cpfCliente) {
        this(modelo, marca, placa, ano, cpfCliente);
        this.id = id;
    }

    public boolean cadastrarVeiculo(Banco db) {
        String query = String.format("INSERT INTO veiculos (modelo, marca, placa, ano, cpf_cliente) VALUES ('%s', '%s', '%s', '%s', '%s')", modelo, marca, placa, ano, cpfCliente);
        return db.queryUpdate(query) > 0;
    }

    public void atualizarDados(int id, String modelo, String marca, String placa, String ano, String cpfCliente) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.id = id;
        this.cpfCliente = cpfCliente;
    }

    public void consultarVeiculo() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Placa: " + placa);
        System.out.println("Ano: " + ano);
        System.out.println("CPF cliente: " + cpfCliente);
    }

    public void consultarOrdens() {
        // Método para consultar ordens de serviço relacionadas ao veículo (a ser implementado)
    }
}
