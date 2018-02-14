/**
 * 
 */
package com.oooffers.web.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.oooffers.common.util.Util;
import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.common.util.constant.EOAConstants.PRICE_PER_NIGHT_FILTER_OPTIONS;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.web.model.HotelOffersModel;
import com.oooffers.web.model.HotelOffersWrapper;
import com.oooffers.web.model.SearchForm;
import com.oooffers.web.service.OooffersService;

/**
 * @author Zrieq
 * 
 */
@Component(value = "hotelOffersControllerHelper")
public class HotelOffersControllerHelper {

	private final static Logger LOG = LoggerFactory.getLogger(HotelOffersControllerHelper.class);

	@Resource(name = "oooffersSvc")
	private OooffersService oooffersService;

	public void executeHotelOffersSearch(SearchForm searchForm, Map<String, Object> allRequestParams, ModelMap model) throws EOAException {
		processSearchForm(searchForm);

		HotelOffersWrapper hotelOffersWrapper = prepareHotelOffersWrapper(searchForm, allRequestParams);

		HotelOffersModel hotelOffersModel = oooffersService.getHotelOffers(hotelOffersWrapper);

		model.put(EOAConstants.KEY_HOTEL_OFFERS_MODEL, hotelOffersModel);
	}

	private void processSearchForm(SearchForm searchForm) {
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

	private HotelOffersWrapper prepareHotelOffersWrapper(SearchForm searchForm, Map<String, Object> requestParam) throws EOAException {
		Map<String, Object> filters = prepareFilters(searchForm, requestParam);
		HotelOffersWrapper hotelOffersWrapper = new HotelOffersWrapper();
		hotelOffersWrapper.setFilters(filters);
		hotelOffersWrapper.setTripStartDate(searchForm.getTripStartDate());
		hotelOffersWrapper.setTripEndDate(searchForm.getTripEndDate());
		return hotelOffersWrapper;
	}

	private Map<String, Object> prepareFilters(SearchForm searchForm, Map<String, Object> allRequestParams) throws EOAException {
		HashMap<String, Object> filters = new HashMap<String, Object>();
		filters.put(EOAConstants.KEY_DESTINATION_NAME, searchForm.getDestinationFormattedAddress());

		if (allRequestParams != null) {
			// move all params to filters
			// TODO: mapping shall be created to move only needed params
			filters.putAll(allRequestParams);
			setStarRating(filters);
			setPricePerNightFilter(filters);
		}
		return filters;
	}

	private void setStarRating(Map<String, Object> filters) {
		String starRating = (String) filters.get(EOAConstants.KEY_STAR_RATING);
		if (starRating != null && !starRating.isEmpty()) {
			filters.put(EOAConstants.KEY_MIN_STAR_RATING, starRating);
			filters.put(EOAConstants.KEY_MAX_STAR_RATING, starRating);
		}
	}

	private void setPricePerNightFilter(Map<String, Object> filters) throws EOAException {
		String pricePerNightOptionStr = (String) filters.get(EOAConstants.KEY_AVG_RATE);
		if (pricePerNightOptionStr != null && !pricePerNightOptionStr.isEmpty()) {
			int pricePerNightOption = new Integer(pricePerNightOptionStr);
			PRICE_PER_NIGHT_FILTER_OPTIONS pricePerNight = PRICE_PER_NIGHT_FILTER_OPTIONS.getPricePerNightFilterOptionByValue(pricePerNightOption);

			int minRate, maxRate;
			minRate = maxRate = -1;
			// Remove the pricePerNightOption param to replace it with minTotalRate & maxTotalRate
			filters.remove(EOAConstants.KEY_AVG_RATE);
			switch (pricePerNight) {
			case OPT_PRICE_BELOW_75:
				maxRate = EOAConstants.RATE_INT_74;
				break;
			case OPT_PRICE_BETWEEN_75_AND_124:
				minRate = EOAConstants.RATE_INT_75;
				maxRate = EOAConstants.RATE_INT_124;
				break;
			case OPT_PRICE_BETWEEN_125_AND_199:
				minRate = EOAConstants.RATE_INT_125;
				maxRate = EOAConstants.RATE_INT_199;
				break;
			case OPT_PRICE_ABOVE_200:
				minRate = EOAConstants.RATE_INT_200;
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
