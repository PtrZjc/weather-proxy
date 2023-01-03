
package pl.zajacp.weatherproxy.accu.model.forecast;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Date",
    "EpochDate",
    "Temperature",
    "Day",
    "Night",
    "Sources",
    "MobileLink",
    "Link"
})
@Generated("jsonschema2pojo")
public class DailyForecast {

    @JsonProperty("Date")
    public String date;
    @JsonProperty("EpochDate")
    public Integer epochDate;
    @JsonProperty("Temperature")
    public Temperature temperature;
    @JsonProperty("Day")
    public Day day;
    @JsonProperty("Night")
    public Night night;
    @JsonProperty("Sources")
    public List<String> sources = null;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;

}
