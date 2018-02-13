
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
    "hotelInfositeUrl",
    "hotelSearchResultUrl"
})
public class HotelUrls {

    @JsonProperty("hotelInfositeUrl")
    private String hotelInfositeUrl;
    @JsonProperty("hotelSearchResultUrl")
    private String hotelSearchResultUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hotelInfositeUrl")
    public String getHotelInfositeUrl() {
        return hotelInfositeUrl;
    }

    @JsonProperty("hotelInfositeUrl")
    public void setHotelInfositeUrl(String hotelInfositeUrl) {
        this.hotelInfositeUrl = hotelInfositeUrl;
    }

    @JsonProperty("hotelSearchResultUrl")
    public String getHotelSearchResultUrl() {
        return hotelSearchResultUrl;
    }

    @JsonProperty("hotelSearchResultUrl")
    public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
        this.hotelSearchResultUrl = hotelSearchResultUrl;
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
        return new ToStringBuilder(this).append("hotelInfositeUrl", hotelInfositeUrl).append("hotelSearchResultUrl", hotelSearchResultUrl).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(hotelSearchResultUrl).append(hotelInfositeUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HotelUrls) == false) {
            return false;
        }
        HotelUrls rhs = ((HotelUrls) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(hotelSearchResultUrl, rhs.hotelSearchResultUrl).append(hotelInfositeUrl, rhs.hotelInfositeUrl).isEquals();
    }

}
