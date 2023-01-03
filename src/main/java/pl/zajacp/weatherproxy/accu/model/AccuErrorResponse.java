package pl.zajacp.weatherproxy.accu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AccuErrorResponse(
        @JsonProperty("Code") String code,
        @JsonProperty("Message") String message
) {
}
