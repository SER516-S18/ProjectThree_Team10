package client.controller;

import java.awt.Dimension;

import javax.swing.JPanel;
import client.service.ColorConstants;
import client.service.TextConstants;
import client.view.LoadImage;

public class FacePanel {

	private static JPanel facePanel = null;
	private static Dimension max;
	
	public static JPanel getPanel() {
		if(facePanel == null) {
			max = new Dimension(400,400);
			facePanel = new JPanel();
			facePanel.setMaximumSize(max);
			facePanel.setBackground(ColorConstants.FACE_BACKGROUND);
			LoadImage.load(facePanel, TextConstants.UPPER_NORMAL, TextConstants.LOWER_NORMAL);
			return facePanel;
		}
		return facePanel;
	}
	
}
