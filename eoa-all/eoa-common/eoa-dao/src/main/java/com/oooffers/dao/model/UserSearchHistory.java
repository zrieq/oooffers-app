package com.oooffers.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="APP_USER_USER_SEARCH_HISTORY")
public class UserSearchHistory {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name="user_id", nullable=false)
    private Integer userId;
     
    @Column(name="search_location", nullable=true)
    private String searchLocation;
    
    @Column(name="search_start_date", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date searchStartDate;
    
    @Column(name="search_end_date", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date searchEndDate;
    
    @Column(name="search_execution_time", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
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
