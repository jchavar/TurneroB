/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métodos;

import Modelo.Asesor;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Miguel
 */
public class Métodos_Config {
    
    public void escribirConfig(ArrayList a, String b, String file){
        try {
            File k = new File(file);
            if(k.exists())
                k.delete();
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                for(Object c:a){
                    pw.println(c); 
                }
                pw.print(b);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se registró la persona correctamente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void escribirConfig2(ArrayList<Asesor> a, String file){
        try {
            File k = new File(file);
            if(k.exists())
                k.delete();
            FileWriter fw = new FileWriter("Asesores.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                for(Asesor c:a){
                    pw.println(c.getNombre()+"|"+c.getServices().get(0)+"|"+c.getServices().get(1)+"|"+c.getServices().get(2)+"|"+c.isFlag());
                }
                
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se registró la persona correctamente", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Vector leerConfig1(String url) throws FileNotFoundException{
        File f = new File(url);
            File file = new File(f.getAbsolutePath());
            Vector x = new Vector();
            Scanner lector = new Scanner(file);
            Scanner t = new Scanner(System.in);
            while (lector.hasNextLine()) { 
                String dato = lector.nextLine();
                if(!(dato == null)){
                    StringTokenizer d= new StringTokenizer(dato,"|");
                    x.addElement(d.nextToken());
                } 
            }
            lector.close();
        return x;
    }
    public Asesor leerRegistro(String datoAmodificar) throws FileNotFoundException, IOException{
        File file = new File("Asesores.txt"); 
        Scanner lector = new Scanner(file); 
        while (lector.hasNextLine()) { 
            String datoBuscado = lector.nextLine(); 
            if (datoBuscado.contains(datoAmodificar)) { 
                StringTokenizer d= new StringTokenizer(datoBuscado,"|");
                Asesor a;
                String name = d.nextToken();
                ArrayList services = new ArrayList();
                services.add(d.nextToken());
                services.add(d.nextToken());
                services.add(d.nextToken());
                int flag = Integer.parseInt(d.nextToken());
                a = new Asesor(name, services,flag);
                lector.close();
                return a;
            }
        }
        return null;
    }
    public void listar(ArrayList<JComboBox> j) throws FileNotFoundException{
        Vector x = leerConfig1("Config.txt");
        x.remove(x.size()-1);
        for(int i=0; i<j.size(); i++){
            j.get(i).removeAllItems();
            j.get(i).addItem("--");
            for(Object b: x){
                j.get(i).addItem(b);
            }
        }   
    }
}
