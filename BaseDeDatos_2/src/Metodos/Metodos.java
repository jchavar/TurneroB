/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Modelo.Persona;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel
 */
public class Metodos {
    Deptos d = new Deptos();
    Ciudades c = new Ciudades();
    ArrayList<Persona> personas = new ArrayList<>();
    public Metodos() {}
    
    
    
    public void agregrarRegistro(Persona a) throws IOException{
        personas.add(a);
    }
    
    
    public DefaultTableModel tabla(){
        Vector cabecera= new Vector();
        
        cabecera.addElement("Nro.Identificación");
        cabecera.addElement("Nombre");
        cabecera.addElement("Fecha de Nacimiento");
        cabecera.addElement("Edad");
        cabecera.addElement("Pais Nacimiento");
        cabecera.addElement("Depto Nacimiento");
        cabecera.addElement("Ciudad Nacimiento");
        cabecera.addElement("Teléfono Casa");
        cabecera.addElement("Celular");
        
        DefaultTableModel mTabla= new DefaultTableModel(cabecera,0);
        return mTabla;
    }
    
    public String edad(String fecha){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fecha, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        return  String.valueOf(periodo.getYears());
    }
    
    public void listarPais(JComboBox pais){
        pais.removeAllItems();
        pais.addItem("Pais");
        pais.addItem("Colombia");
    }
    
    public void listarDepto(String pais, JComboBox depto){
        depto.removeAllItems();
        depto.addItem("Departamento");
        if(pais.contains("Colombia")){
            for(int i =0; i<d.Colombia.length; i++){
                depto.addItem(d.Colombia[i]);
            }
        }
        
    }
    
    public void listarCiudad(int depto, JComboBox city){
        city.removeAllItems();
        city.addItem("Ciudad");
        if(depto > 0){
            Object []k = c.c(depto);
            for (int i=1; i<=Integer.parseInt(k[0].toString()); i++) {
                city.addItem(k[i]);
            } 
        }
        
        
    }
    
}
      
