package Metodos;

import Modelo.Persona;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class Metodos {
    
    //Persona[] contact = new Persona[200];
    ArrayList<Persona> contact = new ArrayList<>();
    
    public Metodos(){}
    
    public void agregarRegistro(Persona a) throws IOException {
        //contact.add(a);
            try {
                FileWriter fw = new FileWriter("Contactos.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                try (PrintWriter pw = new PrintWriter(bw)) {
                    pw.println(a.getNombre()+"|"+a.getTel()+"|"+a.getCorreo());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se registró la persona correctamente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        
    }
    
    public void eliminarRegistro (String datoAborrar) throws FileNotFoundException, IOException{
        File f = new File("Contactos.txt"); 
        File file_2 = new File("temporal.txt");
        BufferedWriter bw;
        Scanner lector;
        try (FileWriter fw = new FileWriter(file_2,true)) {
            bw = new BufferedWriter(fw);
            try (PrintWriter pw = new PrintWriter(bw)) {
                lector = new Scanner(f);
                while(lector.hasNextLine()) {
                    String datoBuscado = lector.nextLine();
                    StringTokenizer d= new StringTokenizer(datoBuscado,"|");
                    if(!(d.nextToken().equals(datoAborrar))){
                        pw.println(datoBuscado);
                    }
                }
            }
        }
        bw.close();
        lector.close();
        if(f.delete())
            System.out.print("");
        if(file_2.renameTo(f))
            System.out.print("");
    }
    
    public void Refresh(){
        File f = new File("Contactos.txt"); 
        File file_2 = new File("temporal.txt");
        if(f.delete())
            System.out.println("Borró");
        if(file_2.renameTo(f))
            System.out.println("Cambio de nombre");
    }
    public void modificarRegistro(Persona a) throws IOException{
        boolean ban=false;
        File file = new File("Contactos.txt"); 
        File file_2 = new File("temporal.txt");
        
        FileWriter fw = new FileWriter(file_2,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Scanner lector = new Scanner(file); 
        while (lector.hasNextLine()) { 
            String datoBuscado = lector.nextLine(); 
            StringTokenizer d= new StringTokenizer(datoBuscado,"|");
            if(d.nextToken().equals(a.getNombre())){
                pw.println(a.getNombre()+"|"+a.getTel()+"|"+a.getCorreo());
                ban = true;
            } else{
                pw.println(datoBuscado);
            }
        }
        if(!ban){
            pw.println(a.getNombre()+"|"+a.getTel()+"|"+a.getCorreo());
        }
        pw.close();
        fw.close();
        bw.close();
        lector.close();

        file.delete();
        file_2.renameTo(file);
    }
    
    @SuppressWarnings("empty-statement")
    
    public boolean existe(String dato) throws FileNotFoundException{
        File file = new File("Contactos.txt");
        Scanner lector = new Scanner(file); 
        while(lector.hasNextLine()) { 
            String datoBuscado = lector.nextLine(); 
            if(datoBuscado.contains(dato)) {
                StringTokenizer d= new StringTokenizer(datoBuscado,"|");
                if(d.nextToken().equals(dato)){
                    lector.close();
                    return true; 
                }
            }
        }
        //lector.close();
        return false;
    }
    
    public Persona leerRegistro(String dato) throws FileNotFoundException, IOException{
        File file = new File("Contactos.txt"); 
        Scanner lector = new Scanner(file); 
        while (lector.hasNextLine()) { 
            String datoBuscado = lector.nextLine(); 
            if (datoBuscado.contains(dato)) { 
                StringTokenizer d= new StringTokenizer(datoBuscado,"|");
                Persona a;
                a = new Persona(d.nextToken(),d.nextToken(),d.nextToken());
                lector.close();
                if(a.getNombre().equals(dato)){
                    return a; 
                }
            }
        }
        return null;
    }
    
    public void pasar(File f) throws FileNotFoundException, IOException{
        Scanner lector = new Scanner(f); 
        while (lector.hasNextLine()) { 
            String dato = lector.nextLine(); 
            StringTokenizer d= new StringTokenizer(dato,"|");
            Persona a = new Persona(d.nextToken(),d.nextToken(),d.nextToken());
            this.agregarRegistro(a);
        }
        lector.close();
    }
    
    public DefaultTableModel tabla(){
        Vector cabecera= new Vector();
        
        cabecera.addElement("Contactos");
        DefaultTableModel mTabla= new DefaultTableModel(cabecera,0);
        try {
            File f = new File("Contactos.txt");
            File file = new File(f.getAbsolutePath());

            Scanner lector = new Scanner(file);
            Scanner t = new Scanner(System.in);
            while (lector.hasNextLine()) { 
                String dato = lector.nextLine();
                if(!(dato == null)){
                    StringTokenizer d= new StringTokenizer(dato,"|");
                    Vector x = new Vector();
                    int a=0;
                    x.addElement(d.nextToken());
                    mTabla.addRow(x);
                }
                    
            }
            lector.close();
        
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return mTabla;
    }
}
