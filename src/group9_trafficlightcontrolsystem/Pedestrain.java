/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9_trafficlightcontrolsystem;

import java.util.Random;

/**
 *
 * @author user
 */
public class Pedestrain extends Thread{
    TrafficLightControl control = new TrafficLightControl();
    public final static Random generator = new Random();
    
    public Pedestrain(TrafficLightControl c){
        control=c;
        System.out.println("Pedestrain crossing button is PRESSED");
    }
    
    public void run(){
        try{
            Thread.sleep(generator.nextInt(6000));
            control.goPedestrain();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
