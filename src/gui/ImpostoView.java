/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaPrincipal.java
 *
 * Created on 03/04/2011, 17:48:10
 */
package gui;

import javax.swing.JOptionPane;
import negocio.IrpfException;

/**
 *
 * @author Julio
 */
public class ImpostoView extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public ImpostoView() throws IrpfException {
        controlador = new ImpostoController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOpcao = new javax.swing.ButtonGroup();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblOpcao = new javax.swing.JLabel();
        rdSimplificado = new javax.swing.JRadioButton();
        rdCompleto = new javax.swing.JRadioButton();
        btCalcular = new javax.swing.JButton();
        lblRendimentos = new javax.swing.JLabel();
        txtRendimentos = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        lblDependentes = new javax.swing.JLabel();
        txtDependentes = new javax.swing.JTextField();
        lblContribuicao = new javax.swing.JLabel();
        txtContribuicao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Contribuinte");

        lblNome.setText("Nome:");

        lblOpcao.setText("Opção");

        grupoOpcao.add(rdSimplificado);
        rdSimplificado.setSelected(true);
        rdSimplificado.setText("Simplificado");
        rdSimplificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdSimplificadoActionPerformed(evt);
            }
        });

        grupoOpcao.add(rdCompleto);
        rdCompleto.setText("Completo");
        rdCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCompletoActionPerformed(evt);
            }
        });

        btCalcular.setText("Calcular");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularActionPerformed(evt);
            }
        });

        lblRendimentos.setText("Total de Rendimentos");

        lblCpf.setText("CPF");

        lblIdade.setText("Idade");

        lblDependentes.setText("Numero de dependentes");

        lblContribuicao.setText("Contribuição previdênciária oficial");

        jList1.setModel(controlador.getListaContribuinteModel());
        jScrollPane1.setViewportView(jList1);

        jLabel2.setText("Impostos calculados");
        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRendimentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRendimentos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCpf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDependentes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDependentes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContribuicao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContribuicao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOpcao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdSimplificado)
                        .addGap(18, 18, 18)
                        .addComponent(rdCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(btCalcular)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDependentes)
                    .addComponent(txtDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContribuicao)
                    .addComponent(txtContribuicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRendimentos)
                    .addComponent(txtRendimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCalcular)
                    .addComponent(lblOpcao)
                    .addComponent(rdSimplificado)
                    .addComponent(rdCompleto))
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularActionPerformed
        
        int idade = -1; 
        int numeroDependentes = -1;
        double contribuicaoPrevidenciaria = -1;
        double totalRendimentos = -1;
        
        String tipo;
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        
        String strIdade = txtIdade.getText();
        if(!strIdade.isEmpty())
            idade = Integer.parseInt(strIdade);
        
        String strNumeroDependentes = txtDependentes.getText();
        if(!strNumeroDependentes.isEmpty())
            numeroDependentes = Integer.parseInt(strNumeroDependentes);
        
        String strContribuicaoPrevidenciaria = txtContribuicao.getText();
        if(!strContribuicaoPrevidenciaria.isEmpty())
            contribuicaoPrevidenciaria = Double.parseDouble(strContribuicaoPrevidenciaria);
        
        String strTotalRendimentos = txtRendimentos.getText();
        if(!strTotalRendimentos.isEmpty())
            totalRendimentos = Double.parseDouble(strTotalRendimentos);
        
        if(rdCompleto.isSelected())
                tipo = "Completo";
        else
                tipo = "Simplificado";
        
        try {
            double valor = controlador.calcularIrpf(nome, cpf, idade, numeroDependentes, contribuicaoPrevidenciaria, totalRendimentos, tipo);
            JOptionPane.showMessageDialog(this, "Valor a pagar: '" + valor + "'.");
            
            //JOptionPane.showMessageDialog(this, "Não foi possível calcular irpf do contribuinte.");
            
        } catch (IrpfException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btCalcularActionPerformed

    private void rdSimplificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdSimplificadoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rdSimplificadoActionPerformed

    private void rdCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdCompletoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new ImpostoView().setVisible(true);
                } catch (IrpfException ex) {
                    System.out.println("Erro fatal: " + ex.getMessage());
                    System.out.println(ex.toString());
                    System.exit(0);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btCalcular;
    private javax.swing.ButtonGroup grupoOpcao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContribuicao;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDependentes;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblOpcao;
    private javax.swing.JLabel lblRendimentos;
    private javax.swing.JRadioButton rdCompleto;
    private javax.swing.JRadioButton rdSimplificado;
    private javax.swing.JTextField txtContribuicao;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDependentes;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRendimentos;
    // End of variables declaration//GEN-END:variables
    private ImpostoController controlador;
}
