/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import Damas.Grafica;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Dell
 */
public class IndividuoTCP {

    private int genotipo[];
    private int[] fenotipo;
    private long fitness;
    private int[][] matriz;
    private int[][] matrizi;

    IndividuoTCP() {
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo.clone(); 
    }

    public int[] getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(int[] fenotipo) {
        this.fenotipo = fenotipo.clone();
    }

    public long getFitness() {
                        calcularFitness();

        return fitness;
    }

    public void setFitness(long fitness) {
        this.fitness = fitness;
    }

//    public IndividuoTCP(int n,int [][] matriz, int[][] mati) {
//        this.genotipo = new int[n];
//        this.matriz = matriz;
//        this.matrizi = mati;
//        inicializarAleatoriamente(n);
//    }

    public IndividuoTCP(int[][] matriz,int[][] mati) {
        this.matriz = matriz;
                this.matrizi = mati;

                calcularFitness();

    }

    public IndividuoTCP(IndividuoTCP ind, int[][] matriz,int[][] mati) {
        this.fitness = ind.fitness;
        this.genotipo = ind.genotipo.clone();
        this.matriz = matriz;
        this.matrizi = mati;
        calcularFitness();

    }

    public IndividuoTCP(int n, int[][] mat,int[][] mati) {
        this.genotipo = new int[n];
        this.matriz = mat;
        this.matrizi = mati;
        inicializarAleatoriamente(n);
        calcularFitness();
    }

    public IndividuoTCP(int aux[], int[][] mat,int[][] mati) {
        this.genotipo = aux.clone();
        this.matriz = mat;
        this.matrizi = mati;

        calcularFitness();
    }

   // public IndividuoTCP(int aux[]) {
   //     this.genotipo = aux.clone();
          //      calcularFitness();

    //}

    public void calcularFitness() {
        this.fitness = 0;
        for (int j = 1; j < this.matriz.length; j++) {
            this.fitness += (this.matriz[this.genotipo[j - 1]][this.genotipo[j]] +  this.matrizi[this.genotipo[j - 1]][this.genotipo[j]]  );
        }
        this.fitness += (this.matriz[this.genotipo[0]][this.genotipo[this.matriz.length - 1]] + this.matrizi[this.genotipo[0]][this.genotipo[this.matriz.length - 1]]);

    }



    private void inicializarAleatoriamente(int n ) {
        Set<Integer> generados = new HashSet<>();
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int posible = (int) (Math.random() * (n - 0) + 0);
                if (!generados.contains(posible)) {
                    generados.add(posible);
                    this.genotipo[i] = posible;
                    aleatorio = posible;
                    generado = true;
                }
            }
        }
        System.out.print("Genotipo: ");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(this.genotipo[i] + ",");
            } else {
                System.out.println(this.genotipo[i]);

            }
        }
        
              //  calcularFitness();


    }
      public boolean validar() {
        for (int i = 0; i < genotipo.length; i++) {
            for (int j = 0; j < genotipo.length; j++) {
                if (i != j && genotipo[i] == genotipo[j]) {
                    return false;
                }

            }
        }
        return true;
    }

    public void imprimirIndividuo() {
        for (int i = 0; i < genotipo.length; i++) {
            if (i != genotipo.length - 1) {
                System.out.print(genotipo[i] + ",");
            } else {
                System.out.println(genotipo[i]);

            }
        }
    }

    @Override
    public String toString() {
        String aux = "Genotipo: ";
        for (int i = 0; i < genotipo.length; i++) {

            if (i == genotipo.length - 1) {
                aux += genotipo[i];

            } else {
                aux += genotipo[i] + ",";
            }
        }
        aux += " Fenotipo => " + this.fitness;
        return aux;
    }

    public static void main(String args[]) throws IOException {

        // System.out.println("Prueba #" + i + ": ");
        
        int Generaciones =     15000;
        double p_Muta =         .5;
        int tamPob =           500; 
        int tam_Genotipo =      20; 
        int Max_Dist =          100;
       // CrearArchivo cr = new CRearARxhivo();
        Generaciones gen1 = new Generaciones(Generaciones, p_Muta, tamPob, tam_Genotipo, Max_Dist);
        gen1.evolucionar();
        Grafica graf1 = new Grafica("Comportamiento ("+Generaciones+","+p_Muta+","+tamPob+","+tam_Genotipo+","+Max_Dist+")", "Generación", "Fitness");
        graf1.crearSerie("Datos : ("+Generaciones+","+p_Muta+","+tamPob+","+tam_Genotipo+","+Max_Dist+")", gen1.getGens());
        graf1.mostrarGrafica();

//            
//             Generaciones gen2 = new Generaciones(1000,.2,500,100);
//            gen2.evolucionar();
//            Grafica graf2 = new Grafica("Comportamiento (000,.2,500,100)","Generación","Fitness");
//            graf2.crearSerie("Datos : (000,.2,500,100)",gen2.getGens());
//            graf2.mostrarGrafica();
//            
//             Generaciones gen3 = new Generaciones(2500,.1,400,150);
//            gen3.evolucionar();
//            Grafica graf3 = new Grafica("Comportamiento (2500,.1,400,150)","Generación","Fitness");
//            graf3.crearSerie("Datos : (2500,.1,400,150)",gen3.getGens());
//            graf3.mostrarGrafica();
//            
//             Generaciones gen4 = new Generaciones(10000,.05,1000,5000);
//            gen4.evolucionar();
//            Grafica graf4 = new Grafica("Comportamiento (10000,.05,1000,500)","Generación","Fitness");
//            graf4.crearSerie("Datos : (10000,.05,1000,5000)",gen4.getGens());
//            graf4.mostrarGrafica();
    }
}
