
package pl.zajacp.weatherproxy.accu.model.location;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Value",
    "Unit",
    "UnitType"
})
@Generated("jsonschema2pojo")
public class Metric {

    @JsonProperty("Value")
    public Double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public Integer unitType;

}
