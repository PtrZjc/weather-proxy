
package pl.zajacp.weatherproxy.accu.model.location;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Version",
    "Key",
    "Type",
    "Rank",
    "LocalizedName",
    "EnglishName",
    "PrimaryPostalCode",
    "Region",
    "Country",
    "AdministrativeArea",
    "TimeZone",
    "GeoPosition",
    "IsAlias",
    "SupplementalAdminAreas",
    "DataSets"
})
@Generated("jsonschema2pojo")
public class AccuLocationResponse {

    @JsonProperty("Version")
    public Integer version;
    @JsonProperty("Key")
    public String key;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Rank")
    public Integer rank;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("PrimaryPostalCode")
    public String primaryPostalCode;
    @JsonProperty("Region")
    public Region region;
    @JsonProperty("Country")
    public Country country;
    @JsonProperty("AdministrativeArea")
    public AdministrativeArea administrativeArea;
    @JsonProperty("TimeZone")
    public TimeZone timeZone;
    @JsonProperty("GeoPosition")
    public GeoPosition geoPosition;
    @JsonProperty("IsAlias")
    public Boolean isAlias;
    @JsonProperty("SupplementalAdminAreas")
    public List<Object> supplementalAdminAreas = null;
    @JsonProperty("DataSets")
    public List<String> dataSets = null;
}
