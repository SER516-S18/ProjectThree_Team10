package client.view;

import java.awt.*;
import javax.swing.*;

public class StatusPanel extends JPanel{
    Font f = new Font("Serif", Font.BOLD, 18);
	JLabel light;
	JLabel status;
	JLabel timeLabel;

	public StatusPanel(){
        setLayout( new FlowLayout(FlowLayout.LEFT, 20, 40));
        setBackground(Color.WHITE); 
        light = new JLabel();
        status = new JLabel();
        timeLabel = new JLabel();
        statusLight(0);
        statusInfo(0);
        timeInfo(0.0);

		light.setFont(f);
        status.setFont(f);
		timeLabel.setFont(f);
	    this.add(light);
        this.add(status);
		this.add(timeLabel);
	}
	
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
	
	public void timeInfo(double time) {
		timeLabel.setText("Time: "+ time);
	}
	
	public void setStatus(int status, double time) {
		statusLight(status);
		statusInfo(status);
		timeInfo(time);
	}
}
