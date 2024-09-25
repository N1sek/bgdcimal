package bigd_ejercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;

public class Harvesine {
    private static final BigDecimal EARTH_RADIUS_KM = new BigDecimal("6371.0");
    private static final MathContext MC = new MathContext(34, RoundingMode.HALF_UP);

    public static void main(String[] args) {
        BigDecimal lat1 = new BigDecimal("40.416775"); // Madrid
        BigDecimal lon1 = new BigDecimal("-3.703790");

        BigDecimal lat2 = new BigDecimal("48.856614"); // Paris
        BigDecimal lon2 = new BigDecimal("2.352222");

        BigDecimal distance = calculateHaversineDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distancia entre Madrid y Paris: " + distance + " km");
    }

    public static BigDecimal calculateHaversineDistance(BigDecimal lat1, BigDecimal lon1, BigDecimal lat2, BigDecimal lon2) {
        BigDecimal lat1Rad = degreesToRadians(lat1);
        BigDecimal lon1Rad = degreesToRadians(lon1);
        BigDecimal lat2Rad = degreesToRadians(lat2);
        BigDecimal lon2Rad = degreesToRadians(lon2);

        BigDecimal deltaLat = lat2Rad.subtract(lat1Rad, MC);
        BigDecimal deltaLon = lon2Rad.subtract(lon1Rad, MC);

        BigDecimal a = haversine(deltaLat).add(
                cos(lat1Rad).multiply(cos(lat2Rad), MC).multiply(haversine(deltaLon), MC), MC
        );

        BigDecimal c = BigDecimal.valueOf(2).multiply(atan2(sqrt(a), sqrt(BigDecimal.ONE.subtract(a, MC))), MC);

        return EARTH_RADIUS_KM.multiply(c, MC).setScale(10, RoundingMode.HALF_EVEN);
    }

    public static BigDecimal degreesToRadians(BigDecimal degrees) {
        BigDecimal pi = new BigDecimal(Math.PI, MC);
        return degrees.multiply(pi).divide(new BigDecimal("180"), MC);
    }

    public static BigDecimal haversine(BigDecimal theta) {
        BigDecimal halfTheta = theta.divide(new BigDecimal("2"), MC);
        return sin(halfTheta).pow(2, MC);
    }

    public static BigDecimal sin(BigDecimal x) {
        return new BigDecimal(Math.sin(x.doubleValue()), MC);
    }

    public static BigDecimal cos(BigDecimal x) {
        return new BigDecimal(Math.cos(x.doubleValue()), MC);
    }

    public static BigDecimal atan2(BigDecimal y, BigDecimal x) {
        return new BigDecimal(Math.atan2(y.doubleValue(), x.doubleValue()), MC);
    }

    public static BigDecimal sqrt(BigDecimal value) {
        return value.sqrt(MC);
    }
}
