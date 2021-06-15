/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class SeleccionSAT {

    public static IndividuoSAT concualseleccion(boolean a , boolean b, PoblacionSAT pob, LinkedList<int[]> m) {

       if(a && !b){
              //  System.out.println("Aleatoria");
                 return seleccionAleatoria(pob,m);
       }else if( !a && b){
        
             //   System.out.println("Torneo");
                 return seleccionTorneo(pob,m);
       }else{
                  Random ran = new Random();
                  if(ran.nextInt(2) == 0){
               //       System.out.println("Aleatoria");
                  return seleccionAleatoria(pob,m);
                  }else{
                 //     System.out.println("Torneo");
                  return seleccionTorneo(pob,m);
                  }
           
        }

      
    }

    
     
  public static IndividuoSAT seleccionAleatoria(PoblacionSAT pob, LinkedList<int[]> m) {
        Random ran = new Random();
        int pos = ran.nextInt(pob.getPoblacionSAT().size());

        return new IndividuoSAT(pob.getPoblacionSAT().get(pos).getGenotipo(), m);
    }

    public static IndividuoSAT seleccionTorneo(PoblacionSAT pob, LinkedList<int[]> m) {
        IndividuoSAT mejor = new IndividuoSAT(pob.getMejor().getGenotipo(), m);
        return mejor;
    }
}
