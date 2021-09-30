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
public class Group9_TrafficLightControlSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TrafficLightControl control = new TrafficLightControl();
        AllTrafficLight tl=new AllTrafficLight(control);
        //Pedestrain p = new Pedestrain(control);
        tl.start();
        //p.start();
        
        
        
    }
    
}
