package client.model;

import client.mode.Eye;
import client.mode.LowerFace;
import client.mode.MentalCmd;
import client.mode.Performance;
import client.mode.UpperFace;

public class Parameters {
    private Eye eye;
    private LowerFace lowerFace;
    private UpperFace upperFace;
    private MentalCmd mentalCmd;
    private Performance performance;
    private double time;

    public Parameters(Eye eye, LowerFace lowerFace, UpperFace upperFace,
                        MentalCmd mentalCmd, Performance performance, double time) {
        this.eye = eye;
        this.lowerFace = lowerFace;
        this.upperFace = upperFace;
        this.mentalCmd = mentalCmd;
        this.performance = performance;
        this.time = time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param eye the eye to set
     */
    public void setEye(Eye eye) {
        this.eye = eye;
    }

    /**
     * @return the eye
     */
    public Eye getEye() {
        return eye;
    }

    /**
     * @param lowerFace the lowerFace to set
     */
    public void setLowerFace(LowerFace lowerFace) {
        this.lowerFace = lowerFace;
    }
    
    /**
     * @return the lowerFace
     */
    public LowerFace getLowerFace() {
        return lowerFace;
    }

    /**
     * @param mentalCmd the mentalCmd to set
     */
    public void setMentalCmd(MentalCmd mentalCmd) {
        this.mentalCmd = mentalCmd;
    }

    /**
     * @return the mentalCmd
     */
    public MentalCmd getMentalCmd() {
        return mentalCmd;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    /**
     * @return the performance
     */
    public Performance getPerformance() {
        return performance;
    }

    /**
     * @param upperFace the upperFace to set
     */
    public void setUpperFace(UpperFace upperFace) {
        this.upperFace = upperFace;
    }

    /**
     * @return the upperFace
     */
    public UpperFace getUpperFace() {
        return upperFace;
    }
    
}