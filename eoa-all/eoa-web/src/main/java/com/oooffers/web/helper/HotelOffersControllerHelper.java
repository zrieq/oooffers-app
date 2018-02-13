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

	public Map<String, Object> prepareFilters(SearchForm searchForm, Map<String, Object> allRequestParams) {
		HashMap<String, Object> filters = new HashMap<String, Object>();
		filters.put(EOAConstants.KEY_DESTINATION_NAME, searchForm.getDestinationFormattedAddress());

		if (allRequestParams != null) {
			// move all params to filters
			// TODO: mapping shall be created to move only needed params
			filters.putAll(allRequestParams);
			setTotalRateFilter(filters);
		}
		return filters;
	}

	public void setTotalRateFilter(Map<String, Object> filters) {
		String totalRate = (String) filters.get(EOAConstants.KEY_TOTAL_RATE);
		if (totalRate != null && !totalRate.isEmpty()) {
			int totalRateInt = new Integer(totalRate);
			int minRate, maxRate;
			minRate = maxRate = -1;
			// Remove the totalRateRange param to replace it with minTotalRate & maxTotalRate
			filters.remove(EOAConstants.KEY_TOTAL_RATE);
			switch (totalRateInt) {
			case 1:
				maxRate = 75;
				break;
			case 2:
				minRate = 75;
				maxRate = 124;
				break;
			case 3:
				minRate = 125;
				maxRate = 199;
				break;
			case 4:
				minRate = 200;
				break;
			default:
				break;
			}
			if (minRate != -1) {
				filters.put(EOAConstants.KEY_MIN_TOTAL_RATE, minRate);
			}
			if (maxRate != -1) {
				filters.put(EOAConstants.KEY_MAX_TOTAL_RATE, maxRate);
			}
		}
	}

}
