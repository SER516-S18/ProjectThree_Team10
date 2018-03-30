package client.service;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import org.codehaus.jettison.json.*;

public class JsonEncoder implements Encoder.Text<Parameters> {
    public void init(EndpointConfig config) {
        // init encoder when load to webSocket
    }

    public void destory() {
        // destory something when unload from webSocket
    }

    public String encode(Parameters params) throws EncodeException {
        JSONObject jo = new JSONObject();
        jo.put("time", params.getTime());
        jo.put("neutral", params.getNeutral());
        jo.put("push_skill", params.getPushSkill());
        jo.put("overall_skill", params.getOverallSkill());
        jo.put("raise_brow", params.getRaiseBrow());
        jo.put("smile", params.getSmile());
        jo.put("blink", params.getBlink());
        jo.put("interest", params.getBlink());
        jo.put("engagement", params.getEngagement());
        jo.put("stress", params.getStress());
        jo.put("relaxation", params.getRelaxation());
        jo.put("excitement", params.getExcitement());
        jo.put("focus", params.getFocus());

        return jo.toString();
    }

}
