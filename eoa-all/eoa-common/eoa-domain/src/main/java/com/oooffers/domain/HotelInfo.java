
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
    "hotelId",
    "hotelName",
    "localizedHotelName",
    "hotelDestination",
    "hotelDestinationRegionID",
    "hotelLongDestination",
    "hotelStreetAddress",
    "hotelCity",
    "hotelProvince",
    "hotelCountryCode",
    "hotelLatitude",
    "hotelLongitude",
    "hotelStarRating",
    "hotelGuestReviewRating",
    "hotelReviewTotal",
    "hotelImageUrl",
    "vipAccess",
    "isOfficialRating"
})
public class HotelInfo {

    @JsonProperty("hotelId")
    private String hotelId;
    @JsonProperty("hotelName")
    private String hotelName;
    @JsonProperty("localizedHotelName")
    private String localizedHotelName;
    @JsonProperty("hotelDestination")
    private String hotelDestination;
    @JsonProperty("hotelDestinationRegionID")
    private String hotelDestinationRegionID;
    @JsonProperty("hotelLongDestination")
    private String hotelLongDestination;
    @JsonProperty("hotelStreetAddress")
    private String hotelStreetAddress;
    @JsonProperty("hotelCity")
    private String hotelCity;
    @JsonProperty("hotelProvince")
    private String hotelProvince;
    @JsonProperty("hotelCountryCode")
    private String hotelCountryCode;
    @JsonProperty("hotelLatitude")
    private Double hotelLatitude;
    @JsonProperty("hotelLongitude")
    private Double hotelLongitude;
    @JsonProperty("hotelStarRating")
    private String hotelStarRating;
    @JsonProperty("hotelGuestReviewRating")
    private Double hotelGuestReviewRating;
    @JsonProperty("hotelReviewTotal")
    private Integer hotelReviewTotal;
    @JsonProperty("hotelImageUrl")
    private String hotelImageUrl;
    @JsonProperty("vipAccess")
    private Boolean vipAccess;
    @JsonProperty("isOfficialRating")
    private Boolean isOfficialRating;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hotelId")
    public String getHotelId() {
        return hotelId;
    }

    @JsonProperty("hotelId")
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @JsonProperty("hotelName")
    public String getHotelName() {
        return hotelName;
    }

    @JsonProperty("hotelName")
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @JsonProperty("localizedHotelName")
    public String getLocalizedHotelName() {
        return localizedHotelName;
    }

    @JsonProperty("localizedHotelName")
    public void setLocalizedHotelName(String localizedHotelName) {
        this.localizedHotelName = localizedHotelName;
    }

    @JsonProperty("hotelDestination")
    public String getHotelDestination() {
        return hotelDestination;
    }

    @JsonProperty("hotelDestination")
    public void setHotelDestination(String hotelDestination) {
        this.hotelDestination = hotelDestination;
    }

    @JsonProperty("hotelDestinationRegionID")
    public String getHotelDestinationRegionID() {
        return hotelDestinationRegionID;
    }

    @JsonProperty("hotelDestinationRegionID")
    public void setHotelDestinationRegionID(String hotelDestinationRegionID) {
        this.hotelDestinationRegionID = hotelDestinationRegionID;
    }

    @JsonProperty("hotelLongDestination")
    public String getHotelLongDestination() {
        return hotelLongDestination;
    }

    @JsonProperty("hotelLongDestination")
    public void setHotelLongDestination(String hotelLongDestination) {
        this.hotelLongDestination = hotelLongDestination;
    }

    @JsonProperty("hotelStreetAddress")
    public String getHotelStreetAddress() {
        return hotelStreetAddress;
    }

    @JsonProperty("hotelStreetAddress")
    public void setHotelStreetAddress(String hotelStreetAddress) {
        this.hotelStreetAddress = hotelStreetAddress;
    }

    @JsonProperty("hotelCity")
    public String getHotelCity() {
        return hotelCity;
    }

    @JsonProperty("hotelCity")
    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    @JsonProperty("hotelProvince")
    public String getHotelProvince() {
        return hotelProvince;
    }

    @JsonProperty("hotelProvince")
    public void setHotelProvince(String hotelProvince) {
        this.hotelProvince = hotelProvince;
    }

    @JsonProperty("hotelCountryCode")
    public String getHotelCountryCode() {
        return hotelCountryCode;
    }

    @JsonProperty("hotelCountryCode")
    public void setHotelCountryCode(String hotelCountryCode) {
        this.hotelCountryCode = hotelCountryCode;
    }

    @JsonProperty("hotelLatitude")
    public Double getHotelLatitude() {
        return hotelLatitude;
    }

    @JsonProperty("hotelLatitude")
    public void setHotelLatitude(Double hotelLatitude) {
        this.hotelLatitude = hotelLatitude;
    }

    @JsonProperty("hotelLongitude")
    public Double getHotelLongitude() {
        return hotelLongitude;
    }

    @JsonProperty("hotelLongitude")
    public void setHotelLongitude(Double hotelLongitude) {
        this.hotelLongitude = hotelLongitude;
    }

    @JsonProperty("hotelStarRating")
    public String getHotelStarRating() {
        return hotelStarRating;
    }

    @JsonProperty("hotelStarRating")
    public void setHotelStarRating(String hotelStarRating) {
        this.hotelStarRating = hotelStarRating;
    }

    @JsonProperty("hotelGuestReviewRating")
    public Double getHotelGuestReviewRating() {
        return hotelGuestReviewRating;
    }

    @JsonProperty("hotelGuestReviewRating")
    public void setHotelGuestReviewRating(Double hotelGuestReviewRating) {
        this.hotelGuestReviewRating = hotelGuestReviewRating;
    }

    @JsonProperty("hotelReviewTotal")
    public Integer getHotelReviewTotal() {
        return hotelReviewTotal;
    }

    @JsonProperty("hotelReviewTotal")
    public void setHotelReviewTotal(Integer hotelReviewTotal) {
        this.hotelReviewTotal = hotelReviewTotal;
    }

    @JsonProperty("hotelImageUrl")
    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    @JsonProperty("hotelImageUrl")
    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
    }

    @JsonProperty("vipAccess")
    public Boolean getVipAccess() {
        return vipAccess;
    }

    @JsonProperty("vipAccess")
    public void setVipAccess(Boolean vipAccess) {
        this.vipAccess = vipAccess;
    }

    @JsonProperty("isOfficialRating")
    public Boolean getIsOfficialRating() {
        return isOfficialRating;
    }

    @JsonProperty("isOfficialRating")
    public void setIsOfficialRating(Boolean isOfficialRating) {
        this.isOfficialRating = isOfficialRating;
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
        return new ToStringBuilder(this).append("hotelId", hotelId).append("hotelName", hotelName).append("localizedHotelName", localizedHotelName).append("hotelDestination", hotelDestination).append("hotelDestinationRegionID", hotelDestinationRegionID).append("hotelLongDestination", hotelLongDestination).append("hotelStreetAddress", hotelStreetAddress).append("hotelCity", hotelCity).append("hotelProvince", hotelProvince).append("hotelCountryCode", hotelCountryCode).append("hotelLatitude", hotelLatitude).append("hotelLongitude", hotelLongitude).append("hotelStarRating", hotelStarRating).append("hotelGuestReviewRating", hotelGuestReviewRating).append("hotelReviewTotal", hotelReviewTotal).append("hotelImageUrl", hotelImageUrl).append("vipAccess", vipAccess).append("isOfficialRating", isOfficialRating).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hotelStreetAddress).append(hotelImageUrl).append(localizedHotelName).append(hotelStarRating).append(vipAccess).append(hotelLatitude).append(hotelDestination).append(isOfficialRating).append(hotelProvince).append(hotelDestinationRegionID).append(hotelId).append(hotelLongitude).append(hotelCity).append(hotelReviewTotal).append(hotelName).append(additionalProperties).append(hotelGuestReviewRating).append(hotelCountryCode).append(hotelLongDestination).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HotelInfo) == false) {
            return false;
        }
        HotelInfo rhs = ((HotelInfo) other);
        return new EqualsBuilder().append(hotelStreetAddress, rhs.hotelStreetAddress).append(hotelImageUrl, rhs.hotelImageUrl).append(localizedHotelName, rhs.localizedHotelName).append(hotelStarRating, rhs.hotelStarRating).append(vipAccess, rhs.vipAccess).append(hotelLatitude, rhs.hotelLatitude).append(hotelDestination, rhs.hotelDestination).append(isOfficialRating, rhs.isOfficialRating).append(hotelProvince, rhs.hotelProvince).append(hotelDestinationRegionID, rhs.hotelDestinationRegionID).append(hotelId, rhs.hotelId).append(hotelLongitude, rhs.hotelLongitude).append(hotelCity, rhs.hotelCity).append(hotelReviewTotal, rhs.hotelReviewTotal).append(hotelName, rhs.hotelName).append(additionalProperties, rhs.additionalProperties).append(hotelGuestReviewRating, rhs.hotelGuestReviewRating).append(hotelCountryCode, rhs.hotelCountryCode).append(hotelLongDestination, rhs.hotelLongDestination).isEquals();
    }

}
