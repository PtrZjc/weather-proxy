
package pl.zajacp.weatherproxy.adapter.accu.model.forecast;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EffectiveDate",
    "EffectiveEpochDate",
    "Severity",
    "Text",
    "Category",
    "EndDate",
    "EndEpochDate",
    "MobileLink",
    "Link"
})
@Generated("jsonschema2pojo")
public class Headline {

    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    public Integer effectiveEpochDate;
    @JsonProperty("Severity")
    public Integer severity;
    @JsonProperty("Text")
    public String text;
    @JsonProperty("Category")
    public String category;
    @JsonProperty("EndDate")
    public String endDate;
    @JsonProperty("EndEpochDate")
    public Integer endEpochDate;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;

}
