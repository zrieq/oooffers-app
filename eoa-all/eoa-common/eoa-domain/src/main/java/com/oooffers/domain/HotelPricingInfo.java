
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
    "averagePriceValue",
    "totalPriceValue",
    "crossOutPriceValue",
    "originalPricePerNight",
    "currency",
    "percentSavings",
    "drr"
})
public class HotelPricingInfo {

    @JsonProperty("averagePriceValue")
    private Double averagePriceValue;
    @JsonProperty("totalPriceValue")
    private Double totalPriceValue;
    @JsonProperty("crossOutPriceValue")
    private Integer crossOutPriceValue;
    @JsonProperty("originalPricePerNight")
    private Integer originalPricePerNight;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("percentSavings")
    private Double percentSavings;
    @JsonProperty("drr")
    private Boolean drr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("averagePriceValue")
    public Double getAveragePriceValue() {
        return averagePriceValue;
    }

    @JsonProperty("averagePriceValue")
    public void setAveragePriceValue(Double averagePriceValue) {
        this.averagePriceValue = averagePriceValue;
    }

    @JsonProperty("totalPriceValue")
    public Double getTotalPriceValue() {
        return totalPriceValue;
    }

    @JsonProperty("totalPriceValue")
    public void setTotalPriceValue(Double totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    @JsonProperty("crossOutPriceValue")
    public Integer getCrossOutPriceValue() {
        return crossOutPriceValue;
    }

    @JsonProperty("crossOutPriceValue")
    public void setCrossOutPriceValue(Integer crossOutPriceValue) {
        this.crossOutPriceValue = crossOutPriceValue;
    }

    @JsonProperty("originalPricePerNight")
    public Integer getOriginalPricePerNight() {
        return originalPricePerNight;
    }

    @JsonProperty("originalPricePerNight")
    public void setOriginalPricePerNight(Integer originalPricePerNight) {
        this.originalPricePerNight = originalPricePerNight;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("percentSavings")
    public Double getPercentSavings() {
        return percentSavings;
    }

    @JsonProperty("percentSavings")
    public void setPercentSavings(Double percentSavings) {
        this.percentSavings = percentSavings;
    }

    @JsonProperty("drr")
    public Boolean getDrr() {
        return drr;
    }

    @JsonProperty("drr")
    public void setDrr(Boolean drr) {
        this.drr = drr;
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
        return new ToStringBuilder(this).append("averagePriceValue", averagePriceValue).append("totalPriceValue", totalPriceValue).append("crossOutPriceValue", crossOutPriceValue).append("originalPricePerNight", originalPricePerNight).append("currency", currency).append("percentSavings", percentSavings).append("drr", drr).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalPriceValue).append(averagePriceValue).append(additionalProperties).append(originalPricePerNight).append(drr).append(percentSavings).append(currency).append(crossOutPriceValue).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HotelPricingInfo) == false) {
            return false;
        }
        HotelPricingInfo rhs = ((HotelPricingInfo) other);
        return new EqualsBuilder().append(totalPriceValue, rhs.totalPriceValue).append(averagePriceValue, rhs.averagePriceValue).append(additionalProperties, rhs.additionalProperties).append(originalPricePerNight, rhs.originalPricePerNight).append(drr, rhs.drr).append(percentSavings, rhs.percentSavings).append(currency, rhs.currency).append(crossOutPriceValue, rhs.crossOutPriceValue).isEquals();
    }

}
