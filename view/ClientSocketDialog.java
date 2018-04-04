package client.view;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.controller.ClientWindowController;

public class ClientSocketDialog {
	public ClientSocketDialog(ClientWindowController ctrl) {
		JTextField xField = new JTextField(14);
		JTextField yField = new JTextField(5);
		
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Address:"));
		myPanel.add(xField);
		myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		myPanel.add(new JLabel("Port:"));
		myPanel.add(yField);
		
		int output = JOptionPane.showConfirmDialog(null, myPanel, 
				"Please Enter Server Address or Port",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (output == JOptionPane.OK_OPTION) {
			ctrl.createSocket(xField.getText(), Integer.parseInt(yField.getText()));
		}
	}
}
