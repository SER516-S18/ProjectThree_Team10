package client.view;

import client.controller.ClientWindowController;
/**
 * This class is ServerTrigger Class
 *
 * @SER516  Project Three
 * @author  Group 10  #118 - #131
 * @version 1.0
 * @since   04/03/2018
 */
public class ServerTrigger {
    
    /**
      * Constructor for ServerTrigger class
      * @param ctrl
      */
    public ServerTrigger(ClientWindowController ctrl){
        Runtime runtime = Runtime.getRuntime();
        try {
            Process server = runtime.exec("java -cp executable.jar server.controller.ServerWindowController");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
