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
    
    public  ArrayList<Gen_Fen_Fit> op_cruza ( ArrayList<Gen_Fen_Fit>  crom,int [] mask){
        
       ArrayList<Gen_Fen_Fit>  Entradas = new ArrayList<>() ;
       Entradas.add(crom.get((int)Math.random()*(crom.size() - 0) + 0));
       Entradas.add(crom.get((int)Math.random()*(crom.size() - 0) + 0));
        
                         
                    int c1[] = crom.get(0).genotipo ;
                    int c2[] = crom.get(1).genotipo ;
                    int ac1[] = new int[c1.length] ;
                    int ac2[] = new int[c1.length] ;
                    
                    for(int i=0;i<mask.length;i++){
                         if(mask[i]==1){
                            ac1[i]=c1[i] ;
                            ac2[i]=c2[i] ;

                         }else{
                            ac1[i]=c2[i] ;
                            ac2[i]=c1[i] ;

                                    }
                 }
             Gen_Fen_Fit aux = new Gen_Fen_Fit(ac1);       
             Gen_Fen_Fit aux2 = new Gen_Fen_Fit(ac2);       

             
             res.add(aux);
             res.add(aux2);
          
        
     return res;
    }
}
