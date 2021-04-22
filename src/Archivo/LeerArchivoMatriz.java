/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import TCP.MatrizDist;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class LeerArchivoMatriz {
    
      public MatrizDist tokenizarDataSet( int tam, int Mdist) throws IOException{
    
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
      int[][] matriz = new int[tam][tam];
        try {
                FileReader archivos = new FileReader("Matriz_" + tam + "_" + Mdist + ".txt");
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();

                ArrayList<String> lista2 = new ArrayList<>();

              for (int i = 0; i < lista.size(); i++) {
                   StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                       lista2.add(st.nextToken());
                   }
                    
                   

                    for (int x = 0; x <tam; x++) {
                        matriz[i][x] = Integer.parseInt(lista2.get(x));
                    }

                          
                
                   lista2.clear();
               }

  //          }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }
            MatrizDist mat = new MatrizDist(matriz);

        return mat;
    }
}
