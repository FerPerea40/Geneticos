/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServidorMuta {
    public static void main(String args[]){
        try { 
            ObjRemMuta obj = new ObjRemMuta();
            //hacer el registro del obj remoto 
            Registry reg = LocateRegistry.createRegistry(2011);                 
            //referencia al objeto remoto 
            reg.rebind("Muta", obj);
            System.out.println("Este servidor está activo...");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
