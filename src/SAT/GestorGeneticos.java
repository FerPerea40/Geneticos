/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class GestorGeneticos {
     private final ArrayList<Data> geneticos = new ArrayList<>();

    public GestorGeneticos(int numGeneticos) throws IOException {
       for (int x=0; x<numGeneticos;x++){
           Data Aux = new Data(x,this);
           Aux.setVisible(true);
           geneticos.add(Aux);
              //geneticos.add(Aux);
        }
    }
    
    public void intercambiarIndividuos(int origen,int destino){
     // el criterio de intercambio es el primero
     Data destinoGen =  this.geneticos.get(destino);
     Data origenGen = this.geneticos.get(origen);
     destinoGen.GS.setPobActual(origenGen.GS.getPobActual());
     destinoGen.setjTextField2(""+origenGen.GS.getTamPob());
     destinoGen.DG.setjTextField8(""+origenGen.GS.getTamPob());
    }
    

    
    // TODO: MODIFCAR OPERADORES 
  //  public void ejecutar(){
//        Thread auxHilo;
//        // proceso iterativo para la asignacion de los hilos y su ejecución
//        for (int x=0; x< this.geneticos.size();x++){
//         auxHilo = new Thread(this.geneticos.get(x));
//         auxHilo.start();
//        }
//    
//    }
}
