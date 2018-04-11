package client.controller;

import java.io.IOException;

import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import java.net.URISyntaxException;

import client.model.Parameters;
import client.view.ClientWindowView;

/**
 * This class is the controller of the client window
 * @author Group10
 * @version 1.0
 */
public class ClientWindowController {
	private ClientWindowView view;
	public WebSocketContainer container;
	public ClientSocket clientSocket = null;

	public ClientWindowController(ClientWindowView view) {
		this.view = view;
	}

	/**
	 * Function to create a socket thread based on address and ports
	 * @param address
	 * @param port
	 * @param context
	 * @param page
	 */
	public void createSocket(String address, int port, String context, String page) {
        clientSocket = new ClientSocket(this, address, port, context, page);
        clientSocket.start();
	}
	
	/**
	 * Update the parameters in the view
	 * @param param
	 */
	public void update(Parameters param) {
		view.update(param);
	}

	/**
	 * Set the correct status of the status panel
	 * @param status
	 * @param time
	 */
	public void setStatus(int status, double time) {
		view.setStatus(status, time);
	}
	
	/**
	 * Get the current socket instance
	 * @return ClientSocket
	 */
	public ClientSocket getSocket() {
		return clientSocket;
	}
	
	public static void main(String args[]) throws URISyntaxException, IOException, DeploymentException {
		ClientWindowView view = new ClientWindowView();
		ClientWindowController ctrl = new ClientWindowController(view);
		view.bindController(ctrl);
	}
}
