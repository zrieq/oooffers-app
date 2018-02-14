/**
 * 
 */
package com.oooffers.web.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.oooffers.adapter.offers.IOffersSvc;
import com.oooffers.common.util.Util;
import com.oooffers.common.util.constant.EOAConstants.PRODUCT_TYPE;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.domain.GetOffersResponse;
import com.oooffers.web.model.HotelOffersModel;
import com.oooffers.web.model.HotelOffersWrapper;
import com.oooffers.web.model.SearchForm;

/**
 * @author Zrieq
 * 
 */
@Component(value = "oooffersSvc")
public class OooffersService {

	private final static Logger LOG = LoggerFactory.getLogger(OooffersService.class);

	@Resource(name = "webDozerMapper")
	private Mapper mapper;

	@Resource
	private IOffersSvc offersSvc;

	public HotelOffersModel getHotelOffers(HotelOffersWrapper hotelOffersWrapper) throws EOAException {
		String methodName = "OooffersService.getOffers(): ";
		LOG.info(methodName + "tripStartDate=[" + hotelOffersWrapper.getTripStartDate() + "], tripEndDate=[" + hotelOffersWrapper.getTripEndDate() + "], filters=["
				+ Util.returnMapEntriesAsString(hotelOffersWrapper.getFilters()) + "]. ");
		
		processHotelOffersWrapper(hotelOffersWrapper);
		
		int lengthOfStay = Util.getDifferenceDays(hotelOffersWrapper.getTripStartDate(), hotelOffersWrapper.getTripEndDate());
		GetOffersResponse hotelOffersResponse = offersSvc.getOffers(hotelOffersWrapper.getTripStartDate(), lengthOfStay, hotelOffersWrapper.getFilters(), PRODUCT_TYPE.HOTEL);
		HotelOffersModel hotelOffersModel = mapper.map(hotelOffersResponse, HotelOffersModel.class);

		return hotelOffersModel;
	}

	private void processHotelOffersWrapper(HotelOffersWrapper hotelOffersWrapper) {
		// set up a default tripStrat Date if nothing is passed
		if (hotelOffersWrapper.getTripStartDate() == null) {
			LOG.info("TripStartDate is null. We will set todays date as the TripStartDate .");
			Date today = new Date();
			hotelOffersWrapper.setTripStartDate(today);
		}

		// set up a default tripEndDate if nothing is passed equals to tripStartDate + 1
		if (hotelOffersWrapper.getTripEndDate() == null) {
			LOG.info("TripEndDate is null. We will add one day to TripStartDate and set it in TripEndDate.");
			// Add one day current date and set it.
			Date tripEndDate = Util.addDaysToDate(hotelOffersWrapper.getTripStartDate(), 1);
			hotelOffersWrapper.setTripEndDate(tripEndDate);
		}
	}

}
