/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Modelo.Asesor;
import Métodos.Métodos;
import Métodos.Métodos_Config;
import Principal.Principal;
import Ventanas_Config.A;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Miguel
 */
public class Monitor extends javax.swing.JFrame {
    Métodos_Config mC = new Métodos_Config();
    Métodos m = new Métodos();
    PedirTurno pt = new PedirTurno();
    int pq = 0;
        
    /**
     * Creates new form Monitor
     * @throws java.io.FileNotFoundException
     */
    public Monitor() throws FileNotFoundException, IOException {
        initComponents();
        init();
    }

    public void init() throws FileNotFoundException, IOException{
        Vector x = mC.leerConfig1("Config.txt");
        Vector y = mC.leerConfig1("Asesores.txt");
        Object ax = x.lastElement();
        int cantP = Integer.valueOf(ax.toString());
        ArrayList<JButton> boton = new ArrayList<>();
        boton.add(p1); boton.add(p2); boton.add(p3); boton.add(p4); boton.add(p5);
        boton.add(p6); boton.add(p7); boton.add(p8); boton.add(p9); boton.add(p10); 
        ArrayList<JCheckBox> combo = new ArrayList<>();
        combo.add(c1); combo.add(c2); combo.add(c3); combo.add(c4); combo.add(c5);
        combo.add(c6); combo.add(c7); combo.add(c8); combo.add(c9); combo.add(c10); 
        for(int i=cantP; i<boton.size(); i++){
            boton.get(i).setVisible(false);
            combo.get(i).setVisible(false);
        } for(int i=0; i<cantP; i++){
            combo.get(i).setText(y.get(i).toString());
            Asesor a = mC.leerRegistro(y.get(i).toString());
            if(a.isFlag()==1){
                combo.get(i).setSelected(true);
            if(a.isFlag()==0)
                combo.get(i).setSelected(false);
                
            

            }
                    }
        this.setSize(new Dimension(boton.get(cantP-1).getX()+148,235));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        sett = new javax.swing.JButton();
        c1 = new javax.swing.JCheckBox();
        p1 = new javax.swing.JButton();
        p3 = new javax.swing.JButton();
        p4 = new javax.swing.JButton();
        p5 = new javax.swing.JButton();
        p6 = new javax.swing.JButton();
        p7 = new javax.swing.JButton();
        p8 = new javax.swing.JButton();
        p9 = new javax.swing.JButton();
        p10 = new javax.swing.JButton();
        p2 = new javax.swing.JButton();
        c2 = new javax.swing.JCheckBox();
        c3 = new javax.swing.JCheckBox();
        c4 = new javax.swing.JCheckBox();
        c5 = new javax.swing.JCheckBox();
        c6 = new javax.swing.JCheckBox();
        c7 = new javax.swing.JCheckBox();
        c8 = new javax.swing.JCheckBox();
        c9 = new javax.swing.JCheckBox();
        c10 = new javax.swing.JCheckBox();
        inte = new javax.swing.JButton();
        see = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        sett.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sett.png"))); // NOI18N
        sett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settActionPerformed(evt);
            }
        });

        c1.setText("jCheckBox1");
        c1.setFocusPainted(false);
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        p1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P1.png"))); // NOI18N
        p1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1ActionPerformed(evt);
            }
        });

        p3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P3.png"))); // NOI18N
        p3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p3ActionPerformed(evt);
            }
        });

        p4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P4.png"))); // NOI18N
        p4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p4ActionPerformed(evt);
            }
        });

        p5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P5.png"))); // NOI18N
        p5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p5ActionPerformed(evt);
            }
        });

        p6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P6.png"))); // NOI18N
        p6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p6ActionPerformed(evt);
            }
        });

        p7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P7.png"))); // NOI18N
        p7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p7ActionPerformed(evt);
            }
        });

        p8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P8.png"))); // NOI18N
        p8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p8ActionPerformed(evt);
            }
        });

        p9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P9.png"))); // NOI18N
        p9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p9ActionPerformed(evt);
            }
        });

        p10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P10.png"))); // NOI18N
        p10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p10ActionPerformed(evt);
            }
        });

        p2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/P2.png"))); // NOI18N
        p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2ActionPerformed(evt);
            }
        });

        c2.setText("jCheckBox2");

        c3.setText("jCheckBox3");
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });

        c4.setText("jCheckBox4");

        c5.setText("jCheckBox5");

        c6.setText("jCheckBox6");

        c7.setText("jCheckBox7");

        c8.setText("jCheckBox8");

        c9.setText("jCheckBox9");

        c10.setText("jCheckBox10");

        inte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png"))); // NOI18N
        inte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inteActionPerformed(evt);
            }
        });

        see.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        see.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c5)
                    .addComponent(p5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c10)
                    .addComponent(p10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(see, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sett, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(c2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p2))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p3))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p6))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p7))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p8))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p9))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(c10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(p10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(c1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sett, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(see, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void settActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settActionPerformed
        // TODO add your handling code here:
        pt.setVisible(false);
        A a = new A();
        a.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_settActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c3ActionPerformed

    private void p1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1ActionPerformed
        // TODO add your handling code here:
        try {
            c1.setSelected(!c1.isSelected());
            String flag="";
            if(c1.isSelected())
                flag = "1";
            else if(!c1.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c1.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p1ActionPerformed

    private void p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2ActionPerformed
        // TODO add your handling code here:
        try {
            c2.setSelected(!c2.isSelected());
            String flag="";
            if(c2.isSelected())
                flag = "1";
            else if(!c2.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c2.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p2ActionPerformed

    private void p3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p3ActionPerformed
        // TODO add your handling code here:
        try {
            c3.setSelected(!c3.isSelected());
            String flag="";
            if(c3.isSelected())
                flag = "1";
            else if(!c3.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c3.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p3ActionPerformed

    private void p4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p4ActionPerformed
        // TODO add your handling code here:
        try {
            c4.setSelected(!c4.isSelected());
            String flag="";
            if(c4.isSelected())
                flag = "1";
            else if(!c4.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c4.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p4ActionPerformed

    private void p5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p5ActionPerformed
        // TODO add your handling code here:
        try {
            c5.setSelected(!c5.isSelected());
            String flag="";
            if(c5.isSelected())
                flag = "1";
            else if(!c5.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c5.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p5ActionPerformed

    private void p6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p6ActionPerformed
        // TODO add your handling code here:
        try {
            c6.setSelected(!c6.isSelected());
            String flag="";
            if(c6.isSelected())
                flag = "1";
            else if(!c6.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c6.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p6ActionPerformed

    private void p7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p7ActionPerformed
        // TODO add your handling code here:
        try {
            c7.setSelected(!c7.isSelected());
            String flag="";
            if(c7.isSelected())
                flag = "1";
            else if(!c7.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c7.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p7ActionPerformed

    private void p8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p8ActionPerformed
        // TODO add your handling code here:
        try {
            c8.setSelected(!c8.isSelected());
            String flag="";
            if(c8.isSelected())
                flag = "1";
            else if(!c8.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c8.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p8ActionPerformed

    private void p9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p9ActionPerformed
        // TODO add your handling code here:
        try {
            c9.setSelected(!c9.isSelected());
            String flag="";
            if(c9.isSelected())
                flag = "1";
            else if(!c9.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c9.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p9ActionPerformed

    private void p10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p10ActionPerformed
        // TODO add your handling code here:
        try {
            c10.setSelected(!c10.isSelected());
            String flag="";
            if(c10.isSelected())
                flag = "1";
            else if(!c10.isSelected())
                flag = "0";
            m.modificarRegistro(mC.leerRegistro(c10.getText()), flag);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_p10ActionPerformed

    private void inteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inteActionPerformed
        // TODO add your handling code here:
        if(pq==0){
            inte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1.png")));
            pq=1;
            pt.setVisible(false);
        } else if(pq==1){
            inte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/0.png")));
            pq=0;
            pt.setVisible(true);
        }
    }//GEN-LAST:event_inteActionPerformed

    private void seeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeActionPerformed
        try {
            // TODO add your handling code here:
            Colas c = new Colas();
            this.setVisible(false);
            c.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_seeActionPerformed

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/m.png"));
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
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if("Nimbus".equals(laf.getName()))
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                }
        } //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Monitor().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox c1;
    private javax.swing.JCheckBox c10;
    private javax.swing.JCheckBox c2;
    private javax.swing.JCheckBox c3;
    private javax.swing.JCheckBox c4;
    private javax.swing.JCheckBox c5;
    private javax.swing.JCheckBox c6;
    private javax.swing.JCheckBox c7;
    private javax.swing.JCheckBox c8;
    private javax.swing.JCheckBox c9;
    private javax.swing.JButton inte;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton p1;
    private javax.swing.JButton p10;
    private javax.swing.JButton p2;
    private javax.swing.JButton p3;
    private javax.swing.JButton p4;
    private javax.swing.JButton p5;
    private javax.swing.JButton p6;
    private javax.swing.JButton p7;
    private javax.swing.JButton p8;
    private javax.swing.JButton p9;
    private javax.swing.JButton see;
    private javax.swing.JButton sett;
    // End of variables declaration//GEN-END:variables
}