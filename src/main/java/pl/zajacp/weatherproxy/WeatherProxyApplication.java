package pl.zajacp.weatherproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.zajacp.weatherproxy.configuration.AccuWeatherConfiguration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@SpringBootApplication
public class WeatherProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherProxyApplication.class, args);
    }

    @Bean
    public Retrofit accuWeatherRetrofitClient(AccuWeatherConfiguration accuWeatherConfiguration) {
        return new Retrofit.Builder()
                .baseUrl(accuWeatherConfiguration.getBasePath())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}

