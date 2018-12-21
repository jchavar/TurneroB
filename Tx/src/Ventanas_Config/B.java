/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Config;

import Modelo.*;
import java.awt.*;
import Métodos.Métodos_Config;
import Ventana.Monitor;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author Miguel
 */
public class B extends javax.swing.JFrame {
    Métodos_Config mC = new Métodos_Config();
    ArrayList<JTextField> jT = new ArrayList<>();
    
    /**
     * Creates new form Prueba
     * @throws java.io.FileNotFoundException
     */
    public B() throws FileNotFoundException {
        initComponents();
        Vector config = mC.leerConfig1("temporal.txt");
        Object ax = config.lastElement();
        int cantP = Integer.valueOf(ax.toString());
        init(cantP);
    }
    
    public static void actionPerformad(ArrayList<JComboBox> j){
        for(int i=0; i<j.size(); i++){
            if((i%3)==0){
                JComboBox c1 = j.get(i);
                JComboBox c2 = j.get(i+1);
                JComboBox c3 = j.get(i+2);
                c1.addActionListener((ActionEvent e) -> {
                    String s = c1.getSelectedItem().toString();
                    if(!(s.contains("--"))){
                        c2.removeItem(s);
                        c3.removeItem(s);
                    }
                });
            } if((i%3)==1){
                JComboBox c1 = j.get(i-1);
                JComboBox c2 = j.get(i);
                JComboBox c3 = j.get(i+1);
                c2.addActionListener((ActionEvent e) -> {
                    String s = c1.getSelectedItem().toString();
                    String r = c2.getSelectedItem().toString();
                    if(!(s.contains("--")))
                        c3.removeItem(s);
                    if(!(r.contains("--")))
                        c3.removeItem(r);
                });
            }
        }
    }

    public void init(int cantP) throws FileNotFoundException{
        JLabel ln = new JLabel("Nombre:");
        ln.setBounds(100, 5, 100, 20);
        JLabel ls = new JLabel("Escoja al menos un servicio por asesor:");
        ls.setBounds(255, 5, 240, 20);
        
        ArrayList<JLabel> label = new ArrayList<>();
        label.add(ln);
        label.add(ls);
        ArrayList<JTextField> text = new ArrayList<>();
        ArrayList<JComboBox> combo = new ArrayList<>();
        int y=30;
        for(int i=0; i<cantP; i++){
            JLabel l1 = new JLabel("Asesor #"+(i+1));
            l1.setBounds(5, y, 100, 30);
            label.add(l1);
            JTextField t1 = new JTextField();
            t1.setBounds(100, y, 135, 30);
            text.add(t1);
            JComboBox jcb1 = new JComboBox();
            jcb1.setBounds(255, y, 110, 30);
            JComboBox jcb2 = new JComboBox();
            jcb2.setBounds(370, y, 110, 30);
            JComboBox jcb3 = new JComboBox();
            jcb3.setBounds(485, y, 110, 30);
            combo.add(jcb1);
            combo.add(jcb2);
            combo.add(jcb3);
            y+=35;
        }
        actionPerformad(combo);
        JButton btn = new JButton();
        btn.setBounds(525, y, 30, 30);
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back.png")));
        btn.setToolTipText("Atrás");
        JButton btn1 = new JButton();
        btn1.setBounds(560, y, 30, 30);
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png")));
        btn1.setToolTipText("Guardar");
        JButton btn2 = new JButton();
        btn2.setBounds(490, y, 30, 30);
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/0.png")));
        btn2.setToolTipText("Cancelar");
        
        
        //this.setPreferredSize(new Dimension(600, y+50));
        this.setSize(new Dimension(600, y+60));
        mC.listar(combo);
        for(JLabel l: label){
            add(l);
        } for(JTextField t: text){
            add(t);
        } for(JComboBox b: combo){
            add(b);
        }
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                boolean flag = false;
                for(JTextField t: text){
                    if(t.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "No se han llenado todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        flag = true;
                        break;
                    }
                }
                for(int i=0; i<combo.size(); i+=3){
                    if(combo.get(i).getSelectedIndex()==0&&combo.get(i+1).getSelectedIndex()==0&&combo.get(i+2).getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null, "El asesor #"+(i/3+1)+" no tiene servicios. Por favor seleccione al menos uno.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    try {
                        ArrayList<Asesor> a = new ArrayList<>();
                        for(int i=0; i<combo.size(); i+=3){
                            ArrayList<String> x = new ArrayList<>();
                            x.add(combo.get(i).getSelectedItem().toString()); x.add(combo.get(i+1).getSelectedItem().toString());  x.add(combo.get(i+2).getSelectedItem().toString());
                            a.add(new Asesor(text.get(i/3).getText(), x, 1, 0));
                        }
                        mC.escribirConfig2(a,"Asesores.txt");
                        File f = new File("Config.txt"); 
                        File file_2 = new File("temporal.txt");
                        f.delete();
                        file_2.renameTo(f); 
                        Monitor m = new Monitor();
                        m.setVisible(true);
                        setVisible(false);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }            
        });
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                try {
                    A v = new A();
                    v.setVisible(true);
                    setVisible(false);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File f = new File("temporal.txt");
                    f.delete();
                    Monitor m = new Monitor();
                    m.setVisible(true);
                    setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        add(btn);
        add(btn1);
        add(btn2);
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/sett.png"));
        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Configuración");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(600, 100));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(B.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new B().setVisible(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(B.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    
}
