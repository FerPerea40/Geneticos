/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import Damas.Individuo;
import Damas.Poblacion;
import TCP.IndividuoTCP;
import TCP.PoblacionTCP;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Dell
 */
public class CrearArchivo {

    public CrearArchivo(LinkedList<Individuo> poblacion, int num_G, double pMuta, int tamPob, int tamg) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
                File fichero2 = new File("datos_" + tamPob + "_" + tamg + ".txt");
            if (!fichero2.exists()) {
                fichero = new FileWriter("datos_" + tamPob + "_" + tamg + ".txt");

                pw = new PrintWriter(fichero);

                for (int i = 0; i < poblacion.size(); i++) {
                    for (int j = 0; j < poblacion.get(0).getGenotipo().length; j++) {
                        pw.print(poblacion.get(i).getGenotipo()[j] + ",");

                    }
                    pw.println();
                }
                System.out.println(fichero2 + " Creado...");
            } else {
           //     System.out.println("Ya existe una versión de " + fichero2);
                LeerArchivo la = new LeerArchivo();
                Poblacion existe = new Poblacion(la.tokenizarDataSet(num_G, pMuta, tamPob, tamg));
                Poblacion nueva = new Poblacion(poblacion);
                    System.out.println("Fitness de Datos Existentes = "+ existe.getFitnessTotal()+" Fitness de Datos Probables: "+nueva.getFitnessTotal());
                if (nueva.getFitnessTotal() <= existe.getFitnessTotal()) {
                    fichero = new FileWriter("datos_" + tamPob + "_" + tamg + ".txt");

                    pw = new PrintWriter(fichero);

                    for (int i = 0; i < poblacion.size(); i++) {
                        for (int j = 0; j < poblacion.get(0).getGenotipo().length; j++) {
                            pw.print(poblacion.get(i).getGenotipo()[j] + ",");

                        }
                        pw.println();
                    }
                    System.out.println(fichero2 + " Actualizado...");
                }
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
  public CrearArchivo(LinkedList<IndividuoTCP> poblacion, int num_G, double pMuta, int tamPob, int tamg,int[][] mat,int[][] matrizi) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
                File fichero2 = new File("datos_" + tamPob + "_" + tamg + ".txt");
            if (!fichero2.exists()) {
                fichero = new FileWriter("datos_" + tamPob + "_" + tamg + ".txt");

                pw = new PrintWriter(fichero);

                for (int i = 0; i < poblacion.size(); i++) {
                    for (int j = 0; j < poblacion.get(0).getGenotipo().length; j++) {
                        pw.print(poblacion.get(i).getGenotipo()[j] + ",");

                    }
                    pw.println();
                }
                System.out.println(fichero2 + " Creado...");
            } 
            //else {
//           //     System.out.println("Ya existe una versión de " + fichero2);
//                LeerArchivo la = new LeerArchivo();
//                PoblacionTCP existe = new PoblacionTCP(la.tokenizarDataSet2(num_G, pMuta, tamPob, tamg),mat,matrizi);
//                PoblacionTCP nueva = new PoblacionTCP(poblacion, mat,matrizi);
//                    System.out.println("Fitness de Datos Existentes = "+ existe.getFitnessTotal()+" Fitness de Datos Probables: "+nueva.getFitnessTotal());
//                if (nueva.getFitnessTotal() <= existe.getFitnessTotal()) {
//                    fichero = new FileWriter("datos_" + tamPob + "_" + tamg + ".txt");
//
//                    pw = new PrintWriter(fichero);
//
//                    for (int i = 0; i < poblacion.size(); i++) {
//                        for (int j = 0; j < poblacion.get(0).getGenotipo().length; j++) {
//                            pw.print(poblacion.get(i).getGenotipo()[j] + ",");
//
//                        }
//                        pw.println();
//                    }
//                    System.out.println(fichero2 + " Actualizado...");
//                }
//            }

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
//    public static void main(String args[]) {
//
//        CrearArchivo c = new CrearArchivo(new Poblacion(50, 10).getPoblacion(), 10, .9, 50, 10);
//
//    }
}
