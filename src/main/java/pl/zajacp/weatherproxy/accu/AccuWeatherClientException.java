package pl.zajacp.weatherproxy.accu;

import lombok.Getter;

@Getter
public class AccuWeatherClientException extends RuntimeException {

    private final int code;
    private final String apiResponse;

    public AccuWeatherClientException(String message, int code, String apiResponse) {
        super(message);
        this.code = code;
        this.apiResponse = apiResponse;
    }
}

