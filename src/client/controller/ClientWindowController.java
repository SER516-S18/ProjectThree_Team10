package client.controller;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import javax.websocket.DeploymentException;

import org.glassfish.tyrus.client.ClientManager;

import java.net.URI;
import java.net.URISyntaxException;

import client.model.ClientWindowModel;
import client.model.Parameters;
import client.view.ClientWindowView;

public class ClientWindowController {
	private ClientWindowView view;
	private ClientWindowModel model;
	private ClientSocket socketCtrl;
	
	public ClientWindowController() {
		model = new ClientWindowModel();
		view = new ClientWindowView();
	}
	
	public ClientWindowController(ClientWindowView view, ClientWindowModel model) {
		this.view = view;
		this.model = model;
	}
	
	public void createSocket(String address, int port) {
		CountDownLatch latch = new CountDownLatch(1);
		 
        ClientManager client = ClientManager.createClient();
        
        ClientSocket clientSocket = new ClientSocket(this);
        
        String uri = "ws://"+address+":"+port;
        try {
            client.connectToServer(clientSocket, new URI(uri));
            latch.await();
 
        } catch (DeploymentException | URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void update(Parameters param) {
		// TODO: need to change to MVC
		view.update(param);
	}
	
	public static void main(String args[]) {
		ClientWindowView view = new ClientWindowView();
		ClientWindowModel model = new ClientWindowModel();
		ClientWindowController ctrl = new ClientWindowController(view, model);
		view.bindController(ctrl);
	}
}
