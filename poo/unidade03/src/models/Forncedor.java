package poo.unidade03.src.models;

public class Forncedor extends Pessoa {
    private String cnpj;

    public Forncedor(String nome, String endereco, String telefone, String email, String cpf, String cnpj) {
        super(nome, endereco, telefone, email, cpf);
        this.cnpj = cnpj;
    }

    public void fornecerProduto() {
        // Lógica para fornecer produto (a ser implementada)
        System.out.println("Fornecedor fornecendo produto...");
    }

    public void listarProdutos() {
        // Lógica para listar produtos (a ser implementada)
        System.out.println("Listando produtos do fornecedor...");
    }

    @Override
    public void consultarDados() {
        super.consultarDados();
        System.out.println("CNPJ: " + cnpj);
    }
}