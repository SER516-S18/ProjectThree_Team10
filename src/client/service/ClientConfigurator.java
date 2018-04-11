package client.service;

import javax.websocket.HandshakeResponse;
import javax.websocket.ClientEndpointConfig.Configurator;

import java.util.List;
import java.util.Map;

/**
 * @author Group10
 * @version 1.0
 * ClientConfigurator class 
 */
public class ClientConfigurator extends Configurator {
   
    /**
      * beforeRequest Method
      * @param headers
      */
    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        super.beforeRequest(headers);
    }

    /**
      * afterRequest Method
      * @param handshakeResponse
      */
    @Override
    public void afterResponse(HandshakeResponse handshakeResponse) {
        System.out.println(handshakeResponse);
    }
}
