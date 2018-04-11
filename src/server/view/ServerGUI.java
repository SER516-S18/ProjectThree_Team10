package server.view;

import server.service.TimerClass;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
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
     * Create the application.
     */
    public ServerGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        composer = new JFrame();
        double value, min, max, step;

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
        labelTime.setOpaque(true);
        composer.getContentPane().add(labelTime);

        JLabel labelSec = new JLabel("sec");
        labelSec.setForeground(ColorConstants.WHITE);
        labelSec.setHorizontalAlignment(SwingConstants.LEFT);
        labelSec.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(labelSec);
        value = 1.00;

        JSpinner timeInterval = new JSpinner();
        value = 0.25;
        min = 0.01;
        max = 99.99;
        step = 0.50;
        timeInterval.setModel(new SpinnerNumberModel(value, min, max, step));
        timeInterval.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(timeInterval);
        time = new JPanel();
        labelTimeDuration = new JLabel();
        labelTimeDuration.setFont(TextConstants.PLAIN);
        time.add(labelTimeDuration);
        composer.getContentPane().add(time);

        JLabel labelSeconds = new JLabel("Seconds");
        labelSeconds.setForeground(ColorConstants.WHITE);
        labelSeconds.setFont(TextConstants.PLAIN);
        labelSeconds.setHorizontalAlignment(SwingConstants.LEFT);
        composer.getContentPane().add(labelSeconds);

        JLabel labelEmostate = new JLabel("EMOSTATE");
        labelEmostate.setForeground(ColorConstants.WHITE);
        labelEmostate.setFont(TextConstants.PLAIN);
        labelEmostate.setHorizontalAlignment(SwingConstants.LEFT);
        labelEmostate.setBackground(SystemColor.activeCaption);
        composer.getContentPane().add(labelEmostate);

        JButton listen = new JButton("Listen");
        listen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        listen.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(listen);

        JLabel labelEye = new JLabel("Eye:");
        labelEye.setForeground(ColorConstants.WHITE);
        labelEye.setBackground(ColorConstants.GRAY);
        labelEye.setHorizontalAlignment(SwingConstants.LEFT);
        labelEye.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(labelEye);

        JComboBox<String> eyeOption = new JComboBox<String>();
        eyeOption.setFont(TextConstants.PLAIN);
        eyeOption.setBackground(ColorConstants.WHITE);
        eyeOption.setToolTipText("");
        composer.getContentPane().add(eyeOption);

//        JSpinner eyeValue = new JSpinner();
//        eyeValue.setModel(new SpinnerNumberModel(0, 0, 1, 1));
//        eyeValue.setFont(TextConstants.PLAIN);
//        composer.getContentPane().add(eyeValue);

        JCheckBox activateEye = new JCheckBox("Activate");
        activateEye.setForeground(ColorConstants.WHITE);
        activateEye.setFont(TextConstants.PLAIN);
        activateEye.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(activateEye);

        JCheckBox autoResetEye = new JCheckBox("Auto-reset");
        autoResetEye.setForeground(ColorConstants.WHITE);
        autoResetEye.setFont(TextConstants.PLAIN);
        autoResetEye.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(autoResetEye);

        JLabel labelUpperFace = new JLabel("Upperface:");
        labelUpperFace.setHorizontalAlignment(SwingConstants.LEFT);
        labelUpperFace.setForeground(ColorConstants.WHITE);
        labelUpperFace.setFont(TextConstants.PLAIN);
        labelUpperFace.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(labelUpperFace);

        JLabel labelLowerFace = new JLabel("Lowerface:");
        labelLowerFace.setHorizontalAlignment(SwingConstants.LEFT);
        labelLowerFace.setForeground(ColorConstants.WHITE);
        labelLowerFace.setFont(TextConstants.PLAIN);
        labelLowerFace.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(labelLowerFace);

        JComboBox<String> upperFaceOption = new JComboBox<String>();
        upperFaceOption.setToolTipText("");
        upperFaceOption.setFont(TextConstants.PLAIN);
        upperFaceOption.setBackground(ColorConstants.WHITE);
        composer.getContentPane().add(upperFaceOption);

        JSpinner upperFaceValue = new JSpinner();
        value = 0.00;
        min = 0.00;
        max = 1.00;
        step = 0.10;
        upperFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
        upperFaceValue.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(upperFaceValue);

        JComboBox<String> lowerFaceOption = new JComboBox<String>();
        lowerFaceOption.setToolTipText("");
        lowerFaceOption.setFont(TextConstants.PLAIN);
        lowerFaceOption.setBackground(ColorConstants.WHITE);
        composer.getContentPane().add(lowerFaceOption);

        JSpinner lowerFaceValue = new JSpinner();
        lowerFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
        lowerFaceValue.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(lowerFaceValue);

        JLabel labelPerformance = new JLabel("Performance Metrics:");
        labelPerformance.setHorizontalAlignment(SwingConstants.LEFT);
        labelPerformance.setForeground(ColorConstants.WHITE);
        labelPerformance.setFont(TextConstants.PLAIN);
        labelPerformance.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(labelPerformance);

        JComboBox<String> performance = new JComboBox<String>();
        performance.setToolTipText("");
        performance.setFont(TextConstants.PLAIN);
        performance.setBackground(ColorConstants.WHITE);
        composer.getContentPane().add(performance);

        JLabel labelConsole = new JLabel("EMOENGINE LOG");
        labelConsole.setHorizontalAlignment(SwingConstants.LEFT);
        labelConsole.setForeground(ColorConstants.WHITE);
        labelConsole.setFont(TextConstants.PLAIN);
        labelConsole.setBackground(ColorConstants.GRAY);

        composer.getContentPane().add(labelConsole);

        console.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(console);
        console.setEditable(false);
        //ServerConsole.setMessage("Message");
        //ServerConsole.setErrorMessage("Error");

        JPanel borderPanel2 = new JPanel();
        borderPanel2.setBackground(ColorConstants.GRAY);
        borderPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        composer.getContentPane().add(borderPanel2);

        Indicator indicatorPanel = new Indicator(0);
        indicatorPanel.setBorder(BorderFactory.createLineBorder(Color.black));

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
        borderPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
        composer.getContentPane().add(borderPanel1);

        JButton clearLog = new JButton("Clear Log");
        clearLog.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(clearLog);

        JPanel borderPanel3 = new JPanel();
        borderPanel3.setBackground(ColorConstants.GRAY);
        borderPanel3.setBorder(BorderFactory.createLineBorder(Color.black));
        composer.getContentPane().add(borderPanel3);

        composer.addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent e){
                borderPanel1.setBounds((int)(composer.getWidth()*0.01), (int)(composer.getHeight()*0.01), (int)(composer.getWidth()*0.95), (int)(composer.getHeight()*0.19));
                indicatorPanel.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.05), (int)(composer.getWidth()*0.12), (int)(composer.getHeight()*0.09));
                labelTimeInterval.setBounds((int)(composer.getWidth()*0.47), (int)(composer.getHeight()*0.05), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                autoResetServer.setBounds((int)(composer.getWidth()*0.47), (int)(composer.getHeight()*0.1), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                start.setBounds((int)(composer.getWidth()*0.68), (int)(composer.getHeight()*0.1), (int)(composer.getWidth()*0.15), (int)(composer.getHeight()*0.04));
                labelSec.setBounds((int)(composer.getWidth()*0.8), (int)(composer.getHeight()*0.06), (int)(composer.getWidth()*0.08), (int)(composer.getHeight()*0.02));
                timeInterval.setBounds((int)(composer.getWidth()*0.67), (int)(composer.getHeight()*0.05), (int)(composer.getWidth()*0.11), (int)(composer.getHeight()*0.03));

                borderPanel2.setBounds((int)(composer.getWidth()*0.01), (int)(composer.getHeight()*0.21), (int)(composer.getWidth()*0.95), (int)(composer.getHeight()*0.48));
                listen.setBounds((int)(composer.getWidth()*0.68), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.15), (int)(composer.getHeight()*0.04));
                labelEmostate.setBounds((int)(composer.getWidth()*0.02), (int)(composer.getHeight()*0.22), (int)(composer.getWidth()*0.26), (int)(composer.getHeight()*0.03));
                labelTime.setBounds((int)(composer.getWidth()*0.06), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.12), (int)(composer.getHeight()*0.04));
                labelSeconds.setBounds((int)(composer.getWidth()*0.38), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.1), (int)(composer.getHeight()*0.04));
                time.setBounds((int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                labelEye.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.36), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                eyeOption.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                //eyeValue.setBounds((int)(composer.getWidth()*0.31), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                activateEye.setBounds((int)(composer.getWidth()*0.31), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.17), (int)(composer.getHeight()*0.04));
                autoResetEye.setBounds((int)(composer.getWidth()*0.48), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.17), (int)(composer.getHeight()*0.04));
                labelUpperFace.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.48), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                labelLowerFace.setBounds((int)(composer.getWidth()*0.48), (int)(composer.getHeight()*0.48), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                upperFaceOption.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                upperFaceValue.setBounds((int)(composer.getWidth()*0.31), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                lowerFaceOption.setBounds((int)(composer.getWidth()*0.48), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                lowerFaceValue.setBounds((int)(composer.getWidth()*0.7), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                labelPerformance.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.6), (int)(composer.getWidth()*0.24), (int)(composer.getHeight()*0.04));
                performance.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.64), (int)(composer.getWidth()*0.22), (int)(composer.getHeight()*0.04));

                borderPanel3.setBounds((int)(composer.getWidth()*0.01), (int)(composer.getHeight()*0.7), (int)(composer.getWidth()*0.95), (int)(composer.getHeight()*0.22));
                clearLog.setBounds((int)(composer.getWidth()*0.7), (int)(composer.getHeight()*0.84), (int)(composer.getWidth()*0.19), (int)(composer.getHeight()*0.05));
                labelConsole.setBounds((int)(composer.getWidth()*0.02), (int)(composer.getHeight()*0.71), (int)(composer.getWidth()*0.26), (int)(composer.getHeight()*0.03));
                console.setBounds((int)(composer.getWidth()*0.08), (int)(composer.getHeight()*0.76), (int)(composer.getWidth()*0.6), (int)(composer.getHeight()*0.13));

            }
        });

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

        clearLog.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                console.setText("");
            }
        });

//        lowerFaceOption.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                var.getLowerFace(lowerFaceOption, lowerFaceValue);
//
//            }
//        });
//
//        lowerFaceValue.addChangeListener(new ChangeListener(){
//            public void stateChanged(ChangeEvent e) {
//              var.setLowerFace(lowerFaceOption, lowerFaceValue);
//
//            }
//          });
//
//        upperFaceOption.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                var.getUpperFace(upperFaceOption, upperFaceValue);
//
//            }
//        });
//
//        upperFaceValue.addChangeListener(new ChangeListener(){
//            public void stateChanged(ChangeEvent e) {
//              var.setUpperFace(upperFaceOption, upperFaceValue);
//
//            }
//          });
//
//        eyeOption.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                var.getEye(eyeOption, eyeValue);
//
//            }
//        });
//
//       eyeValue.addChangeListener(new ChangeListener(){
//            public void stateChanged(ChangeEvent e) {
//              var.setEye(eyeOption, eyeValue);
//
//            }
//          });
//
//       start.addActionListener(new ActionListener() {
//     	   public void actionPerformed(ActionEvent e) {
//     		   if(flag)
//     		   {
//     			resume(labelTimeDuration);
//     			start.setText("Stop");
//     			indicatorPanel.update(0);
//     			flag = false;
//     			ServerConsole.setMessage("Server Running");
//     		   }
//     		   else
//     		   {
//     			pause();
//     			start.setText("Start");
//     			indicatorPanel.update(1);
//     			flag = true;
//     			ServerConsole.setMessage("Server Stopped");
//     		   }
//
//     		   }
//     });

    }
    public static JTextPane getConsole(){
        return console;
    }

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

    public static JLabel getTime() {
        return labelTimeDuration;
    }
}

