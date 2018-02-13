/**
 * 
 */
package com.oooffers.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.web.model.SearchForm;

/**
 * @author Zrieq
 * 
 */

@Controller
@RequestMapping("/")
public class HomeController {

	private final static Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}

	@RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
	}

	@RequestMapping(value = { "/contactusAjax" }, method = RequestMethod.GET)
	public String contactUsAjaxPage(@RequestParam(name = "guestRating", required = false) String guestRating, ModelMap model) {
		LOG.info("Passed guestRating=[" + guestRating + "].");
		return "ajax.contactus";
	}

	@RequestMapping(value = { "/hotel-offers" }, method = RequestMethod.GET)
	public ModelAndView hotelOffers(ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("hotelOffersSearch", EOAConstants.KEY_SEARCH_FORM, new SearchForm());
		return modelAndView;
	}

}
