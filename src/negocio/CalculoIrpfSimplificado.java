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
public class CalculoIrpfSimplificado implements CalculoIrpf {
    
    @Override
    public double calcular(Contribuinte contribuinte){
        
        //calcula base de calculo do contribuinte 
        CalculoBase baseCalculo = new CalculoBase(contribuinte);
        double base = baseCalculo.calculoBaseCalculo();
        
        //define desconto simplificado
        double desconto = 0.05; 
        
        //aplica desconto ao valor base
        double baseComDesconto = base - (base * desconto);
        
        //calcula valor a pagar utilizando a nova base, pos desconto
        CalculoValorPagamento valorPagamento = new CalculoValorPagamento(baseComDesconto);
        
        //retorna resultado de valor a pagar
        return valorPagamento.calculaValorPagamento();
        
    }
} 
