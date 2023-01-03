
package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AccuWeatherResponse(
        @JsonProperty("DailyForecasts") List<DailyForecast> dailyForecasts
) {
}
