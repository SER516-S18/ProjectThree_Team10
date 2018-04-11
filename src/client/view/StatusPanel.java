package client.view;

import java.awt.*;
import javax.swing.*;

/**
 * This class is used to create a panel in Client to show the connection status and time information
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 */
public class StatusPanel extends JPanel{
	JLabel light;
	JLabel status;
	JLabel timeLabel;
	
	/**
     * Constructor for StatusPanel class
     */
	public StatusPanel(){
            setLayout(new FlowLayout());
            setBackground(Color.WHITE); 
            light = new JLabel("O");
            status = new JLabel();
            timeLabel = new JLabel();
            
            setStatus(0, 0);
            this.add(light);
            this.add(status);
            this.add(timeLabel);
	}
	
	/**
     * Method to set the color of Light Label
	 * @param input
     */
	public void statusLight(int input) {
	    light.setOpaque(true);
	    if(input==0) {
	    	light.setForeground(Color.RED);
	    	light.setBackground(Color.RED);
	    }
	    else if(input==1) {
	    	light.setForeground(Color.YELLOW);
	    	light.setBackground(Color.YELLOW);
	    }
	    else if(input==2){
	    	light.setForeground(Color.GREEN);
	    	light.setBackground(Color.GREEN);
	    }
	}
	
	/**
     * Method to set the content of Status Label
	 * @param input
     */
	public void statusInfo(int input) {
        if(input==0) {
        	status.setText("Status: DISCONNECTED");
        }
        else if(input==1) {
        	status.setText("Status: Waiting     ");
        }
        else if(input==2) {
        	status.setText("Status: CONNECTED   ");
        }
	}
	
	/**
     * Method to set the information of Time Label
	 * @param time
     */
	public void timeInfo(double time) {
		timeLabel.setText("Time: "+ time);
	}
	
	
	/**
     * Method to update the Light Label, Status Label, and Time Label
	 * @param status, time
     */
	public void setStatus(int status, double time) {
		statusLight(status);
		statusInfo(status);
		timeInfo(time);
	}
}
