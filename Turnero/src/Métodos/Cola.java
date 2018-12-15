/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métodos;

import Modelo.*;
import java.io.IOException;
import java.util.ArrayList;

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
        System.out.println("Codigo  \t Turno");
        cola.forEach((person) -> {
            System.out.println(person.getNombre()+"\t"+person.getId()+"\t"+person.getService());
        });
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
