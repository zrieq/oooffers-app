package com.oooffers.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "regionID",
    "associatedMultiCityRegionId",
    "longName",
    "shortName",
    "country",
    "province",
    "city",
    "tla",
    "nonLocalizedCity"
})
public class Destination {

    @JsonProperty("regionID")
    private String regionID;
    @JsonProperty("associatedMultiCityRegionId")
    private String associatedMultiCityRegionId;
    @JsonProperty("longName")
    private String longName;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("province")
    private String province;
    @JsonProperty("city")
    private String city;
    @JsonProperty("tla")
    private String tla;
    @JsonProperty("nonLocalizedCity")
    private String nonLocalizedCity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("regionID")
    public String getRegionID() {
        return regionID;
    }

    @JsonProperty("regionID")
    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    @JsonProperty("associatedMultiCityRegionId")
    public String getAssociatedMultiCityRegionId() {
        return associatedMultiCityRegionId;
    }

    @JsonProperty("associatedMultiCityRegionId")
    public void setAssociatedMultiCityRegionId(String associatedMultiCityRegionId) {
        this.associatedMultiCityRegionId = associatedMultiCityRegionId;
    }

    @JsonProperty("longName")
    public String getLongName() {
        return longName;
    }

    @JsonProperty("longName")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("tla")
    public String getTla() {
        return tla;
    }

    @JsonProperty("tla")
    public void setTla(String tla) {
        this.tla = tla;
    }

    @JsonProperty("nonLocalizedCity")
    public String getNonLocalizedCity() {
        return nonLocalizedCity;
    }

    @JsonProperty("nonLocalizedCity")
    public void setNonLocalizedCity(String nonLocalizedCity) {
        this.nonLocalizedCity = nonLocalizedCity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("regionID", regionID).append("associatedMultiCityRegionId", associatedMultiCityRegionId).append("longName", longName).append("shortName", shortName).append("country", country).append("province", province).append("city", city).append("tla", tla).append("nonLocalizedCity", nonLocalizedCity).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(province).append(longName).append(nonLocalizedCity).append(tla).append(shortName).append(associatedMultiCityRegionId).append(regionID).append(city).append(country).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Destination) == false) {
            return false;
        }
        Destination rhs = ((Destination) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(province, rhs.province).append(longName, rhs.longName).append(nonLocalizedCity, rhs.nonLocalizedCity).append(tla, rhs.tla).append(shortName, rhs.shortName).append(associatedMultiCityRegionId, rhs.associatedMultiCityRegionId).append(regionID, rhs.regionID).append(city, rhs.city).append(country, rhs.country).isEquals();
    }

}
