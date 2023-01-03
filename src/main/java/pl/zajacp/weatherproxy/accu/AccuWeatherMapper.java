package pl.zajacp.weatherproxy.accu;

import org.springframework.stereotype.Component;
import pl.zajacp.weatherproxy.accu.model.forecast.AccuWeatherResponse;
import pl.zajacp.weatherproxy.accu.model.forecast.DailyForecast;
import pl.zajacp.weatherproxy.accu.model.location.AccuLocationResponse;
import pl.zajacp.weatherproxy.api.model.DescriptiveWeather;
import pl.zajacp.weatherproxy.api.model.OneDayWeatherForecastResponse;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.shared.LocationKey;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static pl.zajacp.weatherproxy.shared.Utils.*;

@Component
public class AccuWeatherMapper {

    public LocationKey mapToLocationKey(AccuLocationResponse locationResponse) {
        return new LocationKey(locationResponse.key);
    }

    public WeatherForecast mapToDayByDayForecast(AccuLocationResponse location, AccuWeatherResponse weather) {
        return new WeatherForecast(
                location.primaryPostalCode,
                location.localizedName,
                mapAllToDailyWeather(weather)
        );
    }

    private List<OneDayWeatherForecastResponse> mapAllToDailyWeather(AccuWeatherResponse weather) {
        return weather.dailyForecasts.stream()
                .map(this::mapToDailyWeather)
                .toList();
    }

    private OneDayWeatherForecastResponse mapToDailyWeather(DailyForecast dailyForecast) {
        return new OneDayWeatherForecastResponse(
                LocalDate.parse(dailyForecast.date, DateTimeFormatter.ISO_DATE_TIME),
                fahrenheitToCelsius(dailyForecast.temperature.maximum.value),
                fahrenheitToCelsius(dailyForecast.temperature.minimum.value),
                new DescriptiveWeather(dailyForecast.day.iconPhrase, dailyForecast.day.hasPrecipitation),
                new DescriptiveWeather(dailyForecast.night.iconPhrase, dailyForecast.night.hasPrecipitation)
        );
    }
}
