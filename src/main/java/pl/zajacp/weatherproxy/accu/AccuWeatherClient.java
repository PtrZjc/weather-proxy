package pl.zajacp.weatherproxy.accu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.zajacp.weatherproxy.accu.model.AccuLocationResponse;
import pl.zajacp.weatherproxy.accu.model.AccuWeatherResponse;
import pl.zajacp.weatherproxy.configuration.AccuWeatherProperties;
import pl.zajacp.weatherproxy.shared.model.LocationKey;
import pl.zajacp.weatherproxy.shared.model.PostalCode;
import retrofit2.Response;

import java.io.IOException;

@RequiredArgsConstructor
@Component
@Slf4j
public class AccuWeatherClient {
    private final AccuWeatherProperties accuWeatherProperties;
    private final RetrofitAccuWeatherClient retrofitAccuWeatherClient;

    private final AccuWeatherMapper accuWeatherMapper;

    public AccuLocationResponse getLocation(PostalCode postalCode) {
        try {
            return getAccuLocationResponse(postalCode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AccuWeatherResponse getWeather(LocationKey locationKey) {
        try {
            return getAccuWeatherResponse(locationKey);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private AccuLocationResponse getAccuLocationResponse(PostalCode postalCode) throws IOException {
        var response = retrofitAccuWeatherClient.getLocationByKey(
                postalCode.raw(),
                accuWeatherProperties.getApiKey()
        ).execute();
        if (response.isSuccessful() && response.body() != null) {
            if (response.body().length > 0) {
                return response.body()[0];
            } else {
                throw new AccuLocationNotFoundException("No location found for postal code: " + postalCode.raw());
            }
        }
        throw getAccuClientException(response);
    }

    private AccuWeatherResponse getAccuWeatherResponse(LocationKey locationKey) throws IOException {
        var response = retrofitAccuWeatherClient.get5DayForecast(
                locationKey.raw(),
                accuWeatherProperties.getApiKey()
        ).execute();
        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        }
        throw getAccuClientException(response);
    }

    private AccuWeatherClientException getAccuClientException(Response<?> response) throws IOException {
        return new AccuWeatherClientException("AccuWeather API error response", response.code(), accuWeatherMapper.mapToErrorResponse(response.errorBody().string()));
    }
}
