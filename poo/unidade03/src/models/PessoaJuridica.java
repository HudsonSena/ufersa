package poo.unidade03.src.models;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;
    private String tipoOrgao;

    public PessoaJuridica(int id, String nome, String endereco, String telefone, String email, String cpf, String tipoCliente, String cnpj, String razaoSocial, String tipoOrgao) {
        super(nome, endereco, telefone, email, cpf, tipoCliente);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.tipoOrgao = tipoOrgao;
    }

    public void atualizarEmpresa(String cnpj) {
        this.cnpj = cnpj;
    }

    public void validarCNPJ() {
        System.out.println("CNPJ: " + cnpj);
    }
    
    public void consultarDadosEmpresa() {
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Razão Social: " + razaoSocial);
        System.out.println("Tipo de Órgão: " + tipoOrgao);
    }
}
