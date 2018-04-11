package client.service;

import javax.swing.*;

/**
 * @author Group10
 * @version 1.0
 * MessageBox class 
 */
public class MessageBox {
     
     /**
      * windowPop Method 
      * @param message
      */
    public void windowPop(String message){
        JOptionPane.showMessageDialog(null, message,"alert",JOptionPane.ERROR_MESSAGE);
    }
}
