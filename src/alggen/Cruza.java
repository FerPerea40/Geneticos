/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Cruza {
        ArrayList<Gen_Fen_Fit>  res = new ArrayList<>() ;
    public void Cruza(){
    }
    
    public static Gen_Fen_Fit op_cruza ( Gen_Fen_Fit gen1, Gen_Fen_Fit gen2,int [] mask){
        
        int c1 [] = new int[mask.length];
        int c2 [] = new int[mask.length];

        // recorremos la maskara de cruza 
        for (int b=0; b < mask.length; b++){
            if(mask[b]==1){
                c1[b] = gen1.getGenotipo()[b];
                c2[b] = gen2.getGenotipo()[b];
            } else{
                c1[b]=gen2.getGenotipo()[b];
                c2[b] = gen1.getGenotipo()[b];

            }
        }
             Gen_Fen_Fit aux = new Gen_Fen_Fit(c1);       
             Gen_Fen_Fit aux2 = new Gen_Fen_Fit(c2);       

    
        if (aux.getFitness()>aux2.getFitness()){
            return aux;
        } else {
            return aux2;
        }
          
        
     }
}
