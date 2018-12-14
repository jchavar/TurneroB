/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
/**
 *
 * @author Miguel
 */
public class Asesor extends Persona{
    
    private ArrayList services;
    private int flag;
    
    public Asesor(String nombre, ArrayList services, int flag) {
        super(nombre);
        this.services=services;
        this.flag=flag;
    }

    /**
     * @return the services
     */
    public ArrayList getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(ArrayList services) {
        this.services = services;
    }

    /**
     * @return the flag
     */
    public int isFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }
    
}
