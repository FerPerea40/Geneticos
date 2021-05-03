/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import Damas.Grafica;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class GeneracionesSAT {

    private int num_G;
    private double pMuta;
    private PoblacionSAT pobActual;
    private int tamPob;
    private LinkedList<int[]> muestras;
    double gens[];

    public double[] getGens() {
        return gens;
    }

    public void setGens(double[] gens) {
        this.gens = gens;
    }

    public GeneracionesSAT(int num_G, double pMuta, int tamPob, int tamg, int MaxNum, int NumMuestras, int version) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.muestras = Leer3SAT.tokenizarDataSet(MaxNum, NumMuestras, version);
        this.pobActual = new PoblacionSAT(tamPob, tamg, this.muestras);

    }

    public void evolucionar() throws IOException {
        int mascara[] = new int[this.pobActual.getPoblacionSAT().get(0).getGenotipo().length];
        Random ran = new Random();
        for (int x = 0; x < mascara.length; x++) {
            mascara[x] = ran.nextInt(2);
        }

        IndividuoSAT mejor;
        gens = new double[num_G];

        for (int g = 0; g < this.num_G; g++) {

            PoblacionSAT nueva = new PoblacionSAT();
            
            mejor = new IndividuoSAT(new int[mascara.length], this.muestras);
            
            for (int i = 0; i < this.tamPob; i++) {
                
                IndividuoSAT madre = SeleccionSAT.seleccionAleatoria(this.pobActual,this.muestras);
                IndividuoSAT padre = SeleccionSAT.seleccionAleatoria(this.pobActual,this.muestras);
                IndividuoSAT hijo = CruzaSAT.op_cruza(madre, padre, mascara, this.muestras);

                if (Math.random() < this.pMuta) {
                    MutaSAT.aplicarMutaAleatoria(hijo,this.muestras);
                }
                
                nueva.getPoblacionSAT().add(hijo);

               if (hijo.getFitness() > mejor.getFitness()) {
                    mejor = hijo;

               }
            }
            System.out.println("G#" + g + " => ");
            gens[g]=0;
            gens[g] =  mejor.torString();

            this.pobActual = new PoblacionSAT(nueva, this.muestras);

        }
        System.out.println();

    }

    public static void main(String args[]) throws IOException {

        //int num_G,double pMuta,int tamPob,int tamg ,int MaxNum,int NumMuestras,int version
        int Generaciones = 300;
        double p_Muta = .50;
        int tamPob = 1000;
        int tam_Genotipo = 100;
//        DATOS DE ARCHIVO 3SAT
        int Max_Dist = 100;
        int NumMuestras = 550;
        int version = 1;

        GeneracionesSAT GS = new GeneracionesSAT(Generaciones, p_Muta, tamPob, tam_Genotipo, Max_Dist, NumMuestras, version);
        GS.evolucionar();
        Grafica graf1 = new Grafica("Comportamiento (" + Generaciones + "," + p_Muta + "," + tamPob + "," + tam_Genotipo + "," + Max_Dist + ")", "Generación", "Fitness");
        graf1.crearSerie("Datos : (" + Generaciones + "," + p_Muta + "," + tamPob + "," + tam_Genotipo + "," + Max_Dist + ")", GS.getGens());
        graf1.mostrarGrafica();
    }
}
