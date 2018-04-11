package server.controller;

import server.view.ServerConsole;
import server.view.ServerGUI;
import org.glassfish.tyrus.server.Server;
import javax.websocket.DeploymentException;
/**
 * This class is Server window controller class
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 */

public class ServerWindowController {
    private ServerSocket servSocket = null;
    private static Server server;
    public static boolean isStart;

    /**
     * Init server
     * @param
     */
    public ServerWindowController() {
        isStart = false;
    }

    public static void initServerEndPoint(int port) {
        if (server == null) {
            server = new Server("localhost", port, "/ws", null, ServerSocket.class);
        } else {
            ServerConsole.setMessage("Port already been set!");
        }
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
                if (server == null) {
                    server = new Server("localhost", 8025, "/ws", null, ServerSocket.class);
                }
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
        ServerWindowController ctrl = new ServerWindowController();
    }

}
