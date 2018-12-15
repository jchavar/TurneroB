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
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class Cola {
    Métodos m = new Métodos();
    int[] N_turno = {1, 1, 1, 1};
    String[] L_turno = {"D", "C", "B", "A"};
    ArrayList<Usuario> cola = new ArrayList<>();

    
    
    
    public void AsignarTurno(String nombre, String service, String condicion) throws IOException{
        cola = m.leerRegistro();
        int k =Integer.valueOf(condicion);
        Usuario n = new Usuario(L_turno[k]+N_turno[k], nombre, service, condicion);
        if(m.confirmar(L_turno[k]+N_turno[k])==0){
            N_turno[k] = N_turno[k] + 1;
            if(!DefinirPos(n)){
                cola.add(n);
            }
            m.agregarRegistro(n);
            Mostrar();
            cola.remove(0);
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
    
     public void Mostrar(){
        try {
            File k = new File("Prioridad.txt");
            if(k.exists())
                k.delete();
            FileWriter fw = new FileWriter("Prioridad.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                for(Usuario a:cola){
                    pw.println(a.getId()+"|"+a.getNombre()+"|"+a.getService()+"|"+a.getPriori());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se registró la persona correctamente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
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
