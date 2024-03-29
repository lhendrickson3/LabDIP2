/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dip.lab2.student.solution1;

import java.text.NumberFormat;

/**
 *
 * @author User
 */
public class Runner {
    
    public static void main(String[] args) {

        TipCalculator tc1 = new BaggageServiceTipCalculator(BaggageServiceTipCalculator.ServiceQuality.GOOD, 5);
        TipCalculator tc2 = new BaggageServiceTipCalculator(BaggageServiceTipCalculator.ServiceQuality.POOR, 3);
        TipCalculator tc3 = new FoodServiceTipCalculator(FoodServiceTipCalculator.ServiceQuality.FAIR, 50);

        CalculatorService cs = new CalculatorService();

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        System.out.println("Your total tip is " +
            nf.format(cs.getTipTotal(tc1)));
        System.out.println("Your total tip is " +
            nf.format(cs.getTipTotal(tc2)));
        System.out.println("Your total tip is " +
            nf.format(cs.getTipTotal(tc3)));
    
    }
}
