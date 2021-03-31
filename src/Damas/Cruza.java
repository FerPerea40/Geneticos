/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Damas;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Cruza {
        ArrayList<Individuo>  res = new ArrayList<>() ;
    public void Cruza(){
    }
    
    public static Individuo op_cruza ( Individuo gen1, Individuo gen2,int [] mask){
        
        int c1 [] = new int[mask.length];
        int c2 [] = new int[mask.length];

        for (int b=0; b < mask.length; b++){
            if(mask[b]==1){
                c1[b] = gen1.getGenotipo()[b];
                c2[b] = gen2.getGenotipo()[b];
            } else{
                c1[b]=gen2.getGenotipo()[b];
                c2[b] = gen1.getGenotipo()[b];

            }
        }
             Individuo aux = new Individuo(c1);       
             Individuo aux2 = new Individuo(c2);       

    
        if (aux.getFitness()<=aux2.getFitness()){
            return aux;
        } else {
            return aux2;
        }
          
        
     }
}
