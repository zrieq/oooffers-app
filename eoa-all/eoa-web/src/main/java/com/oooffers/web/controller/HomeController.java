/**
 * 
 */
package com.oooffers.web.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
    @Resource
    private AuthenticationTrustResolver authenticationTrustResolver;
    
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
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

	@RequestMapping(value = { "/error" }, method = RequestMethod.GET)
	public String error(ModelMap model) {
		return "error";
	}
	
	/**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/";  
        }
    }
    
    /**
     * This method returns true if users is already authenticated [logged-in], else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
