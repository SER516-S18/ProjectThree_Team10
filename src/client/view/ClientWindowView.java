package client.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import client.controller.ClientWindowController;
import client.model.Parameters;
import client.view.FacialPanel;

public class ClientWindowView extends JFrame {
	private ClientWindowController ctrl;
	private FacialPanel facialPanel;
	private PlotPanel plotPanel;
	private PerformancePanel performPanel;
	
	// create and initialize the menu bar of the window
	public void initMenu() {
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		//Create the menu bar.
		menuBar = new JMenuBar();
		
		//Build Server menu.
		menu = new JMenu("Server");
		menu.setMnemonic(KeyEvent.VK_V);
		menu.getAccessibleContext().setAccessibleDescription(
				"The server menu in this window");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Open Server", KeyEvent.VK_O);
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent event) {
             	ServerGUI serverGUI = new ServerGUI(ctrl);
				// TODO: Open the server
            }
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_O, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open server");
		menu.add(menuItem);
		
		//Build the Connection menu.
		menu = new JMenu("Connetion");
		menu.setMnemonic(KeyEvent.VK_C);
		menu.getAccessibleContext().setAccessibleDescription(
				"The connection menu in this window");
		menuBar.add(menu);
		
		//a group of JMenuItems
		menuItem = new JMenuItem("Settings",
				KeyEvent.VK_S);
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				ClientSocketDialog clientSocketDialog = new ClientSocketDialog(ctrl);
				//TODO: call the connection setting dialog
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_S, ActionEvent.ALT_MASK));
		// TODO: Add hot key listener
		menuItem.getAccessibleContext().setAccessibleDescription(
				"Open dialog of connection settins");
		menu.add(menuItem);
		
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(menu);
		
		menuItem = new JMenuItem("About Program", KeyEvent.VK_A);
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {
				JOptionPane.showMessageDialog(null,
						"Project 3 Team 10",
						"About Program",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu.add(menuItem);
		
		this.setJMenuBar(menuBar);
	}
	
	public void initTabs() {
		JTabbedPane myTabPane = new JTabbedPane();
		JPanel facialExpressionPanel = new JPanel();
		performPanel = new PerformancePanel("Performance");
		myTabPane.addTab("Facial Expressions", facialExpressionPanel);
		myTabPane.addTab("Performance Metrics", performPanel);

		facialPanel = new FacialPanel();
		plotPanel = new PlotPanel();
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                facialPanel, plotPanel);
		splitPane.setResizeWeight(.5d);
		facialExpressionPanel.setLayout(new BorderLayout());
		facialExpressionPanel.add(splitPane);
		
		this.add(myTabPane, BorderLayout.CENTER);
	}
	
	public ClientWindowView() {
		setTitle("Lab3 Team 10 Control Panel");
		setSize(800, 600);
		setLocationByPlatform(true);
		setLayout(new BorderLayout());
		initMenu();
		initTabs();
		setVisible(true);
	}
	
	public void bindController(ClientWindowController controller) {
		this.ctrl = controller;
	}
	
	public void update(Parameters param) {
		facialPanel.setData(param);
		plotPanel.add(param);
		performPanel.add(param);
	}
}
