package client.view;

import client.controller.ClientWindowController;

public class ServerTrigger {
    public ServerTrigger(ClientWindowController ctrl){
        Runtime runtime = Runtime.getRuntime();
        try {
            Process server = runtime.exec("java -jar lib/server.jar");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
