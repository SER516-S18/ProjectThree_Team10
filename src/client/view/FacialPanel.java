package client.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JPanel;

import client.model.Eye;
import client.model.LowerFace;
import client.model.Parameters;
import client.model.PerformanceMet;
import client.model.UpperFace;

/**
 * @author Group10
 * @version 1.0
 * This is the panel to display the facial expression
 */
public class FacialPanel extends JPanel{
	
    //x_factor, y_factor is the scale of the real time size/default size
	private double x_factor, y_factor;
	//x_origin and y_origin are the default of xy coordinate
	private int x_origin, y_origin;
	private Parameters param;
	private Graphics2D g2;
	
	// default position on a 100*100 graph
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

    /**
	 * constructor to display an initial face
	 */
	public FacialPanel() {
		Eye eye = new Eye(false, false, false, false, false);
		LowerFace lowerFace = new LowerFace(0.0, 0.0, 0.0, 0.0, 0.0);
		UpperFace upperFace = new UpperFace(0.0, 0.0);
		PerformanceMet performanceMet = new PerformanceMet(1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		double time = 1.0;
		param = new Parameters(eye, lowerFace, upperFace, performanceMet, time);
	}
    
	/**
	 * update the parameter of the current face
	 * @param param
	 */
	public void setData(Parameters param) {
		this.param = param;
		this.repaint();
	}
	
	/**
	 * use real time size / default size to calculate the scale
	 * @param x
     * @param y
     * @param height
     * @param width
	 */
	public void calc_scaleFactors(int x, int y, int height, int width){
		x_factor = width / DEFAULT_SCALE;
		y_factor = height / DEFAULT_SCALE;
		x_origin = x;
		y_origin = y;
	}
	
	/**
	 * use x in default * xscale to calculate real time x
	 * @param x
	 */
	public int scale_x(int x) {
		return (int)(x * x_factor);
	}
	
	/**
	 * use y in default * yscale to calculate real time y
	 * @param y
	 */
	public int scale_y(int y) {
		return (int)(y * y_factor);
	}
	
	/**
	 * Inherited function to paint the graph
	 * @param graph
	 */
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
		}
	}
	
	/**
	 * Draw the figure of a face
	 * @param g Graphics
	 */
	public void drawFace(Graphics g) {
		drawCircle(g, DEFAULT_FACE_COORD, DEFAULT_FACE_COORD,
				DEFAULT_FACE_SIZE, DEFAULT_FACE_SIZE);
	}
	
	/**
	 * Function to calculate and draw the eye
	 * @param g Graphics
	 * @param eye Eye
	 */
	public void drawEye(Graphics g, Eye eye) {
		if(eye.getBlink() == true){
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
		else {
			if (!eye.getWinkLeft()&&!eye.getWinkRight()) {
				drawCircle(g, LEFT_EYE_POSX-EYE_WIDTH, EYE_POSY-EYE_HEIGHT, 2*EYE_WIDTH, 2*EYE_HEIGHT);			
				drawCircle(g, RIGHT_EYE_POSX-EYE_WIDTH, EYE_POSY-EYE_HEIGHT, 2*EYE_WIDTH, 2*EYE_HEIGHT);
				return;
			}
			
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
	
	/**
	 * Function to calculate and draw the pupil of the face
	 * @param g Graphics
	 * @param eye Eye
	 */
	public void drawPupil(Graphics g, Eye eye) {
		if(eye.getBlink() == false){
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
			
			if (!eye.getWinkLeft()&&!eye.getWinkRight()) {
				if (eye.getLookLeft()==true) {
					drawCircle(g, LEFT_EYE_POSX-PUPIL_RADIUS-PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				} else if (eye.getLookRight()==true) {
					drawCircle(g, LEFT_EYE_POSX-PUPIL_RADIUS+PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				} else {
					drawCircle(g, LEFT_EYE_POSX-PUPIL_RADIUS, EYE_POSY-PUPIL_RADIUS, 2*PUPIL_RADIUS, 2*PUPIL_RADIUS);
				}
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
	
	/**
	 * Function to calculate and draw eyebrow
	 * @param g Graphics
	 * @param upperFace UpperFace
	 */
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
	
	/**
	 * Function to calculate and draw mouth
	 * @param g Graphics
	 * @param lowerFace LowerFace
	 */
	public void drawMouth(Graphics g, LowerFace lowerFace) {
		int bias = 0, smirk = 0;
		if (lowerFace.getLaugh()>MINDOUBLE) {
			bias = Math.min(MOUTH_HEIGHT, (int)(1+MOUTH_HEIGHT*lowerFace.getLaugh()));
			if (lowerFace.getSmirkLeft()>MINDOUBLE) {
				smirk = -Math.min(MOUTH_HEIGHT, (int)(MOUTH_HEIGHT*lowerFace.getSmirkLeft()));
			} else if (lowerFace.getSmirkRight()>MINDOUBLE) {
				smirk = Math.min(MOUTH_HEIGHT, (int)(MOUTH_HEIGHT*lowerFace.getSmirkRight()));
			}
			drawCurvedLine(g2, MOUTH_POSX-MOUTH_WIDTH, MOUTH_POSY+smirk, MOUTH_POSX, MOUTH_POSY+bias,MOUTH_POSX+MOUTH_WIDTH, MOUTH_POSY-smirk);
			drawCurvedLine(g2, MOUTH_POSX-MOUTH_WIDTH, MOUTH_POSY+smirk, MOUTH_POSX, 1+MOUTH_POSY+2*bias,MOUTH_POSX+MOUTH_WIDTH, MOUTH_POSY-smirk);
			return;
		}
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
	}
	
	/**
	 * Function to draw a sphere or circle
	 * @param g Graphics
	 * @param x 
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawCircle(Graphics g, int x, int y, int width, int height) {
		g.drawOval(scale_x(x) + x_origin, scale_y(y) + y_origin,
		           scale_x(width), scale_y(height));
	}
	
	/**
	 * Function to draw a line
	 * @param g Graphics
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
		g.drawLine(scale_x(x1) + x_origin, scale_y(y1) + x_origin,
				scale_x(x2) + x_origin, scale_y(y2) + x_origin);
	}
	
	/**
	 * Function to draw a curved line
	 * @param g2 Graphics2D
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 */
	public void drawCurvedLine(Graphics2D g2, int x1, int y1, int x2, int y2, int x3, int y3) {
		QuadCurve2D q = new QuadCurve2D.Float();
		q.setCurve(scale_x(x1), scale_y(y1), scale_x(x2), scale_y(y2), scale_x(x3), scale_y(y3));
		g2.draw(q);
	}
}