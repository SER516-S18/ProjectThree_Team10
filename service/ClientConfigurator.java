package client.service;

import javax.websocket.HandshakeResponse;
import javax.websocket.ClientEndpointConfig.Configurator;

import java.util.List;
import java.util.Map;

public class ClientConfigurator extends Configurator {
    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        super.beforeRequest(headers);
    }

    @Override
    public void afterResponse(HandshakeResponse handshakeResponse) {
        System.out.println(handshakeResponse);
    }
}