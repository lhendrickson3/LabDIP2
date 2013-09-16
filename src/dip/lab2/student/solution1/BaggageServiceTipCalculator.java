/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2.student.solution1;

/**
 *
 * @author User
 */
public class BaggageServiceTipCalculator implements TipCalculator{
    private static final double MIN_BILL = 0.00;
    private static final double MAX_BILL = 100.00;
    private static final int ONE = 1;
    private static final String BAG_COUNT = "bag count must be greater than or equal to zero";
    private static final String BASE_TIP = "error: base tip must be greater than or equal to zero";
    private static final String BILL_ENTRY_ERR =
            "Error: bill must be between " + MIN_BILL + " and "
            + MAX_BILL;
    private double baseTipPerBag;
    private int bagCount;
    public enum ServiceQuality {
        GOOD, FAIR, POOR
    }
    private ServiceQuality serviceQuality;

    public BaggageServiceTipCalculator(ServiceQuality q, int bags) {
        this.setServiceRating(q); // perform validation
        this.setBagCount(bags);

        baseTipPerBag = 1.00; // set default value
    }
    
    @Override
    public double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = baseTipPerBag * bagCount * (ONE + GOOD_RATE);
                break;
            case FAIR:
                tip = baseTipPerBag * bagCount * (ONE + FAIR_RATE);
                break;
            case POOR:
                tip = baseTipPerBag * bagCount * (ONE + POOR_RATE);
                break;
        }

        return tip;
    }
    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public int getBagCount() {
        return bagCount;
    }

    public final void setBagCount(int bagCount) {
        if(bagCount < 0) {
            throw new IllegalArgumentException(
                    BAG_COUNT);
        }
        this.bagCount = bagCount;
    }

    public double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public void setBaseTipPerBag(double baseTipPerBag) {
        if(baseTipPerBag < 0) {
            throw new IllegalArgumentException(
                    BASE_TIP);
        }
        this.baseTipPerBag = baseTipPerBag;
    }
}
