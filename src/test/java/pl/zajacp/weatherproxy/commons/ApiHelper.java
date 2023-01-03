package pl.zajacp.weatherproxy.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.zajacp.weatherproxy.api.model.WeatherForecast;
import pl.zajacp.weatherproxy.shared.model.ErrorResponse;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RequiredArgsConstructor
@Component
public class ApiHelper {
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    private final static String WEATHER_PATH = "/weather/";

    @SneakyThrows
    public WeatherForecast getWeatherForecastExpectingOK(String zipCode){
        return makeGetRequest(WEATHER_PATH + zipCode, WeatherForecast.class, status().isOk());
    }

    @SneakyThrows
    public ErrorResponse getErrorResponseExpectingStatus(String zipCode, ResultMatcher expectedStatus) {
        return makeGetRequest(WEATHER_PATH + zipCode, ErrorResponse.class, expectedStatus);
    }

    private <T> T makeGetRequest(String path, Class<T> responseType, ResultMatcher expectedStatus) throws Exception {
        var response = mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(expectedStatus)
                .andReturn()
                .getResponse()
                .getContentAsString();
        return objectMapper.readValue(response, responseType);
    }
}



