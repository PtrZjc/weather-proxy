package pl.zajacp.weatherproxy.accu;

import lombok.Getter;
import okhttp3.ResponseBody;

@Getter
public class AccuWeatherClientException extends RuntimeException {
    private final ResponseBody responseBody;

    public AccuWeatherClientException(String message, ResponseBody responseBody) {
        super(message);
        this.responseBody = responseBody;
    }
}
