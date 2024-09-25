package bigd_ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmortizableLoan {
    public static void main(String[] args) {
        BigDecimal interest = new BigDecimal("0.05");
        BigDecimal years = new BigDecimal("12");
        BigDecimal loanQty = new BigDecimal("100.000");
        BigDecimal paymentsNum = new BigDecimal("5");

        BigDecimal r = interest.divide(years, 10, RoundingMode.HALF_UP);

        BigDecimal literallyOne = BigDecimal.ONE;
        BigDecimal addMonthlyInterest = literallyOne.add(r);

        BigDecimal compoundedInterest = addMonthlyInterest.pow(paymentsNum.intValue()).setScale(10, RoundingMode.HALF_UP);
        BigDecimal inverseCompoundedInterest = BigDecimal.ONE.divide(compoundedInterest, 10, RoundingMode.HALF_UP);
        BigDecimal denominator = literallyOne.subtract(inverseCompoundedInterest);
        BigDecimal PMT = (loanQty.multiply(r)).divide(denominator, 10, RoundingMode.HALF_UP);

        System.out.println("PMT: " + PMT);
    }
}
