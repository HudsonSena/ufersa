package poo.unidade03.src.models;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class OrdenServico {
    private DateTimeAtCompleted data;//verificar o modo certo de usar o datetime
    private StatusOs status;
    private Double valor;

    public OrdenServico(DateTimeAtCompleted data, StatusOs status, Double valor) {
        this.data = data;
        this.status = StatusOs.ABERTA;
        this.valor = valor;
    }

    public void abrirOrdem() {
        this.status = StatusOs.ABERTA;
    }

    public void adicionarProduto() {
        // Método para adicionar produtos à ordem de serviço (a ser implementado)
    }

    public void removerProduto() {
        // Método para remover produtos da ordem de serviço (a ser implementado)
    }

    public void adicionarServico() {
        // Método para adicionar serviços à ordem de serviço (a ser implementado)
    }

    public void removerServico() {
        // Método para remover serviços da ordem de serviço (a ser implementado)
    }

    public Double calcularValorTotal() {
        // Método para calcular o valor total da ordem de serviço (a ser implementado)
        return 0.0;
    }

    public void atualizarStatus(StatusOs novoStatus) {
        this.status = novoStatus;
    }

    public void consultarOrdem() {
        System.out.println("Data: " + data);
        System.out.println("Status: " + status);
        System.out.println("Valor: " + valor);
    }

    public void finalizarORdem() {
        this.status = StatusOs.CONCLUIDA;
    }

    public void cancelarOrdem() {
        this.status = StatusOs.CANCELADA;
    }
}
