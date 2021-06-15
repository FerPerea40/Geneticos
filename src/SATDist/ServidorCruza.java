/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServidorCruza {
    public static void main(String args[]){
        try { 
            ObjRemCruza obj = new ObjRemCruza();
            //hacer el registro del obj remoto 
            Registry reg = LocateRegistry.createRegistry(1021);                 
            //referencia al objeto remoto 
            reg.rebind("Cruza", obj);
            System.out.println("El servidor esta activo...");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
