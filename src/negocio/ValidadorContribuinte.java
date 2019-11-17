/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

/**
 *
 * @author Julio
 */
public class ValidadorContribuinte {
    public static boolean validaNome(String nome) {
        return nome.contains(" ");
    }
    public static boolean validaTelefone(String telefone) {
        return (telefone.length() == 8);
    }
}
