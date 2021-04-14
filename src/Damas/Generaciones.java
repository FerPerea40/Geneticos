/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Damas;

import Archivo.CrearArchivo;
import java.util.Random;


/**
 *
 * @author Dell
 */
public class Generaciones {
      private int num_G;
    private double pMuta;
    private Poblacion pobActual;
    private int tamPob;
    private int tamt;
     double gens [] ;

    public double[] getGens() {
        return gens;
    }

    public void setGens(double[] gens) {
        this.gens = gens;
    }
    public Generaciones(int num_G,double pMuta,int tamPob,int tamg){
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.pobActual = new Poblacion(tamPob,tamg);
        CrearArchivo c= new CrearArchivo(new Poblacion(tamPob,tamg).getPoblacion(),num_G,pMuta,tamPob,tamg);
        this.tamt=tamg;
    }

    public void evolucionar(){
        int mascara [] = new int[tamt];
        Random ran = new Random();
        for(int x=0; x<tamt;x++){
           mascara[x]= ran.nextInt(2);}
        Individuo mejor;
         gens = new double[num_G];
        for(int g=0; g<this.num_G; g++){
            Poblacion nueva = new Poblacion();
            mejor = new Individuo(new int[mascara.length]);
            for(int i=0; i<this.tamPob;i++){
                Individuo madre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo padre = Seleccion.seleccionAleatoria(this.pobActual);
                Individuo hijo = Cruza.op_cruza(madre,padre,mascara);
            
                if(Math.random()<this.pMuta){
                    Muta.aplicarMutaAleatoria(hijo);
                }
                nueva.getPoblacion().add(hijo);
                if (hijo.getFitness()<=mejor.getFitness()){
                    mejor = new Individuo(hijo.getGenotipo());
                }
            }
          //  System.out.println("Generación #"+g+":"+mejor.toString());
           
            gens[g] = mejor.getFitness();
            this.pobActual = new Poblacion(nueva);
             
        }

    }
    
    


}
