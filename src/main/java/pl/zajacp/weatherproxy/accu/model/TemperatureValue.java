
package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TemperatureValue(
        @JsonProperty("Value") BigDecimal value,
        @JsonProperty("Unit") String unit,
        @JsonProperty("UnitType") Integer unitType) {

}
