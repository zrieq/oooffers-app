/**
 * 
 */
package com.oooffers.adapter.offers.expedia;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.oooffers.adapter.offers.IOffersSvc;
import com.oooffers.common.util.Util;
import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.common.util.constant.EOAConstants.PRODUCT_TYPE;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.common.util.exception.EOAExceptionUtil;
import com.oooffers.common.util.exception.ErrorCode;
import com.oooffers.domain.GetOffersResponse;
import com.oooffers.domain.expedia.ExpediaGetOffersResponse;

/**
 * @author Zrieq
 * 
 */
@Component(value = "expediaOffersSvcAdapter")
public class ExpediaOffersSvcAdapter implements IOffersSvc {

	private final static Logger LOG = LoggerFactory.getLogger(ExpediaOffersSvcAdapter.class);

	@Value("${app.service.expedia.offers.svc.endpoint}")
	private String expediaOffersServiceEndpoint;

	@Override
	public GetOffersResponse getOffers(Date tripStartDate, int lengthOfStay, Map<String, Object> filters, PRODUCT_TYPE productType)
			throws EOAException {
		String methodName = "ExpediaOffersSvcAdapter.getOffers()";
		GetOffersResponse getOffersResponse = new GetOffersResponse();
		// TODO: add needed validation for inputs and create helper class to prepare and parse request/response. Also add sufficient logs and
		// documentation.
		String expediaOffersServiceFullUrl = prepareEndpointUrl(tripStartDate, lengthOfStay, filters);

		RestTemplate restTemplate = new RestTemplate();
		ExpediaGetOffersResponse expediaGetOffersResponse = null;
		try {
			expediaGetOffersResponse = restTemplate.getForObject(expediaOffersServiceFullUrl, ExpediaGetOffersResponse.class);
			LOG.info(expediaGetOffersResponse.toString());
			getOffersResponse.setOfferInfo(expediaGetOffersResponse.getOfferInfo());
			getOffersResponse.setOffers(expediaGetOffersResponse.getOffers());
		} catch (Exception e) {
			EOAExceptionUtil.logAndRethrowEOAException(LOG, ErrorCode.EOA_UNDEFINED_ERROR, methodName, e.getMessage(), e);
		}
		return getOffersResponse;
	}

	private String prepareEndpointUrl(Date tripStartDate, int lengthOfStay, Map<String, Object> filters) {
		if (filters == null) {
			filters = new HashMap<String, Object>();
		}

		filters.put(EOAConstants.KEY_PRODUCT_TYPE, PRODUCT_TYPE.HOTEL);
		String startDateStr = Util.formatDate(tripStartDate);
		filters.put(EOAConstants.KEY_MIN_TRIP_START_DATE, startDateStr);
		filters.put(EOAConstants.KEY_MAX_TRIP_START_DATE, startDateStr);
		filters.put(EOAConstants.KEY_LENGTH_OF_STAY, lengthOfStay);
		String expediaOffersServiceFullUrl = expediaOffersServiceEndpoint + EOAConstants.STR_QUERY_STRING_AND
				+ Util.returnMapEntriesAsQueryString(filters);
		LOG.info("expediaOffersServiceEndpoint=[" + expediaOffersServiceFullUrl + "].");
		return expediaOffersServiceFullUrl;
	}

}
