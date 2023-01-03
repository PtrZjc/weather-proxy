package pl.zajacp.weatherproxy.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    public static BigDecimal fahrenheitToCelsius(BigDecimal fahrenheit) {
        return fahrenheit
                .subtract(BigDecimal.valueOf(32))
                .multiply(BigDecimal.valueOf(5))
                .divide(BigDecimal.valueOf(9), 2, RoundingMode.HALF_UP);
    }
}
