/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9_trafficlightcontrolsystem;

/**
 *
 * @author user
 */
public class AllTrafficLight extends Thread{
    
    TrafficLightControl control = new TrafficLightControl();
    
    public AllTrafficLight(TrafficLightControl c){
        control=c;
    }
    
    public void run(){
        
        try{
            control.goNorth();
            control.goSouth();
            control.goWest();
            control.goEast();
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
    
    
}
