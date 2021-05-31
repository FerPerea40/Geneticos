/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import Damas.Grafica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class GeneracionesSAT implements Runnable {

    private int num_G;
    private double pMuta;
    private PoblacionSAT pobActual;
    private int tamPob;
    private LinkedList<int[]> muestras;
  //  double gens[];
     ArrayList<Double> gens = new ArrayList<>();
    String salida = "";
    private int MaxNum;
    private int NumMuestras;
    private int version;
    private int tamg;
    boolean a;
    boolean b;
    Data d;
    
    public void setseleccion(boolean a, boolean b){
    this.a = a;
    this.b = 
            b ;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public double getpMuta() {
        return pMuta;
    }

    public void setpMuta(double pMuta) {
        this.pMuta = pMuta;
    }

    public int getNum_G() {
        return num_G;
    }

    public void setNum_G(int num_G) {
        this.num_G = num_G;
    }

    public PoblacionSAT getPobActual() {
        return pobActual;
    }

    public void setPobActual(PoblacionSAT pobActual) {
        this.pobActual = pobActual;
    }

    public int getTamPob() {
        return tamPob;
    }

    public void setTamPob(int tamPob) {
        this.tamPob = tamPob;
    }

    public LinkedList<int[]> getMuestras() {
        return muestras;
    }

    public void setMuestras(LinkedList<int[]> muestras) {
        this.muestras = muestras;
    }

    public ArrayList<Double> getGens() {
        return gens;
    }

    public void setGens(ArrayList<Double> gens) {
        this.gens = gens;
    }

    
    public GeneracionesSAT(int num_G, double pMuta, int tamPob, int tamg, int MaxNum, int NumMuestras, int version) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.MaxNum = MaxNum;
        this.NumMuestras = NumMuestras;
        this.version = version;
        this.tamg = tamg;
        this.muestras = Leer3SAT.tokenizarDataSet(MaxNum, NumMuestras, version);
        this.pobActual = new PoblacionSAT(tamPob, tamg, this.muestras);

    }
     public GeneracionesSAT(Data d, int num_G, double pMuta, int tamPob, int tamg, int MaxNum, int NumMuestras, int version) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        this.MaxNum = MaxNum;
        this.NumMuestras = NumMuestras;
        this.version = version;
        this.tamg = tamg;
        this.muestras = Leer3SAT.tokenizarDataSet(MaxNum, NumMuestras, version);
        this.pobActual = new PoblacionSAT(tamPob, tamg, this.muestras);
          this.d = d ;
    }

    public void evolucionar() throws IOException {

        int mascara[] = new int[this.pobActual.getPoblacionSAT().get(0).getGenotipo().length];
        Random ran = new Random();
        for (int x = 0; x < mascara.length; x++) {
            mascara[x] = ran.nextInt(2);
        }

        IndividuoSAT mejor;
        
        d.actualizarGrafica(gens);
        for (int g = 0; g < this.num_G; g++) {

            PoblacionSAT nueva = new PoblacionSAT();

            mejor = new IndividuoSAT(new int[mascara.length], this.muestras);

            for (int i = 0; i < this.tamPob; i++) {

                IndividuoSAT madre = SeleccionSAT.concualseleccion(this.a,this.b,this.pobActual, this.muestras);
                IndividuoSAT padre = SeleccionSAT.concualseleccion(this.a, this.b,this.pobActual, this.muestras);
                IndividuoSAT hijo = CruzaSAT.op_cruza(madre, padre, mascara, this.muestras);

                if (Math.random() < this.pMuta) {
                    MutaSAT.aplicarMutaAleatoria(hijo, this.muestras);
                }

                nueva.getPoblacionSAT().add(hijo);

                if (hijo.getFitness() > mejor.getFitness()) {
                    mejor = hijo;

                }
            }
            //  System.out.println("\nG#" + g + " => ");
            salida += ("\nG#" + g + " => ");
            salida += mejor.tor2String();
         
            gens.add( mejor.torString());
                    d.actualizarGrafica(gens);

            d.setSalida(salida);
            
            this.pobActual = new PoblacionSAT(nueva, this.muestras);
           // System.out.println("Pmutaaaaaa:" + this.pMuta);
        }
        System.out.println();

    }

    /*   public static void main(String args[]) throws IOException {

        int Generaciones = 3000;
        double p_Muta = .50;
        int tamPob = 1000;
        int tam_Genotipo = 100;
//        DATOS DE ARCHIVO 3SAT
        int Max_Dist = 100;
        int NumMuestras = 550;
        int version = 2;

        GeneracionesSAT GS = new GeneracionesSAT(Generaciones, p_Muta, tamPob, tam_Genotipo, Max_Dist, NumMuestras, version);
                  
       
        GS.evolucionar();
        Grafica graf1 = new Grafica("Comportamiento (" + Generaciones + "," + p_Muta + "," + tamPob + "," + tam_Genotipo + "," + Max_Dist + ")", "Generación", "Fitness");
        graf1.crearSerie("Datos : (" + Generaciones + "," + p_Muta + "," + tamPob + "," + tam_Genotipo + "," + Max_Dist + ")", GS.getGens());
        graf1.mostrarGrafica();
    }*/
    @Override
    public void run() {
        try {
            evolucionar();
        } catch (IOException ex) {
            Logger.getLogger(GeneracionesSAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getMaxNum() {
        return MaxNum;
    }

    public void setMaxNum(int MaxNum) {
        this.MaxNum = MaxNum;
    }

    public int getNumMuestras() {
        return NumMuestras;
    }

    public void setNumMuestras(int NumMuestras) {
        this.NumMuestras = NumMuestras;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) throws IOException {
        this.version = version;
         this.muestras = Leer3SAT.tokenizarDataSet(this.MaxNum, this.NumMuestras, this.version);
    }

    public int getTamg() {
        return tamg;
    }

    public void setTamg(int tamg) {
        this.tamg = tamg;
    }
}
