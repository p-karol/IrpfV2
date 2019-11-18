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

// usa padrão Strategy para ter métodos distintos dependendo da demanda, deixando fácil a adição de novos cálculos em caso de mudanças e evitando uso de ifs
public interface CalculoIrpf {
    
    public double calcular(Contribuinte contribuinte);
    
}
