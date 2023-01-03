package pl.zajacp.weatherproxy.adapter.accu;

import lombok.AllArgsConstructor;
import pl.zajacp.weatherproxy.adapter.api.WeatherResponse;
import pl.zajacp.weatherproxy.shared.PostalCode;

@AllArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherResponse get5DayWeatherForecast(PostalCode postalCode){
        var locationKey = weatherClient.getLocationKey(postalCode);
        return weatherClient.get5DayWeatherForecast(locationKey);
    }
}
