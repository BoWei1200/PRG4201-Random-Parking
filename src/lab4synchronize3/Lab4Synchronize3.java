/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4synchronize3;

/**
 *
 * @author asus
 */
public class Lab4Synchronize3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NonCircularBuffer myNonCB = new NonCircularBuffer();
        Producer myProd = new Producer(myNonCB);
        Consumer myCon = new Consumer (myNonCB);
        
        myProd.start();
        myCon.start();
    }
    
}
