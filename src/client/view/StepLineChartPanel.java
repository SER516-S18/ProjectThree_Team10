package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryStepRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * The step line chart panel to display the step line chart
 * @author Group10
 * @version 1.0
 */
public class StepLineChartPanel extends JPanel{
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private DefaultCategoryDataset dataset;
	private String title;
	
	/**
	 * Constructor to initialize the step line chart
	 * @param chartTitle
	 */
	public StepLineChartPanel(String chartTitle) {
		title = chartTitle;
		CategoryAxis domainAxis = new CategoryAxis();
        ValueAxis rangeAxis = new NumberAxis();
		dataset = new DefaultCategoryDataset();

		CategoryItemRenderer renderer = new CategoryStepRenderer(true);
		CategoryPlot plot = new CategoryPlot(dataset, domainAxis, rangeAxis, renderer);
		plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
		plot.setBackgroundPaint(Color.lightGray);
		
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(-0.5, 1.5);
		
		chart = new JFreeChart(null,
				plot
				);
        chart.setBackgroundPaint(Color.white);
		chartPanel = new ChartPanel(chart);

		setLayout(new BorderLayout(1, 1));
		this.add(chartPanel);
	}
	
	/**
	 * Override paintComponent and repaint chart panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		chartPanel.repaint();
		super.paintComponent(g);
	}
	
	/**
	 * Add data to the chart
	 * @param value
	 * @param time
	 */
	public void addData(boolean value, double time) {
		if (value) {
			dataset.addValue(1, title, Double.toString(time));
		} else {
			dataset.addValue(0, title, Double.toString(time));
		}
	}
}
