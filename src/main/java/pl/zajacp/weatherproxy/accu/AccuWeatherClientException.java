package pl.zajacp.weatherproxy.accu;

import lombok.Getter;

@Getter
public class AccuWeatherClientException extends RuntimeException {
    private final String apiResponse;

    public AccuWeatherClientException(String message, String apiResponse) {
        super(message);
        this.apiResponse = apiResponse;
    }
}
