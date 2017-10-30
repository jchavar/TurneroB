/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;



/**
 *
 * @author Miguel
 */
public class Arbol {
     /* Atributos */
    private Nodo raiz;
    
    
    private void addNodo( int valor, Nodo raiz ) {
        Nodo nodo = new Nodo(valor);
        if ( raiz == null ) {
            this.raiz=nodo;
        }
        else {
            if ( nodo.getValor() <= raiz.getValor() ) {
                if (raiz.getHojaIzquierda() == null) {
                    raiz.setHojaIzquierda(nodo);
                }
                else {
                    addNodo( valor , raiz.getHojaIzquierda() );
                }
            }
            else {
                if (raiz.getHojaDerecha() == null) {
                    raiz.setHojaDerecha(nodo);
                }
                else {
                    addNodo( valor, raiz.getHojaDerecha() );
                }
            }
        }
    }
 
    public void addNodo( int valor ) {
        this.addNodo( valor , this.raiz );
    }
    
    private void imprimirEntreConNivel(Nodo tmp, int nivel){
        if(tmp !=null){
            System.out.println(tmp.getValor() + "("+nivel+") - ");
            imprimirEntreConNivel(tmp.getHojaIzquierda(),nivel+1);
            imprimirEntreConNivel(tmp.getHojaDerecha(),nivel+1);
        }
    }
 
    public void imprimirEntreConNivel(){
        imprimirEntreConNivel(raiz,1);
        System.out.println();
    }
    
    
    
    
    
    /*
    public Arbol clonarArbol(){
        Arbol  copia;
        copia=this.clonarArbol(raiz);
        return copia;
    }
    
    public Arbol clonarArbol(Nodo temp){
        Nodo  auxc;
        if(temp==null){
            auxc=null;
        }else{
            Arbol  copiaHojai,copiaHojad ;
            copiaHojai=clonarArbol(temp.getHojaIzquierda());
            copiaHojad=clonarArbol(temp.getHojaDerecha());
            auxc=new Nodo (temp.getValor());
            auxc.setHojaIzquierda(copiaHojai.getRaiz());
            auxc.setHojaDerecha(copiaHojad.getRaiz());
        }
        Arbol clon=new Arbol();
        clon.setRaiz(auxc);
        return clon;
    }
    
    private void preOrden(Nodo raiz){
        if(raiz!=null){
            System.out.println(raiz.getValor());
            preOrden(raiz.getHojaIzquierda());
            preOrden(raiz.getHojaDerecha());
        }
    }
    
    public void preOrden(){
        this.preOrden(this.raiz);
    }
    
    private void Orden(Nodo raiz){
        if(raiz!=null){
            preOrden(raiz.getHojaIzquierda());
            System.out.println(raiz.getValor());
            preOrden(raiz.getHojaDerecha());
        }
    }
    
    public void Orden(){
        this.Orden(this.raiz);
    }
    
    private void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.getHojaIzquierda());
            postOrden(raiz.getHojaDerecha());
            System.out.println(raiz.getValor());
        }
    }
    
    public void postOrden(){
        this.postOrden(this.raiz);
    }
    */
    /* Contructories */    
    public Arbol() {
        this.raiz = null;
    }
 
    public Arbol( Nodo raiz ) {
        this.raiz = raiz;
    }
 
    /* Setters y Getters */
    public Nodo getRaiz() {
        return raiz;
    }
 
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

}
