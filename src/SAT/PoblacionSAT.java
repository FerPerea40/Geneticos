/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAT;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class PoblacionSAT {

    private LinkedList<IndividuoSAT> poblacion;
    private int i;
    private int tam;
    private LinkedList<int[]> muestras;

    public LinkedList<int[]> getMuestras() {
        return muestras;
    }

    public void setMuestras(LinkedList<int[]> muestras) {
        this.muestras = muestras;
    }

    public PoblacionSAT(int i, int tam, LinkedList<int[]> m) {
        this.i = i;
        this.tam = tam;
        this.poblacion = new LinkedList<>();
        this.muestras = m;
        inicializarAleatorimente();
    }

    public PoblacionSAT(LinkedList<IndividuoSAT> muestra, int i, LinkedList<int[]> m) {
        this.poblacion = new LinkedList<>();
        this.muestras = m;
        for (int x = 0; x < muestra.size(); x++) {
            this.poblacion.add(new IndividuoSAT(muestra.get(x).getGenotipo(), this.muestras));
        }
    }

    public PoblacionSAT() {
        this.poblacion = new LinkedList<>();

    }

    public PoblacionSAT(PoblacionSAT n, LinkedList<int[]> m) {
        this.poblacion = new LinkedList<>();
        this.muestras = m;

        for (IndividuoSAT aux : n.getPoblacionSAT()) {
            this.poblacion.add(new IndividuoSAT(aux.getGenotipo(), this.muestras));

        }

    }

    public void inicializarAleatorimente() {

        for (int x = 0; x < this.i; x++) {
            this.poblacion.add(new IndividuoSAT(this.tam, this.muestras));

        }

    }

    public LinkedList<IndividuoSAT> generarMuestraAleatoria(double p) {
        int c = (int) ((this.i * p) / 100);
        LinkedList<IndividuoSAT> muestra = new LinkedList<>();
        int pa = 0;
        Random ran = new Random();
        for (int x = 0; x < c; x++) {
            pa = ran.nextInt(this.i);
            muestra.add(this.poblacion.get(pa));

        }
        return muestra;
    }

    public LinkedList<IndividuoSAT> getPoblacionSAT() {

        return poblacion;
    }
}
