
package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DailyForecast(
        @JsonProperty("Date") String date,
        @JsonProperty("Temperature") Temperature temperature,
        @JsonProperty("Day") DayPeriod day,
        @JsonProperty("Night") DayPeriod night) {

}
