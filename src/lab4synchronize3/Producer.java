/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4synchronize3;

import java.util.Random;

/**
 *
 * @author asus
 */
public class Producer extends Thread{
    private final static Random generator = new Random();
    private final NonCircularBuffer Non_CB;
    
    public Producer (NonCircularBuffer Non_CB){
        this.Non_CB = Non_CB;
    }
    
    public void run(){
        int sum = 0;
        for (int count = 1; count <= 10; count++) {
            try{
                Thread.sleep(generator.nextInt(3000));
                
                Non_CB.give(count);
                sum += count;
            }catch(InterruptedException e){
                System.out.println(e.toString());
            }
        }
        System.out.println("Producer done producing " + sum + " ... Terminating Producer..");
    }
    
    
}
