package client.service;

import javax.swing.*;

public class MessageBox {
    public void windowPop(String message){
        JOptionPane.showMessageDialog(null, message,"alert",JOptionPane.ERROR_MESSAGE);
    }
}
