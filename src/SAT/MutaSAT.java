/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class MutaSAT {
     public static void aplicarMutaAleatoria(IndividuoSAT p,LinkedList<int[]> m){
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        if(p.getGenotipo()[pos]==1){
            p.getGenotipo()[pos]=0;

        }else {
            p.getGenotipo()[pos]=1;
        }
        p.calcularFitness(m);

    }
}
