package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Group10
 * @version 1.0
 * Draw line chart Panel 
 */
public class LineChartPanel extends JPanel{
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	
    /**
      * Constructor to build the LineChart panel
      * @param chartTitle
      */
	public LineChartPanel(String chartTitle) {
		chart = ChartFactory.createLineChart(
				null,
				null,
				null,
				data,
				PlotOrientation.VERTICAL,
		        true,true,false);
		chart.setBackgroundPaint(Color.white);
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(-0.5, 1.5);
		chartPanel = new ChartPanel(chart);
		setLayout(new BorderLayout(1, 1));
		this.add(chartPanel);
	}
	
    /**
      * paintComponent override method
      * @param g
      */
	@Override
	public void paintComponent(Graphics g) {
		System.out.println(this.getWidth());
		super.paintComponent(g);
	}
	/**
      * addData method
      * @param value
      * @param labelLegend
      * @param labelX
      */
	public void addData(double value, String labelLegend, String labelX) {
		data.addValue(value, labelLegend, labelX);
	}
}
