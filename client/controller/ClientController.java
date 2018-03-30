package client.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.*;

@ClientEndpoint
public class ClientController {
    private Logger logger = Logger.getLogger(ClientController.class.getName());
    private Session session;

    @OnOpen
    public void open(Session session) {
        logger.info("Client webSocket is opening ...");
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        logger.info("Server send message");

    }

    @OnClose
    public void onClose() {
        logger.info("WebSocket closed");
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

    public void send(String message) {
        if (session == null) {
            // No connection found error.
        }

        this.session.getAsyncRemote().sendObject(message);
    }

    public void close() throws IOException {
        if (this.session != null && this.session.isOpen()) {
            this.session.close();
        }
    }
}