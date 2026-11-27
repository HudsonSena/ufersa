package models;

import database.Banco;
import java.util.Date;

public class OrdemServico {
    private int id;
    private String titulo;
    private Date data;
    private StatusOs status;
    private Double valor;
    private String nomecliente;
    private String cpf;
    private String placa;

    public OrdemServico(String titulo, Double valor, String nomecliente) {
        this.titulo = titulo;
        this.status = StatusOs.ABERTA;
        this.valor = valor;
        this.nomecliente = nomecliente;
    }

    public OrdemServico(String titulo, Double valor, String nomecliente, String cpf, String placa) {
        this.titulo = titulo;
        this.status = StatusOs.ABERTA;
        this.valor = valor;
        this.cpf = cpf;
        this.placa = placa;
        this.nomecliente = nomecliente;
    }

    public OrdemServico(int id, String titulo, Date data, Double valor, String nomecliente, String cpf, String placa) {
        this(titulo, valor, nomecliente, cpf, placa);
        this.id = id;
        this.data = data;
    }

    public boolean cadastrarOrdem(Banco db) {
        String query = String.format("INSERT INTO servicos (titulo, status, valor, nome_cliente, cpf, placa, data) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', 'CURRENT_TIMESTAMP')", 
        titulo, status, valor, nomecliente, cpf, placa);
        return db.queryUpdate(query) > 0;
    }

    public void abrirOrdem() {
        this.status = StatusOs.ABERTA;
    }

    public void atualizarStatus() {
        this.status = StatusOs.EM_ANDAMENTO;
    }

    public void consultarOrdem() {
        System.out.println("Nome: " + titulo);
        System.out.println("Data: " + data);
        System.out.println("Status: " + status);
        System.out.println("Valor: " + valor);
        System.out.println("CPF: " + cpf);
        System.out.println("Cliente: " + nomecliente);

    }

    public void finalizarORdem() {
        this.status = StatusOs.CONCLUIDA;
    }

    public void cancelarOrdem() {
        this.status = StatusOs.CANCELADA;
    }
}
