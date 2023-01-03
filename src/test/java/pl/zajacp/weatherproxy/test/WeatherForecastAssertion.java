package pl.zajacp.weatherproxy.test;

import lombok.RequiredArgsConstructor;
import pl.zajacp.weatherproxy.api.model.OneDayWeatherForecastResponse;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;


@RequiredArgsConstructor(staticName = "assertWeatherForecast")
public class WeatherForecastAssertion {

    private final WeatherForecast weatherForecast;

    public WeatherForecastAssertion hasZipCode(String zipCode) {
        assertThat(weatherForecast.zipCode()).isEqualTo(zipCode);
        return this;
    }

    public WeatherForecastAssertion hasCity(String city) {
        assertThat(weatherForecast.city()).isEqualTo(city);
        return this;
    }

    public WeatherForecastAssertion hasForecastForNumberOfDays(int quantity) {
        assertThat(weatherForecast.weatherByDate()).hasSize(quantity);
        return this;
    }

    public OneDayWeatherForecastAssertion hasDailyForecastForDate(String date) {
        var dayForecast = weatherForecast.weatherByDate().stream()
                .filter(w -> w.date().equals(LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)))
                .findFirst();
        assertThat(dayForecast).isPresent();
        return new OneDayWeatherForecastAssertion(dayForecast.get(), this);
    }

    @RequiredArgsConstructor
    public class OneDayWeatherForecastAssertion {
        private final OneDayWeatherForecastResponse oneDayWeatherForecastResponse;
        private final WeatherForecastAssertion parent;


        public OneDayWeatherForecastAssertion withCelsiusTemperatureMaximum(String celsiusTemperatureMaximum) {
            assertThat(oneDayWeatherForecastResponse.celsiusTemperatureMaximum()).isEqualTo(new BigDecimal(celsiusTemperatureMaximum));
            return this;
        }

        public OneDayWeatherForecastAssertion withCelsiusTemperatureMinimum(String celsiusTemperatureMinimum) {
            assertThat(oneDayWeatherForecastResponse.celsiusTemperatureMinimum()).isEqualTo(new BigDecimal(celsiusTemperatureMinimum));
            return this;
        }

        public OneDayWeatherForecastAssertion withExpectedDayWeatherDescription(String description) {
            assertThat(oneDayWeatherForecastResponse.dayWeather().description()).isEqualTo(description);
            return this;
        }

        public OneDayWeatherForecastAssertion withDayWeatherPrecipitation(Boolean hasPrecipitation) {
            assertThat(oneDayWeatherForecastResponse.dayWeather().hasPrecipitation()).isEqualTo(hasPrecipitation);
            return this;
        }

        public OneDayWeatherForecastAssertion withExpectedNightWeatherDescription(String description) {
            assertThat(oneDayWeatherForecastResponse.nightWeather().description()).isEqualTo(description);
            return this;
        }

        public OneDayWeatherForecastAssertion withNightWeatherPrecipitation(Boolean hasPrecipitation) {
            assertThat(oneDayWeatherForecastResponse.nightWeather().hasPrecipitation()).isEqualTo(hasPrecipitation);
            return this;
        }

        public WeatherForecastAssertion and() {
            return parent;
        }
    }
}
