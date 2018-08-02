/**
 * 
 */
package com.oooffers.domain;

import java.util.Date;

/**
 * @author Zrieq
 *
 */
public class UserSearchHistory {
	
    private Integer id;
 
    private Integer userId;
     
    private String searchLocation;
    
    private Date searchStartDate;
    
    private Date searchEndDate;
    
    private Date searchExecutionDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSearchLocation() {
		return searchLocation;
	}

	public void setSearchLocation(String searchLocation) {
		this.searchLocation = searchLocation;
	}

	public Date getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(Date searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public Date getSearchEndDate() {
		return searchEndDate;
	}

	public void setSearchEndDate(Date searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	public Date getSearchExecutionDate() {
		return searchExecutionDate;
	}

	public void setSearchExecutionDate(Date searchExecutionDate) {
		this.searchExecutionDate = searchExecutionDate;
	}
    
}
