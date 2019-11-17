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
    
    double desconto;
    CalculoBase baseCalculo;
    double baseComDesconto;
    CalculoValorPagamento valorPagamento;
    
    @Override
    public double calcular(Contribuinte contribuinte){
        
        int dependentes = contribuinte.getNumeroDependentes();
        boolean idoso = contribuinte.getIdade() >= 65;
        double base = baseCalculo.calculoBaseCalculo(contribuinte);
        
        //calcula o desconto de acordo com dependentes e idade (idoso/nao idoso)
        if (dependentes <= 2) {
            desconto = idoso ? 0.03 : 0.02;
        } else if (dependentes <= 5) {
            desconto = idoso ? 0.045 : 0.035;
        } else {
            desconto = idoso ? 0.06 : 0.05;
        }
        
        //aplica desconto ao valor base
        baseComDesconto = base - (base * desconto);
        
        return valorPagamento.calculaValorPagamento(baseComDesconto);
        
    }
} 
