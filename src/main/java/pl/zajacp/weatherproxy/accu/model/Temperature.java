
package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Temperature(
        @JsonProperty("Minimum") TemperatureValue minimum,
        @JsonProperty("Maximum") TemperatureValue maximum) {

}
