/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Random;

public class ObjRemMuta extends UnicastRemoteObject implements MutaOperaciones{
    
    public ObjRemMuta() throws RemoteException{
        super();
    }
    
    @Override
   public  void aplicarMutaAleatoria(IndividuoSAT p,LinkedList<int[]> m){
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
