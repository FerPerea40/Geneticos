/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SATDist;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;

public interface MutaOperaciones extends Remote{
    public void aplicarMutaAleatoria(IndividuoSAT p,
            LinkedList<int[]> muestras)
            throws RemoteException;
}
