package pl.zajacp.weatherproxy;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.zajacp.weatherproxy.accu.AccuLocationNotFoundException;
import pl.zajacp.weatherproxy.accu.AccuWeatherClientException;
import pl.zajacp.weatherproxy.shared.model.ErrorResponse;

import java.util.regex.Pattern;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {

    private final static Pattern CAMEL_CASE_REGEX = Pattern.compile("(?<=[a-zA-Z])([A-Z])");
    private final static String NOT_FOUND_CODE = "LOCATION_NOT_FOUND";
    private final static String CONSTRAINT_VIOLATION_CODE = "ARGUMENT_VALIDATION_FAILED";
    private final static String INVALID_ZIP_CODE_MESSAGE = "Zip code must be in format: XX-XXX";

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ConstraintViolationException e) {
        log.info("Validation failed", e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(CONSTRAINT_VIOLATION_CODE, INVALID_ZIP_CODE_MESSAGE));
    }

    @ExceptionHandler(AccuWeatherClientException.class)
    public ResponseEntity<ErrorResponse> handleAccuClientException(AccuWeatherClientException e) {
        log.error("AccuWeatherClient exception: {}", e.getMessage());
        var httpStatus = mapToHttpStatus(e);
        return ResponseEntity
                .status(httpStatus)
                .body(new ErrorResponse(httpStatus.name(), e.getMessage()));
    }

    @ExceptionHandler(AccuLocationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccuLocationNotFound(AccuLocationNotFoundException e) {
        log.info(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(NOT_FOUND_CODE, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleOtherException(Exception e) {
        log.error("Unexpected e", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(asErrorCode(e), e.getMessage()));
    }

    private HttpStatus mapToHttpStatus(AccuWeatherClientException e) {
        return switch (e.getCode()) {
            case 401 -> HttpStatus.UNAUTHORIZED;
            case 500 -> HttpStatus.INTERNAL_SERVER_ERROR;
            default -> HttpStatus.SERVICE_UNAVAILABLE;
        };
    }

    private String asErrorCode(Throwable e) {
        return CAMEL_CASE_REGEX
                .matcher(e.getClass().getSimpleName())
                .replaceAll("_$1")
                .toUpperCase();
    }
}
