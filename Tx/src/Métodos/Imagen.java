/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métodos;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Miguel
 */
 public class Imagen extends javax.swing.JPanel {
        String ruta;
        int x, y;
        public Imagen(String r, int x, int y) {
            this.setSize(600, 400); //se selecciona el tamaño del panel
            this.ruta=r;
            this.x=x;
            this.y=y;
        }
        public Imagen(String r) {
            this.setSize(600, 400); //se selecciona el tamaño del panel
            this.ruta=r;
        }

        @Override
        public void paint(Graphics grafico) {
            //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
            ImageIcon Img = new ImageIcon(getClass().getResource(ruta)); 
            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), x, y, null);
            setOpaque(false);
            super.paintComponent(grafico);
        }
    }