package poo.unidade03.src.models;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private double comissao;

    public Funcionario(int id, String nome, String endereco, String telefone, String email, String cpf, String cargo, double salario, double comissao) {
        super(id, nome, endereco, telefone, email, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.comissao = comissao;
    }

    public void atualizarCargo(String cargo) {
        this.cargo = cargo;
    }

    public void atualizarSalario(double salario) {
        this.salario = salario;
    }

    public void calcularComissao(double comissao) {
        this.comissao = comissao;
    }

    public void consultarComissaoCargo() {
        System.out.println("Cargo: " + cargo);
        System.out.println("Comissão: " + comissao);
    }

    public void consultarDadosFuncionario() {
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
    }
    
}
