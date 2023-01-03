package pl.zajacp.weatherproxy.commons;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static pl.zajacp.weatherproxy.commons.TestData.DEFAULT_LOCATION_KEY;

@Component
public class AccuHelper {

    @Autowired
    private WireMockServer wireMockServer;

    final static String ACCU_API_LOCATION_PATH = "/locations/v1/postalcodes/PL/search";
    final static String ACCU_API_FORECAST_PATH = "/forecasts/v1/daily/5day/" + DEFAULT_LOCATION_KEY;


    public void stubAccuWeatherLocationEndpoint(String postalCode, String apikey, int statusCode, String responseBody) {
        wireMockServer.stubFor(get(urlPathEqualTo(ACCU_API_LOCATION_PATH))
                .withQueryParam("q", equalTo(postalCode))
                .withQueryParam("apikey", equalTo(apikey))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseBody)
                )
        );
    }

    public void stubAccuWeatherForecastEndpoint(String apikey, int statusCode, String responseBody) {
        wireMockServer.stubFor(get(urlPathEqualTo(ACCU_API_FORECAST_PATH))
                .withQueryParam("apikey", equalTo(apikey))
                .willReturn(aResponse()
                        .withStatus(statusCode)
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseBody)));
    }
}
