/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import javax.swing.JProgressBar;

/**
 *
 * @author Karito
 */
public class Cargar2 extends Thread {

    JProgressBar progreso;
    
    public Cargar2 (JProgressBar prog){
        super();
        progreso=prog;
        
    }
        
    @Override
    public void run(){
        
        for(int i=1;i<=100;i++){
            progreso.setValue(i);
            pausa(210);
        }
    }
    
    public void pausa(int mlSeg){
        
        try{
            Thread.sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }   
}
