package pl.zajacp.weatherproxy.accu;

public class AccuLocationNotFoundException extends RuntimeException {
    public AccuLocationNotFoundException(String message) {
        super(message);
    }
}

