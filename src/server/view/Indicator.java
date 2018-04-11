package server.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 */

public class Indicator extends JPanel {
	
	private static final long serialVersionUID = 1L;
    private Color displayColor, status, backgroundColor;

    /**
     * Initialize the Light on the panel.
     * @param error
     */
    Indicator(int error) {
        displayColor = getBackground();
        backgroundColor = getBackground();
        update(error);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            boolean hidden = false;
            @Override
            public void run() {
                if (hidden) {
                    setColor(status);
                } else {
                    setColor(backgroundColor);
                }
                hidden = !hidden;
            }
        }, 1000, 300);
    }

    /**
     * Paint indicator
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        if (g==null) return;
        Graphics2D ledIndicator = (Graphics2D) g;
        ledIndicator.setColor(displayColor);
        ledIndicator.fillOval(0, 0, 60, 60);
    }

    /**
     * set Color
     * @param color
     */
    private void setColor(Color color){
        displayColor = color;
        this.paint(this.getGraphics());
    }

    /**
     * Sets the color based on the error code
     * @param status
     */
    public void update(int status) {
        if (status == 0) {
            this.status=  Color.GREEN;
        } else {
            this.status = Color.RED;
        }
    }

}
