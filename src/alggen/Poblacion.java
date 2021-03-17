/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Poblacion {
    
 private LinkedList<Gen_Fen_Fit> poblacion;
    private int i;
    private int tam;

    // creacion aleatoria de la población
    public Poblacion(int i,int tam){
        this.i = i;
        this.tam=tam;
        this.poblacion = new LinkedList<>();
        inicializarAleatorimente();
    }

    // creacion  población con muestreo
    public Poblacion(LinkedList<Gen_Fen_Fit> muestra, int i){
        this.poblacion = new LinkedList<>();
        for(int x=0;x<muestra.size();x++){
            this.poblacion.add(new Gen_Fen_Fit(muestra.get(x).getGenotipo()));
        }
        // ver como se resolverá el
    }

      // creacion  población con muestreo
      public Poblacion(){
        this.poblacion = new LinkedList<>();
        
    }

    public Poblacion(Poblacion n){
        this.poblacion = new LinkedList<>();
        // crear un nueva población en base a otra 
        for(Gen_Fen_Fit aux: n.getPoblacion()){
            this.poblacion.add(new Gen_Fen_Fit(aux.getGenotipo()));

        }

    }

    public void inicializarAleatorimente(){

       // un proceso iterativo con respecto a i
       for(int x=0; x< this.i; x++){
            this.poblacion.add(new Gen_Fen_Fit(this.tam));

       }

    }
    public LinkedList<Gen_Fen_Fit> generarMuestraAleatoria(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Gen_Fen_Fit> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for(int x=0; x<c;x++){
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
     return muestra;
    }

    public LinkedList<Gen_Fen_Fit> generarMuestraMejores(double p){
        int c = (int)((this.i*p)/100);
        LinkedList<Gen_Fen_Fit> muestra = new LinkedList<>();
        // ordenar los elementos
     return muestra;
    }
   
   public LinkedList<Gen_Fen_Fit> getPoblacion(){

    return poblacion;
   }
}
