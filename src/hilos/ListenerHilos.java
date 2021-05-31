/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author working
 */
public class ListenerHilos implements ActionListener{

    private HiloJFrame frame;
    private SerieNumeros serie;

    public ListenerHilos(HiloJFrame frame, SerieNumeros serie) {
        this.frame = frame;
        this.serie = serie;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        int c = Integer.parseInt(frame.getjTextFieldC().getText());
        int limite = Integer.parseInt(frame.getjTextFieldLimite().getText());
        // modificar los valores de la serie en su hilo independiente
        serie.setC(c);
       // serie.setLimite(limite);
    }
    
}
