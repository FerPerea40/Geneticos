/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import Archivo.CrearArchivo;
import Archivo.CrearArchivoMatriz;
import Archivo.LeerArchivoMatriz;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Generaciones {

    private int num_G;
    private double pMuta;
    private PoblacionTCP pobActual;
    private int tamPob;
    private int tamt;
    double gens[];
    int[][] matriz;
    int[][] matrizi;
    public double[] getGens() {
        return gens;
    }

    public void setGens(double[] gens) {
        this.gens = gens;
    }

    public Generaciones(int num_G, double pMuta, int tamPob, int tamg, int Mdist) throws IOException {
        this.num_G = num_G;
        this.pMuta = pMuta;
        this.tamPob = tamPob;
        CrearArchivoMatriz md = new CrearArchivoMatriz(new MatrizDist(tamg,Mdist).Matriz,tamg,Mdist);
        CrearArchivoMatriz md1 = new CrearArchivoMatriz(new MatrizInclinacion(tamg,Mdist).Matriz,tamg,Mdist,1);
        
        
        this.matriz = LeerArchivoMatriz.tokenizarDataSet4(tamg,Mdist);
        this.matrizi = LeerArchivoMatriz.tokenizarDataSet5(tamg,Mdist);
        MatrizDist red = new MatrizDist(this.matriz,Mdist);
        MatrizInclinacion incli = new MatrizInclinacion(this.matrizi,Mdist);
        red.imprimirMat();
                incli.imprimirMat();

        CrearArchivo c = new CrearArchivo(new PoblacionTCP(tamPob, tamg,this.matriz,this.matrizi).getPoblacion(), num_G, pMuta, tamPob, tamg,this.matriz,this.matrizi);
       this.pobActual = new PoblacionTCP(Archivo.LeerArchivo.tokenizarDataSet2(num_G, pMuta, tamPob, tamg,this.matriz,this.matrizi),this.matriz,this.matrizi);
       this.pobActual.mostrarPob();
        this.tamt = tamg;
    }

    public void evolucionar() {
        int mascara[] = new int[tamt];
        Random ran = new Random();
        for (int x = 0; x < tamt; x++) {
            mascara[x] = ran.nextInt(2);
        }
        IndividuoTCP mejor;
        gens = new double[num_G];
        for (int g = 0; g < this.num_G; g++) {
            PoblacionTCP nueva = new PoblacionTCP();
            mejor = Seleccion.seleccionAleatoria(this.pobActual,this.matriz,this.matrizi);
            for (int i = 0; i < this.tamPob; i++) {
                IndividuoTCP madre = Seleccion.seleccionAleatoria(this.pobActual,this.matriz,this.matrizi);
                IndividuoTCP padre = Seleccion.seleccionAleatoria(this.pobActual,this.matriz,this.matrizi);
                IndividuoTCP hijo = Cruza.op_cruza(madre, padre, mascara,this.matriz,this.matrizi);

                if (Math.random() < this.pMuta) {
                    Muta.aplicarMutaAleatoria(hijo);
                }
                   nueva.getPoblacion().add(hijo);
                if (hijo.getFitness() <= mejor.getFitness()) {
                    mejor = new IndividuoTCP(hijo.getGenotipo(),this.matriz,this.matrizi);
                }
            }
            System.out.println("Generación #" + g + " ===> " + mejor.toString());
           
            gens[g] = mejor.getFitness();
            this.pobActual = new PoblacionTCP(nueva,this.matriz,this.matrizi);
           
            //CrearArchivo c = new CrearArchivo(this.pobActual.getPoblacion(), num_G, pMuta, tamPob, tamt,this.matriz,this.matrizi);

        }

    }

}
