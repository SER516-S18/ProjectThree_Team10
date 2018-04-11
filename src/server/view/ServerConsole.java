package server.view;
import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;

import server.view.ServerGUI;

/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 * To Print and display messages in console
 */

@SuppressWarnings("serial")
public class ServerConsole extends JTextPane{
	static JTextPane console = ServerGUI.getConsole();

	/**
	 * set Error message
	 * @param error
	 */
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

	/**
	 * set info message
	 * @param message
	 */
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
