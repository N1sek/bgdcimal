package bigd_ejercicios;
import java.math.BigInteger;

public class FactorialBigDecimal {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("5");
        new FactorialBigDecimal().calculateFactorial(num);
        System.out.println(new FactorialBigDecimal().calculateFactorial(num));
    }


    public BigInteger calculateFactorial(BigInteger num) {
        if (num.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        } else {
            return num.multiply(calculateFactorial(num.subtract(BigInteger.ONE)));
        }
    }
}