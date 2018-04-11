package client.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryStepRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class StepLineChartPanel extends JPanel{
	private ChartPanel chartPanel;
	private JFreeChart chart;
	//private XYDataset data;
	//private XYSeries ydata;
	private DefaultCategoryDataset dataset;
	
	public StepLineChartPanel(String chartTitle) {
		//ydata = new XYSeries(chartTitle, false, true);

		/*XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(ydata);
		data = dataset;
		chart = ChartFactory.createXYStepChart(
				chartTitle,
				null,
				null,
				data,
				PlotOrientation.VERTICAL,
                false,   // legend
                false,   // tooltips
                false   // urls
                );*/
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
        range.setRange(0.0, 1.0);
		
		chart = new JFreeChart(chartTitle,
				plot
				);
        chart.setBackgroundPaint(Color.white);
		chartPanel = new ChartPanel(chart);

		setLayout(new BorderLayout(1, 1));
		this.add(chartPanel);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//chartPanel.repaint();
		super.paintComponent(g);
	}
	
	public void addData(boolean value, double time) {
		if (value) {
			//ydata.add(time, 1.0f);
			dataset.addValue(1, "time", Double.toString(time));
		} else {
			//ydata.add(time, 0.0f);
			dataset.addValue(0, "time", Double.toString(time));
		}
	}
}
