package models;

import database.Banco;
import java.util.Date;

public class OrdemServico {
    private int id;
    private String nome;
    private Date data;
    private StatusOs status;
    private Double valor;
    private String nomecliente;
    private int idCliente;
    private int idVeiculo;

    public OrdemServico(String nome, Double valor, String nomecliente, int idCliente, int idVeiculo) {
        this.nome = nome;
        this.status = StatusOs.ABERTA;
        this.valor = valor;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
        this.nomecliente = nomecliente;
    }

    public OrdemServico(int id, String nome, Date data, Double valor, String nomecliente, int idCliente, int idVeiculo) {
        this(nome, valor, nomecliente, idCliente, idVeiculo);
        this.id = id;
        this.data = data;
    }

    public boolean cadastrarOrdem(Banco db) {
        String query = String.format("INSERT INTO servicos (nome, data, status, valor, nome_cliente, id_cliente, id_veiculo) VALUES ('%s', 'CURRENT_TIMESTAMP', '%s', '%s', '%s', '%d', '%d')", 
        nome, status, valor, nomecliente, idCliente, idVeiculo);
        return db.queryUpdate(query) > 0;
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
        System.out.println("Cliente: " + nomecliente);

    }

    public void finalizarORdem() {
        this.status = StatusOs.CONCLUIDA;
    }

    public void cancelarOrdem() {
        this.status = StatusOs.CANCELADA;
    }
}
