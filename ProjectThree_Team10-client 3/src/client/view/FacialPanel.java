package client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
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
	private Graphics2D g2;
	
	private static final double DEFAULT_SCALE = 100.0;
	private static final int DEFAULT_FACE_COORD = 20;
	private static final int DEFAULT_FACE_SIZE = 60;
	
	private static final int LEFT_EYE_POSX = 40;
	private static final int RIGHT_EYE_POSX = 60;
	private static final int EYE_POSY = 40;
	private static final int EYE_WIDTH = 5;
	private static final int EYE_HEIGHT = 3;
	private static final int PUPIL_RADIUS = 2;
	
	private static final int EYEBROW_POSY = 33;
	private static final int EYEBROW_HEIGHT = 3;
	
	private static final int MOUTH_POSX = 50;
	private static final int MOUTH_POSY = 65;
	private static final int MOUTH_WIDTH = 10;
	private static final int MOUTH_HEIGHT = 6;
	
	private static final double MINDOUBLE = 0.000000001;
	
	public FacialPanel() {
		Eye eye = new Eye(false, true, true, false, true);
		LowerFace lowerFace = new LowerFace(1.0, 0.0, 0.0, 0.5, 0.5);
		UpperFace upperFace = new UpperFace(0.0, 1.0);
		MentalCmd mentalCmd = new MentalCmd(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		PerformanceMet performanceMet = new PerformanceMet(1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		double time = 1.0;
		param = new Parameters(eye, lowerFace, upperFace, mentalCmd, performanceMet, time);
	}
	
	public void setData(Parameters param) {
		this.param = param;
		this.repaint();
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
		super.paintComponent(graph);
		calc_scaleFactors(0,0,this.getHeight(),this.getWidth());
		
		drawFace(graph);
		g2 = (Graphics2D) graph;
		if (param!=null) {
			drawEye(graph, param.getEye());
			drawPupil(graph, param.getEye());
			drawEyebrow(graph, param.getUpperFace());
			drawMouth(graph, param.getLowerFace());
			//TODO: draw other components for logic test
		}
	}
	
	public void drawFace(Graphics g) {
		drawCircle(g, DEFAULT_FACE_COORD, DEFAULT_FACE_COORD,
				DEFAULT_FACE_SIZE, DEFAULT_FACE_SIZE);
	}
	
	public void drawEye(Graphics g, Eye eye) {
		if(eye.getBlink() == true){
			drawCurvedLine(g2, LEFT_EYE_POSX-EYE_WIDTH, EYE_POSY, LEFT_EYE_POSX, EYE_POSY+EYE_HEIGHT, LEFT_EYE_POSX+EYE_WIDTH, EYE_POSY);
			drawCurvedLine(g2, RIGHT_EYE_POSX-EYE_WIDTH, EYE_POSY, RIGHT_EYE_POSX, EYE_POSY+EYE_HEIGHT, RIGHT_EYE_POSX+EYE_WIDTH, EYE_POSY);
		}
		else {
			if(eye.getWinkLeft() == true){
				drawCircle(g, LEFT_EYE_POSX-EYE_WIDTH, EYE_POSY-EYE_HEIGHT, 2*EYE_WIDTH, 2*EYE_HEIGHT);			
			} else {
				drawCurvedLine(g2, LEFT_EYE_POSX-EYE_WIDTH, EYE_POSY, LEFT_EYE_POSX, EYE_POSY+EYE_HEIGHT, LEFT_EYE_POSX+EYE_WIDTH, EYE_POSY);
			}
			
			if(eye.getWinkRight() == true){
				drawCircle(g, RIGHT_EYE_POSX-EYE_WIDTH, EYE_POSY-EYE_HEIGHT, 2*EYE_WIDTH, 2*EYE_HEIGHT);
			} else {
				drawCurvedLine(g2, RIGHT_EYE_POSX-EYE_WIDTH, EYE_POSY, RIGHT_EYE_POSX, EYE_POSY+EYE_HEIGHT, RIGHT_EYE_POSX+EYE_WIDTH, EYE_POSY);
			}
		}
	}
	
	public void drawPupil(Graphics g, Eye eye) {
		if(eye.getBlink() != true){
			if(eye.getWinkLeft() == true){
				if (eye.getLookLeft()==true) {
					drawCircle(g, LEFT_EYE_POSX-PUPIL_RADIUS-PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				} else if (eye.getLookRight()==true) {
					drawCircle(g, LEFT_EYE_POSX-PUPIL_RADIUS+PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				} else {
					drawCircle(g, LEFT_EYE_POSX-PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				}
			}
			if(eye.getWinkRight() == true){
				if (eye.getLookLeft()==true) {
					drawCircle(g, RIGHT_EYE_POSX-PUPIL_RADIUS-PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				} else if (eye.getLookRight()==true) {
					drawCircle(g, RIGHT_EYE_POSX-PUPIL_RADIUS+PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				} else {
					drawCircle(g, RIGHT_EYE_POSX-PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				}
			}
		}
	}
	
	public void drawEyebrow(Graphics g, UpperFace upperFace) {
		if (upperFace.getFurrowBrow() > upperFace.getRaiseBrow()) {
			int bias = Math.min(EYEBROW_HEIGHT, (int)(1+EYEBROW_HEIGHT*upperFace.getFurrowBrow()));
			drawCurvedLine(g2, LEFT_EYE_POSX-EYE_WIDTH, EYEBROW_POSY, LEFT_EYE_POSX, EYEBROW_POSY+bias, LEFT_EYE_POSX+EYE_WIDTH, EYEBROW_POSY);
			drawCurvedLine(g2, RIGHT_EYE_POSX-EYE_WIDTH, EYEBROW_POSY, RIGHT_EYE_POSX, EYEBROW_POSY+bias, RIGHT_EYE_POSX+EYE_WIDTH, EYEBROW_POSY);
		} else {
			int bias = Math.min(EYEBROW_HEIGHT, (int)(1+EYEBROW_HEIGHT*upperFace.getRaiseBrow()));
			drawCurvedLine(g2, LEFT_EYE_POSX-EYE_WIDTH, EYEBROW_POSY, LEFT_EYE_POSX, EYEBROW_POSY-bias, LEFT_EYE_POSX+EYE_WIDTH, EYEBROW_POSY);
			drawCurvedLine(g2, RIGHT_EYE_POSX-EYE_WIDTH, EYEBROW_POSY, RIGHT_EYE_POSX, EYEBROW_POSY-bias, RIGHT_EYE_POSX+EYE_WIDTH, EYEBROW_POSY);
		}
	}
	
	public void drawMouth(Graphics g, LowerFace lowerFace) {
		int bias = 0, smirk = 0;
		if (lowerFace.getSmile()>MINDOUBLE) {
			bias = Math.min(MOUTH_HEIGHT, (int)(1+MOUTH_HEIGHT*lowerFace.getSmile()));
		} else if (lowerFace.getClench()>MINDOUBLE) {
			bias = -Math.min(MOUTH_HEIGHT, (int)(1+MOUTH_HEIGHT*lowerFace.getClench()));
		}
		
		if (lowerFace.getSmirkLeft()>MINDOUBLE) {
			smirk = -Math.min(MOUTH_HEIGHT, (int)(MOUTH_HEIGHT*lowerFace.getSmirkLeft()));
		} else if (lowerFace.getSmirkRight()>MINDOUBLE) {
			smirk = Math.min(MOUTH_HEIGHT, (int)(MOUTH_HEIGHT*lowerFace.getSmirkRight()));
		}
		
		drawCurvedLine(g2, MOUTH_POSX-MOUTH_WIDTH, MOUTH_POSY+smirk, MOUTH_POSX, MOUTH_POSY+bias,MOUTH_POSX+MOUTH_WIDTH, MOUTH_POSY-smirk);
		if (lowerFace.getLaugh()>MINDOUBLE) {
			drawCurvedLine(g2, MOUTH_POSX-MOUTH_WIDTH, MOUTH_POSY+smirk, MOUTH_POSX, MOUTH_POSY+2*bias,MOUTH_POSX+MOUTH_WIDTH, MOUTH_POSY-smirk);
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
	
	public void drawCurvedLine(Graphics2D g2, int x1, int y1, int x2, int y2, int x3, int y3) {
		
		QuadCurve2D q = new QuadCurve2D.Float();
		q.setCurve(scale_x(x1), scale_y(y1), scale_x(x2), scale_y(y2), scale_x(x3), scale_y(y3));
		g2.draw(q);
	}
}