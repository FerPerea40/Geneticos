/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

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
public class Leer3SAT {
    
static int tamSAT;

     public static  LinkedList <int[]> tokenizarDataSet(int MaxNum, int NumMuestras, int version) throws IOException{
    // ventana para abrir el txt
    
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
     LinkedList<int[]> muestras = new LinkedList<>();

     try {
               FileReader archivos = new FileReader("3SAT/G2-" + MaxNum + "-" +NumMuestras +"-"+ version +".txt");
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                
                                ArrayList<String> lista2 = new ArrayList<>();


                 StringTokenizer st0 = new StringTokenizer(lista.get(1), " ");

                    while (st0.hasMoreTokens()) {
                       lista2.add(st0.nextToken());
                   }

                    int[] gen0 = new int[3];

             
                        gen0[0] = Integer.parseInt(lista2.get(0));
                    

                          tamSAT = gen0[0];
                
                   lista2.clear();
                
                
              for (int i = 2; i < lista.size(); i++) {
                   StringTokenizer st = new StringTokenizer(lista.get(i), " ");

                    while (st.hasMoreTokens()) {
                       lista2.add(st.nextToken());
                   }

                    int[] gen = new int[3];

                    for (int x = 0; x <3; x++) {
                        gen[x] = Integer.parseInt(lista2.get(x));
                    }

                          muestras.add(gen);
                
                   lista2.clear();
               }
              

  //          }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }
       
        return muestras;
    }
}
