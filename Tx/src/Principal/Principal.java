/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Ventana.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Miguel
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
       
        Monitor m = new Monitor();
        m.setVisible(true);
        /*
        Colas c = new Colas();
        c.setVisible(true);*/
    }
}
