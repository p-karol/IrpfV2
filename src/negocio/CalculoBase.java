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
    
    public double calculoBaseCalculo(Contribuinte contribuinte) {
        return (contribuinte.getTotalRendimentos() - contribuinte.getContrubuicaoPrevidenciaria());
    }   
}
