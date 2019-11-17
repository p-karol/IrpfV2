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
public class CadastroControlador {
    private IrpfFachada fachada;
    private ListaPessoasModel modelSaidaTexto;

    public CadastroControlador() throws IrpfException {
        fachada = new IrpfFachada();
        modelSaidaTexto = new ListaPessoasModel(toListString(fachada.buscarTodos()));
    }

    public ListModel<String> getListaPessoasModel(){
        return modelSaidaTexto;
    }
    
    private List<String> toListString(List<Contribuinte> listaOrigem) {
        List<String> listaDestino = new ArrayList<String>(listaOrigem.size());
        for(Contribuinte p : listaOrigem) {
            listaDestino.add(p.toString());
        }
        return listaDestino;
    }
    
    public boolean adicionarPessoa(String nome, String telefone, boolean masculino) throws IrpfException {
        Contribuinte p = fachada.adicionarPessoa(nome, telefone, masculino);
        if(p != null){
            modelSaidaTexto.add(p.toString());
            return true;
        }
        return false;
    }

    public List<String> buscarHomens() throws IrpfException {
        return toListString(fachada.buscarHomens());
    }

    public List<String> buscarMulheres() throws IrpfException {
        return toListString(fachada.buscarMulheres());
    }

    public List<String> getTodos() throws IrpfException {
        return toListString(fachada.buscarTodos());
    }
}
