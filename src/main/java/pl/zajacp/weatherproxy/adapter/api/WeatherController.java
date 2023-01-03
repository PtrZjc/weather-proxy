package pl.zajacp.weatherproxy.adapter.api;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.zajacp.weatherproxy.adapter.accu.WeatherService;
import pl.zajacp.weatherproxy.shared.PostalCode;

@RestController
@RequestMapping(("/weather"))
@Validated
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    static final String POLISH_POSTAL_CODE_REGEX = "^[0-9]{2}-[0-9]{3}$";

    @GetMapping("/{zipCode}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherResponse getWeather(@PathVariable
                                      @Pattern(regexp = POLISH_POSTAL_CODE_REGEX)
                                      String zipCode) {
        return weatherService.get5DayWeatherForecast(new PostalCode(zipCode));
    }
}
