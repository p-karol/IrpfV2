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
public class CalculoIrpfFactory {
    
    //devolve um CalculoIrpf, dependendo do tipo
    public CalculoIrpf criarCalculoIrpf(String Tipo){
        
        CalculoIrpf calculo;
    
        if(Tipo == "Simplificado"){
            calculo = new CalculoIrpfSimplificado();
        }
        else {
            calculo = new CalculoIrpfCompleto();
        }
        
        return calculo;
    }  
}
