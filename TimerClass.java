import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimerClass{
	private boolean isAutoReset = false;
	private Timer timer;
	private double timeCounter = (double) 0.0;
	private static TimerClass timerObject = null;
	
	protected TimerClass() {}

	public static TimerClass getInstance() {
		if (timerObject == null) {
			timerObject = new TimerClass();
		}
		return timerObject;
	}

	/**
	 * Timer Start
	 * 
	 * @param delay - delay between two messages
	 */
	public void startTimer(double delay) {
		timer = new Timer((int) Math.round(delay * 1000), new ActionListener() {
			public void actionPerformed( ActionEvent event )  {
				//TO-DO - send message to client
				updateTimer(delay);
				ServerGUI.getTime().setText(getTimer() + "");
			}
		});
		timer.setRepeats(this.isAutoReset);
		timer.start();
	}
	
	/**
	 * Timer Stop
	 */
	public void stopTimer() {
		timer.stop();
	}

	/**
	 * Check for Auto-Reset
	 */
	public void setAutoReset(boolean autoRepeated) {
		this.isAutoReset = autoRepeated;
	}
	
	void updateTimer(double delay) {
		timeCounter += delay; 
	}
	
	double getTimer() {
		return timeCounter;
	}
	
	public void setTimer(double time) {
		timeCounter = time;
	}
}
