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
import org.springframework.web.servlet.ModelAndView;

import com.oooffers.common.util.Util;
import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.web.helper.HotelOffersControllerHelper;
import com.oooffers.web.model.HotelOffersModel;
import com.oooffers.web.model.SearchForm;

/**
 * @author Zrieq
 * 
 */
@Controller
@RequestMapping("/hotel-offers")
public class HotelOffersController {

	private final static Logger LOG = LoggerFactory.getLogger(HotelOffersController.class);

	@Resource
	private HotelOffersControllerHelper hotelOffersControllerHelper;

	@RequestMapping(value = { "/search-ajax" }, method = RequestMethod.GET)
	public String filterHotelOffersAjax(@ModelAttribute("searchForm") SearchForm searchForm, BindingResult result,
			@RequestParam Map<String, Object> allRequestParams, ModelMap model) throws EOAException {
		LOG.info("searchForm data: " + searchForm.toString());
		LOG.info("allRequestParams data: " + Util.returnMapEntriesAsString(allRequestParams));

		hotelOffersControllerHelper.executeHotelOffersSearch(searchForm, allRequestParams, model);

		return "ajax.hotelOffersSearchResults";
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public ModelAndView hotelOffersSearchGet() {
		ModelAndView modelAndView = new ModelAndView("hotelOffersSearch", EOAConstants.KEY_SEARCH_FORM, new SearchForm());
		return modelAndView;
	}

	@RequestMapping(value = { "/search" }, method = RequestMethod.POST)
	public String hotelOffersSearchPost(@ModelAttribute("searchForm") SearchForm searchForm, BindingResult result, ModelMap model) throws EOAException {
		LOG.info("searchForm data: " + searchForm.toString());
		
		hotelOffersControllerHelper.executeHotelOffersSearch(searchForm, null, model);

		HotelOffersModel hotelOffersModel = (HotelOffersModel) model.get(EOAConstants.KEY_HOTEL_OFFERS_MODEL);

		if (hotelOffersModel.getOffers() != null && hotelOffersModel.getOffers().getHotel() != null
				&& hotelOffersModel.getOffers().getHotel().size() > 0) {
			return "hotelOffersSearchResults";
		}

		return "hotelOffersSearchZeroResults";
	}

}
