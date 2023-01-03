package pl.zajacp.weatherproxy.shared;

import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.shared.PostalCode;

public interface WeatherService {
    WeatherForecast get5DayWeatherForecast(PostalCode postalCode);
}
