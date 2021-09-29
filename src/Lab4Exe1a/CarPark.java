/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4Exe1a;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class CarPark {
    private final int [] carPark = {0,0,0,0,0,0,0};
    private ArrayList<String> availableCarPark = new ArrayList<String>();
    
    private int carAmount_in_carPark = 7; 
    private int parkIndex;
    private int leftIndex;
    
    public CarPark(){
        for (int i = 0; i < carPark.length; i++) {
            availableCarPark.add(Integer.toString(i));
            System.out.println();
        }
        
        for(String j : availableCarPark){
            System.out.println(j);
        }
    }
    
    public synchronized void leave (int leftIndex) throws InterruptedException { 
        availableCarPark.add(Integer.toString(leftIndex));
        carAmount_in_carPark++;
        this.leftIndex = leftIndex;
        carPark[leftIndex] = 0;
        displayState("*Consumer left " + leftIndex);
        notify();
    }
    
    public synchronized int park () throws InterruptedException {
        while (carAmount_in_carPark == 0){
            System.out.println("            Car park is full. Please wait for a while ..\n");
            wait();
        }
        
        //randomize taking available slot in array list
        int availableSlotIndexInArrayList = (int)(Math.random() * availableCarPark.size());
        System.out.println("Random slot : "+ availableCarPark.get(availableSlotIndexInArrayList));
        parkIndex = Integer.parseInt(availableCarPark.get(availableSlotIndexInArrayList));
        
        availableCarPark.remove(availableCarPark.get(availableSlotIndexInArrayList));
        
        carAmount_in_carPark--;
        carPark[parkIndex] = 1;
        
        displayState("*Consumer park in " + parkIndex);
        
        notify();
        return parkIndex;
    }
    
    public void displayState(String operation){
        System.out.println(operation);
        for (int value : carPark) {
            System.out.printf("  %2d  ", value);
        }
        System.out.println("");
        
        for (int i = 0; i < carPark.length; i++) {
            System.out.print("  __  ");
        }
        
        System.out.println("\n\n");
    }
}
