
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
    "siteID",
    "language",
    "currency",
    "userSelectedCurrency"
})
public class OfferInfo {

    @JsonProperty("siteID")
    private String siteID;
    @JsonProperty("language")
    private String language;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("userSelectedCurrency")
    private String userSelectedCurrency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("siteID")
    public String getSiteID() {
        return siteID;
    }

    @JsonProperty("siteID")
    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("userSelectedCurrency")
    public String getUserSelectedCurrency() {
        return userSelectedCurrency;
    }

    @JsonProperty("userSelectedCurrency")
    public void setUserSelectedCurrency(String userSelectedCurrency) {
        this.userSelectedCurrency = userSelectedCurrency;
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
        return new ToStringBuilder(this).append("siteID", siteID).append("language", language).append("currency", currency).append("userSelectedCurrency", userSelectedCurrency).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(siteID).append(additionalProperties).append(userSelectedCurrency).append(language).append(currency).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OfferInfo) == false) {
            return false;
        }
        OfferInfo rhs = ((OfferInfo) other);
        return new EqualsBuilder().append(siteID, rhs.siteID).append(additionalProperties, rhs.additionalProperties).append(userSelectedCurrency, rhs.userSelectedCurrency).append(language, rhs.language).append(currency, rhs.currency).isEquals();
    }

}
