/**
 * 
 */
package com.oooffers.web.model;

import java.util.Date;

/**
 * @author Zrieq
 * 
 */
public class SearchForm {

	private Date tripStartDate;

	private Date tripEndDate;

	private String destinationFormattedAddress;

	public Date getTripStartDate() {
		return tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public Date getTripEndDate() {
		return tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public String getDestinationFormattedAddress() {
		return destinationFormattedAddress;
	}

	public void setDestinationFormattedAddress(String destinationFormattedAddress) {
		this.destinationFormattedAddress = destinationFormattedAddress;
	}

	@Override
	public String toString() {
		return "destinationFormattedAddress=[" + destinationFormattedAddress +"], tripStartDate=[" + tripStartDate + "], tripEndDate=[" + tripEndDate + "].";
	}
}
