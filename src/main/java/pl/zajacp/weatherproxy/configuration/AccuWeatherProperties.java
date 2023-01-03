package pl.zajacp.weatherproxy.configuration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "accu-weather")
@AllArgsConstructor
@Getter
public class AccuWeatherProperties {
    private String basePath;
    private String apiKey;
}