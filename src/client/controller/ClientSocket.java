package client.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import client.model.Parameters;
import javax.websocket.*;

import org.codehaus.jettison.json.JSONException;

import client.service.*;

@ClientEndpoint (
    configurator=ClientConfigurator.class,
    decoders=JsonDecoder.class
)
public class ClientSocket extends Thread{
    private Logger logger = Logger.getLogger(ClientSocket.class.getName());
    private Session session;
    private ClientWindowController ctrl;
    public static Parameters param;

    static {
        param = new Parameters();
    }
    
    public void setSession(Session session) {
    	this.session = session;
    }

    public ClientSocket(ClientWindowController ctrl) {
    	this.ctrl = ctrl;
    }
    private String address;
    private int port;
    private String context;
    private String page;
    
    public ClientSocket(ClientWindowController ctrl, String address, int port, String context, String page) {
    	this.ctrl = ctrl;
    	this.address = address;
    	this.port = port;
    	this.context = context;
    	this.page = page;
    }

    @OnOpen
    public void open(Session session) {
        logger.info("Client webSocket is opening ...");
        this.session = session;
    }

    @OnMessage
    public void onMessage(Parameters message, Session session) throws JSONException, IOException {
        param.setEye(message.getEye());
        param.setLowerFace(message.getLowerFace());
        param.setUpperFace(message.getUpperFace());
        param.setPerformance(message.getPerformance());
        param.setTime(message.getTime());
        ctrl.update(param);
    }

    @OnClose
    public void onClose() {
        logger.info("WebSocket closed");
    }

    @OnError
    public void onError(Session session, Throwable t) {
    	System.out.println("Error!");
        t.printStackTrace();
    }

    public void close() throws IOException {
        if (this.session != null && this.session.isOpen()) {
            this.session.close();
        }
    }
    
    public void run() {
    	CountDownLatch latch = new CountDownLatch(1);

        ctrl.container = ContainerProvider.getWebSocketContainer();

        String uri = "ws://" + address + ":" + port + "/" + context + "/" + page;

        try {
            session = ctrl.container.connectToServer(this, new URI(uri));
            latch.await();
        } catch (DeploymentException | URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}