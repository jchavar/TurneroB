/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Miguel
 */
public class Usuario extends Persona{
    
    private String id;
    private String service;
    private String priori;
    
    public Usuario(String id, String nombre, String service, String priori) {
        super(nombre);
        this.id=id;
        this.service=service;
        this.priori=priori;
    }
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the priori
     */
    public String getPriori() {
        return priori;
    }

    /**
     * @param priori the priori to set
     */
    public void setPriori(String priori) {
        this.priori = priori;
    }
}
