package client.service;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import org.codehaus.jettison.json.*;

import client.model.Parameters;

public class JsonDecoder implements Decoder.Text<Parameters> {
    public void init(EndpointConfig config) {
        // init when load to webSocket
    }

    public void destroy() {
        // destory when unload from webSocket
    }

    public Parameters decode(String jsonString) throws DecodeException {
        Parameters params = null;
        try {
            JSONObject jo = new JSONObject(jsonString);
            params = new Parameters(jo.getDouble("time"),
                                            jo.getDouble("neutral"),
                                            jo.getDouble("push_skill"),
                                            jo.getDouble("overall_skill"),
                                            jo.getDouble("raise_brow"),
                                            jo.getDouble("smile"),
                                            jo.getBoolean("blink"),
                                            jo.getDouble("interest"),
                                            jo.getDouble("engagement"),
                                            jo.getDouble("stress"),
                                            jo.getDouble("relaxation"),
                                            jo.getDouble("excitement"),
                                            jo.getDouble("focus"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return params;
    }
    
    public boolean willDecode(String jsonString) {
        // Called before decode
        return true;
    }
    
}
