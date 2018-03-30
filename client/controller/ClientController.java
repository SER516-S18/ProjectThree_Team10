package client.controller;

import java.io.IOException;
import java.util.logging.Logger;
import client.model.Parameters;
import javax.websocket.*;

@ClientEndpoint (
    configurator=client.service.CilentConfigurator.class,
    decoders={client.service.JsonDecoder.class},
    encoders={client.service.JsonEncoder.class},
    subprotocols={"subprotocol1"}
)
public class ClientController {
    private Logger logger = Logger.getLogger(ClientController.class.getName());
    private Session session;

    @OnOpen
    public void open(Session session) {
        logger.info("Client webSocket is opening ...");
        this.session = session;
    }

    @OnMessage
    public void onMessage(Parameters message) {
        logger.info("Server send message - " + message.getTime());
    }

    @OnClose
    public void onClose() {
        logger.info("WebSocket closed");
    }

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }

    public void send(Parameters message) {
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