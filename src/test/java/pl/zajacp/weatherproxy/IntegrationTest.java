package pl.zajacp.weatherproxy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.commons.AccuHelper;
import pl.zajacp.weatherproxy.commons.ApiHelper;
import pl.zajacp.weatherproxy.commons.WireMockInitializer;

import static pl.zajacp.weatherproxy.commons.TestAccuResponses.ACCU_FORECAST_RESPONSE;
import static pl.zajacp.weatherproxy.commons.TestAccuResponses.ACCU_LOCATION_RESPONSE;
import static pl.zajacp.weatherproxy.commons.TestData.API_KEY;
import static pl.zajacp.weatherproxy.commons.TestData.ZIP_CODE;

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
        accuHelper.stubAccuWeatherForecastEndpoint(API_KEY, 200, ACCU_FORECAST_RESPONSE);
        accuHelper.stubAccuWeatherLocationEndpoint(ZIP_CODE, API_KEY, 200, ACCU_LOCATION_RESPONSE);

        //when
        WeatherForecast response = apiHelper.getWeatherForecastExpectingOK(ZIP_CODE);

        //then
        Assertions.assertThat(response.city()).isEqualTo("Wroclaw");
        Assertions.assertThat(response.zipCode()).isEqualTo(ZIP_CODE);
        Assertions.assertThat(response.weatherByDate()).hasSize(5);
    }
}
