package client.model;

public class MentalCmd {
    private double neutral;
    private double push;
    private double pull;
    private double lift;
    private double drop;
    private double left;
    private double right;
    private double rotateLeft;
    private double rotateRight;
    private double rotateClockWise;
    private double rotateCounterClockWise;
    private double rotateForward;
    private double rotateReverse;
    private double disappear;

    private double pushSkill;

    private double overallSkill;

    public MentalCmd(double neutral,
                        double push,
                        double pull,
                        double lift, 
                        double drop,
                        double left,
                        double right,
                        double rotateLeft,
                        double rotateRight,
                        double rotateClockWise,
                        double rotateCounterClockWise,
                        double rotateForward,
                        double rotateReverse,
                        double disappear,
                        double pushSkill,
                        double overallSkill) {
        this.neutral = neutral;
        this.push = push;
        this.pull = pull;
        this.lift = lift;
        this.drop = drop;
        this.left = left;
        this.right = right;
        this.rotateLeft = rotateLeft;
        this.rotateRight = rotateRight;
        this.rotateClockWise = rotateClockWise;
        this.rotateCounterClockWise = rotateCounterClockWise;
        this.rotateForward = rotateForward;
        this.rotateReverse = rotateReverse;
        this.disappear = disappear;
        this.pushSkill = pushSkill;
        this.overallSkill = overallSkill;
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
     * @param push the push to set
     */
    public void setPush(double push) {
        this.push = push;
    }
    
    /**
     * @return the push
     */
    public double getPush() {
        return push;
    }

    /**
     * @param pull the pull to set
     */
    public void setPull(double pull) {
        this.pull = pull;
    }

    /**
     * @return the pull
     */
    public double getPull() {
        return pull;
    }

    /**
     * @param disappear the disappear to set
     */
    public void setDisappear(double disappear) {
        this.disappear = disappear;
    }

    /**
     * @return the disappear
     */
    public double getDisappear() {
        return disappear;
    }

    /**
     * @param drop the drop to set
     */
    public void setDrop(double drop) {
        this.drop = drop;
    }

    /**
     * @return the drop
     */
    public double getDrop() {
        return drop;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(double left) {
        this.left = left;
    }

    /**
     * @return the left
     */
    public double getLeft() {
        return left;
    }

    /**
     * @param lift the lift to set
     */
    public void setLift(double lift) {
        this.lift = lift;
    }

    /**
     * @return the lift
     */
    public double getLift() {
        return lift;
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
     * @param right the right to set
     */
    public void setRight(double right) {
        this.right = right;
    }

    /**
     * @return the right
     */
    public double getRight() {
        return right;
    }
    /**
     * @param rotateClockWise the rotateClockWise to set
     */
    public void setRotateClockWise(double rotateClockWise) {
        this.rotateClockWise = rotateClockWise;
    }

    /**
     * @return the rotateClockWise
     */
    public double getRotateClockWise() {
        return rotateClockWise;
    }
    
    /**
     * @param rotateCounterClockWise the rotateCounterClockWise to set
     */
    public void setRotateCounterClockWise(double rotateCounterClockWise) {
        this.rotateCounterClockWise = rotateCounterClockWise;
    }

    /**
     * @return the rotateCounterClockWise
     */
    public double getRotateCounterClockWise() {
        return rotateCounterClockWise;
    }

    /**
     * @param rotateForward the rotateForward to set
     */
    public void setRotateForward(double rotateForward) {
        this.rotateForward = rotateForward;
    }

    /**
     * @return the rotateForward
     */
    public double getRotateForward() {
        return rotateForward;
    }

    /**
     * @param rotateLeft the rotateLeft to set
     */
    public void setRotateLeft(double rotateLeft) {
        this.rotateLeft = rotateLeft;
    }

    /**
     * @return the rotateLeft
     */
    public double getRotateLeft() {
        return rotateLeft;
    }

    /**
     * @param rotateReverse the rotateReverse to set
     */
    public void setRotateReverse(double rotateReverse) {
        this.rotateReverse = rotateReverse;
    }
    
    /**
     * @return the rotateReverse
     */
    public double getRotateReverse() {
        return rotateReverse;
    }

    /**
     * @param rotateRight the rotateRight to set
     */
    public void setRotateRight(double rotateRight) {
        this.rotateRight = rotateRight;
    }

    /**
     * @return the rotateRight
     */
    public double getRotateRight() {
        return rotateRight;
    }

}
