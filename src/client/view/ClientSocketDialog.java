package client.view;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.ClientWindowController;
import client.service.MessageBox;

/**
 * @author Group10
 * This class is to generate a client dialog to setup socket connection
 */
public class ClientSocketDialog {
	/**
	 * Constructor of the client socket dialog
	 * @param ctrl controller of the client window
	 */
	public ClientSocketDialog(ClientWindowController ctrl) {
		JTextField xField = new JTextField(14);
		JTextField yField = new JTextField(5);
		
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Address:"));
		myPanel.add(xField);
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		myPanel.add(new JLabel("Port:"));
		myPanel.add(yField);
		
		//open a plain message panel
		int output = JOptionPane.showConfirmDialog(null, myPanel, 
				"Please Enter Server Address and Port",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (output == JOptionPane.OK_OPTION) {
			if (ctrl.getSocket()==null) {
				ctrl.createSocket(xField.getText(), Integer.parseInt(yField.getText()), "ws", "team10");		
			} else {
				MessageBox msgBox = new MessageBox();
				msgBox.windowPop("Socket has already been started!");
			}
		}		
	}
}
