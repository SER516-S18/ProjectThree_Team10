package client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import client.controller.*;
import client.model.Parameters;
import org.glassfish.tyrus.client.ClientManager;

public class ClientMain {
    public static void main(String[] args) throws Exception {
        ClientManager client = ClientManager.createClient();

        // connect to server
        Session session = client.connectToServer(ClientController.class, new URI("ws://localhost:8080/ws/chat"));
        // repeatedly read a message and send it to the server (until quit)
        session.getBasicRemote().sendObject(new Parameters(0.5, 0.5, 0.5, 0.5, 0.5, 0.5, false, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5));
    }
}