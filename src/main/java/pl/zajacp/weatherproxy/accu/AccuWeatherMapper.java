package pl.zajacp.weatherproxy.accu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zajacp.weatherproxy.accu.model.AccuErrorResponse;
import pl.zajacp.weatherproxy.accu.model.AccuLocationResponse;
import pl.zajacp.weatherproxy.accu.model.AccuWeatherResponse;
import pl.zajacp.weatherproxy.accu.model.DailyForecast;
import pl.zajacp.weatherproxy.api.model.DescriptiveWeather;
import pl.zajacp.weatherproxy.api.model.OneDayWeatherForecastResponse;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.shared.model.LocationKey;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static pl.zajacp.weatherproxy.shared.Utils.fahrenheitToCelsius;

@RequiredArgsConstructor
@Component
class AccuWeatherMapper {

    private final ObjectMapper objectMapper;

    LocationKey mapToLocationKey(AccuLocationResponse locationResponse) {
        return new LocationKey(locationResponse.key());
    }

    WeatherForecast mapToDayByDayForecast(AccuLocationResponse location, AccuWeatherResponse weather) {
        return new WeatherForecast(
                location.primaryPostalCode(),
                location.localizedName(),
                mapAllToDailyWeather(weather)
        );
    }

    private List<OneDayWeatherForecastResponse> mapAllToDailyWeather(AccuWeatherResponse weather) {
        return weather.dailyForecasts().stream()
                .map(this::mapToDailyWeather)
                .toList();
    }

    private OneDayWeatherForecastResponse mapToDailyWeather(DailyForecast dailyForecast) {
        return new OneDayWeatherForecastResponse(
                LocalDate.parse(dailyForecast.date(), DateTimeFormatter.ISO_DATE_TIME),
                fahrenheitToCelsius(dailyForecast.temperature().maximum().value()),
                fahrenheitToCelsius(dailyForecast.temperature().minimum().value()),
                new DescriptiveWeather(dailyForecast.day().iconPhrase(), dailyForecast.day().hasPrecipitation()),
                new DescriptiveWeather(dailyForecast.night().iconPhrase(), dailyForecast.night().hasPrecipitation())
        );
    }

    String mapToErrorResponse(String errorBody) {
        AccuErrorResponse response;
        try {
            response = objectMapper.readValue(errorBody, AccuErrorResponse.class);
        } catch (JsonProcessingException e) {
            return "Undescribed error";
        }
        return "Client failed with code: " + response.code() + "; and response: " + response.message();
    }
}
