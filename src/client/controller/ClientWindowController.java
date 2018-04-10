package client.controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.glassfish.tyrus.client.ClientManager;

import java.net.URI;
import java.net.URISyntaxException;


import client.model.Eye;
import client.model.LowerFace;

import client.model.Parameters;
import client.model.PerformanceMet;
import client.model.UpperFace;
import client.view.ClientWindowView;

public class ClientWindowController {
	private ClientWindowView view;
	private ClientSocket socketCtrl;
	private ClientSocket clientSocket = null;
	
	public ClientWindowController() {
		view = new ClientWindowView();
	}
	
	public ClientWindowController(ClientWindowView view) {
		this.view = view;
	}
	
	public void createSocket(String address, int port, String context, String page) {
		CountDownLatch latch = new CountDownLatch(1);

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        ClientSocket clientSocket = new ClientSocket(this);

        String uri = "ws://" + address + ":" + port + "/" + context + "/" + page;

        try {
            container.connectToServer(clientSocket, new URI(uri));
            latch.await();
        } catch (DeploymentException | URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

	}
	
	public void update(Parameters param) {
		// TODO: need to change to MVC
		view.update(param);
	}

	public ClientSocket getSocket() {
		return clientSocket;
	}
	
	public static void main(String args[]) throws URISyntaxException, IOException, DeploymentException {
		ClientWindowView view = new ClientWindowView();
		ClientWindowController ctrl = new ClientWindowController(view);
		view.bindController(ctrl);
		Eye eye = new Eye(false, true, true, false, true);
		LowerFace lowerFace = new LowerFace(1.0, 0.0, 0.0, 0.5, 0.5);
		UpperFace upperFace = new UpperFace(0.0, 1.0);
		PerformanceMet performanceMet = new PerformanceMet(1.0, 1.0, 1.0, 1.0, 1.0, 1.0);
		double time = 1.0;
		Parameters param = new Parameters(eye, lowerFace, upperFace, performanceMet, time);
		ctrl.update(param);
	}
}
