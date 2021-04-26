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
public class Seleccion {
     public static IndividuoTCP seleccionAleatoria(PoblacionTCP pob, int[][]mat) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacion().size());

        return new IndividuoTCP(pob.getPoblacion().get(pos).getGenotipo(),mat);
    }

    public static IndividuoTCP seleccionRuleta(PoblacionTCP pob, int [][] mat) {
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
        return  new IndividuoTCP(pob.getPoblacion().get(pos).getGenotipo(),mat);
    }
}
