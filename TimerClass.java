package com.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerClass {
	private static int counter;
	private static double z;
	public static void main(String[] args) {
		double x = 0.5;
		int y = (int) (x * 1000);
		z = x;
		Timer timer = new Timer();
		try {
			timer.scheduleAtFixedRate(new TimerTask(){ 
				public void run() {
					if(true) {
						System.out.println(z+"\t"+counter++);
						z += x;
					}
				} 
			}, new Date(), y);
		}
		catch(Exception e) {
			System.out.println("Exception!");
		}
	}

}
