package server;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;

/**
 * SER516 Project3_Team10
 * Description: Sever GUI (View for Server)
 * @author Kanchan Wakchaure
 * @version 1.0
 */

public class ServerGUI {

	private JFrame composer;
	private JTextField time;

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
	 */
	private void initialize() {
		double value, min, max, step;
		
		composer = new JFrame();
		composer.setTitle("Emotive Composer");
		composer.getContentPane().setBackground(Color.LIGHT_GRAY);
		composer.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		composer.setBounds(100, 100, 631, 683);
		composer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		composer.getContentPane().setLayout(null);
		
		JLabel labelTimeInterval = new JLabel("Time interval: ");
		labelTimeInterval.setForeground(Color.WHITE);
		labelTimeInterval.setBackground(Color.GRAY);
		labelTimeInterval.setHorizontalAlignment(SwingConstants.CENTER);
		labelTimeInterval.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelTimeInterval.setBounds(300, 32, 113, 28);
		labelTimeInterval.setOpaque(true);
		composer.getContentPane().add(labelTimeInterval);
		
		JCheckBox autoResetServer = new JCheckBox("Auto-reset");
		autoResetServer.setForeground(Color.WHITE);
		autoResetServer.setBackground(Color.GRAY);
		autoResetServer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		autoResetServer.setBounds(300, 73, 113, 25);
		composer.getContentPane().add(autoResetServer);
		
		JButton start = new JButton("Start");
		start.setForeground(Color.WHITE);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		start.setBackground(Color.BLACK);
		start.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		start.setBounds(425, 73, 97, 25);
		start.setOpaque(true);
		composer.getContentPane().add(start);
		
		JLabel labelTime = new JLabel("Time:");
		labelTime.setForeground(Color.WHITE);
		labelTime.setBackground(Color.GRAY);
		labelTime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelTime.setHorizontalAlignment(SwingConstants.CENTER);
		labelTime.setBounds(38, 192, 80, 28);
		labelTime.setOpaque(true);
		composer.getContentPane().add(labelTime);
		
		JLabel labelSec = new JLabel("sec");
		labelSec.setForeground(Color.WHITE);
		labelSec.setHorizontalAlignment(SwingConstants.LEFT);
		labelSec.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelSec.setBounds(504, 38, 56, 16);
		composer.getContentPane().add(labelSec);
		
		time = new JTextField();
		time.setHorizontalAlignment(SwingConstants.LEFT);
		time.setBounds(113, 194, 121, 26);
		time.setEditable(false);
		composer.getContentPane().add(time);
		time.setColumns(10);
		
		JLabel labelSeconds = new JLabel("Seconds");
		labelSeconds.setForeground(Color.WHITE);
		labelSeconds.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelSeconds.setHorizontalAlignment(SwingConstants.LEFT);
		labelSeconds.setBounds(242, 194, 73, 25);
		composer.getContentPane().add(labelSeconds);
		
		JLabel labelEmostate = new JLabel("EMOSTATE");
		labelEmostate.setForeground(Color.WHITE);
		labelEmostate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelEmostate.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmostate.setBackground(SystemColor.activeCaption);
		labelEmostate.setBounds(22, 136, 113, 28);
		composer.getContentPane().add(labelEmostate);
		
		JLabel labelEye = new JLabel("Eye:");
		labelEye.setForeground(Color.WHITE);
		labelEye.setBackground(Color.GRAY);
		labelEye.setHorizontalAlignment(SwingConstants.LEFT);
		labelEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelEye.setBounds(56, 245, 62, 26);
		composer.getContentPane().add(labelEye);
		
		JComboBox eyeOption = new JComboBox();
		eyeOption.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		eyeOption.setBackground(new Color(255, 255, 255));
		eyeOption.setToolTipText("");
		eyeOption.setBounds(56, 272, 140, 28);
		composer.getContentPane().add(eyeOption);
		
		JSpinner timeInterval = new JSpinner();
		value = 0.01;
		min = 0.01;
		max = 99.99;
		step = 0.50;
		timeInterval.setModel(new SpinnerNumberModel(value, min, max, step));
		timeInterval.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		timeInterval.setBounds(425, 36, 73, 22);
		composer.getContentPane().add(timeInterval);
		
		JSpinner eyeValue = new JSpinner();
		eyeValue.setModel(new SpinnerNumberModel(0, 0, 1, 1));
		eyeValue.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		eyeValue.setBounds(198, 272, 62, 27);
		composer.getContentPane().add(eyeValue);
		
		JButton activateEye = new JButton("Activate");
		activateEye.setForeground(Color.WHITE);
		activateEye.setBackground(Color.BLACK);
		activateEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		activateEye.setBounds(272, 272, 113, 28);
		activateEye.setOpaque(true);
		composer.getContentPane().add(activateEye);
		
		JCheckBox autoResetEye = new JCheckBox("Auto-reset");
		autoResetEye.setForeground(Color.WHITE);
		autoResetEye.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		autoResetEye.setBackground(Color.GRAY);
		autoResetEye.setBounds(397, 274, 113, 25);
		composer.getContentPane().add(autoResetEye);
		
		JLabel labelUpperFace = new JLabel("Upperface:");
		labelUpperFace.setHorizontalAlignment(SwingConstants.LEFT);
		labelUpperFace.setForeground(Color.WHITE);
		labelUpperFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelUpperFace.setBackground(Color.GRAY);
		labelUpperFace.setBounds(56, 328, 140, 26);
		composer.getContentPane().add(labelUpperFace);
		
		JLabel labelLowerFace = new JLabel("Lowerface:");
		labelLowerFace.setHorizontalAlignment(SwingConstants.LEFT);
		labelLowerFace.setForeground(Color.WHITE);
		labelLowerFace.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelLowerFace.setBackground(Color.GRAY);
		labelLowerFace.setBounds(300, 328, 140, 26);
		composer.getContentPane().add(labelLowerFace);
		
		JComboBox upperFaceOption = new JComboBox();
		upperFaceOption.setToolTipText("");
		upperFaceOption.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		upperFaceOption.setBackground(Color.WHITE);
		upperFaceOption.setBounds(56, 356, 140, 28);
		composer.getContentPane().add(upperFaceOption);
		
		JSpinner upperFaceValue = new JSpinner();
		value = 0.00;
		min = 0.00;
		max = 1.00;
		step = 0.10;
		upperFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
		upperFaceValue.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		upperFaceValue.setBounds(198, 356, 62, 27);
		composer.getContentPane().add(upperFaceValue);
		
		JComboBox lowerFaceOption = new JComboBox();
		lowerFaceOption.setToolTipText("");
		lowerFaceOption.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lowerFaceOption.setBackground(Color.WHITE);
		lowerFaceOption.setBounds(300, 356, 140, 28);
		composer.getContentPane().add(lowerFaceOption);
		
		JSpinner lowerFaceValue = new JSpinner();
		lowerFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
		lowerFaceValue.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lowerFaceValue.setBounds(442, 357, 62, 25);
		composer.getContentPane().add(lowerFaceValue);
		
		JLabel labelPerformance = new JLabel("Performance Metrics:");
		labelPerformance.setHorizontalAlignment(SwingConstants.LEFT);
		labelPerformance.setForeground(Color.WHITE);
		labelPerformance.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelPerformance.setBackground(Color.GRAY);
		labelPerformance.setBounds(56, 408, 165, 26);
		composer.getContentPane().add(labelPerformance);
		
		JComboBox performance = new JComboBox();
		performance.setToolTipText("");
		performance.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		performance.setBackground(Color.WHITE);
		performance.setBounds(56, 436, 151, 28);
		composer.getContentPane().add(performance);
		
		JLabel labelConsole = new JLabel("EMOENGINE LOG");
		labelConsole.setHorizontalAlignment(SwingConstants.LEFT);
		labelConsole.setForeground(Color.WHITE);
		labelConsole.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelConsole.setBackground(Color.GRAY);
		labelConsole.setBounds(22, 489, 199, 26);
		composer.getContentPane().add(labelConsole);
		
		JEditorPane console = new JEditorPane();
		console.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		console.setBounds(56, 522, 384, 89);
		composer.getContentPane().add(console);
		
		JPanel borderPanel2 = new JPanel();
		borderPanel2.setBackground(Color.GRAY);
		borderPanel2.setBounds(12, 116, 589, 356);
		borderPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		composer.getContentPane().add(borderPanel2);
		
		JPanel indicatorPanel = new JPanel();
		indicatorPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		indicatorPanel.setBackground(new Color(50, 205, 50));
		indicatorPanel.setBounds(62, 32, 73, 66);
		indicatorPanel.setOpaque(true);
		composer.getContentPane().add(indicatorPanel);		
		
		JPanel borderPanel1 = new JPanel();
		borderPanel1.setBackground(Color.GRAY);
		borderPanel1.setBounds(12, 13, 589, 96);
		borderPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		composer.getContentPane().add(borderPanel1);
		
		JButton clearLog = new JButton("Clear Log");
		clearLog.setOpaque(true);
		clearLog.setForeground(Color.WHITE);
		clearLog.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		clearLog.setBackground(Color.BLACK);
		clearLog.setBounds(451, 580, 121, 31);
		composer.getContentPane().add(clearLog);
		
		JPanel borderPanel3 = new JPanel();
		borderPanel3.setBackground(Color.GRAY);
		borderPanel3.setBounds(12, 477, 589, 146);
		borderPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
		composer.getContentPane().add(borderPanel3);
	}
}
