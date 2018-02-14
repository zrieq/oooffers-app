/**
 * 
 */
package com.oooffers.web.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.oooffers.common.util.Util;
import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.web.model.HotelOffersWrapper;
import com.oooffers.web.model.SearchForm;

/**
 * @author Zrieq
 * 
 */
@Component(value = "hotelOffersControllerHelper")
public class HotelOffersControllerHelper {

	private final static Logger LOG = LoggerFactory.getLogger(HotelOffersControllerHelper.class);

	public void processSearchForm(SearchForm searchForm) {
		// set up a default tripStrat Date if nothing is passed
		if (searchForm.getTripStartDate() == null) {
			LOG.info("TripStartDate is null. We will set todays date as the TripStartDate .");
			Date today = new Date();
			searchForm.setTripStartDate(today);
		}

		// set up a default tripEndDate if nothing is passed equals to tripStartDate + 1
		if (searchForm.getTripEndDate() == null) {
			LOG.info("TripEndDate is null. We will add one day to TripStartDate and set it in TripEndDate.");
			// Add one day current date and set it.
			Date tripEndDate = Util.addDaysToDate(searchForm.getTripStartDate(), 1);
			searchForm.setTripEndDate(tripEndDate);
		}
	}

	public HotelOffersWrapper prepareHotelOffersWrapper(SearchForm searchForm, Map<String, Object> requestParam) {
		Map<String, Object> filters = prepareFilters(searchForm, requestParam);
		HotelOffersWrapper hotelOffersWrapper = new HotelOffersWrapper();
		hotelOffersWrapper.setFilters(filters);
		hotelOffersWrapper.setTripStartDate(searchForm.getTripStartDate());
		hotelOffersWrapper.setTripEndDate(searchForm.getTripEndDate());
		return hotelOffersWrapper;
	}

	private Map<String, Object> prepareFilters(SearchForm searchForm, Map<String, Object> allRequestParams) {
		HashMap<String, Object> filters = new HashMap<String, Object>();
		filters.put(EOAConstants.KEY_DESTINATION_NAME, searchForm.getDestinationFormattedAddress());

		if (allRequestParams != null) {
			// move all params to filters
			// TODO: mapping shall be created to move only needed params
			filters.putAll(allRequestParams);
			setStarRating(filters);
			setAverageRateFilter(filters);
		}
		return filters;
	}

	public void setStarRating(Map<String, Object> filters) {
		String starRating = (String) filters.get(EOAConstants.KEY_STAR_RATING);
		if (starRating != null && !starRating.isEmpty()) {
				filters.put(EOAConstants.KEY_MIN_STAR_RATING, starRating);
				filters.put(EOAConstants.KEY_MAX_STAR_RATING, starRating);
		}
	}

	private void setAverageRateFilter(Map<String, Object> filters) {
		String averageRate = (String) filters.get(EOAConstants.KEY_AVG_RATE);
		if (averageRate != null && !averageRate.isEmpty()) {
			int avgRateInt = new Integer(averageRate);
			int minRate, maxRate;
			minRate = maxRate = -1;
			// Remove the totalAverageRate param to replace it with minTotalRate & maxTotalRate
			filters.remove(EOAConstants.KEY_AVG_RATE);
			switch (avgRateInt) {
			case 1:
				maxRate = EOAConstants.RATE_INT_74;
				break;
			case 2:
				minRate = EOAConstants.RATE_INT_75;
				maxRate = EOAConstants.RATE_INT_124;
				break;
			case 3:
				minRate = EOAConstants.RATE_INT_125;
				maxRate = EOAConstants.RATE_INT_199;
				break;
			case 4:
				minRate = EOAConstants.RATE_INT_200;
				break;
			default:
				break;
			}
			if (minRate != -1) {
				filters.put(EOAConstants.KEY_MIN_AVG_RATE, minRate);
			}
			if (maxRate != -1) {
				filters.put(EOAConstants.KEY_MAX_AVG_RATE, maxRate);
			}
		}
	}

}
