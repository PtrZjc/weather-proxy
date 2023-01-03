
package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DayPeriod(
        @JsonProperty("Icon") Integer icon,
        @JsonProperty("IconPhrase") String iconPhrase,
        @JsonProperty("HasPrecipitation") Boolean hasPrecipitation,
        @JsonProperty("PrecipitationType") String precipitationType,
        @JsonProperty("PrecipitationIntensity") String precipitationIntensity) {

}
