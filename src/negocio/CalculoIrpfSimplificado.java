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
    
    double desconto;
    CalculoBase baseCalculo;
    double baseComDesconto;
    CalculoValorPagamento valorPagamento;
    
    @Override
    public double calcular(Contribuinte contribuinte){
        
        double base = baseCalculo.calculoBaseCalculo(contribuinte);
        desconto = 0.05; 
        
        //aplica desconto ao valor base
        baseComDesconto = base - (base * desconto);
        
        return valorPagamento.calculaValorPagamento(baseComDesconto);
        
    }
} 
