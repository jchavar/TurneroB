/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.Sudoku;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class SudokuK {
    Object m=0;
    Object [][]copy;
    List help = new ArrayList();
    List help2 = new ArrayList();
    
    public void asignarPosibles(int i, int j, Object [][]sudoku){
        List poss = new ArrayList();
        for(int v=1; v<10; v++){
            poss.add(v);
        }
        sudoku[i][j]=poss;
    }

    public void reduceUsingRow(int i, int j, Object [][]sudoku){
        List rocell = new ArrayList();
        rocell.addAll((Collection) sudoku[i][j]);
        for(int a=0; a<9; a++ ){
            if("Integer".equals(sudoku[i][a].getClass().getSimpleName())){
                help.add(sudoku[i][a]);
                if(a!=j&&help.size()==1){
                    if (sudoku[i][a]!=m) {
                        rocell.remove(sudoku[i][a]);
                    }
                }
                help.clear();
            }
        }
        sudoku[i][j]=rocell;
    }
    
    public void reduceUsingCol(int i, int j,Object [][]sudoku){
        List cocell = new ArrayList();
        cocell.addAll((Collection) sudoku[i][j]);
        for(int a=0; a<9; a++){
            if("Integer".equals(sudoku[a][j].getClass().getSimpleName())){
                help.add(sudoku[a][j]);
                if(a!=i&&help.size()==1){
                    if (sudoku[a][j]!=m) {
                        cocell.remove(sudoku[a][j]);
                    }
                }
                help.clear();
            }
        }
        sudoku[i][j]=cocell;
    }
   
    public void reduceUsingReg(int i, int j, Object [][]sudoku){
        int iC=0, iF=0, fC=0, fF=0;
        if(i<9) iC=6; 
        if(i<6) iC=3;
        if(i<3) iC=0;
        if(j<9) iF=6;
        if(j<6) iF=3;
        if(j<3) iF=0;
        fC=iC+3;
        fF=iF+3;
        List recell = new ArrayList();
        recell.addAll((Collection) sudoku[i][j]);
        for(int a=iC; a<fC; a++){
            for(int b=iF; b<fF; b++){
                if("Integer".equals(sudoku[a][b].getClass().getSimpleName())){
                    help.add(sudoku[a][b]);
                    if(a!=i||b!=j&&help.size()==1){
                        if (sudoku[a][b]!=m) {
                            recell.remove(sudoku[a][b]);
                        }
                    }
                    help.clear();
                }
            }
        }
        if(recell.size()==1) sudoku[i][j]=recell.get(0);
    }

    public void reduceCell(int i, int j, Object [][]sudoku){
        reduceUsingRow(i, j, sudoku);
        reduceUsingCol(i, j, sudoku);
        reduceUsingReg(i, j, sudoku);
    }

    public void reduce(Object [][]sudoku){
        Object v;
        v=0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if("Integer".equals(sudoku[i][j].getClass().getSimpleName())&&sudoku[i][j]== v)  asignarPosibles(i, j, sudoku); 
                if("ArrayList".equals(sudoku[i][j].getClass().getSimpleName())) reduceCell(i, j, sudoku);
            }
        }
    }

    public int contarAsignados(Object [][]sudoku){
        int r=0;
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(sudoku[i][j]!=m){
                    if("Integer".equals(sudoku[i][j].getClass().getSimpleName())){
                        r++;
                    }
                }
                help.clear();
            }
        }
        return r;
    }

    public void superReducir(Object [][]sudoku){
        int y=0;
        int x; 
        x=contarAsignados(sudoku);
        
        while(x!=y){
            y=x;
            reduce(sudoku);
            x=contarAsignados(sudoku);
            System.out.println("X: "+x);
        }
        
        if(!esFallo(sudoku)){
            if(x!=81){
                escoger(2, sudoku);
                superReducir(copy);
                if(Solucionar(copy)){
                    Saber(copy);
                } /*else if(Solucionar(sudoku)){
                    Saber(sudoku);
                } */else{
                    superReducir(sudoku);
                }
            }
        }
    }

    public void escoger(int l, Object [][]sudoku){
        boolean bandera=false;
        /*
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                help.add(sudoku[i][j]);
                copy[i][j]=help;
                help.clear();
            }
        }*/
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                help.add(0, sudoku[i][j]);
                if(help.size()==l){
                    bandera=true;
                    copy[i][j]=help.get(0);
                    sudoku[i][j]=help.remove(0);
                    break;
                }
                help.clear();
            }
        }
        if(!bandera) escoger(l+1, sudoku);
    }
    
    public boolean esSolucion(Object [][]sudoku){
            return contarAsignados(sudoku)==81;
    }

    public boolean esFallo(Object [][]sudoku){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                help.add(sudoku[i][j]);
                if(help.isEmpty()){
                    System.out.println(sudoku[i][j]);
                    return true;
                }
                help.clear();
            }
        }
        return false;
    }
    
    public boolean Solucionar(Object [][]sudoku){
        boolean bol=false;
        superReducir(sudoku);
        if(esSolucion(sudoku)) bol=true;
        else if(esFallo(sudoku)) bol=false;
        return bol;
    }
    
    public void Saber(Object [][]sudoku){
        if(Solucionar(sudoku)){
            System.out.println("Solución:\n");
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if(j==3||j==6) System.out.print("|");
                    if("Integer".equals(sudoku[i][j].getClass().getSimpleName())) System.out.print(sudoku[i][j]);
                    else System.out.print("0");
                }
                if(i==2||i==5) System.out.print("\n-----------");   
                System.out.print("\n");
            }
        }
        else{
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if("ArrayList".equals(sudoku[i][j].getClass().getSimpleName())) System.out.println(sudoku[i][j]);
                }
            }
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    if(j==3||j==6) System.out.print("|");
                    if("Integer".equals(sudoku[i][j].getClass().getSimpleName())) System.out.print(sudoku[i][j]);
                    else System.out.print(sudoku[i][j]);
                }
                if(i==2||i==5) System.out.print("\n-----------");   
                System.out.print("\n");
            }
        } 
        //    System.out.println("No tiene solución");    
    }
}
