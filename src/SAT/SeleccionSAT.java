/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class SeleccionSAT {
    
  public static IndividuoSAT seleccionAleatoria(PoblacionSAT pob){
        Random ran = new Random();
       int pos = ran.nextInt(pob.getPoblacionSAT().size());

       return new IndividuoSAT(pob.getPoblacionSAT().get(pos).getGenotipo(),pob.getPoblacionSAT().get(pos).getMuestras()); 
    }
}