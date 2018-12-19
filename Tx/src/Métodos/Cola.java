/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métodos;

import Modelo.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class Cola {
    Métodos m = new Métodos();
    Métodos_Config mC = new Métodos_Config();
    
    Vector N_t;
    int[] N_turno = new int[4];
    String[] L_turno = {"D", "C", "B", "A"};
    ArrayList<Usuario> cola;
    
    
    public Cola(){
        try {
            this.cola= m.leerRegistro();
        } catch (IOException ex) {
            Logger.getLogger(Cola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public void AsignarTurno(String nombre, String service, String condicion) throws IOException{
        this.N_t = mC.leerConfig1("Cola.txt");
        for(int i=0; i<N_turno.length; i++){
            N_turno[i] = Integer.valueOf(N_t.get(i).toString());
        }
        int k =Integer.valueOf(condicion);
        Usuario n = new Usuario(L_turno[k]+N_turno[k], nombre, service, condicion);
        if(m.confirmar(L_turno[k]+N_turno[k])==0){
            N_turno[k] = N_turno[k] +1;
            ArrayList a = new ArrayList();
            for(Integer d: N_turno){
                a.add(d);
            }
            mC.escribirConfig(a, null, "Cola.txt");
            if(!DefinirPos(n)){
                cola.add(n);
            }
            m.agregarRegistro(n);
            Mostrar();
        }
    }
    
    public boolean DefinirPos(Usuario a){
        String letra = String.valueOf(a.getId().charAt(0));
        int pos = 0;
        if(cola.isEmpty()){
            cola.add(0, a);
            return true;
        } else{
            for(Usuario person : cola){
                String l = String.valueOf(person.getId().charAt(0));
                if(l.codePointAt(0)>letra.codePointAt(0)){
                    cola.add(pos, a);
                    return true;
                }
                pos++;
            }
        }
        return false;
    }
    
    public void Mostrar() throws IOException{
        File file = new File("Prioridad.txt") ;
        if(file.exists()){
            file.delete();
        }
        FileWriter fw = new FileWriter("Prioridad.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        try (PrintWriter pw = new PrintWriter(bw)) {
            for(Usuario a:cola){
                pw.println(a.getId()+"|"+a.getNombre()+"|"+a.getService()+"|"+a.getPriori());
            }
        }
    }
     
    public void atender() throws IOException{
        cola.remove(0);
        Mostrar();
    }
    
    public boolean Existe(String e){
        for(Usuario person : cola){
            if(person.getNombre().equals(e)){
                return true;
            }
        }
        return false;
    }
}
