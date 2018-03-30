package client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

public class ClientMain {
    public static void main(String[] args) 
        throws DeploymentException, IOException, URISyntaxException, InterruptedException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        ClientController client = ClientController();
        container.connectToServer(client, new URI("localhost:8080"));
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }
        
        client.close();
    }
}