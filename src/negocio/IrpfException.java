/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Júlio
 */
public class IrpfException extends Exception {

    /**
     * Creates a new instance of
     * <code>CadastroException</code> without detail message.
     */
    public IrpfException() {
    }

    /**
     * Constructs an instance of
     * <code>CadastroException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public IrpfException(String msg) {
        super(msg);
    }

    public IrpfException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
