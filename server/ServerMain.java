package server;

import java.util.Scanner;
import client.model.Parameters;

import javax.websocket.*;

public class ServerMain {
    public static void main(String[] args) {
        ChatEndPoint cep = new ChatEndPoint();
        org.glassfish.tyrus.server.Server server =
                new org.glassfish.tyrus.server.Server("localhost", 8080, "/ws", null, ChatEndPoint.class);
        try {
            server.start();
            Parameters p = new Parameters(0.25, 0.5, 0.5, 0.5, 0.5, 0.5, false, 0.5, 0.5, 0.5, 0.5, 0.5, 0.5);
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
        
    }
}
