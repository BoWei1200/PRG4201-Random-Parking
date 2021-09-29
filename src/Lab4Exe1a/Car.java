/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4Exe1a;


import java.util.Random;

public class Car extends Thread{
    private final static Random generator = new Random();
    private final CarPark Non_CB;
    
    public Car (CarPark Non_CB){
        this.Non_CB = Non_CB;
    }
    
    public void run(){
        int sum = 0;
        
        try{
            int parkIndex = Non_CB.park();
            
            int parkDuration = (int)(Math.random()*(20000-10000)) + 10000;
            Thread.sleep(parkDuration);
            Non_CB.leave(parkIndex);
            System.out.printf("\t\t\t\n");
        }catch(InterruptedException e){
            System.out.println(e.toString());
        }
    }
}