
package com.oooffers.domain;

import java.util.HashMap;
import java.util.List;
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
    "travelStartDate",
    "travelEndDate",
    "lengthOfStay"
})
public class OfferDateRange {

    @JsonProperty("travelStartDate")
    private List<Integer> travelStartDate = null;
    @JsonProperty("travelEndDate")
    private List<Integer> travelEndDate = null;
    @JsonProperty("lengthOfStay")
    private Integer lengthOfStay;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("travelStartDate")
    public List<Integer> getTravelStartDate() {
        return travelStartDate;
    }

    @JsonProperty("travelStartDate")
    public void setTravelStartDate(List<Integer> travelStartDate) {
        this.travelStartDate = travelStartDate;
    }

    @JsonProperty("travelEndDate")
    public List<Integer> getTravelEndDate() {
        return travelEndDate;
    }

    @JsonProperty("travelEndDate")
    public void setTravelEndDate(List<Integer> travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    @JsonProperty("lengthOfStay")
    public Integer getLengthOfStay() {
        return lengthOfStay;
    }

    @JsonProperty("lengthOfStay")
    public void setLengthOfStay(Integer lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
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
        return new ToStringBuilder(this).append("travelStartDate", travelStartDate).append("travelEndDate", travelEndDate).append("lengthOfStay", lengthOfStay).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(travelEndDate).append(lengthOfStay).append(additionalProperties).append(travelStartDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OfferDateRange) == false) {
            return false;
        }
        OfferDateRange rhs = ((OfferDateRange) other);
        return new EqualsBuilder().append(travelEndDate, rhs.travelEndDate).append(lengthOfStay, rhs.lengthOfStay).append(additionalProperties, rhs.additionalProperties).append(travelStartDate, rhs.travelStartDate).isEquals();
    }

}
