package server.controller;

import org.glassfish.tyrus.server.Server;
import server.model.*;

import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.util.Scanner;

public class ServerWindowController  {

    public ServerWindowController() {
    }


    public static void main(String[] args) throws IOException, EncodeException {
        Server server = new Server("localhost", 8025, "/ws", null, ServerSocket.class);

        try {
            server.start();
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
        Parameters p = new Parameters();
        p.setEye(new Eye(false, true, false, false, false));
        p.setLowerFace(new LowerFace(0.8, 0.0, 0.0, 0.0, 0.0));
        p.setPerformance(new PerformanceMet(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        p.setTime(0.0);
        p.setUpperFace(new UpperFace(0.0, 0.0));
        String ss;
        do {
            ss = new Scanner(System.in).nextLine();
            ServerSocket.sendMessage(p);
        } while(!ss.equals("q"));

        server.stop();
    }
}
