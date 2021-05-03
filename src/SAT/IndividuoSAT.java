/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import Damas.Grafica;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class IndividuoSAT {

    private int genotipo[];
    private long fenotipo;
    private long fitness;
    private LinkedList<int[]> muestras;

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public long getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(int fenotipo) {
        this.fenotipo = fenotipo;
    }

    public long getFitness() {
        return fitness;
    }

    public void setFitness(long fitness) {
        this.fitness = fitness;
    }

    public IndividuoSAT(int n, LinkedList<int[]> muestras) {
        this.genotipo = new int[n];
        inicializarAleatoriamente();
        this.muestras = muestras;
        calcularFitness();
    }

    public IndividuoSAT(int aux[], LinkedList<int[]> muestras) {
        this.genotipo = aux.clone();
        this.muestras = muestras;
        calcularFitness();
    }

    public void calcularFitness() {
this.fitness = 0;
        for (int i = 0; i < this.muestras.size(); i++) {
            int[] muestrita = this.muestras.get(i);
            int[] binario = new int[muestrita.length];
            for (int k = 0; k < muestrita.length; k++) {
                if (muestrita[k] >= 0) {
                    binario[k] = 1;
                    
                } else {
                    binario[k] = 0;
                    muestrita[k] = muestrita[k]*(-1);
                }
            }
            int [] operandos = new int[muestrita.length];
            for (int j = 0; j < muestrita.length; j++) {
                operandos[j] = this.genotipo[muestrita[j]]*binario[j]; 
              //  System.out.println("Vuelta: "+ i +" Gen: "+this.genotipo[muestrita[j]]+ " Muestra: "+ muestrita[j]+" Binario: "+ binario[j]+" Operando: "+operandos[j]);
            }
            boolean result =false;
            for(int r=0;r<operandos.length;r++){
            if(operandos[r]==1){
              result = true || result ;
            }else{
              result = false || result ;
            }
             
            }
               if(result == true){
               this.fitness++;
               //System.out.println("Resultado: true");
               }else{   //           System.out.println("Resultado: false");
}
        }
    //   System.out.println("Fitness : " +this.fitness);
    }

    private void inicializarAleatoriamente() {
        Random ran = new Random();
        for (int x = 0; x < this.genotipo.length; x++) {
            this.genotipo[x] = ran.nextInt(2);
        }
    }

    @Override
    public String toString() {
        String aux = "Genotipo: ";
        for (int i = 0; i < genotipo.length; i++) {
            aux += genotipo[i] + ",";
            if (i == genotipo.length - 1) {
                aux += genotipo[i];

            }
        }
        aux += " Fenotipo => " + this.fitness;
        return aux;
    }

    public static void main(String args[]) throws IOException {
//        LinkedList<int[]> muestras = Leer3SAT.tokenizarDataSet(100, 550, 1);
//        int tamg = Leer3SAT.tamSAT + 1;
//        IndividuoSAT IS = new IndividuoSAT(tamg, muestras);
//        System.out.println("");
//        
//        
// int num_G,double pMuta,int tamPob,int tamg ,int MaxNum,int NumMuestras,int version


       int Generaciones =     50;
        double p_Muta =         .5;
        int tamPob =           1000; 
        int tam_Genotipo =      100; 
        //DATOS DE ARCHIVO 3SAT
        int Max_Dist =          100;
        int NumMuestras =         550;
        int version =          2;
       GeneracionesSAT GS = new GeneracionesSAT(Generaciones,p_Muta,tamPob,tam_Genotipo+1,Max_Dist,NumMuestras,version);
       GS.evolucionar();
       Grafica graf1 = new Grafica("Comportamiento ("+Generaciones+","+p_Muta+","+tamPob+","+tam_Genotipo+","+Max_Dist+")", "Generación", "Fitness");
        graf1.crearSerie("Datos : ("+Generaciones+","+p_Muta+","+tamPob+","+tam_Genotipo+","+Max_Dist+")", GS.getGens());
        graf1.mostrarGrafica();
    }

    public LinkedList<int[]> getMuestras() {
        return muestras;
    }

    public void setMuestras(LinkedList<int[]> muestras) {
        this.muestras = muestras;
    }

}
