/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import Damas.Individuo;
import Damas.Poblacion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class LeerArchivo {
     public   LinkedList <Individuo> tokenizarDataSet(int num_G, double pMuta, int tamPob, int tamg) throws IOException{
    // ventana para abrir el txt
    
     String texto, aux;
     LinkedList<String> lista = new LinkedList();
     LinkedList<Individuo> poblacion = new LinkedList<>();
        try {
            //llamamos el metodo que permite cargar la ventana
//            JFileChooser file = new JFileChooser();
//            file.showOpenDialog(file);
//            //abrimos el archivo seleccionado
//            File abre = file.getSelectedFile();

            //recorremos el archivo y lo leemos
          //  if (abre != null) {
             //  FileReader fr = new FileReader("C:\\Users\\carli\\Desktop\\iris.data"); 

                FileReader archivos = new FileReader("datos_" + tamPob + "_" + tamg + ".txt");
                BufferedReader lee = new BufferedReader(archivos);

                while ((aux = lee.readLine()) != null) {
                    texto = aux;
                    lista.add(texto);
                }
                lee.close();
                //System.out.println(lista.size());

                ArrayList<String> lista2 = new ArrayList<>();
//                String clase = "";
//                String claseComp="";
              for (int i = 0; i < lista.size(); i++) {
                   StringTokenizer st = new StringTokenizer(lista.get(i), ",");

                    while (st.hasMoreTokens()) {
                       lista2.add(st.nextToken());
                   }

                    int[] gen = new int[tamg];

                    for (int x = 0; x <tamg; x++) {
                        gen[x] = Integer.parseInt(lista2.get(x));
                    }

                          poblacion.add(new Individuo(gen));
                
                   lista2.clear();
               }

  //          }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            return null;
        }
       
        return poblacion;
    }
     
//     public static void main(String args[]) throws IOException{
//      
//         LeerArchivo la = new LeerArchivo();
//          Poblacion p = new Poblacion(la.tokenizarDataSet( 10, .9, 50, 10));
//          
//             for (int i = 0; i < p.getPoblacion().size(); i++) {
//                    for (int j = 0; j < p.getPoblacion().get(0).getGenotipo().length; j++) {
//                        if (j < p.getPoblacion().get(0).getGenotipo().length - 1) {
//                            System.out.print(p.getPoblacion().get(i).getGenotipo()[j] + ",");
//                        } else {
//                            System.out.print(p.getPoblacion().get(i).getGenotipo()[j]);
//                        }
//
//                    }
//                    System.out.println();
//                }
//          
//    }
}
