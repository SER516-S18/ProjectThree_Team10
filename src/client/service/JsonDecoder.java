package client.service;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import org.codehaus.jettison.json.*;

import client.model.Eye;
import client.model.LowerFace;
import client.model.MentalCmd;
import client.model.PerformanceMet;
import client.model.UpperFace;
import client.model.Parameters;

public class JsonDecoder implements Decoder.Text<Parameters> {
    public void init(EndpointConfig config) {
        // init when load to webSocket
    }

    public void destroy() {
        // destroy when unload from webSocket
    }

    public Parameters decode(String jsonString) throws DecodeException {
        Parameters params = null;
        try {
            JSONObject jo = new JSONObject(jsonString);
            JSONObject jEye = jo.getJSONObject("eye");
            JSONObject jLowerFace = jo.getJSONObject("lower_face");
            JSONObject jMentalCmd = jo.getJSONObject("mental_cmd");
            JSONObject jPerformanceMet = jo.getJSONObject("performance_met");
            JSONObject jUpperFace = jo.getJSONObject("upper_face");

            Eye eye = new Eye(jEye.getBoolean("blink"), jEye.getBoolean("wink_left"),
                                jEye.getBoolean("wink_right"), jEye.getBoolean("look_left"),
                                jEye.getBoolean("look_right"));
            LowerFace lowerFace = new LowerFace(jLowerFace.getDouble("smile"), jLowerFace.getDouble("clench"),
                                                jLowerFace.getDouble("smirk_left"), jLowerFace.getDouble("smirk_right"),
                                                jLowerFace.getDouble("laugh"));
            MentalCmd mentalCmd = new MentalCmd(jMentalCmd.getDouble("neutral"), jMentalCmd.getDouble("push"),
                                                jMentalCmd.getDouble("pull"), jMentalCmd.getDouble("lift"),
                                                jMentalCmd.getDouble("drop"), jMentalCmd.getDouble("left"),
                                                jMentalCmd.getDouble("right"), jMentalCmd.getDouble("rotate_left"),
                                                jMentalCmd.getDouble("rotate_right"), jMentalCmd.getDouble("rotate_clockwise"),
                                                jMentalCmd.getDouble("rotate_counter_clockwise"),
                                                jMentalCmd.getDouble("rotate_forward"), jMentalCmd.getDouble("rotate_reverse"),
                                                jMentalCmd.getDouble("rotate_disappear"), jMentalCmd.getDouble("push_skill"),
                                                jMentalCmd.getDouble("overall_skill"));
            PerformanceMet performanceMet = new PerformanceMet(jPerformanceMet.getDouble("interest"), jPerformanceMet.getDouble("engagement"),
                                                                jPerformanceMet.getDouble("stress"), jPerformanceMet.getDouble("relaxation"),
                                                                jPerformanceMet.getDouble("excitement"), jPerformanceMet.getDouble("focus"));
            UpperFace upperFace = new UpperFace(jUpperFace.getDouble("raise_brow"), jUpperFace.getDouble("furrow_brow"));
            params = new Parameters(eye, lowerFace, upperFace, mentalCmd, performanceMet, jo.getDouble("time"));
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
