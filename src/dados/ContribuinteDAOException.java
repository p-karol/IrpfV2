/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author p-karol
 */
public class ContribuinteDAOException extends Exception {

    /**
     * Creates a new instance of
     * <code>CadastroDAOException</code> without detail message.
     */
    public ContribuinteDAOException() {
    }

    /**
     * Constructs an instance of
     * <code>CadastroDAOException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ContribuinteDAOException(String msg) {
        super(msg);
    }

    public ContribuinteDAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
