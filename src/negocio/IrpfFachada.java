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
 * @author Julio
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
    
    public Contribuinte adicionarPessoa(String nome, String telefone, boolean masculino) throws IrpfException{
        if(!ValidadorContribuinte.validaNome(nome)) {
            throw new IrpfException("Nome de pessoa inválido!");
        }
        if(!ValidadorContribuinte.validaTelefone(telefone)) {
            throw new IrpfException("Número de telefone inválido!");
        }
        Contribuinte p = new Contribuinte(nome, telefone, masculino);
        try {
            boolean ok = dao.adicionar(p);
            if(ok) {
                return p;
            }
            return null;
        } catch (ContribuinteDAOException e) {
            throw new IrpfException("Falha ao adicionar pessoa!", e);
        }
    }

    public List<Contribuinte> buscarHomens() throws IrpfException{
        try {
            return dao.getHomens();
        } catch (ContribuinteDAOException e) {
            throw new IrpfException("Falha ao buscar homens!", e);
        }
    }

    public List<Contribuinte> buscarMulheres() throws IrpfException{
        try {
            return dao.getMulheres();
        } catch (ContribuinteDAOException e) {
            throw new IrpfException("Falha ao buscar mulheres!", e);
        }
    }

    public List<Contribuinte> buscarTodos() throws IrpfException{
        try {
            return dao.getTodos();
        } catch (ContribuinteDAOException e) {
            throw new IrpfException("Falha ao buscar pessoas!", e);
        }
    }

    public Contribuinte buscarPessoaPorNome(String n) throws IrpfException{
        try{
            return dao.getPessoaPorNome(n);
        } catch(ContribuinteDAOException e) {
            throw new IrpfException("Falha ao buscar pessoa", e);
        }
    }
}
