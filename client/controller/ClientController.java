package client.controller;

import java.io.IOException;
import java.util.logging.Logger;
import client.model.Parameters;
import javax.websocket.*;
import client.service.*;

@ClientEndpoint (
    configurator=ClientConfigurator.class,
    decoders=JsonDecoder.class,
    encoders=JsonEncoder.class,
    subprotocols={"subprotocol1"}
)
public class ClientController {
    private Logger logger = Logger.getLogger(ClientController.class.getName());
    private Session session;
    public static Parameters param;

    static {
        param = new Parameters(0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    @OnOpen
    public void open(Session session) {
        logger.info("Client webSocket is opening ...");
        this.session = session;
    }

    @OnMessage
    public void onMessage(Parameters message) {
        param.setTime(message.getTime());
        param.setNeutral(message.getNeutral());
        param.setPushSkill(message.getPushSkill());
        param.setOverallSkill(message.getOverallSkill());
        param.setRaiseBrow(message.getRaiseBrow());
        param.setSmile(message.getSmile());
        param.setBlink(message.getBlink());
        param.setInterest(message.getInterest());
        param.setEngagement(message.getEngagement());
        param.setStress(message.getStress());
        param.setRelaxation(message.getRelaxation());
        param.setExcitement(message.getExcitement());
        param.setFocus(message.getFocus());
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