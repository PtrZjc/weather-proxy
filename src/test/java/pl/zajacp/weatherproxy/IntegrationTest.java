package pl.zajacp.weatherproxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.test.AccuHelper;
import pl.zajacp.weatherproxy.test.ApiHelper;
import pl.zajacp.weatherproxy.test.WireMockInitializer;
import pl.zajacp.weatherproxy.shared.model.ErrorResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.zajacp.weatherproxy.test.TestAccuResponses.ACCU_FORECAST_RESPONSE;
import static pl.zajacp.weatherproxy.test.TestAccuResponses.ACCU_EMPTY_LOCATION_RESPONSE;
import static pl.zajacp.weatherproxy.test.TestAccuResponses.ACCU_LOCATION_RESPONSE;
import static pl.zajacp.weatherproxy.test.TestAccuResponses.ACCU_UNAUTHORIZED_RESPONSE;
import static pl.zajacp.weatherproxy.test.TestData.API_KEY;
import static pl.zajacp.weatherproxy.test.TestData.MALFORMED_ZIP_CODE;
import static pl.zajacp.weatherproxy.test.TestData.ZIP_CODE;
import static pl.zajacp.weatherproxy.test.WeatherForecastAssertion.*;

@SpringBootTest
@ActiveProfiles("integration")
@AutoConfigureMockMvc
@ContextConfiguration(initializers = WireMockInitializer.class)
class IntegrationTest {

    @Autowired
    private ApiHelper apiHelper;

    @Autowired
    private AccuHelper accuHelper;

    @Test
    void shouldMakeSuccessfulRequest() {
        //given
        accuHelper.stubAccuWeatherLocationEndpoint(ZIP_CODE, API_KEY, 200, ACCU_LOCATION_RESPONSE);
        accuHelper.stubAccuWeatherForecastEndpoint(API_KEY, 200, ACCU_FORECAST_RESPONSE);

        //when
        WeatherForecast response = apiHelper.getWeatherForecastExpectingOK(ZIP_CODE);

        //then
        assertWeatherForecast(response)
                .hasCity("Wroclaw")
                .hasZipCode(ZIP_CODE)
                .hasForecastForNumberOfDays(5)
                .hasDailyForecastForDate("2022-12-20")
                .withCelsiusTemperatureMinimum("-1.11")
                .withCelsiusTemperatureMaximum("5.56")
                .withExpectedDayWeatherDescription("Mostly cloudy")
                .withDayWeatherPrecipitation(false)
                .withExpectedNightWeatherDescription("Cloudy")
                .withNightWeatherPrecipitation(false)
                .and()
                .hasDailyForecastForDate("2022-12-21")
                .withCelsiusTemperatureMinimum("1.11")
                .withCelsiusTemperatureMaximum("5.00")
                .withExpectedDayWeatherDescription("Showers")
                .withDayWeatherPrecipitation(true)
                .withExpectedNightWeatherDescription("Intermittent clouds")
                .withNightWeatherPrecipitation(false)
                .and()
                .hasDailyForecastForDate("2022-12-22")
                .withCelsiusTemperatureMinimum("4.44")
                .withCelsiusTemperatureMaximum("7.22")
                .withExpectedDayWeatherDescription("Showers")
                .withDayWeatherPrecipitation(true)
                .withExpectedNightWeatherDescription("Showers")
                .withNightWeatherPrecipitation(true)
                .and()
                .hasDailyForecastForDate("2022-12-23")
                .withCelsiusTemperatureMinimum("6.67")
                .withCelsiusTemperatureMaximum("10.00")
                .withExpectedDayWeatherDescription("Cloudy")
                .withDayWeatherPrecipitation(true)
                .withExpectedNightWeatherDescription("Showers")
                .withNightWeatherPrecipitation(true)
                .and()
                .hasDailyForecastForDate("2022-12-24")
                .withCelsiusTemperatureMinimum("4.44")
                .withCelsiusTemperatureMaximum("10.56")
                .withExpectedDayWeatherDescription("Showers")
                .withDayWeatherPrecipitation(true)
                .withExpectedNightWeatherDescription("Intermittent clouds")
                .withNightWeatherPrecipitation(true);
    }

    @Test
    void shouldReturnUnauthorizedWhenApiKeyIsWrong() {
        //given
        accuHelper.stubAccuWeatherLocationEndpoint(ZIP_CODE, API_KEY, 401, ACCU_UNAUTHORIZED_RESPONSE);

        //when
        ErrorResponse response = apiHelper.getErrorResponseExpectingStatus(ZIP_CODE, status().isUnauthorized());

        //then
        assertThat(response.code()).isEqualTo("UNAUTHORIZED");
        assertThat(response.message()).isEqualTo("AccuWeather API error response");
    }

    @Test
    void shouldReturnBadRequestWhenValidationFails() {
        //when
        ErrorResponse response = apiHelper.getErrorResponseExpectingStatus(MALFORMED_ZIP_CODE, status().isBadRequest());

        //then
        assertThat(response.code()).isEqualTo("ARGUMENT_VALIDATION_FAILED");
        assertThat(response.message()).isEqualTo("Zip code must be in format: XX-XXX");
    }

    @Test
    void shouldReturnNotFoundWhenZipCodeInUnknown() {
        //given
        accuHelper.stubAccuWeatherLocationEndpoint(ZIP_CODE, API_KEY, 200, ACCU_EMPTY_LOCATION_RESPONSE);

        //when
        ErrorResponse response = apiHelper.getErrorResponseExpectingStatus(ZIP_CODE, status().isNotFound());

        //then
        assertThat(response.code()).isEqualTo("LOCATION_NOT_FOUND");
        assertThat(response.message()).isEqualTo("No location found for postal code: " + ZIP_CODE);
    }
}
