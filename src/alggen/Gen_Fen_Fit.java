/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alggen;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Gen_Fen_Fit {
    int genotipo[];
    int fenotipo;
    double fit;
    
       public Gen_Fen_Fit(){
    
    }
    public Gen_Fen_Fit(int[] gen){
      genotipo = gen;
      fenotipo = bin_dec(gen);
      fit = cal_fit(fenotipo);
    }
    
    public static int bin_dec(int[] gen){
     
        int n_bits = gen.length;
        int total=0;
        
        for(int i=0;i<n_bits;i++){
            total+=  Math.pow(2,i)*gen[i];
        System.out.println("haha = "+ total);
        
        }
    return total;
    
    }
    public static double cal_fit(int fen){
    
   return Math.sin(fen);
    }

    public int[] getGenotipo() {
        return genotipo;
    }

    public void setGenotipo(int[] genotipo) {
        this.genotipo = genotipo;
    }

    public int getFenotipo() {
        return fenotipo;
    }

    public void setFenotipo(int fenotipo) {
        this.fenotipo = fenotipo;
    }

    public double getFit() {
        return fit;
    }

    public void setFit(double fit) {
        this.fit = fit;
    }
  
  
    
    public static void main(String args[]){
        int[] bin = {1,1,1,0};
       Gen_Fen_Fit gff = new Gen_Fen_Fit(bin);
      // System.out.print(gff.genotipo);
       System.out.println(gff.fenotipo);
       System.out.println(gff.fit);
       
       Gen_Fen_Fit gen1 = new Gen_Fen_Fit(new int[]{1,1,1,0,1,0,0,1,0,0,0});
       Gen_Fen_Fit gen2 = new Gen_Fen_Fit(new int[]{0,0,0,0,1,0,1,0,1,0,1});
       
 ArrayList<Gen_Fen_Fit>  res = new ArrayList<>();
 res.add(gen2);
 res.add(gen1);
 
       Cruza c = new Cruza();
       int [] mask = new int[]{1,0,0,1,1,0,1,0,0,1,1};
       
       c.op_cruza(res, mask);
       System.out.print("gg");
    }       
}
