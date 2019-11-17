package negocio;

public class Contribuinte {

    private String nome;
    private String telefone;
    private char sexo;

    public Contribuinte(String umNome, String umTelefone, boolean masculino) {
        nome = umNome;
        telefone = umTelefone;
        if (masculino) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public char getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "[" + nome + "," + telefone + "," + sexo + "]";
    }
}
