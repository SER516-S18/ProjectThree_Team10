package client.model;

public class Parameters {
    private double time;
    private double neutral;
    private double pushSkill;
    private double overallSkill;
    private double raiseBrow;
    private double smile;
    private boolean blink;

    private double interest;
    private double engagement;
    private double stress;
    private double relaxation;
    private double excitement;
    private double focus;

    public Parameters(double time, 
                        double neutral, 
                        double pushSkill, 
                        double overallSkill, 
                        double raiseBrow, 
                        double smile, 
                        boolean blink,
                        double interest,
                        double engagement,
                        double stress,
                        double relaxation,
                        double excitement,
                        double focus) {
        setTime(time);
        setNeutral(neutral);
        setPushSkill(pushSkill);
        setOverallSkill(overallSkill);
        setRaiseBrow(raiseBrow);
        setSmile(smile);
        setBlink(blink);
        setInterest(interest);
        setEngagement(engagement);
        setStress(stress);
        setRelaxation(relaxation);
        setExcitement(excitement);
        setFocus(focus);
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

    /**
     * @param interest the interest to set
     */
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * @return the interest
     */
    public double getInterest() {
        return interest;
    }

    /**
     * @param engagement the engagement to set
     */
    public void setEngagement(double engagement) {
        this.engagement = engagement;
    }

    /**
     * @return the engagement
     */
    public double getEngagement() {
        return engagement;
    }

    /**
     * @param stress the stress to set
     */
    public void setStress(double stress) {
        this.stress = stress;
    }

    /**
     * @return the stress
     */
    public double getStress() {
        return stress;
    }

    /**
     * @param relaxation the relaxation to set
     */
    public void setRelaxation(double relaxation) {
        this.relaxation = relaxation;
    }

    /**
     * @return the relaxation
     */
    public double getRelaxation() {
        return relaxation;
    }

    /**
     * @param excitement the excitement to set
     */
    public void setExcitement(double excitement) {
        this.excitement = excitement;
    }

    /**
     * @return the excitement
     */
    public double getExcitement() {
        return excitement;
    }

    /**
     * @param focus the focus to set
     */
    public void setFocus(double focus) {
        this.focus = focus;
    }
    
    /**
     * @return the focus
     */
    public double getFocus() {
        return focus;
    }
    
}