
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
    "offerDateRange",
    "destination",
    "hotelInfo",
    "hotelPricingInfo",
    "hotelUrls"
})
public class Hotel {

    @JsonProperty("offerDateRange")
    private OfferDateRange offerDateRange;
    @JsonProperty("destination")
    private Destination destination;
    @JsonProperty("hotelInfo")
    private HotelInfo hotelInfo;
    @JsonProperty("hotelPricingInfo")
    private HotelPricingInfo hotelPricingInfo;
    @JsonProperty("hotelUrls")
    private HotelUrls hotelUrls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("offerDateRange")
    public OfferDateRange getOfferDateRange() {
        return offerDateRange;
    }

    @JsonProperty("offerDateRange")
    public void setOfferDateRange(OfferDateRange offerDateRange) {
        this.offerDateRange = offerDateRange;
    }

    @JsonProperty("destination")
    public Destination getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @JsonProperty("hotelInfo")
    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    @JsonProperty("hotelInfo")
    public void setHotelInfo(HotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    @JsonProperty("hotelPricingInfo")
    public HotelPricingInfo getHotelPricingInfo() {
        return hotelPricingInfo;
    }

    @JsonProperty("hotelPricingInfo")
    public void setHotelPricingInfo(HotelPricingInfo hotelPricingInfo) {
        this.hotelPricingInfo = hotelPricingInfo;
    }

    @JsonProperty("hotelUrls")
    public HotelUrls getHotelUrls() {
        return hotelUrls;
    }

    @JsonProperty("hotelUrls")
    public void setHotelUrls(HotelUrls hotelUrls) {
        this.hotelUrls = hotelUrls;
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
        return new ToStringBuilder(this).append("offerDateRange", offerDateRange).append("destination", destination).append("hotelInfo", hotelInfo).append("hotelPricingInfo", hotelPricingInfo).append("hotelUrls", hotelUrls).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(offerDateRange).append(hotelUrls).append(additionalProperties).append(hotelInfo).append(hotelPricingInfo).append(destination).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hotel) == false) {
            return false;
        }
        Hotel rhs = ((Hotel) other);
        return new EqualsBuilder().append(offerDateRange, rhs.offerDateRange).append(hotelUrls, rhs.hotelUrls).append(additionalProperties, rhs.additionalProperties).append(hotelInfo, rhs.hotelInfo).append(hotelPricingInfo, rhs.hotelPricingInfo).append(destination, rhs.destination).isEquals();
    }

}
