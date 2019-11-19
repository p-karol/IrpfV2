/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dados.ContribuinteDAOException;
import java.util.List;

/**
 *
 * @author p-karol
 */
public interface ContribuinteDAO {
    boolean adicionar(Contribuinte p) throws ContribuinteDAOException;
    public List<Contribuinte> getTodos() throws ContribuinteDAOException;
}
