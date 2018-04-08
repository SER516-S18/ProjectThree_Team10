package client.view;

import java.awt.*;
import javax.swing.*;

public class StatusPanel extends JPanel{
    Font f = new Font("Serif", Font.BOLD, 18);

	public StatusPanel(){
        setSize(new Dimension(400,100));
        setLayout( new FlowLayout(FlowLayout.LEFT, 20, 40));
        setBackground(Color.WHITE); 
        statusLight(0);
        statusInfo(0);
        timeInfo(88.88);
        
	}
	
	public void statusLight(int input) {
		JLabel light = new JLabel("111");
		light.setFont(f);
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
	    this.add(light);

	}
	
	public void statusInfo(int input) {
		JLabel status = new JLabel();
        status.setFont(f);
        if(input==0) {
        	status.setText("Status: DISCONNECTED");
        }
        else if(input==1) {
        	status.setText("Status: Waiting     ");
        }
        else if(input==2) {
        	status.setText("Status: CONNECTED   ");
        }
        this.add(status);
	}
	
	public void timeInfo(double time) {
		JLabel timeLabel = new JLabel("Time: "+ time);
		timeLabel.setFont(f);
		this.add(timeLabel);
	}
	
}
