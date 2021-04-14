/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Damas;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Poblacion {
    
 private LinkedList<Individuo> poblacion;
    private int i;
    private int tam;

    public Poblacion(int i,int tam){
        this.i = i;
        this.tam=tam;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    public Poblacion(LinkedList<Individuo> muestra){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Individuo(muestra.get(x).getGenotipo()));
        }
    }

      public Poblacion(){
        this.poblacion = new LinkedList<>();
        
    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        for(Individuo aux: n.getPoblacion()){
            this.poblacion.add(new Individuo(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(){

       for(int x=0; x< this.i; x++){
            this.poblacion.add(new Individuo(this.tam));

       }

    }
    public LinkedList<Individuo> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Individuo> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public LinkedList<Individuo> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Individuo> muestra = new LinkedList<>();
     return muestra;
    }
   
   public LinkedList<Individuo> getPoblacion(){

    return poblacion;
   }
   
   public int getFitnessTotal(){
   int fitT=0;
   
   for(int i=0;i<poblacion.size();i++){
    fitT+=poblacion.get(i).getFitness();
   
   }
   return fitT;
   }
}
