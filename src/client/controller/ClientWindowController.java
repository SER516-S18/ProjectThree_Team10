package client.controller;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.concurrent.CountDownLatch;

import javax.websocket.DeploymentException;

import org.glassfish.tyrus.client.ClientManager;

import java.net.URI;
import java.net.URISyntaxException;

import client.model.ClientWindowModel;
import client.model.Eye;
import client.model.LowerFace;
import client.model.MentalCmd;
import client.model.Parameters;
import client.model.PerformanceMet;
import client.model.UpperFace;
import client.view.ClientWindowView;

public class ClientWindowController {
	private ClientWindowView view;
	private ClientWindowModel model;
	private ClientSocket socketCtrl;
	private ClientSocket clientSocket = null;
	
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
        
        clientSocket = new ClientSocket(this);
        
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
		view.update(param);;
	}

	public ClientSocket getSocket() {
		return clientSocket;
	}
	
	public static void main(String args[]) {
		ClientWindowView view = new ClientWindowView();
		ClientWindowModel model = new ClientWindowModel();
		ClientWindowController ctrl = new ClientWindowController(view, model);
		view.bindController(ctrl);
		Eye eye = new Eye(false, true, true, false, true);
		LowerFace lowerFace = new LowerFace(1.0, 0.0, 0.0, 0.5, 0.5);
		UpperFace upperFace = new UpperFace(0.0, 1.0);
		MentalCmd mentalCmd = new MentalCmd(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		PerformanceMet performanceMet = new PerformanceMet(1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		double time = 1.0;
		Parameters param = new Parameters(eye, lowerFace, upperFace, mentalCmd, performanceMet, time);
		ctrl.update(param);
	}
}
