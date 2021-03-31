/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Gen_Fen_Fit {
   private int genotipo[];
    private long fenotipo;
    private long fitness;

    public int[]getGenotipo(){
        return genotipo;
    }
    public void setGenotipo(int[]genotipo){
        this.genotipo =genotipo;
    }
    public long getFenotipo(){
        return fenotipo;
    }
    public void setFenotipo(int fenotipo){
        this.fenotipo =fenotipo;
    }
    public long getFitness(){
        return fitness;
    }
    public void setFitness(long fitness){
        this.fitness =fitness;
    }

    public Gen_Fen_Fit (int n){
        this.genotipo = new int[n];
        inicializarAleatoriamente();
        calcularFitness();
    }

    public Gen_Fen_Fit (int aux[]){
        this.genotipo = aux.clone();
        calcularFitness();
    }

    public void calcularFitness(){
        calcularFenotipo();
        this.fitness = (2*this.fenotipo*this.fenotipo)+this.fenotipo+1;
    }

    private void calcularFenotipo(){
      this.fenotipo = 0;
      for(int x=0; x<this.genotipo.length;x++){
          if (this.genotipo[x]==1){
            this.fenotipo+= Math.pow(2,this.genotipo.length-1-x);
          }
      }
             
    }

    private void inicializarAleatoriamente(){
        Random ran = new Random();
        for(int x=0; x<this.genotipo.length;x++){
            this.genotipo[x]= ran.nextInt(2);
        }
    }

    @Override
    public String toString() {
        String aux = ""+this.fenotipo+": "+this.fitness;
        return aux;
    }

  
    
    public static void main(String args[]){
      Generaciones G = new Generaciones(10,3,10,8);
      G.evolucionar();
      
    }       
}
