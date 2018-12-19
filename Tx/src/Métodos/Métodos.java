/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métodos;


import Modelo.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class Métodos {
    Métodos_Config mC = new Métodos_Config();
    
    public void agregarRegistro(Usuario a) throws IOException {
            try {
                FileWriter fw = new FileWriter("Usuarios.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                try (PrintWriter pw = new PrintWriter(bw)) {
                    pw.println(a.getId()+"|"+a.getNombre()+"|"+a.getService()+"|"+a.getPriori());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se registró la persona correctamente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        
    }
    
    public void modificarRegistro(Asesor c, String flag) throws IOException{
        boolean ban=false;
        File file = new File("Asesores.txt"); 
        File file_2 = new File("temporal.txt");
        
        FileWriter fw = new FileWriter(file_2,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner lector = new Scanner(file); 
        while (lector.hasNextLine()) { 
            String datoBuscado = lector.nextLine(); 
            StringTokenizer d= new StringTokenizer(datoBuscado,"|");
            if(d.nextToken().equals(c.getNombre())){
                pw.println(c.getNombre()+"|"+c.getServices().get(0)+"|"+c.getServices().get(1)+"|"+c.getServices().get(2)+"|"+flag+"|"+c.getLibre());
                ban = true;
            } else{
                pw.println(datoBuscado);
            }
        }
        if(!ban){
            pw.println(c.getNombre()+"|"+c.getServices().get(0)+"|"+c.getServices().get(1)+"|"+c.getServices().get(2)+"|"+c.isFlag());
        }
        pw.close();
        fw.close();
        bw.close();
        lector.close();

        file.delete();
        file_2.renameTo(file);
    }
    
    public void listar(JComboBox x) throws FileNotFoundException{
        Vector v = mC.leerConfig1("Config.txt");
        v.remove(v.size()-1);
        x.removeAllItems();
        x.addItem("--");
        v.forEach((b) -> {
            x.addItem(b);
        });
    }
    
    public int confirmar(String a){
        return JOptionPane.showConfirmDialog(null, "Su turno es: "+a, "Alerta!", JOptionPane.CANCEL_OPTION);
    }
    
    public ArrayList<Usuario> leerRegistro(String datoAmodificar) throws FileNotFoundException, IOException{
        ArrayList<Usuario> aU = new ArrayList<>();
        File file = new File("Prioridad.txt"); 
        Scanner lector = new Scanner(file); 
        while (lector.hasNextLine()) { 
            String datoBuscado = lector.nextLine(); 
            if (datoBuscado.contains(datoAmodificar)) { 
                StringTokenizer d= new StringTokenizer(datoBuscado,"|");
                Usuario a = new Usuario(d.nextToken(), d.nextToken(), d.nextToken(),d.nextToken());
                aU.add(a);
                
            }
        }
        return aU;
    }
    public ArrayList<Usuario> leerRegistro() throws FileNotFoundException, IOException{
        ArrayList<Usuario> aU = new ArrayList<>();
        File file = new File("Prioridad.txt"); 
        if(file.exists()){
            Scanner lector = new Scanner(file); 
            while (lector.hasNextLine()) { 
                String datoBuscado = lector.nextLine(); 
                if(datoBuscado!=null){
                    StringTokenizer d= new StringTokenizer(datoBuscado,"|");
                    Usuario a = new Usuario(d.nextToken(), d.nextToken(), d.nextToken(),d.nextToken());
                    aU.add(a);
                }
                
            }
            lector.close();
        }
        return aU;
    }
    
    public DefaultTableModel tabla() throws FileNotFoundException, IOException{
        ArrayList<ArrayList<Usuario>> sup = new ArrayList<>();
        Vector cabecera = mC.leerConfig1("Config.txt");
        cabecera.remove(cabecera.lastElement());
        DefaultTableModel mTabla= new DefaultTableModel(null, cabecera);
        for(Object k: cabecera){
            ArrayList<Usuario> au = this.leerRegistro((String) k);
            sup.add(au);
        }
        int[] tam = new int[sup.size()];
        for(int i=0; i<sup.size(); i++){
            tam[i]=sup.get(i).size();
        } 
            
        for(int i=0; i<mayor(tam);i++){
            Vector x = new Vector();
            for(ArrayList<Usuario> kk: sup){
                if(kk.size()>i)
                    x.add(kk.get(i).getId());
                else
                    x.add("");
            }
            mTabla.addRow(x);
        }
        return mTabla;
    }
    
    public int mayor(int[] v){
        int aux;
        for (int i=0; i<v.length-1; i++){
            for (int j=i+1; j<v.length; j++){
                if(v[i]<v[j]){
                 aux = v[i];
                 v[i] = v[j];
                 v[j] = aux;
                }
            }    
        }
        return v[0];
    }
}
