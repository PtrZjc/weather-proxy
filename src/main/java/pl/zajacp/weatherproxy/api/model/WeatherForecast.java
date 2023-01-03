package pl.zajacp.weatherproxy.api.model;

import java.util.List;

public record WeatherForecast(
        String zipCode,
        String city,
        List<OneDayWeatherForecastResponse> weatherByDate
) {
}
