package server;

import client.model.Parameters;

import java.io.IOException;

import javax.websocket.*;
import javax.websocket.server.*;

@ServerEndpoint(
    value="/chat",
    decoders = client.service.JsonDecoder.class, 
    encoders = client.service.JsonEncoder.class)
public class ChatEndPoint {
    private Session session;
 
    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
    }
 
    @OnMessage
    public void onMessage(Session session, Parameters message) 
      throws IOException {
        System.out.println(message.getTime());
    }
 
    @OnClose
    public void onClose(Session session) throws IOException {
        
    }
 
    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }
 
    public void send(Parameters message)
        throws IOException, EncodeException {
        session.getAsyncRemote().sendObject(message);
    }

}
