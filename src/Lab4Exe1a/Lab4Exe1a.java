/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4Exe1a;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class Lab4Exe1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarPark carPark = new CarPark();
        
        Car car[] = new Car[20];
        for (int count = 0; count < car.length; count++) {
            car[count] = new Car (carPark);
            car[count].start();
            try {
                Thread.sleep(1000);
                System.out.println("Hiiiiiiiiiiiiiiiii");
            } catch (InterruptedException ex) {
                Logger.getLogger(Lab4Exe1a.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
