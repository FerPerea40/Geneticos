/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Damas;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class Individuo {
     private int genotipo[];
    private int[] fenotipo;
    private long fitness;

    public int[]getGenotipo(){
        return genotipo;
    }
    public void setGenotipo(int[]genotipo){
        this.genotipo =genotipo;
    }
    public int[] getFenotipo(){
        return fenotipo;
    }
    public void setFenotipo(int[] fenotipo){
        this.fenotipo =fenotipo;
    }
    public long getFitness(){
        return fitness;
    }
    public void setFitness(long fitness){
        this.fitness =fitness;
    }

    public Individuo (int n){
        this.genotipo = new int[n];
        inicializarAleatoriamente(n);
        calcularFitness();
    }

    public Individuo (int aux[]){
        this.genotipo = aux.clone();
        calcularFitness();
    }

    public void calcularFitness(){
       calcularFenotipo();
       
    }

    public void calcularFenotipo(){
     
     numHorizontales();
     numDiagonales1();
     numDiagonales2();
    

    }

    private void inicializarAleatoriamente(int n){
        Random ran = new Random();
        for(int x=0; x<this.genotipo.length;x++){
            this.genotipo[x]= ran.nextInt(n);
        }
    }
    
    public void numHorizontales(){
      for(int i =0;i<genotipo.length;i++){
        for(int j =i+1;j<genotipo.length;j++){
            if(i!=j){
          if(genotipo[i]==genotipo[j]){
                   this.fitness+=2;
               }}
        }
     
       }
    }
    public void numDiagonales1(){
       for(int i =0;i<genotipo.length;i++){
        for(int j = i+1;j<genotipo.length;j++){
          if(i!=j){
        if(this.genotipo[i]-i == this.genotipo[j]-j){
             this.fitness+=2;
        }}
       }
    }
   }
    public void numDiagonales2(){
      for(int i =0;i<genotipo.length;i++){
        for(int j = i+1;j<genotipo.length;j++){
         if(i!=j){
        if(this.genotipo[i]+i == this.genotipo[j]+j){
             this.fitness+=2;
        }
}
        }
        
       }
    }
    
    
    public void calcularFit(){
     this.fitness=0;
     
     for(int i=0;i<genotipo.length;i++){
          for(int j=i+1;j<genotipo.length;j++){
               int a = this.genotipo[i];
               int b = this.genotipo[j];
               int auxi =this.genotipo[i]-i;
               int auxj =this.genotipo[j]-j;
               int aux2i =this.genotipo[i]+i;
               int aux2j =this.genotipo[j]+j;
               if(a==b||auxi==auxj||aux2i==aux2j){
                   this.fitness+=2;
               }
     }
     }
    
    }
    
    @Override
    public String toString() {
        System.out.print("Genotipo: " );
        for(int i=0;i<genotipo.length;i++){
                  System.out.print(genotipo[i]+",");
      
        }
        String aux = "\n"+this.fenotipo+": "+this.fitness;
        return aux;
    }
    public static void main(String args[]){
        
       // Individuo i =  new Individuo();
        
            Generaciones gen = new Generaciones(100,.5,100,10);
            gen.evolucionar();
            Grafica graf = new Grafica("Comportamiento (100,.5,100,10)","Generación","Fitness");
            graf.crearSerie("Datos : (100,.5,100,110)",gen.getGens());
            graf.mostrarGrafica();
            
            Generaciones gen1 = new Generaciones(200,.2,400,25);
            gen1.evolucionar();
            Grafica graf1 = new Grafica("Comportamiento (200,.2,400,25)","Generación","Fitness");
            graf1.crearSerie("Datos : (200,.2,400,25)",gen1.getGens());
            graf1.mostrarGrafica();
            
             Generaciones gen2 = new Generaciones(1000,.2,500,100);
            gen2.evolucionar();
            Grafica graf2 = new Grafica("Comportamiento (000,.2,500,100)","Generación","Fitness");
            graf2.crearSerie("Datos : (000,.2,500,100)",gen2.getGens());
            graf2.mostrarGrafica();
            
             Generaciones gen3 = new Generaciones(2500,.1,400,150);
            gen3.evolucionar();
            Grafica graf3 = new Grafica("Comportamiento (2500,.1,400,150)","Generación","Fitness");
            graf3.crearSerie("Datos : (2500,.1,400,150)",gen3.getGens());
            graf3.mostrarGrafica();
            
             Generaciones gen4 = new Generaciones(10000,.05,1000,5000);
            gen4.evolucionar();
            Grafica graf4 = new Grafica("Comportamiento (10000,.05,1000,500)","Generación","Fitness");
            graf4.crearSerie("Datos : (10000,.05,1000,5000)",gen4.getGens());
            graf4.mostrarGrafica();
           
    }       
}
