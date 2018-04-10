package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartPanel extends JPanel{
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	
	public LineChartPanel(String chartTitle) {
		chart = ChartFactory.createLineChart(
				chartTitle,
				null,
				null,
				data,
				PlotOrientation.VERTICAL,
		        true,true,false);
		chart.setBackgroundPaint(Color.white);
		chartPanel = new ChartPanel(chart);
		setLayout(new BorderLayout(1, 1));
		this.add(chartPanel);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println(this.getWidth());
		super.paintComponent(g);
	}
	
	public void addData(double value, String labelLegend, String labelX) {
		data.addValue(value, labelLegend, labelX);
	}
}
