package pl.zajacp.weatherproxy.accu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.shared.WeatherService;
import pl.zajacp.weatherproxy.shared.model.PostalCode;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccuWeatherService implements WeatherService {
    private final AccuWeatherClient accuWeatherClient;
    private final AccuWeatherMapper accuWeatherMapper;

    @Override
    public WeatherForecast get5DayWeatherForecast(PostalCode postalCode) {
        log.info("Getting location info for area with postal code: {}", postalCode.raw());
        var location = accuWeatherClient.getLocation(postalCode);
        var locationKey = accuWeatherMapper.mapToLocationKey(location);

        log.info("Getting weather forecast for location with key: {}", locationKey.raw());
        var weather = accuWeatherClient.getWeather(locationKey);
        return accuWeatherMapper.mapToDayByDayForecast(location, weather);
    }
}
