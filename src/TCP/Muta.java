/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class Muta {
    public static void aplicarMutaAleatoria(IndividuoTCP ind){
         Random ran = new Random();
        int pos = ran.nextInt(ind.getGenotipo().length);
        int nuevapos = ran.nextInt(ind.getGenotipo().length);
        while (pos == nuevapos || pos == 0 || nuevapos==0) {
             pos = ran.nextInt(ind.getGenotipo().length);
             nuevapos = ran.nextInt(ind.getGenotipo().length);
        }
        int aux=ind.getGenotipo()[pos];
        ind.getGenotipo()[pos] = ind.getGenotipo()[nuevapos];
        ind.getGenotipo()[nuevapos] = aux;
        ind.calcularFitness();
    }

    }
//     public static void main(String args[]) {
//         IndividuoTCP it = new IndividuoTCP(5);
//         it.imprimirIndividuo();
//          Muta.aplicarMutaAleatoria(it);
//                   it.imprimirIndividuo();
//
//     }

