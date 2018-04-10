package client.view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.service.TextConstants;

public class LoadImage {
	public static Image getImage(String path) {
//		System.out.println(path);
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(TextConstants.IMAGE_PATH + path + TextConstants.IMAGE_TYPE);
		try {
			File imagePath = new File(TextConstants.IMAGE_PATH + path + TextConstants.IMAGE_TYPE);
			BufferedImage image = ImageIO.read(imagePath);
			return image;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void load(JPanel facePanel, String upperPath, String lowerPath) {
		Image scaledUpper = getImage(upperPath).getScaledInstance(320,245,Image.SCALE_SMOOTH);
		Image scaledLower = getImage(lowerPath).getScaledInstance(320,180,Image.SCALE_SMOOTH);
		JLabel upperLabel = new JLabel(new ImageIcon(scaledUpper));
		JLabel lowerLabel = new JLabel(new ImageIcon(scaledLower));
		
		JPanel newFacePanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		
		newFacePanel.add(upperLabel,c);
		
		c.gridy = 1;
		newFacePanel.add(lowerLabel,c);
		
		facePanel.removeAll();
		facePanel.add(newFacePanel);
		facePanel.validate();
	}

}
