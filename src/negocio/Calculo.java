package negocio;

public class Calculo {

    private Contribuinte contribuinte;
    private String tipo;
    private double valor;
   

    public Calculo(Contribuinte contribuinte, String tipo, double valor) {
        this.contribuinte = contribuinte;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
