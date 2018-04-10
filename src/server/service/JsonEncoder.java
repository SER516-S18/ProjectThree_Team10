package server.service;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import org.codehaus.jettison.json.*;

import server.model.Parameters;

public class JsonEncoder implements Encoder.Text<Parameters> {
    public void init(EndpointConfig config) {
        // init when load to webSocket
    }

    public void destroy() {
        // destory when unload from webSocket
    }

    @Override
    public String encode(Parameters object) {
        JSONObject paramJson = new JSONObject();
        JSONObject eyeJson = new JSONObject();
        JSONObject lowerFaceJSON = new JSONObject();
        JSONObject upperFaceJSON = new JSONObject();
        JSONObject performanceJOSN = new JSONObject();
        try {
            eyeJson.put("blink", object.getEye().getBlink());
            eyeJson.put("wink_left", object.getEye().getWinkLeft());
            eyeJson.put("wink_right", object.getEye().getWinkRight());
            eyeJson.put("look_left", object.getEye().getLookLeft());
            eyeJson.put("look_right", object.getEye().getLookRight());

            lowerFaceJSON.put("smile", object.getLowerFace().getSmile());
            lowerFaceJSON.put("clench", object.getLowerFace().getClench());
            lowerFaceJSON.put("smirk_left", object.getLowerFace().getSmirkLeft());
            lowerFaceJSON.put("smirk_right", object.getLowerFace().getSmirkRight());
            lowerFaceJSON.put("laugh", object.getLowerFace().getLaugh());

            performanceJOSN.put("interest", object.getPerformance().getInterest());
            performanceJOSN.put("engagement", object.getPerformance().getEngagement());
            performanceJOSN.put("stress", object.getPerformance().getStress());
            performanceJOSN.put("relaxation", object.getPerformance().getRelaxation());
            performanceJOSN.put("excitement", object.getPerformance().getExcitement());
            performanceJOSN.put("focus", object.getPerformance().getFocus());

            upperFaceJSON.put("raise_brow", object.getUpperFace().getRaiseBrow());
            upperFaceJSON.put("furrow_brow", object.getUpperFace().getFurrowBrow());

            paramJson.put("eye", eyeJson);
            paramJson.put("lower_face", lowerFaceJSON);
            paramJson.put("upper_face", upperFaceJSON);
            paramJson.put("performance_met", performanceJOSN);
            paramJson.put("time", object.getTime());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return paramJson.toString();
    }
}
