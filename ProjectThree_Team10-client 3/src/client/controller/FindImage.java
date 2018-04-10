package client.controller;

import client.model.Parameters;
import client.service.TextConstants;

public class FindImage {

	public static String findLowerFace(Parameters params) {
		if(params.getLowerFace().getSmile() > 0.5) {
			return TextConstants.SMILE;
		}
		else if(params.getLowerFace().getClench() > 0) {
			return TextConstants.CLENCH;
		}
		else if(params.getLowerFace().getSmirkLeft() > 0) {
			return TextConstants.SMIRK_LEFT;
		}
		else if(params.getLowerFace().getSmirkRight() > 0) {
			return TextConstants.SMIRK_RIGHT;
		}
		else if(params.getLowerFace().getLaugh() > 0) {
			return TextConstants.LAUGH;
		}
		return TextConstants.LOWER_NORMAL;
	}
	
	public static String findUpperFace(Parameters params) {
		if(params.getUpperFace().getFurrowBrow() > 0) {
			return TextConstants.FURROW_BROW;
		}
		else if(params.getUpperFace().getRaiseBrow() > 0) {
			return TextConstants.RAISE_BROW;
		}
		else if(params.getEye().getBlink()) {
			return TextConstants.BLINK_EYE;
		}
		else if(params.getEye().getLookLeft()) {
			return TextConstants.LOOK_LEFT;
		}
		else if(params.getEye().getLookRight()) {
			return TextConstants.LOOK_RIGHT;
		}
		else if(params.getEye().getWinkLeft()) {
			return TextConstants.WINK_LEFT;
		}
		else if(params.getEye().getWinkRight()) {
			return TextConstants.WINK_RIGHT;
		}
		return TextConstants.UPPER_NORMAL;
	}
	
}
