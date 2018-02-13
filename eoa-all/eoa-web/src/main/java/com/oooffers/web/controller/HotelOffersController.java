/**
 * 
 */
package com.oooffers.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oooffers.common.util.Util;
import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.web.helper.HotelOffersControllerHelper;
import com.oooffers.web.model.HotelOffersModel;
import com.oooffers.web.model.SearchForm;
import com.oooffers.web.service.OooffersService;

/**
 * @author Zrieq
 * 
 */
@Controller
@RequestMapping("/hotel-offers")
public class HotelOffersController {

	private final static Logger LOG = LoggerFactory.getLogger(HotelOffersController.class);

	@Resource(name = "oooffersSvc")
	private OooffersService oooffersService;

	@Resource
	private HotelOffersControllerHelper hotelOffersControllerHelper;

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String filterHotelOffers(@ModelAttribute("searchForm") SearchForm searchForm, BindingResult result,
			@RequestParam Map<String, Object> allRequestParams, ModelMap model) {
		try {
			LOG.info("searchForm data: " + searchForm.toString());
			LOG.info("allRequestParams data: " + Util.returnMapEntriesAsString(allRequestParams));

			hotelOffersControllerHelper.processSearchForm(searchForm);
			Map<String, Object> filters = hotelOffersControllerHelper.prepareFilters(searchForm, allRequestParams);

			HotelOffersModel hotelOffersModel = oooffersService.getHotelOffers(searchForm.getTripStartDate(), searchForm.getTripEndDate(), filters);
			model.put(EOAConstants.KEY_HOTEL_OFFERS_MODEL, hotelOffersModel);
		} catch (EOAException e) {
			LOG.error(e.getErrorMessage(), e);
			// TODO error shall be redirected to human friendly error page to contact support
		}

		return "ajax.hotelOffersSearchResults";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String hotelOffersSearch(@ModelAttribute("searchForm") SearchForm searchForm, BindingResult result, ModelMap model) {
		try {
			LOG.info("searchForm data: " + searchForm.toString());
			hotelOffersControllerHelper.processSearchForm(searchForm);
			Map<String, Object> filters = hotelOffersControllerHelper.prepareFilters(searchForm, null);
			HotelOffersModel hotelOffersModel = oooffersService.getHotelOffers(searchForm.getTripStartDate(), searchForm.getTripEndDate(), filters);
			// set result model to be used by views.
			model.put(EOAConstants.KEY_HOTEL_OFFERS_MODEL, hotelOffersModel);

			if (hotelOffersModel.getOffers() != null && hotelOffersModel.getOffers().getHotel() != null
					&& hotelOffersModel.getOffers().getHotel().size() > 0) {
				return "hotelOffersSearchResults";
			}
		} catch (EOAException e) {
			LOG.error(e.getErrorMessage(), e);
		}

		return "hotelOffersSearchZeroResults";
	}

}
