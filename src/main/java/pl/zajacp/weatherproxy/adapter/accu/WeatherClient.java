package pl.zajacp.weatherproxy.adapter.accu;

import pl.zajacp.weatherproxy.adapter.api.WeatherResponse;
import pl.zajacp.weatherproxy.shared.LocationKey;
import pl.zajacp.weatherproxy.shared.PostalCode;

public interface WeatherClient {

    LocationKey getLocationKey(PostalCode postalCode);

    WeatherResponse get5DayWeatherForecast(LocationKey locationKey);
}
