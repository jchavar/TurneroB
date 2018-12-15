/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Modelo.*;
import Métodos.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Miguel
 */
public class PedirTurno extends javax.swing.JFrame {
    Cola c = new Cola();
    Métodos_Config mC = new Métodos_Config();
    Métodos m = new Métodos();
    /**
     * Creates new form Ventana
     * @throws java.io.FileNotFoundException
     */
    public PedirTurno() throws FileNotFoundException, IOException {
        initComponents();
        m.listar(jComboBox1);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCodigo = new javax.swing.JTextField();
        jTurno = new javax.swing.JButton();
        D = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedir Turno");
        setIconImage(getIconImage());
        setResizable(false);

        jTurno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/turno.png"))); // NOI18N
        jTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTurnoActionPerformed(evt);
            }
        });

        buttonGroup1.add(D);
        D.setText("Ninguna Prioridad");
        D.setName("0"); // NOI18N

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Mujer embarazada");
        jRadioButton2.setName("1"); // NOI18N

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Persona de la tercera edad");
        jRadioButton3.setName("2"); // NOI18N

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("<html>Persona con limitaciones físicas <br> u ortopédicas</html>");
        jRadioButton4.setName("3"); // NOI18N

        jLabel1.setText("Ingrese su nombre:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(200, 20));

        jLabel2.setText("Seleccione el tipo de servicio que necesita:");

        jLabel3.setText("Seleccione su prioridad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(D)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(D)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTurno)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTurnoActionPerformed
        // TODO add your handling code here:
        String codigo = jCodigo.getText();
        if(c.Existe(codigo)){
            JOptionPane.showMessageDialog(this, "Este documento ya está inscrito, espere su turno.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if(CheckboxSelect(buttonGroup1)==null){
            JOptionPane.showMessageDialog(this, "Faltan campos por rellenar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if(jComboBox1.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningún servicio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if(!c.Existe(codigo)&&CheckboxSelect(buttonGroup1)!=null){
            Usuario u = new Usuario(null, jCodigo.getText(), null, null);
            try {
                c.AsignarTurno(jCodigo.getText(), jComboBox1.getSelectedItem().toString(), CheckboxSelect(buttonGroup1));
            } catch (IOException ex) {
                Logger.getLogger(PedirTurno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTurnoActionPerformed

    public String CheckboxSelect(ButtonGroup buttonGroup){
        for(Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getName();
            }
        }
        return null;
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/t.png"));
        return retValue;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedirTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedirTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedirTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedirTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PedirTurno().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PedirTurno.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PedirTurno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton D;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton jTurno;
    // End of variables declaration//GEN-END:variables
}
