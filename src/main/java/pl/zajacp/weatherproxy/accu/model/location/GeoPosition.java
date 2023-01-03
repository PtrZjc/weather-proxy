
package pl.zajacp.weatherproxy.accu.model.location;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Latitude",
    "Longitude",
    "Elevation"
})
@Generated("jsonschema2pojo")
public class GeoPosition {

    @JsonProperty("Latitude")
    public Double latitude;
    @JsonProperty("Longitude")
    public Double longitude;
    @JsonProperty("Elevation")
    public Elevation elevation;

}
