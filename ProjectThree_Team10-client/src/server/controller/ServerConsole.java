package server.controller;
import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;

import server.view.ServerGUI;

/**
 * @SER516 ProjecThree_Team10
 * @author Hari Siddarth V Kesavan
 * @version 1.0
 * To print messages and errors on log in server GUI
*/

@SuppressWarnings("serial")
public class ServerConsole extends JTextPane{
	static JTextPane console = ServerGUI.getConsole();
	public static void setErrorMessage(String error) {
		try {
			console.setContentType( "text/html" );
			HTMLDocument doc=(HTMLDocument) console.getDocument();
            doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()),
               "[ " + new Date() +  " ] " + "<span style=\"color:red\">"  
                + error + "</span> <br>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setMessage(String message) {
		try {
			console.setContentType( "text/html" );
			HTMLDocument doc=(HTMLDocument) console.getDocument();
			doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()), 
			  "[ " +  new Date() + " ] " + "<span style=\"color:black\">" 
			   + message + "</span> <br>");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}