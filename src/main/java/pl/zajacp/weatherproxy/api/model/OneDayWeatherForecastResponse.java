package pl.zajacp.weatherproxy.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OneDayWeatherForecastResponse(
        LocalDate date,
        BigDecimal celsiusTemperatureMaximum,
        BigDecimal celsiusTemperatureMinimum,
        DescriptiveWeather dayWeather,
        DescriptiveWeather nightWeather
) {
}
