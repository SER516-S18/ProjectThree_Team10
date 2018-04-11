package client.controller;

import java.io.IOException;

import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import java.net.URISyntaxException;

import client.model.Parameters;
import client.view.ClientWindowView;

public class ClientWindowController {
	private ClientWindowView view;
	public WebSocketContainer container;
	public ClientSocket clientSocket = null;

	public ClientWindowController(ClientWindowView view) {
		this.view = view;
	}

	public void createSocket(String address, int port, String context, String page) {
        clientSocket = new ClientSocket(this, address, port, context, page);
        clientSocket.start();
	}
	
	public void update(Parameters param) {
		view.update(param);
	}

	public void setStatus(int status, double time) {
		view.setStatus(status, time);
	}
	
	public ClientSocket getSocket() {
		return clientSocket;
	}
	
	public static void main(String args[]) throws URISyntaxException, IOException, DeploymentException {
		ClientWindowView view = new ClientWindowView();
		ClientWindowController ctrl = new ClientWindowController(view);
		view.bindController(ctrl);
	}
}
