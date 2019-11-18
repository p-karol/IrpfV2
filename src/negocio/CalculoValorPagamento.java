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
public class CalculoValorPagamento {
    
    private double baseCalculo;
    
    public CalculoValorPagamento(double baseCalculo){
        this.baseCalculo = baseCalculo; 
    }
    
    public double calculaValorPagamento(){
        
        if (baseCalculo <= 12000) {
            return 0.0;
        } 
        
        else {
            if (baseCalculo < 24000) {
                return ((baseCalculo - 12000) * 0.15);
            } else {
                return (12000 * 0.15 + (baseCalculo - 24000) * 0.275);
            }
        }
    }    
    
}
