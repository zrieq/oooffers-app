/**
 * 
 */
package com.oooffers.web.model;

import java.util.Date;
import java.util.Map;

/**
 * @author Zrieq
 * 
 */
public class HotelOffersWrapper {
	private Date tripStartDate;

	private Date tripEndDate;

	private Map<String, Object> filters;

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

	public Map<String, Object> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Object> filters) {
		this.filters = filters;
	}

}
