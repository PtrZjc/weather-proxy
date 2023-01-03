
package pl.zajacp.weatherproxy.adapter.accu.model.location;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Metric",
    "Imperial"
})
@Generated("jsonschema2pojo")
public class Elevation {

    @JsonProperty("Metric")
    public Metric metric;
    @JsonProperty("Imperial")
    public Imperial imperial;

}