/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import Archivo.CrearArchivoMatriz;

/**
 *
 * @author Dell
 */
public class MatrizInclinacion {

    int[][] Matriz;
    int Mdist;

    public MatrizInclinacion(int n, int Mdist) {
        this.Mdist = Mdist;
      this.Matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    if(i == j ){
                    Matriz[i][j] = 0;
                    }else{
                        int num = (int) (Math.random()*(Mdist - 1)+ (-Mdist));
                    Matriz[i][j] = num;
                    Matriz[j][i] = -1*num;
                    }
            }
        }
          CrearArchivoMatriz c = new CrearArchivoMatriz(Matriz,Matriz.length,Mdist);
    }
    
    public MatrizInclinacion (int [][] Mat,int Mdist){
            this.Matriz = Mat;
            this.Mdist=Mdist;
      CrearArchivoMatriz c = new CrearArchivoMatriz(Matriz,Matriz.length,Mdist);

     }

    public MatrizInclinacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void imprimirMat(){
        System.out.println("Matriz de Inclinacion");
    for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz.length; j++) {
 
                 if(j == Matriz.length-1){
                 System.out.println(Matriz[i][j]);
                
                
                }else{
                                 System.out.print(Matriz[i][j]+",");
                 }
                
                 
                }
            }
    
    }
//public static void main(String args[]){
//        MatrizInclinacion md = new MatrizInclinacion(8,5);
//        md.imprimirMat();
//}
}
