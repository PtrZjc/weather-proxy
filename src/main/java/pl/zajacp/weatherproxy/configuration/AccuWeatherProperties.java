package pl.zajacp.weatherproxy.configuration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "accu-weather")
@Getter
@Setter
@Component
public class AccuWeatherProperties {
    private String basePath;
    private String apiKey;
}
