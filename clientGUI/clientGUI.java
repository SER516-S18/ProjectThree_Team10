import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;


public class clientGUI extends JPanel{
    
   
    
  
    public clientGUI (){
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
        setBackground(Color.BLACK); 
    
        
    }
        
    
    
    
    
   
    public void main(String[] args){
        JFrame f=new JFrame();
        f.setSize(200,200);    
        f.setLayout(new BorderLayout()); 
        f.setVisible(true); 
        f.setBackground(Color.blue);
        clientGUI p = new clientGUI();
        f.add(p, BorderLayout.CENTER);
    }
    
    
    
    
    
}