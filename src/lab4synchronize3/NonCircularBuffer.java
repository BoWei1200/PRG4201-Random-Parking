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
public class NonCircularBuffer {
    private final int [] buffer = {0,0,0,0,0};
    private int item_in_buffer = 0;
    private int index_give = 0;
    private int index_take = 0;
    
    public synchronized void give (int giveValue) throws InterruptedException {
        while (item_in_buffer == buffer.length){
            System.out.println("            Buffer is full. Producer is blocked\n");
            wait();
        }
        
        buffer[index_give] = giveValue;
        //index_give++;
        index_give = (index_give+1) % buffer.length; // circular buffer
        item_in_buffer++;
        
        displayState("*Prodecer give " + giveValue);
        notify();
        
    }
    
    public synchronized int take () throws InterruptedException {
        while (item_in_buffer == 0){
            System.out.println("            Buffer is empty. Consumer is blocked\n");
            wait();
        }
        
        int getValue = buffer[index_take];
        //index_take++;
        index_take = (index_take+1) % buffer.length; //circular buffer
        item_in_buffer--;
        
        displayState("*Consumer take " + getValue);
        notify();
        return getValue;
    }
    
    public void displayState(String operation){
        System.out.printf("%s%s%d)\n", operation, "  (  space occupied : ", item_in_buffer, "buffer cells :");
        for (int value : buffer) {
            System.out.printf("  %2d  ", value);
        }
        System.out.println("");
        
        for (int i = 0; i < buffer.length; i++) {
            System.out.print("  __  ");
        }
        
        System.out.println("");
        
        for (int i = 0; i <= buffer.length; i++) {
            if(i == index_give && i == index_take)
                System.out.print("  PC");
            else if (i == index_give)
                System.out.print("  P   ");
            else if (i == index_take)
                System.out.print("  C   ");
            else 
                System.out.print("      ");
        }
        System.out.println("\n");
    }
}
