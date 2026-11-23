package poo.unidade03.src.models;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private double[] comissao;
    private double totalComissao;
    private int id;

    public Funcionario(String nome, String endereco, String telefone, String email, String cpf, String cargo, double salario, double[] comissao) {
        super(nome, endereco, telefone, email, cpf);
        this.cargo = cargo;
        this.salario = salario;
        this.comissao = comissao;
    }

    public Funcionario(int id, String nome, String endereco, String telefone, String email, String cpf, String cargo, double salario, double[] comissao) {
        this(nome, endereco, telefone, email, cpf, cargo, salario, comissao);
        this.id = id;
    }

    public void atualizarCargo(String cargo) {
        this.cargo = cargo;
    }

    public void atualizarSalario(double salario) {
        this.salario = salario;
    }

    public void calcularComissao(double comissao) {
        //this.comissao = comissao;
    }

    public void consultarComissaoCargo() {        
        for(double a : comissao) {
            totalComissao += a;
        }

        System.out.println("Cargo: " + cargo);
        System.out.println("Comissão: " + totalComissao);
    }

    @Override 
    public void consultarDados() {
        super.consultarDados();
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário: " + salario);
    }
    
}
