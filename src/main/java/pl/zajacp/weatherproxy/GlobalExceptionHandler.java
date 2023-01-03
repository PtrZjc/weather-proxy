package pl.zajacp.weatherproxy;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.zajacp.weatherproxy.accu.AccuWeatherClientException;

import java.util.regex.Pattern;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {

    private final Pattern CAMEL_CASE_REGEX = Pattern.compile("(?<=[a-zA-Z])([A-Z])");

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(ConstraintViolationException exception) {
        log.info("Validation failed", exception);
        return new ErrorResponse(
                asErrorCode(exception),
                exception.getMessage()
        );
    }

    @ExceptionHandler(AccuWeatherClientException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ExternalClientError handleRetrofitClientException(AccuWeatherClientException e) {
        log.error("AccuWeatherClient exception: {}", e.getMessage());
        return new ExternalClientError(e.getMessage(), e.getResponseBody());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception exception) {
        log.error("Unexpected exception", exception);
        return new ErrorResponse(asErrorCode(exception), exception.getMessage());
    }

    private String asErrorCode(Exception exception) {
        return CAMEL_CASE_REGEX
                .matcher(exception.getClass().getSimpleName())
                .replaceAll("_$1")
                .toUpperCase().split("_EXCEPTION")[0];
    }
}

record ErrorResponse(String code, String message) {
}

record ExternalClientError(String message, ResponseBody responseBody) {
}

