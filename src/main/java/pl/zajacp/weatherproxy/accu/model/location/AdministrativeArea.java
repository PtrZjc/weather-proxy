
package pl.zajacp.weatherproxy.accu.model.location;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ID",
    "LocalizedName",
    "EnglishName",
    "Level",
    "LocalizedType",
    "EnglishType",
    "CountryID"
})
@Generated("jsonschema2pojo")
public class AdministrativeArea {

    @JsonProperty("ID")
    public String id;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("Level")
    public Integer level;
    @JsonProperty("LocalizedType")
    public String localizedType;
    @JsonProperty("EnglishType")
    public String englishType;
    @JsonProperty("CountryID")
    public String countryID;

}
