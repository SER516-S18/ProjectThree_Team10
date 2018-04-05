package client.model;

import java.util.ArrayList;
import java.util.List;

public class ClientWindowModel {
	private ArrayList<Parameters> paramList;
	public void setParaList(ArrayList<Parameters> paramList) {
		this.paramList = paramList;
	}
	
	public void addPara(Parameters param) {
		paramList.add(param);
	}
	
	public ArrayList<Parameters> getParamList(){
		return paramList;
	}
}
