/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group9_trafficlightcontrolsystem;
import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author user
 */
public class TrafficLightModel extends Applet{
    
    public void paint(Graphics g){ //paint the Applet
        g.drawRect(1, 1, 70, 100);
        g.setColor(Color.black);
        g.fillRect(1, 1, 70, 200);
        
        for(int i=0;i<2;i++){
        
            delay();
            g.setColor(Color.red);
            g.fillOval(10,10,50,50);
            
            delay();
            g.setColor(Color.black);
            g.fillOval(10,10,50,50);
            
            delay();
            g.setColor(Color.yellow);
            g.fillOval(10,70,50,50);
            
            delay();
            g.setColor(Color.black);
            g.fillOval(10,70,50,50);
            
            delay();
            g.setColor(Color.green);
            g.fillOval(10,130,50,50);
            
            delay();
            g.setColor(Color.black);
            g.fillOval(10,130,50,50);
        }
        
    }
  
    public void delay(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    
    
}


