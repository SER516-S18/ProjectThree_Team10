package team10;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class Variables {

	 
	 public void getLowerFace(JComboBox<String> lowerFaceOption, JSpinner lowerFaceValue){
		 String lowerFaceString = (String)lowerFaceOption.getSelectedItem();
		 Double lowerFaceVal= hashvalues.lowerFace.get(lowerFaceString);
		 lowerFaceValue.setValue(Double.valueOf(lowerFaceVal));
	 }
	 public void setLowerFace(JComboBox<String> lowerFaceOption, JSpinner lowerFaceValue){
		 String lowerFaceString = (String)lowerFaceOption.getSelectedItem();
		 Object lfv =  lowerFaceValue.getValue();
		 hashvalues.lowerFace.put(lowerFaceString,  (Double) lfv);
	 }
	 
	 public void getUpperFace(JComboBox<String> upperFaceOption, JSpinner upperFaceValue){
		 String upperFaceString = (String)upperFaceOption.getSelectedItem();
		 Double upperFaceVal= hashvalues.upperFace.get(upperFaceString);
		 upperFaceValue.setValue(Double.valueOf(upperFaceVal));
	 }
	 public void setUpperFace(JComboBox<String> upperFaceOption, JSpinner upperFaceValue){
		 String upperFaceString = (String)upperFaceOption.getSelectedItem();
		 Object ufv =  upperFaceValue.getValue();
		 hashvalues.upperFace.put(upperFaceString,  (Double) ufv);
	 }
	 
	 public void getEye(JComboBox<String> eyeOption, JSpinner eyeValue){
		 String eyeString = (String)eyeOption.getSelectedItem();
		 Integer eyeVal= hashvalues.eyes.get(eyeString);
		 eyeValue.setValue(Integer.valueOf(eyeVal));
	 }
	 public void setEye(JComboBox<String> eyeOption, JSpinner eyeValue){
		 String eyeString = (String)eyeOption.getSelectedItem();
		 Object efv =  eyeValue.getValue();
		 hashvalues.eyes.put(eyeString,  (Integer) efv); 
		 eyeValue.setValue(efv);
		 
	 }
	 

	 
}
