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
        double test = 0.0;
        double smile = 1.0;
        LowerFace lf = new LowerFace(smile, 0.0, 0.0, 0.0, 0.0);
        Parameters p = new Parameters();
        p.setEye(new Eye(false, true, false, false, false));
        p.setLowerFace(lf);
        p.setPerformance(new PerformanceMet(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        p.setTime(test);
        p.setUpperFace(new UpperFace(0.0, 0.0));
        String ss;
        do {
            ss = new Scanner(System.in).nextLine();
            ServerSocket.sendMessage(p);
            test+=0.25;
            smile-=0.1;
            p.setTime(test);
            lf.setSmile(smile);
        } while(!ss.equals("q"));

        server.stop();
    }
}
