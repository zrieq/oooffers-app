/**
 * 
 */
package com.oooffers.adapter.offers;

import java.util.Date;
import java.util.Map;

import com.oooffers.common.util.constant.EOAConstants.PRODUCT_TYPE;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.domain.GetOffersResponse;

/**
 * @author Zrieq
 *
 */
public interface IOffersSvc {
	
	/**
	 * 
	 * getOffers will return offers details for the selected period of time, product and passed filters.
	 * 
	 * @param tripStartDate start date that will be used to lookup the offers. 
	 * @param lengthOfStay period in days.
	 * @param filters a map of filter list that will be used to retrieve the offers. null is allowed for no filters.
	 * @param productType use {@link PRODUCT_TYPE} enum to pass the need type. 
	 * @return an object wrapper that has the list of Offers and offersInfo.
	 * @throws EOAException an exception will be thrown with desired error code and message in case of any issues.
	 */
	public GetOffersResponse getOffers(Date tripStartDate, int lengthOfStay, Map<String,Object> filters, PRODUCT_TYPE productType) throws EOAException;
	
}
