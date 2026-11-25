package models;

import java.util.Date;

public class OrdenServico {
    private int id;
    private String nome;
    private Date data;
    private StatusOs status;
    private Double valor;
    private int idCliente;
    private int idVeiculo;

    public OrdenServico(String nome, Date data, StatusOs status, Double valor, int idCliente, int idVeiculo) {
        this.nome = nome;
        this.data = data;
        this.status = StatusOs.ABERTA;
        this.valor = valor;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
    }

    public OrdenServico(int id, String nome, Date data, StatusOs status, Double valor, int idCliente, int idVeiculo) {
        this(nome, data, status, valor, idCliente, idVeiculo);
        this.id = id;
    }

    public void abrirOrdem() {
        this.status = StatusOs.ABERTA;
    }

    public void atualizarStatus() {
        this.status = StatusOs.EM_ANDAMENTO;
    }

    public void consultarOrdem() {
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Status: " + status);
        System.out.println("Valor: " + valor);
        System.out.println("Id Cliente: " + idCliente);
    }

    public void finalizarORdem() {
        this.status = StatusOs.CONCLUIDA;
    }

    public void cancelarOrdem() {
        this.status = StatusOs.CANCELADA;
    }
}
