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
    private ListaPessoasModel modelSaidaTexto;

    public ImpostoController() throws IrpfException {
        fachada = new IrpfFachada();
       // modelSaidaTexto = new ListaPessoasModel(toListString(fachada.buscarTodos()));
    }

    public ListModel<String> getListaPessoasModel(){
        return modelSaidaTexto;
    }
    
    public boolean adicionarContribuinte(String nome, String cpf, int idade, int numeroDependentes, double contrubuicaoPrevidenciaria, double  totalRendimentos) throws IrpfException {
        Contribuinte p = fachada.adicionarContribuinte(nome, cpf, idade, numeroDependentes, contrubuicaoPrevidenciaria,  totalRendimentos);
        if(p != null){
//            modelSaidaTexto.add(p.toString());
            return true;
        }
        return false;
    }
}
