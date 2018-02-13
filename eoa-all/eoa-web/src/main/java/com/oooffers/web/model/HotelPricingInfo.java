package com.oooffers.web.model;

public class HotelPricingInfo {

	private Double averagePriceValue;
	private Double totalPriceValue;
	private Double crossOutPriceValue;
	private Double originalPricePerNight;
	private String currency;
	private Double percentSavings;
	private Boolean drr;

	public Double getAveragePriceValue() {
		return averagePriceValue;
	}

	public void setAveragePriceValue(Double averagePriceValue) {
		this.averagePriceValue = averagePriceValue;
	}

	public Double getTotalPriceValue() {
		return totalPriceValue;
	}

	public void setTotalPriceValue(Double totalPriceValue) {
		this.totalPriceValue = totalPriceValue;
	}

	public Double getCrossOutPriceValue() {
		return crossOutPriceValue;
	}

	public void setCrossOutPriceValue(Double crossOutPriceValue) {
		this.crossOutPriceValue = crossOutPriceValue;
	}

	public Double getOriginalPricePerNight() {
		return originalPricePerNight;
	}

	public void setOriginalPricePerNight(Double originalPricePerNight) {
		this.originalPricePerNight = originalPricePerNight;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPercentSavings() {
		return percentSavings;
	}

	public void setPercentSavings(Double percentSavings) {
		this.percentSavings = percentSavings;
	}

	public Boolean getDrr() {
		return drr;
	}

	public void setDrr(Boolean drr) {
		this.drr = drr;
	}

}
