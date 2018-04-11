package server.view;

import server.controller.ServerSocket;
import server.controller.ServerWindowController;
import server.model.Parameters;
import server.model.Eye;
import server.model.LowerFace;
import server.model.PerformanceMet;
import server.model.UpperFace;
import server.service.TimerClass;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.websocket.EncodeException;

/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
  Contains Server GUI which displays the Graphical user Interface for server
 */

public class ServerGUI extends TimerClass {
    private JPanel time;

    private boolean isSending;
    private double timeRec;
    private JFrame composer;
    private static JTextPane console = new JTextPane();
    private static JLabel labelTimeDuration;

    private JComboBox<String> eyeOption;
    private JCheckBox activateEye;
    private JCheckBox autoResetEye;
    private JCheckBox autoResetServer;
    private JComboBox<String> upperFaceOption;
    private JSpinner upperFaceValue;
    private JComboBox<String> lowerFaceOption;
    private JSpinner lowerFaceValue;
    private JComboBox<String> performanceOption;
    private JSpinner performanceValue;
    private int port;

    /**
     * Init ServerGUI
     */
    public ServerGUI() {
        initialize();
        composer.setVisible(true);
        isSending = false;
        timeRec = 0.0;
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
        labelTimeInterval.setOpaque(true);
        composer.getContentPane().add(labelTimeInterval);

        autoResetServer = new JCheckBox("Auto-reset");
        autoResetServer.setForeground(ColorConstants.WHITE);
        autoResetServer.setBackground(ColorConstants.GRAY);
        autoResetServer.setFont(TextConstants.PLAIN);
        autoResetServer.setBounds(300, 73, 113, 25);
        composer.getContentPane().add(autoResetServer);

        JButton start = new JButton("Send");
        start.setFont(TextConstants.PLAIN);
        start.setBounds(425, 73, 97, 25);
        composer.getContentPane().add(start);

        JLabel port = new JLabel("Port: ");
        port.setForeground(ColorConstants.WHITE);
        port.setFont(TextConstants.PLAIN);
        port.setBackground(SystemColor.activeCaption);
        composer.getContentPane().add(port);

        JTextField portInput =new JTextField(6);
        composer.getContentPane().add(portInput);

        JButton changePort = new JButton("Change");
        changePort.setFont(TextConstants.PLAIN);
        changePort.setBounds(425, 73, 97, 25);
        composer.getContentPane().add(changePort);
        changePort.addActionListener(e -> {
            String s = portInput.getText();
            try {
                int p = Integer.parseInt(s);
                ServerWindowController.initServerEndPoint(p);
            } catch (NumberFormatException nfe) {
                ServerWindowController.initServerEndPoint(8025);
            }

        });

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


        listen.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(listen);

        JLabel labelEye = new JLabel("Eye:");
        labelEye.setForeground(ColorConstants.WHITE);
        labelEye.setBackground(ColorConstants.GRAY);
        labelEye.setHorizontalAlignment(SwingConstants.LEFT);
        labelEye.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(labelEye);

        eyeOption = new JComboBox<String>();
        eyeOption.setFont(TextConstants.PLAIN);
        eyeOption.setBackground(ColorConstants.WHITE);
        eyeOption.setToolTipText("");
        composer.getContentPane().add(eyeOption);

        activateEye = new JCheckBox("Activate");
        activateEye.setForeground(ColorConstants.WHITE);
        activateEye.setFont(TextConstants.PLAIN);
        activateEye.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(activateEye);

        autoResetEye = new JCheckBox("Auto-reset");
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

        upperFaceOption = new JComboBox<String>();
        upperFaceOption.setToolTipText("");
        upperFaceOption.setFont(TextConstants.PLAIN);
        upperFaceOption.setBackground(ColorConstants.WHITE);
        composer.getContentPane().add(upperFaceOption);

        upperFaceValue = new JSpinner();
        value = 0.00;
        min = 0.00;
        max = 1.00;
        step = 0.10;
        upperFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
        upperFaceValue.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(upperFaceValue);

        lowerFaceOption = new JComboBox<String>();
        lowerFaceOption.setToolTipText("");
        lowerFaceOption.setFont(TextConstants.PLAIN);
        lowerFaceOption.setBackground(ColorConstants.WHITE);
        composer.getContentPane().add(lowerFaceOption);

        lowerFaceValue = new JSpinner();
        lowerFaceValue.setModel(new SpinnerNumberModel(value, min, max, step));
        lowerFaceValue.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(lowerFaceValue);

        JLabel labelPerformance = new JLabel("Performance Metrics:");
        labelPerformance.setHorizontalAlignment(SwingConstants.LEFT);
        labelPerformance.setForeground(ColorConstants.WHITE);
        labelPerformance.setFont(TextConstants.PLAIN);
        labelPerformance.setBackground(ColorConstants.GRAY);
        composer.getContentPane().add(labelPerformance);

        performanceOption = new JComboBox<String>();
        performanceOption.setToolTipText("");
        performanceOption.setFont(TextConstants.PLAIN);
        performanceOption.setBackground(ColorConstants.WHITE);
        composer.getContentPane().add(performanceOption);

        performanceValue = new JSpinner();
        performanceValue.setModel(new SpinnerNumberModel(value, min, max, step));
        performanceValue.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(performanceValue);

        JLabel labelConsole = new JLabel("EMOENGINE LOG");
        labelConsole.setHorizontalAlignment(SwingConstants.LEFT);
        labelConsole.setForeground(ColorConstants.WHITE);
        labelConsole.setFont(TextConstants.PLAIN);
        labelConsole.setBackground(ColorConstants.GRAY);

        composer.getContentPane().add(labelConsole);

        console.setFont(TextConstants.PLAIN);
        composer.getContentPane().add(console);
        console.setEditable(false);

        JPanel borderPanel = new JPanel();
        borderPanel.setBackground(ColorConstants.GRAY);
        borderPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        composer.getContentPane().add(borderPanel);

        Indicator indicatorPanel = new Indicator(1);
        indicatorPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        composer.getContentPane().add(indicatorPanel);


        listen.addActionListener(new ActionListener() {
            /**
             * start or stop listening
             * @param arg0
             */
            public void actionPerformed(ActionEvent arg0) {
                ServerWindowController.changeStatus();
                if (ServerWindowController.isStart) {
                    indicatorPanel.update(0);
                } else {
                    indicatorPanel.update(1);
                }
            }
        });

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
            /**
             * Set flexible bounds
             * @param e
             */
            public void componentResized(ComponentEvent e){
                borderPanel1.setBounds((int)(composer.getWidth()*0.01), (int)(composer.getHeight()*0.01), (int)(composer.getWidth()*0.95), (int)(composer.getHeight()*0.19));
                indicatorPanel.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.05), (int)(composer.getWidth()*0.12), (int)(composer.getHeight()*0.09));
                labelTimeInterval.setBounds((int)(composer.getWidth()*0.47), (int)(composer.getHeight()*0.05), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                autoResetServer.setBounds((int)(composer.getWidth()*0.47), (int)(composer.getHeight()*0.1), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                start.setBounds((int)(composer.getWidth()*0.68), (int)(composer.getHeight()*0.1), (int)(composer.getWidth()*0.15), (int)(composer.getHeight()*0.04));
                labelSec.setBounds((int)(composer.getWidth()*0.8), (int)(composer.getHeight()*0.06), (int)(composer.getWidth()*0.08), (int)(composer.getHeight()*0.02));
                timeInterval.setBounds((int)(composer.getWidth()*0.67), (int)(composer.getHeight()*0.05), (int)(composer.getWidth()*0.11), (int)(composer.getHeight()*0.03));
                borderPanel.setBounds((int)(composer.getWidth()*0.01), (int)(composer.getHeight()*0.21), (int)(composer.getWidth()*0.95), (int)(composer.getHeight()*0.48));
                listen.setBounds((int)(composer.getWidth()*0.68), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.15), (int)(composer.getHeight()*0.04));
                labelEmostate.setBounds((int)(composer.getWidth()*0.02), (int)(composer.getHeight()*0.22), (int)(composer.getWidth()*0.26), (int)(composer.getHeight()*0.03));
                labelTime.setBounds((int)(composer.getWidth()*0.06), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.12), (int)(composer.getHeight()*0.04));
                labelSeconds.setBounds((int)(composer.getWidth()*0.38), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.1), (int)(composer.getHeight()*0.04));
                time.setBounds((int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.28), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                labelEye.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.36), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                eyeOption.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                activateEye.setBounds((int)(composer.getWidth()*0.31), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.17), (int)(composer.getHeight()*0.04));
                autoResetEye.setBounds((int)(composer.getWidth()*0.48), (int)(composer.getHeight()*0.4), (int)(composer.getWidth()*0.17), (int)(composer.getHeight()*0.04));
                labelUpperFace.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.48), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                labelLowerFace.setBounds((int)(composer.getWidth()*0.48), (int)(composer.getHeight()*0.48), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                upperFaceOption.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                upperFaceValue.setBounds((int)(composer.getWidth()*0.31), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                lowerFaceOption.setBounds((int)(composer.getWidth()*0.48), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.2), (int)(composer.getHeight()*0.04));
                lowerFaceValue.setBounds((int)(composer.getWidth()*0.7), (int)(composer.getHeight()*0.52), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
                labelPerformance.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.6), (int)(composer.getWidth()*0.24), (int)(composer.getHeight()*0.04));
                performanceOption.setBounds((int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.64), (int)(composer.getWidth()*0.22), (int)(composer.getHeight()*0.04));
                port.setBounds((int)(composer.getWidth()*0.47), (int)(composer.getHeight()*0.15), (int)(composer.getWidth()*0.18), (int)(composer.getHeight()*0.04));
                portInput.setBounds((int)(composer.getWidth()*0.60), (int)(composer.getHeight()*0.15), (int)(composer.getWidth()*0.12), (int)(composer.getHeight()*0.04));
                changePort.setBounds((int)(composer.getWidth()*0.77), (int)(composer.getHeight()*0.15), (int)(composer.getWidth()*0.16), (int)(composer.getHeight()*0.04));
                performanceValue.setBounds((int)(composer.getWidth()*0.33), (int)(composer.getHeight()*0.64), (int)(composer.getWidth()*0.09), (int)(composer.getHeight()*0.04));
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

        performanceOption.addItem("Interest");
        performanceOption.addItem("Excitement");
        performanceOption.addItem("Engagement");
        performanceOption.addItem("Stress");
        performanceOption.addItem("Relaxation");
        performanceOption.addItem("Focus");

        clearLog.addActionListener( new ActionListener() {
            /**
             * Clean log
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e)
            {
                console.setText("");
            }


        });

       start.addActionListener(new ActionListener() {
           /**
            * Send message listener
            * @param e
            */
     	   public void actionPerformed(ActionEvent e) {
     	       if (!isSending) {
     	           if (autoResetServer.isSelected()) {
                       start.setText("Stop");
                       isSending = true;
                   }

                   ServerConsole.setMessage("Server Running");
                   Runnable r = () -> {
                       do {
                           Parameters param = gatherData();
                           labelTimeDuration.setText(Double.toString(timeRec));
                           double interval = (double) timeInterval.getValue();
                           timeRec += interval;
                           try {
                               Thread.sleep((long) (interval * 1000));
                               ServerSocket.sendMessage(param);
                           } catch (InterruptedException | IOException | EncodeException e1) {
                               ServerConsole.setErrorMessage(e1.getMessage());
                           }

                           if (autoResetEye.isSelected()) {
                               activateEye.setSelected(false);
                           }

                       } while (autoResetServer.isSelected() && isSending);
                   };

                   Thread th = new Thread(r);
                   th.start();
               } else {
                   timeRec = 0.0;
                   isSending = false;
                   start.setText("Start");
                   ServerConsole.setMessage("Server Stopped");
               }

               Parameters param = gatherData();
               System.out.println(param.getPerformance().getEngagement());
           }

       });

    }
    /**
     * Encapsulate data on the client side in an object.
=======

    /**
     * Collect data from components
     * @return
>>>>>>> 4a4595dd3a5d2f3ae648fd1cda1feeb0f85ed881
     */
    public Parameters gatherData() {
        Eye eye = new Eye();
        LowerFace lf = new LowerFace();
        PerformanceMet pm = new PerformanceMet();
        UpperFace uf = new UpperFace();

        String eo = (String) eyeOption.getSelectedItem();
        String ufo = (String) upperFaceOption.getSelectedItem();
        String lfo = (String) lowerFaceOption.getSelectedItem();
        String pmo = (String) performanceOption.getSelectedItem();
        switch (eo) {
            default:
            case "Blink":
                eye.setBlink(activateEye.isSelected());
                break;
            case "wink left":
                eye.setWinkLeft(activateEye.isSelected());
                break;
            case "wink right":
                eye.setWinkRight(activateEye.isSelected());
                break;
            case "look left":
                eye.setLookLeft(activateEye.isSelected());
                break;
            case "look right":
                eye.setLookRight(activateEye.isSelected());
                break;
        }

        switch (ufo) {
            default:
            case "Raise Brow":
                uf.setRaiseBrow((double) upperFaceValue.getValue());
                break;
            case "Furrow Brow":
                uf.setFurrowBrow((double) upperFaceValue.getValue());
                break;
        }

        switch (lfo) {
            default:
            case "Smile":
                lf.setSmile((double) lowerFaceValue.getValue());
                break;
            case "Clench":
                lf.setClench((double) lowerFaceValue.getValue());
                break;
            case "Smirk Left":
                lf.setSmirkLeft((double) lowerFaceValue.getValue());
                break;
            case "Smirk Right":
                lf.setSmirkRight((double) lowerFaceValue.getValue());
                break;
            case "Laugh":
                lf.setLaugh((double) lowerFaceValue.getValue());
                break;
        }

        switch (pmo) {
            default:
            case "Interest":
                pm.setInterest((double) performanceValue.getValue());
                break;
            case "Excitement":
                pm.setExcitement((double) performanceValue.getValue());
                break;
            case "Engagement":
                pm.setEngagement((double) performanceValue.getValue());
                break;
            case "Stress":
                pm.setStress((double) performanceValue.getValue());
                break;
            case "Relaxation":
                pm.setRelaxation((double) performanceValue.getValue());
                break;
            case "Focus":
                pm.setFocus((double) performanceValue.getValue());
                break;

        }

        return new Parameters(eye, lf, uf, pm, timeRec);
    }

    /**
     * get console log
     * @return
     */
    public static JTextPane getConsole(){
        return console;
    }

}

