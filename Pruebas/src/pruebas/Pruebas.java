/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import pruebas.Sudoku.SudokuK;

/**
 *
 * @author Miguel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arbol ejm = new Arbol();
        SudokuK v = new SudokuK();
        Object [][]sudoku= {{0,4,0,9,0,0,6,0,8},
                            {0,0,9,8,0,0,0,1,4},
                            {7,0,0,0,1,0,0,9,0},
                            {0,0,0,0,0,0,9,8,0},
                            {8,9,5,0,0,7,1,4,6},
                            {0,0,0,0,0,0,7,0,2},
                            {0,6,0,0,0,0,4,0,1},
                            {0,5,0,2,0,0,8,0,9},
                            {0,0,0,0,5,9,0,0,0}
                            };
     
        switch(1){
            case 0:
                ejm.addNodo(10);
                ejm.addNodo(1);
                ejm.addNodo(5);
                ejm.addNodo(11);
                ejm.imprimirEntreConNivel();
            case 1:
                v.Saber(sudoku);
                break;
        }
        
    }
    
}
