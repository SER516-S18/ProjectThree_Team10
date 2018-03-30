package client.model;

public class Face {
    private double time;
    private double neutral;
    private double pushSkill;
    private double overallSkill;
    private double raiseBrow;
    private double smile;
    private boolean blink;

    public Face(double time, double neutral, double pushSkill, double overallSkill, double raiseBrow, double smile, boolean blink) {
        setTime(time);
        setNeutral(neutral);
        setPushSkill(pushSkill);
        setOverallSkill(overallSkill);
        setRaiseBrow(raiseBrow);
        setSmile(smile);
        setBlink(blink);
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
     * @param neutral the neutral to set
     */
    public void setNeutral(double neutral) {
        this.neutral = neutral;
    }

    /**
     * @return the neutral
     */
    public double getNeutral() {
        return neutral;
    }

    /**
     * @param pushSkill the pushSkill to set
     */
    public void setPushSkill(double pushSkill) {
        this.pushSkill = pushSkill;
    }

    /**
     * @return the pushSkill
     */
    public double getPushSkill() {
        return pushSkill;
    }

    /**
     * @param overallSkill the overallSkill to set
     */
    public void setOverallSkill(double overallSkill) {
        this.overallSkill = overallSkill;
    }

    /**
     * @return the overallSkill
     */
    public double getOverallSkill() {
        return overallSkill;
    }

    /**
     * @param raiseBrow the raiseBrow to set
     */
    public void setRaiseBrow(double raiseBrow) {
        this.raiseBrow = raiseBrow;
    }

    /**
     * @return the raiseBrow
     */
    public double getRaiseBrow() {
        return raiseBrow;
    }

    /**
     * @param smile the smile to set
     */
    public void setSmile(double smile) {
        this.smile = smile;
    }

    /**
     * @return the smile
     */
    public double getSmile() {
        return smile;
    }

    /**
     * @param blink the blink to set
     */
    public void setBlink(boolean blink) {
        this.blink = blink;
    }

    /**
     * @return the blink
     */
    public boolean getBlink() {
        return blink;
    }
    
}