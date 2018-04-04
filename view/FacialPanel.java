package client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import client.model.Eye;
import client.model.LowerFace;
import client.model.MentalCmd;
import client.model.Parameters;
import client.model.PerformanceMet;
import client.model.UpperFace;

public class FacialPanel extends JPanel{
	private double x_factor, y_factor;
	private int x_origin, y_origin;
	private Parameters param;
	
	private static final double DEFAULT_SCALE = 100.0;
	private static final int DEFAULT_FACE_COORD = 20;
	private static final int DEFAULT_FACE_SIZE = 60;
	private static final int eye_radiusval = 5;
	private static final int eye_left_xpos = 40;
	private static final int eye_right_xpos = 60;
	private static final int eye_ypos = 40;
	private static final int pupil_size = 2;
	private static final int eyebrow_left_left_x = 35;
	private static final int eyebrow_left_right_x = 45;
	private static final int eyebrow_right_left_x = 55;
	private static final int eyebrow_right_right_x = 65;
	private static final int eyebrow_y = 30;
	private static final int mouth_ypos = 65;
	private static final int nose_apex_x = 50;
	private static final int nose_apex_y = 45;
	private static final int nose_ypos = 54;
	private static final int nose_width = 8;
	
	public FacialPanel() {
		Eye eye = new Eye(true, true, true, true, true);
		LowerFace lowerFace = new LowerFace(1.0, 1.0, 1.0, 1.0, 1.0);
		UpperFace upperFace = new UpperFace(1.0, 1.0);
		MentalCmd mentalCmd = new MentalCmd(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		PerformanceMet performanceMet = new PerformanceMet(1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		double time = 1.0;
		param = new Parameters(eye, lowerFace, upperFace, mentalCmd, performanceMet, time);
	}
	
	public void setData(Parameters param) {
		this.param = param;
		//this.repaint();
	}
	
	public void calc_scaleFactors(int x, int y, int height, int width){
		x_factor = width / DEFAULT_SCALE;
		y_factor = height / DEFAULT_SCALE;
		x_origin = x;
		y_origin = y;
	}
	
	public int scale_x(int x) {
		return (int)(x * x_factor);
	}
	
	public int scale_y(int y) {
		return (int)(y * y_factor);
	}
	
	@Override
	protected void paintComponent(Graphics graph) {
		calc_scaleFactors(0,0,this.getHeight(),this.getWidth());
		
		drawFace(graph);
		if (param!=null) {
			drawEye(graph, param.getEye());
			//TODO: draw other components for logic test
		}
	}
	
	public void drawFace(Graphics g) {
		drawCircle(g, DEFAULT_FACE_COORD, DEFAULT_FACE_COORD,
				DEFAULT_FACE_SIZE, DEFAULT_FACE_SIZE);
	}
	
	public void drawEye(Graphics g, Eye eye) {
		if(eye.getBlink() == true){
			drawLine(g, eye_left_xpos + eye_radiusval, eye_ypos, eye_left_xpos - eye_radiusval, eye_ypos);
			drawLine(g, eye_right_xpos - eye_radiusval, eye_ypos, eye_right_xpos + eye_radiusval, eye_ypos);
		}
		else if(eye.getWinkLeft() == true){
			
			drawCircle(g, eye_left_xpos, eye_ypos, eye_radiusval, eye_radiusval);
			drawLine(g, eye_right_xpos - eye_radiusval, eye_ypos, eye_right_xpos + eye_radiusval, eye_ypos);
		}
		else if(eye.getWinkRight() == true){
			drawLine(g, eye_left_xpos + eye_radiusval, eye_ypos, eye_left_xpos - eye_radiusval, eye_ypos);
			drawCircle(g, eye_right_xpos, eye_ypos, eye_radiusval, eye_radiusval);
		}
		else{
			drawCircle(g, eye_left_xpos, eye_ypos, eye_radiusval, eye_radiusval);
			drawCircle(g, eye_right_xpos, eye_ypos, eye_radiusval, eye_radiusval);
		}
	}
	
	public void drawCircle(Graphics g, int x, int y, int width, int height) {
		g.drawOval(scale_x(x) + x_origin, scale_y(y) + y_origin,
		           scale_x(width), scale_y(height));
	}

	public void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		g.drawLine(scale_x(x1) + x_origin, scale_y(y1) + x_origin,
				scale_x(x2) + x_origin, scale_y(y2) + x_origin);
	}
}