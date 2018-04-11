package client.service;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import org.codehaus.jettison.json.*;

import client.model.Eye;
import client.model.LowerFace;
import client.model.PerformanceMet;
import client.model.UpperFace;
import client.model.Parameters;

/**
 * @author Group10
 * @version 1.0
 * JsonDecoder class 
 */
public class JsonDecoder implements Decoder.Text<Parameters> {
    
    /**
      * init Method to init when load to webSocket
      * @param config
      */
    public void init(EndpointConfig config) {
       
    }
    
    /**
      * destroy Method to destroy when unload from webSocket
      */
    public void destroy() {
        
    }
    
    /**
      * Parameters decode Method
      * @param jsonString
      */
    public Parameters decode(String jsonString) throws DecodeException {
        Parameters params = null;
        try {
            JSONObject jo = new JSONObject(jsonString);
            JSONObject jEye = jo.getJSONObject("eye");
            JSONObject jLowerFace = jo.getJSONObject("lower_face");
            JSONObject jPerformanceMet = jo.getJSONObject("performance_met");
            JSONObject jUpperFace = jo.getJSONObject("upper_face");

            Eye eye = new Eye(jEye.getBoolean("blink"), jEye.getBoolean("wink_left"),
                                jEye.getBoolean("wink_right"), jEye.getBoolean("look_left"),
                                jEye.getBoolean("look_right"));
            LowerFace lowerFace = new LowerFace(jLowerFace.getDouble("smile"), jLowerFace.getDouble("clench"),
                                                jLowerFace.getDouble("smirk_left"), jLowerFace.getDouble("smirk_right"),
                                                jLowerFace.getDouble("laugh"));

            PerformanceMet performanceMet = new PerformanceMet(jPerformanceMet.getDouble("interest"), jPerformanceMet.getDouble("engagement"),
                                                                jPerformanceMet.getDouble("stress"), jPerformanceMet.getDouble("relaxation"),
                                                                jPerformanceMet.getDouble("excitement"), jPerformanceMet.getDouble("focus"));
            UpperFace upperFace = new UpperFace(jUpperFace.getDouble("raise_brow"), jUpperFace.getDouble("furrow_brow"));
            params = new Parameters(eye, lowerFace, upperFace, performanceMet, jo.getDouble("time"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return params;
    }
    /**
      * willDecode Method
      * @param jsonString
      */
    public boolean willDecode(String jsonString) {
        // Called before decode
        return true;
    }
    
}
