package negocio;

public class Contribuinte {

    private String nome;
    private String cpf;
    private int Idade;
    private int numeroDependentes;
    private double contrubuicaoPrevidenciaria;
    private double totalRendimentos;

    public Contribuinte(String nome, String cpf, int idade, int numDependentes, double contrubuicaoPrevidenciaria, double totalRendimentos) {
        this.nome = nome;
        this.cpf = cpf;
        Idade = idade;
        this.numeroDependentes = numeroDependentes;
        this.contrubuicaoPrevidenciaria = contrubuicaoPrevidenciaria;
        this.totalRendimentos = totalRendimentos;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return Idade;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public double getContrubuicaoPrevidenciaria() {
        return contrubuicaoPrevidenciaria;
    }


    public double getTotalRendimentos() {
        return totalRendimentos;
    }

    @Override
    public String toString() {
        return "Contribuinte [Idade=" + Idade + ", contrubuicaoPrevidenciaria=" + contrubuicaoPrevidenciaria + ", cpf=" + cpf
                + ", nome=" + nome + ", numDependentes=" + numeroDependentes + ", totalRendimentos=" + totalRendimentos
                + "]";
    }

}
