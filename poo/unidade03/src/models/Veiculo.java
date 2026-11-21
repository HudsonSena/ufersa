package poo.unidade03.src.models;

public class Veiculo {
    private String modelo;
    private String marca;
    private String placa;
    private int ano;

    public Veiculo(String modelo, String marca, String placa, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
    }

    public void atualizarDados(String modelo, String marca, String placa, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.ano = ano;
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
