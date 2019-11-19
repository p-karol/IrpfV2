/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author p-karol
 */
public class CalculoIrpfCompleto implements CalculoIrpf {
        
    @Override
    public double calcular(Contribuinte contribuinte){
        
        double desconto;
        int dependentes = contribuinte.getNumeroDependentes();
        boolean idoso = contribuinte.getIdade() >= 65;
        
        //define base de calculo do contribuinte, separado em classe caso mude a lógica facilita manutenção/usada tb pro calculo simples
        CalculoBase baseCalculo = new CalculoBase(contribuinte);
        double base = baseCalculo.calculoBaseCalculo();
        
        //calcula o desconto de acordo com dependentes e idade (idoso/nao idoso)
        if (dependentes <= 2) {
            desconto = idoso ? 0.03 : 0.02;
        } else if (dependentes <= 5) {
            desconto = idoso ? 0.045 : 0.035;
        } else {
            desconto = idoso ? 0.06 : 0.05;
        }
        
        //aplica desconto ao valor base
        double baseComDesconto = base - (base * desconto);
        
        //calcula e retorna valor de pagamento
        CalculoValorPagamento valorPagamento = new CalculoValorPagamento(baseComDesconto);
        return valorPagamento.calculaValorPagamento();
        
        
    }
} 
