/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import dados.ContribuinteDAOException;
import dados.ContribuinteDAOJavaDb;
import java.util.List;

/**
 *
 * @author p-karol
 */
public class IrpfFachada {
    private ContribuinteDAO dao;
    
    public IrpfFachada() throws IrpfException {
        try {
            dao = ContribuinteDAOJavaDb.getInstance();
        } catch (ContribuinteDAOException e) {
            throw new IrpfException("Falha de criação da fachada!", e);
        }
    }
    
    public Contribuinte adicionarContribuinte(String nome, String cpf, int idade, int numeroDependentes, double contrubuicaoPrevidenciaria, double  totalRendimentos) throws IrpfException{
        
        if(!ValidadorContribuinte.isValidName(nome)) {
            throw new IrpfException("Nome de contribuinte inválido!");
        }
        if(!ValidadorContribuinte.isValidCPF(cpf)) {
            throw new IrpfException("CPF inválido!");
        }
       /* if(!ValidadorContribuinte.isValidAge(idade)) {
            throw new IrpfException("Idade inválida!");
        }
        */
        Contribuinte c = new Contribuinte(nome, cpf, idade,numeroDependentes,contrubuicaoPrevidenciaria,totalRendimentos);
        try {
            boolean ok = dao.adicionar(c);
            if(ok) {
                return c;
            }
            return null;
        } catch (ContribuinteDAOException e) {
            throw new IrpfException("Falha ao adicionar contribuinte!", e);
        }
    }
}
