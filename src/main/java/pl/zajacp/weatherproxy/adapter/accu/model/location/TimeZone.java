
package pl.zajacp.weatherproxy.adapter.accu.model.location;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Code",
    "Name",
    "GmtOffset",
    "IsDaylightSaving",
    "NextOffsetChange"
})
@Generated("jsonschema2pojo")
public class TimeZone {

    @JsonProperty("Code")
    public String code;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("GmtOffset")
    public Double gmtOffset;
    @JsonProperty("IsDaylightSaving")
    public Boolean isDaylightSaving;
    @JsonProperty("NextOffsetChange")
    public String nextOffsetChange;

}
