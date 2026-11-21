package poo.unidade03.src.models;

public class Cliente extends Pessoa {
    private String tipoCliente;
    private int servicosConsumidos;

    public Cliente(int id, String nome, String endereco, String telefone, String email, String cpf, String tipoCliente) {
        super(id, nome, endereco, telefone, email, cpf);
        this.tipoCliente = tipoCliente;
        
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

    public void atualizarDados(int id, String nome, String endereco, String telefone, String email, String cpf, String tipoCliente) {
        super.atualizarDados(id, nome, endereco, telefone, email, cpf);
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }
}
