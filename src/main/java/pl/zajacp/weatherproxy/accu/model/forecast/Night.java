
package pl.zajacp.weatherproxy.accu.model.forecast;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Icon",
    "IconPhrase",
    "HasPrecipitation",
    "PrecipitationType",
    "PrecipitationIntensity"
})
@Generated("jsonschema2pojo")
public class Night {

    @JsonProperty("Icon")
    public Integer icon;
    @JsonProperty("IconPhrase")
    public String iconPhrase;
    @JsonProperty("HasPrecipitation")
    public Boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    public String precipitationType;
    @JsonProperty("PrecipitationIntensity")
    public String precipitationIntensity;

}
