/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Dell
 */
public class CrearArchivoMatriz {
    
    public CrearArchivoMatriz(int[][]matriz, int tam, int Mdist) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            
                File fichero2 = new File("Matriz_" + tam + "_" + Mdist + ".txt");
            if (!fichero2.exists()) {
                fichero = new FileWriter("Matriz_" + tam + "_" + Mdist + ".txt");

                pw = new PrintWriter(fichero);

                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz.length; j++) {
                        pw.print(matriz[i][j] + ",");

                    }
                    pw.println();
                }
                System.out.println(fichero2 + " Creado...");
            }else{
               System.out.println(fichero2 + " Ya exiiste se utilizara el archivo viejo....");

            
            }
            
           

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
