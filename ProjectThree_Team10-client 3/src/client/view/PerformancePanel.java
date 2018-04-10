package client.view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import client.model.Parameters;

public class PerformancePanel extends JPanel{
	
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	
	public PerformancePanel(String chartTitle) {
		chart = ChartFactory.createLineChart(
				chartTitle,
				null,
				null,
				data,
				PlotOrientation.VERTICAL,
		        true,true,false);
		chartPanel = new ChartPanel(chart);
		setLayout(new BorderLayout(1, 1));
		this.add(chartPanel);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println(this.getWidth());
		//chartPanel.repaint();
		super.paintComponent(g);
	}
	
	public void addData(double value, String labelLegend, String labelX) {
		data.addValue(value, labelLegend, labelX);
	}
	
	public void add(Parameters param) {
		addData(param.getPerformance().getEngagement(),"engagement",Double.toString(param.getTime()));
		addData(param.getPerformance().getExcitement(),"excitment",Double.toString(param.getTime()));
		addData(param.getPerformance().getFocus(),"focus",Double.toString(param.getTime()));
		addData(param.getPerformance().getInterest(),"interest",Double.toString(param.getTime()));
		addData(param.getPerformance().getRelaxation(),"relaxation",Double.toString(param.getTime()));
		addData(param.getPerformance().getStress(),"stress",Double.toString(param.getTime()));
	}
}
