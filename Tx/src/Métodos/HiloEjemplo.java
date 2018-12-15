/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métodos;

import Modelo.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Métodos.*;
import java.io.IOException;


/**
 *
 * @author Miguel
 */
public class HiloEjemplo extends Thread{
    Métodos m = new Métodos();
    Métodos_Config mC = new Métodos_Config();
    public HiloEjemplo(String nombre){
        super(nombre);
    }
    
    
    
    @Override
    public void run(){
        try {

            ArrayList<Asesor> aa = mC.leerAsesores();
            Usuario u = new Usuario("D1", "Alejo", "Asesoramiento financiero", "Ninguna");
            boolean flag = false;
            
            System.out.print(u.getId()+"--->");
            for (Asesor a: aa) {
                if (a.getFlag()==1) {
                    if(a.getServices().contains(u.getService())&&a.getLibre()==0){
                        System.out.print(a.getNombre()+" ");
                        flag = true;
                        a.setLibre(1);
                        mC.modificarAsesor(a);
                        break;
                    }
                }
            }
                
            try {
                if (flag) {
                    Thread.sleep(500);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloEjemplo.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
         catch (IOException ex) {
            Logger.getLogger(HiloEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
