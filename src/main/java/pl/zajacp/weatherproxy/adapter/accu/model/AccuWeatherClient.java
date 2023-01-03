package pl.zajacp.weatherproxy.adapter.accu.model;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import pl.zajacp.weatherproxy.adapter.accu.RetrofitAccuWeatherClient;
import pl.zajacp.weatherproxy.adapter.accu.WeatherClient;
import pl.zajacp.weatherproxy.adapter.api.WeatherResponse;
import pl.zajacp.weatherproxy.configuration.AccuWeatherProperties;
import pl.zajacp.weatherproxy.shared.LocationKey;
import pl.zajacp.weatherproxy.shared.PostalCode;

@AllArgsConstructor
public class AccuWeatherClient implements WeatherClient {

    private final AccuWeatherProperties accuWeatherProperties;
    private final RetrofitAccuWeatherClient retrofitAccuWeatherClient;
    @Override
    public LocationKey getLocationKey(PostalCode postalCode) {
        //todo error handling
//        var response = retrofitAccuWeatherClient.getLocationByKey(postalCode.raw(), accuWeatherProperties.getApiKey()).execute();
        return null;
    }

    @Override
    public WeatherResponse get5DayWeatherForecast(LocationKey locationKey) {
        return null;
    }
}
