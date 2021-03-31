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
public class Muta {
    public static void aplicarMutaAleatoria(Individuo p){
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);

            p.getGenotipo()[pos]=  ran.nextInt(p.getGenotipo().length);;

       
        p.calcularFit();

    }
}
