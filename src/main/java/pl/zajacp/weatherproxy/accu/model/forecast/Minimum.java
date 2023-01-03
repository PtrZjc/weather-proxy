
package pl.zajacp.weatherproxy.accu.model.forecast;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Value",
    "Unit",
    "UnitType"
})
@Generated("jsonschema2pojo")
public class Minimum {

    @JsonProperty("Value")
    public BigDecimal value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public Integer unitType;

}
