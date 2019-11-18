package negocio;

public class Contribuinte {

    private String nome;
    private String cpf;
    private int idade;
    private int numeroDependentes;
    private double contribuicaoPrevidenciaria;
    private double totalRendimentos;

    public Contribuinte(String nome, String cpf, int idade, int numeroDependentes, double contribuicaoPrevidenciaria, double totalRendimentos) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.numeroDependentes = numeroDependentes;
        this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
        this.totalRendimentos = totalRendimentos;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public double getContribuicaoPrevidenciaria() {
        return contribuicaoPrevidenciaria;
    }


    public double getTotalRendimentos() {
        return totalRendimentos;
    }

    @Override
    public String toString() {
        return "Contribuinte [idade=" + idade + ", contribuicaoPrevidenciaria=" + contribuicaoPrevidenciaria + ", cpf=" + cpf
                + ", nome=" + nome + ", numDependentes=" + numeroDependentes + ", totalRendimentos=" + totalRendimentos
                + "]";
    }

}
