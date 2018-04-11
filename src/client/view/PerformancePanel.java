package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import client.model.Parameters;

/**
 * @author Group10
 * @version 1.0
 * Draw line chart of 6 performance 
 */
public class PerformancePanel extends JPanel{
	private ChartPanel chartPanel;
	private JFreeChart chart;
	private DefaultCategoryDataset data = new DefaultCategoryDataset();
	
	/**
      * Constructor to build the performance panel
	  * @param chartTitle
      */
	public PerformancePanel(String chartTitle) {
		chart = ChartFactory.createLineChart(
				chartTitle,
				null,
				null,
				data,
				PlotOrientation.VERTICAL,
		        true,false,false);
		CategoryPlot plot = (CategoryPlot)chart.getPlot();
		
		NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0.0, 1.0);
        
		chartPanel = new ChartPanel(chart);
		setLayout(new BorderLayout(1, 1));
		
		this.add(chartPanel);
		chartPanel.addChartMouseListener(new ChartMouseListener() {

			@Override
			public void chartMouseClicked(ChartMouseEvent event) {
				final ChartEntity e = event.getEntity();
		        if (e != null) {
		            if (e instanceof LegendItemEntity) {
		            	
		                final LegendItemEntity entity = (LegendItemEntity) e;
		                final Comparable<?> seriesKey = entity.getSeriesKey();
		                final CategoryPlot plot = (CategoryPlot) chart.getPlot();
		                Color color = new Color(233);
		                plot.getRenderer().setSeriesPaint(data.getRowIndex(entity.getSeriesKey()), color);
		            }
		        }
			}

			@Override
			public void chartMouseMoved(ChartMouseEvent event) {			
			}		
		});
	}
	
	/**
      * paintComponent override method
	  * @param g
      */
	@Override
	public void paintComponent(Graphics g) {
		chartPanel.repaint();
		super.paintComponent(g);
	}
	
	/**
	 * Add data to the category labelLegend and the domain is labelX
	 * @param value of the data
	 * @param labelLegend category of the value
	 * @param labelX domain value
	 */
	public void addData(double value, String labelLegend, String labelX) {
		data.addValue(value, labelLegend, labelX);
	}
	
	/**
	 * add parameters to the chart dataset
	 * @param param
	 */
	public void add(Parameters param) {
		addData(param.getPerformance().getEngagement(),"engagement",Double.toString(param.getTime()));
		addData(param.getPerformance().getExcitement(),"excitment",Double.toString(param.getTime()));
		addData(param.getPerformance().getFocus(),"focus",Double.toString(param.getTime()));
		addData(param.getPerformance().getInterest(),"interest",Double.toString(param.getTime()));
		addData(param.getPerformance().getRelaxation(),"relaxation",Double.toString(param.getTime()));
		addData(param.getPerformance().getStress(),"stress",Double.toString(param.getTime()));
	}
}
