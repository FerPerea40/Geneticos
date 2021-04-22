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
    public static void aplicarMutaAleatoria(IndividuoTCP p){
        Random ran = new Random();
        int pos = ran.nextInt(p.getGenotipo().length);
        int pos2 = ran.nextInt(p.getGenotipo().length);
        boolean bandera=true;
        while(bandera){
        if(pos!=pos2){
           int guarda = p.getGenotipo()[pos];
           int guarda2 = p.getGenotipo()[pos2];
            p.getGenotipo()[pos]= guarda2 ;
            p.getGenotipo()[pos2]= guarda ;
            bandera=false;
        }else{
         bandera = true;
        }
        }
        p.calcularFit();

    }
//     public static void main(String args[]) {
//         IndividuoTCP it = new IndividuoTCP(5);
//         it.imprimirIndividuo();
//          Muta.aplicarMutaAleatoria(it);
//                   it.imprimirIndividuo();
//
//     }
}
