package client.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class StepLineChartPanel extends JPanel{
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private XYDataset data;
	private XYSeries ydata;
	
	public StepLineChartPanel(String chartTitle) {
		ydata = new XYSeries(chartTitle, false, true);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(ydata);
		data = dataset;
		chart = ChartFactory.createXYStepChart(
				chartTitle,
				null,
				null,
				data,
				PlotOrientation.VERTICAL,
                true,   // legend
                true,   // tooltips
                false   // urls
                );
        
		chartPanel = new ChartPanel(chart);

		//XYPlot plot = chart.getXYPlot();
		//plot.getRenderer().setSeriesStroke(0, new BasicStroke(2.0f));
        //plot.getRenderer().setSeriesStroke(1, new BasicStroke(2.0f));
		setLayout(new BorderLayout(1, 1));
		this.add(chartPanel);	    
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println(data);
		//chartPanel.repaint();
		super.paintComponent(g);
	}
	
	public void addData(boolean value, double time) {
		if (value) {
			ydata.add(time, 1);
		} else {
			ydata.add(time, 0);
		}
	}
}
