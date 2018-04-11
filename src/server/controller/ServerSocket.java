package server.controller;

import server.model.Parameters;
import server.service.JsonEncoder;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@ServerEndpoint(
        value = "/team10",
        encoders = JsonEncoder.class
)
public class ServerSocket {
    private Logger logger = Logger.getLogger(ServerSocket.class.getSimpleName());
    public static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void open(Session session) {
        System.out.println("server open");
        logger.info("Server Web socket is opening");
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Receive message:");
        System.out.println(message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Server close");
        logger.info("Server web socket is closing");
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println(t.getMessage());
        logger.info(t.getMessage());
    }

    public static boolean sendMessage(Parameters param) throws IOException, EncodeException {
        if (sessions.isEmpty()) {
            return false;
        }

        for (Session session : sessions) {
            session.getBasicRemote().sendObject(param);
        }

        return true;
    }

}
