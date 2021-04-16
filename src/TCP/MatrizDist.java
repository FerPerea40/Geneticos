/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

/**
 *
 * @author Dell
 */
public class MatrizDist {

    int[][] Matriz;

    public MatrizDist(int n) {
      this.Matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    if(i == j ){
                    Matriz[i][j] = 0;
                    }else{
                        int num = (int) (Math.random()*(10 - 1)+ 1);
                    Matriz[i][j] = num;
                    Matriz[j][i] = num;
                    }
            }
        }

    }
    
    public MatrizDist (int [][] Mat){
            this.Matriz = Mat;
    
    
    }
    
    public void imprimirMat(){
        System.out.println("Matriz de distancias");
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
public static void main(String args[]){
        MatrizDist md = new MatrizDist(8);
        md.imprimirMat();
}
}
