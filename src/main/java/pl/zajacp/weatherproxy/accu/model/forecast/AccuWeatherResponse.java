
package pl.zajacp.weatherproxy.accu.model.forecast;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Headline",
    "DailyForecasts"
})
@Generated("jsonschema2pojo")
public class AccuWeatherResponse {

    @JsonProperty("Headline")
    public Headline headline;
    @JsonProperty("DailyForecasts")
    public List<DailyForecast> dailyForecasts = null;

}
