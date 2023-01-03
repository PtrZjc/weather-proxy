package com.example.weatherproxy.api;

import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(("/weather"))
@Validated
public class WeatherController {

    static final String POLISH_POSTAL_CODE_REGEX = "^[0-9]{2}-[0-9]{3}$";

    @GetMapping("/{zipCode}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherResponse getWeather(@PathVariable
                                      @Pattern(regexp = POLISH_POSTAL_CODE_REGEX)
                                      String zipCode) {
        return new WeatherResponse(zipCode, null, null);
    }
}

record WeatherResponse(
        String zipCode,
        String city,
        ForecastResponse forecast
) {
}

record ForecastResponse(
        List<DayWeatherForecastResponse> weatherByDate
) {
}

record DayWeatherForecastResponse(
        BigDecimal celsiusTemperatureMaximum,
        BigDecimal celsiusTemperatureMinimum,
        DescriptiveWeather dayWeather,
        DescriptiveWeather nightWeather
) {
}

record DescriptiveWeather(String description, Boolean hasPrecipitation) {
}
