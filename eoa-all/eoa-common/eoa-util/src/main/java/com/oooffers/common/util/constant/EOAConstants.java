/**
 * 
 */
package com.oooffers.common.util.constant;

/**
 * @author Zrieq
 * 
 */
public final class EOAConstants {

	public static final String STR_QUERY_STRING_AND = "&";
	public static final String KEY_PRODUCT_TYPE = "productType";
	public static final String KEY_MIN_TRIP_START_DATE = "minTripStartDate";
	public static final String KEY_MAX_TRIP_START_DATE = "maxTripStartDate";
	public static final String KEY_LENGTH_OF_STAY = "lengthOfStay";
	public static final String KEY_HOTEL_OFFERS_MODEL = "hotelOffersModel";
	public static final String KEY_SEARCH_FORM = "searchForm";
	public static final String KEY_DESTINATION_NAME = "destinationName";;
	public static final String KEY_TOTAL_RATE = "totalRateRange";
	public static final String KEY_AVG_RATE = "totalAverageRate";
	public static final String KEY_MIN_TOTAL_RATE = "minTotalRate";
	public static final String KEY_MAX_TOTAL_RATE = "maxTotalRate";
	public static final String KEY_MIN_AVG_RATE = "minAverageRate";
	public static final String KEY_MAX_AVG_RATE = "maxAverageRate";
	public static final String KEY_STAR_RATING = "starRating";
	public static final String KEY_MIN_STAR_RATING = "minStarRating";
	public static final String KEY_MAX_STAR_RATING = "maxStarRating";

	public static final int RATE_INT_74 = 74;
	public static final int RATE_INT_75 = 75;
	public static final int RATE_INT_124 = 124;
	public static final int RATE_INT_125 = 125;
	public static final int RATE_INT_199 = 199;
	public static final int RATE_INT_200 = 200;

	public enum PRODUCT_TYPE {
		HOTEL
	}
	
	public enum PRICE_PER_NIGHT_FILTER_OPTIONS {
		OPT_PRICE_BELOW_75(1),OPT_PRICE_BETWEEN_75_AND_124(2),OPT_PRICE_BETWEEN_125_AND_199(3),OPT_PRICE_ABOVE_200(4);
		
		private int value;
		
		private PRICE_PER_NIGHT_FILTER_OPTIONS(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
}
