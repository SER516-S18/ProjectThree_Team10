package client.model;

public class PerformanceMet {
    private double interest;
    private double engagement;
    private double stress;
    private double relaxation;
    private double excitement;
    private double focus;

    public PerformanceMet(double interest, double engagement, double stress,
                            double relaxation, double excitement, double focus) {
        this.interest = interest;
        this.engagement = engagement;
        this.stress = stress;
        this.relaxation = relaxation;
        this.excitement = excitement;
        this.focus = focus;                            
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

}
