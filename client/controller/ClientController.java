package client.controller;

import java.io.IOException;
import java.util.logging.Logger;
import client.model.Parameters;
import javax.websocket.*;
import client.service.*;

@ClientEndpoint (
    configurator=ClientConfigurator.class,
    decoders=JsonDecoder.class
)
public class ClientController {
    private Logger logger = Logger.getLogger(ClientController.class.getName());
    private Session session;
    public static Parameters param;

    static {
        param = new Parameters();
    }

    @OnOpen
    public void open(Session session) {
        logger.info("Client webSocket is opening ...");
        this.session = session;
    }

    @OnMessage
    public void onMessage(Parameters message) {
        param.setEye(message.getEye());
        param.setLowerFace(message.getLowerFace());
        param.setUpperFace(message.getUpperFace());
        param.setMentalCmd(message.getMentalCmd());
        param.setPerformance(message.getPerformance());
        param.setTime(message.getTime());
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