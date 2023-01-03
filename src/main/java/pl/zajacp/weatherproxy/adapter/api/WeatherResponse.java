package pl.zajacp.weatherproxy.adapter.api;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record WeatherResponse(
        String zipCode,
        String city,
        ForecastResponse forecast
) {
}

record ForecastResponse(
        List<OneDayWeatherForecastResponse> weatherByDate
) {
}

record OneDayWeatherForecastResponse(
        LocalDate date,
        BigDecimal celsiusTemperatureMaximum,
        BigDecimal celsiusTemperatureMinimum,
        DescriptiveWeather dayWeather,
        DescriptiveWeather nightWeather
) {
}

record DescriptiveWeather(String description, Boolean hasPrecipitation) {
}
