package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AccuLocationResponse(
        @JsonProperty("Key") String key,
        @JsonProperty("LocalizedName") String localizedName,
        @JsonProperty("PrimaryPostalCode") String primaryPostalCode) {

}
