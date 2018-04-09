package server.service;


import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import org.codehaus.jettison.json.*;

import server.model.Eye;
import server.model.LowerFace;
import server.model.Parameters;
import server.model.UpperFace;
import server.model.hashvalues;

public class JSONEncoder implements Encoder.Text<Parameters> {
    public void init(EndpointConfig config) {
        // init when load to webSocket
    }

    public void destroy() {
        // destory when unload from webSocket
    }


    
    public boolean willDecode(String jsonString) {
        // Called before decode
        return true;
    }


	public String encode(Eye eye, LowerFace lowerFace, UpperFace upperFace ) throws EncodeException {
		JSONObject jo = new JSONObject();
		try {
            
            jo.put("Eyes", hashvalues.geteye());
            jo.put("lowerFace", hashvalues.getLf());
            jo.put("upperFace", hashvalues.getUf());
            jo.put("PerformanceMet", hashvalues.getPm());

           
        } catch (Exception e) {
            e.printStackTrace();
        }
		 return jo.toString();
	}


    
}
