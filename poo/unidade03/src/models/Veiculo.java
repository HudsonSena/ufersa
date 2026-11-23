package poo.unidade03.src.models;

public class Veiculo {
    private String modelo;
    private String marca;
    private String placa;
    private int ano;
    private int id;
    private int idCliente;

    public Veiculo(String modelo, String marca, String placa, int ano, int idCliente) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.idCliente = idCliente;
    }

    public Veiculo(int id, String modelo, String marca, String placa, int ano, int idCliente) {
        this(modelo, marca, placa, ano, idCliente);
        this.id = id;
    }

    public void atualizarDados(int id, String modelo, String marca, String placa, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
        this.id = id;
    }

    public void consultarVeiculo() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Placa: " + placa);
        System.out.println("Ano: " + ano);
    }

    public void consultarOrdens() {
        // Método para consultar ordens de serviço relacionadas ao veículo (a ser implementado)
    }
}
