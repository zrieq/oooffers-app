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

	public HotelOffersModel getHotelOffers(Date tripStartDate, Date tripEndDate, Map<String, Object> filters) throws EOAException {
		String methodName = "OooffersService.getOffers(): ";
		LOG.info(methodName + "tripStartDate=[" + tripStartDate + "], tripEndDate=[" + tripEndDate + "], filters=["
				+ Util.returnMapEntriesAsString(filters) + "]. ");

		int lengthOfStay = Util.getDifferenceDays(tripStartDate, tripEndDate);
		GetOffersResponse hotelOffersResponse = offersSvc.getOffers(tripStartDate, lengthOfStay, filters, PRODUCT_TYPE.HOTEL);
		HotelOffersModel hotelOffersModel = mapper.map(hotelOffersResponse, HotelOffersModel.class);

		return hotelOffersModel;
	}
}
