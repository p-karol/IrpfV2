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
public class CalculoBase {
    
    private Contribuinte contribuinte;
    
    public CalculoBase(Contribuinte contribuinte){
        this.contribuinte = contribuinte;
    }
    
    public double calculoBaseCalculo() {
        return contribuinte.getTotalRendimentos() - contribuinte.getContribuicaoPrevidenciaria();
    }   
}
