/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import negocio.*;

/**
 *
 * @author p-karol
 */
public class ImpostoController {
    private IrpfFachada fachada;
    private ListaContribuintes modelSaidaTexto;

    public ImpostoController() throws IrpfException {
        fachada = new IrpfFachada();
       // modelSaidaTexto = new ListaContribuintes(toListString(fachada.buscarTodos()));
    }

    public ListModel<String> getListaPessoasModel(){
        return modelSaidaTexto;
    }
    
    public double calcularIrpf(String nome, String cpf, int idade, int numeroDependentes, double contrubuicaoPrevidenciaria, double  totalRendimentos, String tipo) throws IrpfException {
        Contribuinte p = fachada.adicionarContribuinte(nome, cpf, idade, numeroDependentes, contrubuicaoPrevidenciaria,  totalRendimentos, tipo);
        System.out.println(p.toString());
        return fachada.calculaIrpf(p, tipo);
    }
    
    
}
