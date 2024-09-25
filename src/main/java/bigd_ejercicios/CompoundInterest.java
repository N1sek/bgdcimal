package bigd_ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CompoundInterest {
    public static void main(String[] args) {

        BigDecimal p = new BigDecimal("1000");
        BigDecimal r = new BigDecimal("0.05");
        BigDecimal n = new BigDecimal("5");

        BigDecimal sum = r.add(BigDecimal.ONE);
        BigDecimal potencia = sum.pow(n.intValueExact());
        BigDecimal resultado = (p.multiply(potencia));
        resultado = resultado.setScale(10, RoundingMode.HALF_EVEN);

        System.out.println("Resultado: " + resultado);
    }
}
