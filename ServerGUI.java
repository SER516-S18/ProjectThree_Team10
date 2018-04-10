package server;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

//import server.model.hashvalues;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.border.LineBorder;
/**
 * SER516 Project3_Team10
 * Description: Sever GUI (View for Server)
 * Has action and event listeners
 * @author Kanchan Wakchaure
 * @author prasanth Venugopal
 * @author Divya Yadamreddi
 * @version 1.0
 */


public class ServerGUI extends TimerClass {

	private JPanel time;
	private boolean flag = true;
	private boolean autoReset = true;
	private static JFrame composer;
	static JTextPane console = new JTextPane();
	private static JLabel labelTimeDuration;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerGUI window = new ServerGUI();
					window.composer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param composer 
	 */
	private void initialize() {
		composer = new JFrame();
		double value, min, max, step;
		Variables var = new Variables();

		composer.setTitle("Emotiv Composer");
		composer.getContentPane().setBackground(ColorConstants.LIGHT_GRAY);
		composer.getContentPane().setFont(TextConstants.PLAIN);
		composer.setBounds(100, 100, 631, 683);
		composer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		composer.getContentPane().setLayout(null);
		
		JLabel labelTimeInterval = new JLabel("Time interval: ");
		labelTimeInterval.setForeground(ColorConstants.WHITE);
		labelTimeInterval.setBackground(ColorConstants.GRAY);
		labelTimeInterval.setHorizontalAlignment(SwingConstants.CENTER);
		labelTimeInterval.setFont(TextConstants.PLAIN);
		labelTimeInterval.setBounds(300, 32, 113, 28);
		labelTimeInterval.setOpaque(true);
		composer.getContentPane().add(labelTimeInterval);
		
		JCheckBox autoResetServer = new JCheckBox("Auto-reset");
		autoResetServer.setForeground(ColorConstants.WHITE);
		autoResetServer.setBackground(ColorConstants.GRAY);
		autoResetServer.setFont(TextConstants.PLAIN);
		autoResetServer.setBounds(300, 73, 113, 25);
		composer.getContentPane().add(autoResetServer);
		
		JButton start = new JButton("Send");
		start.setFont(TextConstants.PLAIN);
		start.setBounds(425, 73, 97, 25);
		composer.getContentPane().add(start);
		
		JLabel labelTime = new JLabel("Time:");
		labelTime.setForeground(ColorConstants.WHITE);
		labelTime.setBackground(ColorConstants.GRAY);
		labelTime.setFont(TextConstants.PLAIN);
		labelTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelTime.setBounds(38, 177, 80, 28);
		labelTime.setOpaque(true);
		composer.getContentPane().add(labelTime);
		
		JLabel labelSec = new JLabel("sec");
		labelSec.setForeground(ColorConstants.WHITE);
		labelSec.setHorizontalAlignment(SwingConstants.LEFT);
		labelSec.setFont(TextConstants.PLAIN);
		labelSec.setBounds(504, 38, 56, 16);
		composer.getContentPane().add(labelSec);
		
		JSpinner timeInterval = new JSpinner();
		value = 0.25;
		min = 0.01;
		max = 99.99;
		step = 0.50;
		timeInterval.setModel(new SpinnerNumberModel(value, min, max, step));
		timeInterval.setFont(TextConstants.PLAIN);
		timeInterval.setBounds(425, 36, 73, 22);
		composer.getContentPane().add(timeInterval);
		
		time = new JPanel();
		time.setBounds(126, 179, 121, 26);
		composer.getContentPane().add(time);
		
		labelTimeDuration = new JLabel();
		labelTimeDuration.setFont(TextConstants.PLAIN);
		time.add(labelTimeDuration);
		composer.getContentPane().add(time);
		
		//start(labelTimeDuration);
		//pause();
		
		JLabel labelSeconds = new JLabel("Seconds");
		labelSeconds.setForeground(ColorConstants.WHITE);
		labelSeconds.setFont(TextConstants.PLAIN);
		labelSeconds.setHorizontalAlignment(SwingConstants.LEFT);
		labelSeconds.setBounds(253, 179, 73, 25);
		composer.getContentPane().add(labelSeconds);
		
		JLabel labelEmostate = new JLabel("EMOSTATE");
		labelEmostate.setForeground(ColorConstants.WHITE);
		labelEmostate.setFont(TextConstants.PLAIN);
		labelEmostate.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmostate.setBackground(SystemColor.activeCaption);
		labelEmostate.setBounds(22, 136, 113, 28);
		composer.getContentPane().add(labelEmostate);
		
		JLabel labelEye = new JLabel("Eye:");
		labelEye.setForeground(ColorConstants.WHITE);
		labelEye.setBackground(ColorConstants.GRAY);
		labelEye.setHorizontalAlignment(SwingConstants.LEFT);
		labelEye.setFont(TextConstants.PLAIN);
		labelEye.setBounds(38, 233, 62, 26);
		composer.getContentPane().add(labelEye);
		
		JComboBox<String> eyeOption = new JComboBox<String>();
		eyeOption.setFont(TextConstants.PLAIN);
		eyeOption.setBackground(ColorConstants.WHITE);
		eyeOption.setToolTipText("");
		eyeOption.setBounds(38, 261, 140, 28);
		composer.getContentPane().add(eyeOption);
		
		JSpinner eyeValue = new JSpinner();
		eyeValue.setModel(new SpinnerNumberModel(0, 0, 1, 1));
		eyeValue.setFont(TextConstants.PLAIN);
		eyeValue.setBounds(178, 261, 62, 27);
		composer.getContentPane().add(eyeValue);
		
		JButton activateEye = new JButton("Activate");
		activateEye.setFont(TextConstants.PLAIN);
		activateEye.setBounds(245, 261, 113, 28);
		composer.getContentPane().add(activateEye);
		
		JCheckBox autoResetEye = new JCheckBox("Auto-reset");
		autoResetEye.setForeground(ColorConstants.WHITE);
		autoResetEye.setFont(TextConstants.PLAIN);
		autoResetEye.setBackground(ColorConstants.GRAY);
		autoResetEye.setBounds(366, 263, 113, 25);
		composer.getContentPane().add(autoResetEye);
		
		JLabel labelUpperFace = new JLabel("Upperface:");
		labelUpperFace.setHorizontalAlignment(SwingConstants.LEFT);
		labelUpperFace.setForeground(ColorConstants.WHITE);
		labelUpperFace.setFont(TextConstants.PLAIN);
		labelUpperFace.setBackground(ColorConstants.GRAY);
		labelUpperFace.setBounds(38, 317, 140, 26);
		composer.getContentPane().add(labelUpperFace);
		
		JLabel labelLowerFace = new JLabel("Lowerface:");
		labelLowerFace.setHorizontalAlignment(SwingConstants.LEFT);
		labelLowerFace.setForeground(ColorConstants.WHITE);
		labelLowerFace.setFont(TextConstants.PLAIN);
		labelLowerFace.setBackground(ColorConstants.GRAY);
		labelLowerFace.setBounds(282, 317, 140, 26);
		composer.getContentPane().add(labelLowerFace);
		
		JComboBox<String> upperFaceOption = new JComboBox<String>();
		upperFaceOption.setToolTipText("");
		upperFaceOption.setFont(TextConstants.PLAIN);
		upperFaceOption.setBackground(ColorConstants.WHITE);
		upperFaceOption.setBounds(38, 344, 140, 28);
		composer.getContentPane().add(upperFaceOption);
		
		JSpinner upperFaceValue = new JSpinner();
		value = 0.00;
		min = 0.00;
		max = 1.00;
		step = 0.10;
		upperFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
		upperFaceValue.setFont(TextConstants.PLAIN);
		upperFaceValue.setBounds(178, 344, 62, 27);
		composer.getContentPane().add(upperFaceValue);
		
		JComboBox<String> lowerFaceOption = new JComboBox<String>();
		lowerFaceOption.setToolTipText("");
		lowerFaceOption.setFont(TextConstants.PLAIN);
		lowerFaceOption.setBackground(ColorConstants.WHITE);
		lowerFaceOption.setBounds(282, 344, 140, 28);
		composer.getContentPane().add(lowerFaceOption);
		
		JSpinner lowerFaceValue = new JSpinner();
		lowerFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
		lowerFaceValue.setFont(TextConstants.PLAIN);
		lowerFaceValue.setBounds(425, 344, 62, 26);
		composer.getContentPane().add(lowerFaceValue);
		
		JLabel labelPerformance = new JLabel("Performance Metrics:");
		labelPerformance.setHorizontalAlignment(SwingConstants.LEFT);
		labelPerformance.setForeground(ColorConstants.WHITE);
		labelPerformance.setFont(TextConstants.PLAIN);
		labelPerformance.setBackground(ColorConstants.GRAY);
		labelPerformance.setBounds(38, 397, 165, 26);
		composer.getContentPane().add(labelPerformance);
		
		JComboBox<String> performance = new JComboBox<String>();
		performance.setToolTipText("");
		performance.setFont(TextConstants.PLAIN);
		performance.setBackground(ColorConstants.WHITE);
		performance.setBounds(38, 423, 151, 28);
		composer.getContentPane().add(performance);
		
		JLabel labelConsole = new JLabel("EMOENGINE LOG");
		labelConsole.setHorizontalAlignment(SwingConstants.LEFT);
		labelConsole.setForeground(ColorConstants.WHITE);
		labelConsole.setFont(TextConstants.PLAIN);
		labelConsole.setBackground(ColorConstants.GRAY);
		labelConsole.setBounds(22, 489, 165, 26);
		composer.getContentPane().add(labelConsole);
		
		console.setFont(TextConstants.PLAIN);
		console.setBounds(56, 522, 384, 89);
		composer.getContentPane().add(console);
		console.setEditable(false);
		
		Indicator indicatorPanel = new Indicator(0);
		indicatorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		indicatorPanel.setBounds(62, 32, 73, 66);
		composer.getContentPane().add(indicatorPanel);
		indicatorPanel.update(1);
		
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		indicatorPanel.update(0);
		
		JPanel borderPanel1 = new JPanel();
		borderPanel1.setBackground(Color.GRAY);
		borderPanel1.setBounds(12, 13, 589, 96);
		borderPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		composer.getContentPane().add(borderPanel1);
		
		JButton clearLog = new JButton("Clear Log");
		clearLog.setFont(TextConstants.PLAIN);
		clearLog.setBounds(451, 580, 121, 31);
		composer.getContentPane().add(clearLog);
		
		JPanel borderPanel3 = new JPanel();
		borderPanel3.setBackground(ColorConstants.GRAY);
		borderPanel3.setBounds(12, 477, 589, 146);
		borderPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
		composer.getContentPane().add(borderPanel3);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(TextConstants.PLAIN);
		spinner.setBounds(190, 424, 67, 26);
		composer.getContentPane().add(spinner);
		
		JPanel borderPanel2 = new JPanel();
		borderPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		borderPanel2.setBackground(Color.GRAY);
		borderPanel2.setBounds(12, 116, 589, 354);
		composer.getContentPane().add(borderPanel2);
		
		composer.setVisible(true);
		
		lowerFaceOption.addItem("Smile");
		lowerFaceOption.addItem("Clench");
		lowerFaceOption.addItem("Smirk Left");
		lowerFaceOption.addItem("Smirk Right");
		lowerFaceOption.addItem("Laugh");
			
		upperFaceOption.addItem("Raise Brow");
		upperFaceOption.addItem("Furrow Brow");
		
		eyeOption.addItem("Blink");
		eyeOption.addItem("wink left");
		eyeOption.addItem("wink right");
		eyeOption.addItem("look right");
		eyeOption.addItem("look left");
		
		performance.addItem("Interest");
		performance.addItem("Excitement");
		performance.addItem("Engagement");
		performance.addItem("Stress");
		performance.addItem("Relaxation");
		performance.addItem("Focus");
		
		hashvalues.initialize();
		
		clearLog.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        console.setText("");
		    }
		});
		
        lowerFaceOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                var.getLowerFace(lowerFaceOption, lowerFaceValue);
               
            }
        });
        
        lowerFaceValue.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
              var.setLowerFace(lowerFaceOption, lowerFaceValue);
              
            }
          });
        
        upperFaceOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                var.getUpperFace(upperFaceOption, upperFaceValue);
                
            }
        });
        
        upperFaceValue.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
              var.setUpperFace(upperFaceOption, upperFaceValue);
              
            }
          });
        
        eyeOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                var.getEye(eyeOption, eyeValue);
               
            }
        });
        
       eyeValue.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
              var.setEye(eyeOption, eyeValue);
              
            }
          });
       
       start.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {
     		   if(autoReset) {
     			   start.setText("Send");
     			   TimerClass.getInstance().startTimer((double)timeInterval.getValue());
     			  ServerConsole.setMessage("Data sent to client");
     			   
     		   }
     		   else {
				   if(flag)
				   {
					 start.setText("Stop");
					 flag = false;
					 TimerClass.getInstance().startTimer((double)timeInterval.getValue());  
					 indicatorPanel.update(0);
					 ServerConsole.setMessage("Data sent to client");
				   }
				   else
				   {
					  TimerClass.getInstance().stopTimer();
					  start.setText("Start");
					  indicatorPanel.update(1);
					  flag = true;
					  ServerConsole.setMessage("Stopped sending data");
				   }
			   }
     	 }
       });
       
       autoResetServer.addActionListener(new ActionListener() {
     	   public void actionPerformed(ActionEvent e) {
     		  
     		  if(autoReset) {
     			 TimerClass.getInstance().setAutoReset(true);
     			 autoReset = false;
     			start.setText("Start");
     		  }
     		  else {
     			TimerClass.getInstance().setAutoReset(false);
     			autoReset = true;
     			start.setText("Send");
     		  }
     	   }
       });
      
	}
	
	public static JTextPane getConsole(){
		return console;
	}
	
	public static JLabel getTime() {
		return labelTimeDuration;
	}
}
	
