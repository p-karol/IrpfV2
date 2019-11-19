/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import negocio.*;

/**
 *
 * @author p-karol
 */
public class CalculoIrpfTest {
    
    @Test
    public void addContribuinteTest() throws IrpfException {
        String nome;
        String cpf;
        int idade;
        int numeroDependentes;
        double contribuicaoPrevidenciaria;
        double  totalRendimentos;
        String tipo;
        
        IrpfFachada fachada = new IrpfFachada();
        
        nome = "Priscilla Karolczak";
        cpf = "00742165035";
        idade = 20;
        numeroDependentes = 1;
        contribuicaoPrevidenciaria = 15000;
        totalRendimentos = 150000;
        tipo = "Simplificado";
        
        assertNotNull(fachada.adicionarContribuinte(nome, cpf, idade, numeroDependentes, contribuicaoPrevidenciaria, totalRendimentos, tipo));   
    }
    
    @Test
    public void calculaIrpfSimplificadoTest() throws IrpfException{
        Contribuinte contribuinte = contribuinteExemplo();
        IrpfFachada fachada = new IrpfFachada();
        assertEquals(16936.0, fachada.calculaIrpf(contribuinte, "Simplificado"), 0.001);
    }
    
    @Test
    public void calculaIrpfCompletoTest() throws IrpfException{
        Contribuinte contribuinte = contribuinteExemplo();
        IrpfFachada fachada = new IrpfFachada();
        assertEquals(17622.4, fachada.calculaIrpf(contribuinte, "Completo"), 0.001);
    }
    
    @Test
    public void calculaIrpfCompletoIdosoTest() throws IrpfException{
        Contribuinte contribuinte = contribuinteIdosoExemplo();
        IrpfFachada fachada = new IrpfFachada();
        assertEquals(17393.6, fachada.calculaIrpf(contribuinte, "Completo"), 0.001);
    }
    
    
    //devolve um contribuinte para teste
    private Contribuinte contribuinteExemplo() {
        return new Contribuinte("Priscilla Karolczak", "00742165035", 33, 1, 16800.00, 100000.00);
    }
    
    //devolve um contribuinte para teste
    private Contribuinte contribuinteIdosoExemplo() {
        return new Contribuinte("Priscilla Karolczak", "00742165035", 75, 1, 16800.00, 100000.00);
    }
    
        
}
