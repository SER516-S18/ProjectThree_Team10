package server.controller;

import server.view.ServerConsole;
import server.view.ServerGUI;
import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;

public class ServerWindowController {
    private ServerSocket servSocket = null;
    private static Server server;
    public static boolean isStart;

    /**
     * Init server
     * @param view
     */
    public ServerWindowController(ServerGUI view) {
        server = new Server("localhost", 8025, "/ws", null, ServerSocket.class);
        isStart = false;
    }

    public void initServerEndPoint(int port) {
        if (server != null) {
            server.stop();
        }

        server = new Server("localhost", port, "/ws", null, ServerSocket.class);
    }

    /**
     * Change the listen status
     */
    public static void changeStatus() {
        if (isStart) {
            server.stop();
            ServerConsole.setMessage("Stop Listening");
            isStart = false;
        } else {
            try {
                server.start();
                ServerConsole.setMessage("Start Listening");
                isStart = true;
            } catch (DeploymentException e1) {
                ServerConsole.setErrorMessage(e1.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ServerGUI view = new ServerGUI();
        ServerWindowController ctrl = new ServerWindowController(view);
    }

}
