package server;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * Author: Shubham Vyas
 * Description: Display time dynamically for server based on frequency selected.
 */

public class TimerClass {
	private static int counter;
	private static double z;
	public static JLabel timeLabel = new JLabel();
	public static String labelText;
	
	public static void timer(double frequency, JPanel time) {
		
		int y = (int) (frequency * 1000);
		z = frequency;
		Timer timer = new Timer();
		try {
			timer.scheduleAtFixedRate(new TimerTask(){ 
				public void run() {
					if(true) {
						//System.out.println(z+"\t"+counter++);
						labelText = String.valueOf(z);
						timeLabel.setText(labelText);
						time.add(timeLabel);
						z += frequency;
						
					}
				} 
			}, new Date(), y);
		}
		catch(Exception e) {
			System.out.println("Exception!");
		}
	}

}
