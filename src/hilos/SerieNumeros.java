/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author working
 */
public class SerieNumeros implements Runnable{
    
    private int c;
    private int limite;

    public SerieNumeros(int c, int limite) {
        this.c = c;
        this.limite = limite;
    }
    
    public void generarSerie(int limite){
    
        for(int x=0; x<limite;x++){
            System.out.println("x:"+x+"/"+x+this.c);
        }
    }

    /**
     * @return the c
     */
    public int getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(int c) {
        this.c = c;
    }

      
    
    @Override
    public void run() {
        generarSerie(this.getLimite());
    }

    /**
     * @return the limite
     */
    public int getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(int limite) {
        this.limite = limite;
    }
    
    
    
    
    
}
