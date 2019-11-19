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
    private ListaContribuintesModel modelSaidaTexto;

    public ImpostoController() throws IrpfException {
        fachada = new IrpfFachada();
        modelSaidaTexto = new ListaContribuintesModel(toListString(fachada.buscarTodos()));
    }
    
    public double calcularIrpf(String nome, String cpf, int idade, int numeroDependentes, double contribuicaoPrevidenciaria, double  totalRendimentos, String tipo) throws IrpfException {
        Contribuinte p = fachada.adicionarContribuinte(nome, cpf, idade, numeroDependentes, contribuicaoPrevidenciaria,  totalRendimentos, tipo);
        
        if(p != null)
            modelSaidaTexto.add(p.toString());
        
        return fachada.calculaIrpf(p, tipo);
    }
    
    private List<String> toListString(List<Contribuinte> listaOrigem) {
        List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
        for(Contribuinte c : listaOrigem) {
            listaDestino.add(c.toString());
        }
        return listaDestino;
    }
    
    public List<String> getTodos() throws IrpfException {
        return toListString(fachada.buscarTodos());
    }
    
    public ListModel<String> getListaContribuinteModel(){
        return modelSaidaTexto;
    }
    
    
}
