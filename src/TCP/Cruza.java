/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import Archivo.CrearArchivoMatriz;
import Archivo.LeerArchivoMatriz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class Cruza {

    ArrayList<IndividuoTCP> res = new ArrayList<>();

    public void Cruza() {
    }

    public static IndividuoTCP op_cruza(IndividuoTCP gen1, IndividuoTCP gen2, int[] mask, int[][] matriz) {
        IndividuoTCP ret = null ;
        boolean sigue = true;
        while (sigue) {
            int c1[] = new int[mask.length];
            int c2[] = new int[mask.length];

            for (int b = 0; b < mask.length; b++) {
                if (mask[b] == 1) {
                    c1[b] = gen1.getGenotipo()[b];
                    c2[b] = gen2.getGenotipo()[b];
                } else {
                    c1[b] = gen2.getGenotipo()[b];
                    c2[b] = gen1.getGenotipo()[b];

                }
            }
            IndividuoTCP aux = new IndividuoTCP(c1,matriz);
            IndividuoTCP aux2 = new IndividuoTCP(c2,matriz);
                System.out.println("aux");
                      aux.imprimirIndividuo();
                System.out.println("aux2");
                aux2.imprimirIndividuo();

            if (aux.validar() && aux2.validar()) {
                sigue = false;

                if (aux.getFitness() <= aux2.getFitness()) {
                    ret = new IndividuoTCP(aux);

                } else {
                    ret =  new IndividuoTCP(aux2);
                }

            } else {
                System.out.println("No jalo cambio de mask");
                Random ran = new Random();
                for (int x = 0; x < mask.length; x++) {
                    mask[x] = ran.nextInt(2);
                    if (x != mask.length - 1) {
                        System.out.print(mask[x] + ",");
                    } else {
                        System.out.println(mask[x]);

                    }
                }
                sigue = true;
            }
        }
        return ret;
    }

    public static void main(String args[]) throws IOException {
        int[] mask = {0, 1, 0, 1, 1};
        MatrizDist M  =new MatrizDist(5,5);
        CrearArchivoMatriz n = new  CrearArchivoMatriz (M.Matriz,M.Matriz.length, 5);
        LeerArchivoMatriz l = new  LeerArchivoMatriz ();

        MatrizDist t = l.tokenizarDataSet(5,5);
        IndividuoTCP it = new IndividuoTCP(5,t.Matriz);
        IndividuoTCP it2 = new IndividuoTCP(5,t.Matriz);

//         it.imprimirIndividuo();
        Cruza.op_cruza(it, it2, mask, t.Matriz).imprimirIndividuo();

    }
}
