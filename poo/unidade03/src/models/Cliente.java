package poo.unidade03.src.models;

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

    @Override
    public void consultarDados() {
        super.consultarDados();
        System.out.println("Tipo Cliente: "+ tipoCliente);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }
}
