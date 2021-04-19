/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Damas;

import TCP.IndividuoTCP;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Dell
 */
public class Seleccion {

    public static Individuo seleccionAleatoria(Poblacion pob) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacion().size());

        return new Individuo(pob.getPoblacion().get(pos).getGenotipo());
    }

    public Individuo seleccionRuleta(Poblacion pob) {
        int sumatotal = pob.getFitnessTotal();
        double[] probabilidad = new double[pob.getPoblacion().size()];
        double[] probacumulada = new double[pob.getPoblacion().size()];

     
        for (int i = 0; i < pob.getPoblacion().size(); i++) {
            probabilidad[i] = (double) pob.getPoblacion().get(i).getFitness() / sumatotal;
        }
        probacumulada[0] = probabilidad[0];

        for (int i = 1; i < pob.getPoblacion().size(); i++) {
            probacumulada[i] = probabilidad[i] + probacumulada[i - 1];
        }
        double numale = Math.random();
            int pos = 0;
        for (int i = 1; i < probacumulada.length; i++) {
                if(numale<= probacumulada[i]  && numale >probacumulada[i-1] ){
                pos=i;
                break;
                }
        }
        return pob.getPoblacion().get(pos);
    }

    public static void main(String args[]) {
        Poblacion p = new Poblacion(10, 8);
        p.mostrarPob();
    
        Seleccion s = new Seleccion();
        Individuo ind = new Individuo(s.seleccionRuleta(p).getGenotipo()); 
        
        System.out.println("jaja"+ind.getFitness());
        System.out.println();
    }
}
