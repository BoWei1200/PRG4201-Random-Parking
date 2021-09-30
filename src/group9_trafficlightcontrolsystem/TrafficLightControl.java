/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9_trafficlightcontrolsystem;

import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author user
 */
public class TrafficLightControl
{
    Timer timer = new Timer();
    private String occupied="N";
    
    public TrafficLightControl(){
        
    }
    
    public synchronized void goNorth() throws InterruptedException{
        
        while(occupied.compareTo("N")!=0){
           wait();
        }
        System.out.println("North Traffic Light is GREEN");
        Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask(){
                int i =5;
                @Override
                public void run() {
                     System.out.println("Time left: " + i);
                        i--;
                        if (i < 0) {
                            timer.cancel();
                            System.out.println("Time Over");
                        }
                   //1000*5=5000 mlsec. i.e. 5 seconds. u can change accordngly 
                }
            },0,1000); //delay,period
        //if(occupied.compareTo("S")==0)
        notify();
    }
    
    public synchronized void goSouth()throws InterruptedException{
        while(occupied.compareTo("S")!=0){
            System.out.println("South waiting...");
            wait();
        }
        System.out.println("South Traffic Light is GREEN");
        notify();
    }
    
    public synchronized void goWest()throws InterruptedException{
        while(occupied.compareTo("W")!=0){
             System.out.println("West waiting...");
            wait();
        }
        System.out.println("West Traffic Light is GREEN");
        notify();
    }
    
    public synchronized void goEast()throws InterruptedException{
        while(occupied.compareTo("E")!=0){
             System.out.println("East waiting...");
            wait();
        }
        System.out.println("East Traffic Light is GREEN");
        notify();
    }
    
    public synchronized void goPedestrain()throws InterruptedException{
        while(occupied.compareTo("P")!=0){
            System.out.println("Pedestrain waiting...");
            wait();
        }
        System.out.println("Pedestrain Crossing is ON");
        notify();
    }
    
    
    
    
}
