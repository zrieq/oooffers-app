
package com.oooffers.domain.expedia;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.oooffers.domain.OfferInfo;
import com.oooffers.domain.Offers;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offerInfo",
    "userInfo",
    "offers"
})
public class ExpediaGetOffersResponse {

    @JsonProperty("offerInfo")
    private OfferInfo offerInfo;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonProperty("offers")
    private Offers offers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("offerInfo")
    public OfferInfo getOfferInfo() {
        return offerInfo;
    }

    @JsonProperty("offerInfo")
    public void setOfferInfo(OfferInfo offerInfo) {
        this.offerInfo = offerInfo;
    }

    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonProperty("offers")
    public Offers getOffers() {
        return offers;
    }

    @JsonProperty("offers")
    public void setOffers(Offers offers) {
        this.offers = offers;
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
        return new ToStringBuilder(this).append("offerInfo", offerInfo).append("userInfo", userInfo).append("offers", offers).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(offers).append(offerInfo).append(userInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExpediaGetOffersResponse) == false) {
            return false;
        }
        ExpediaGetOffersResponse rhs = ((ExpediaGetOffersResponse) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(offers, rhs.offers).append(offerInfo, rhs.offerInfo).append(userInfo, rhs.userInfo).isEquals();
    }

}
