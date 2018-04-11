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
/**
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 * Controller class for server socket 
 */

@ServerEndpoint(
        value = "/team10",
        encoders = JsonEncoder.class
)
public class ServerSocket {
    private Logger logger = Logger.getLogger(ServerSocket.class.getSimpleName());
    public static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    /**
     * Call when session opens
     * @param session
     */
    @OnOpen
    public void open(Session session) {
        System.out.println("server open");
        logger.info("Server Web socket is opening");
        sessions.add(session);
    }

    /**
     * Call when receive msg
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Receive message:");
        System.out.println(message);
    }

    /**
     * Call when session close
     * @param session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("Server close");
        logger.info("Server web socket is closing");
        sessions.remove(session);
    }

    /**
     * Call when meet msg
     * @param t
     */
    @OnError
    public void onError(Throwable t) {
        System.out.println(t.getMessage());
        logger.info(t.getMessage());
    }

    /**
     * Send Message to client
     * @param param
     * @return
     * @throws IOException
     * @throws EncodeException
     */
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
