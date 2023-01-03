package pl.zajacp.weatherproxy.accu.model;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;
import pl.zajacp.weatherproxy.accu.model.location.AccuLocationResponse;
import pl.zajacp.weatherproxy.accu.AccuWeatherClientException;
import pl.zajacp.weatherproxy.accu.RetrofitAccuWeatherClient;
import pl.zajacp.weatherproxy.accu.model.forecast.AccuWeatherResponse;
import pl.zajacp.weatherproxy.configuration.AccuWeatherProperties;
import pl.zajacp.weatherproxy.shared.LocationKey;
import pl.zajacp.weatherproxy.shared.PostalCode;

import java.io.IOException;

@AllArgsConstructor
@Component
@Slf4j
public class AccuWeatherClient {
    private final AccuWeatherProperties accuWeatherProperties;
    private final RetrofitAccuWeatherClient retrofitAccuWeatherClient;

    @SneakyThrows(IOException.class)
    public AccuLocationResponse getLocation(PostalCode postalCode) {
        var response = retrofitAccuWeatherClient.getLocationByKey(
                postalCode.raw(),
                accuWeatherProperties.getApiKey()
        ).execute();
        if (response.isSuccessful() && response.body() != null) {
            return response.body()[0];
        }
        throw getAccuClientException(response.errorBody());
    }

    @SneakyThrows(IOException.class)
    public AccuWeatherResponse getWeather(LocationKey locationKey) {
        var response = retrofitAccuWeatherClient.get5DayForecast(
                locationKey.raw(),
                accuWeatherProperties.getApiKey()
        ).execute();
        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        }
        throw getAccuClientException(response.errorBody());
    }

    private AccuWeatherClientException getAccuClientException(ResponseBody response) throws IOException {
        return new AccuWeatherClientException("AccuWeather API error response", response);
    }
}
