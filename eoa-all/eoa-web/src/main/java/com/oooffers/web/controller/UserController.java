/**
 * 
 */
package com.oooffers.web.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oooffers.common.util.constant.EOAConstants;
import com.oooffers.common.util.constant.EOAConstants.UserProfileType;
import com.oooffers.common.util.exception.EOAException;
import com.oooffers.domain.User;
import com.oooffers.domain.UserProfile;
import com.oooffers.domain.UserSearchHistory;
import com.oooffers.web.interfaces.UserService;
import com.oooffers.web.model.UserRegisterForm;
import com.oooffers.web.model.UserSearchHistoryForm;

/**
 * @author Zrieq
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private final static Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public Object registerUserPost(@ModelAttribute("userRegisterForm") UserRegisterForm userRegisterForm, BindingResult result, ModelMap model)
			throws EOAException {
		LOG.info("userRegisterForm data: " + userRegisterForm.toString());

		if (!userRegisterForm.getPassword().equals(userRegisterForm.getConfirmPassword())) {
			model.addAttribute("error", "Entered password mismatched.");
			userRegisterForm.setPassword(null);
			userRegisterForm.setConfirmPassword(null);
			return new ModelAndView("register", EOAConstants.KEY_USER_REGISTER_FORM, userRegisterForm);
		}
		
		User user = new User();
		user.setUsername(userRegisterForm.getUsername());
		user.setEmail(userRegisterForm.getEmail());
		user.setPassword(userRegisterForm.getPassword());
		HashSet<UserProfile> userProfile = new HashSet<UserProfile>();
		UserProfile userProfileUser = new UserProfile();
		userProfileUser.setId(1);
		userProfileUser.setType(UserProfileType.USER.name());
		userProfile.add(userProfileUser);
		user.setUserProfiles(userProfile);
		userService.saveUser(user);
		return "userRegisteredSuccessfully";
	}
	
	@RequestMapping(value = { "/search-history" }, method = RequestMethod.GET)
	public ModelAndView getUserSearchHistory(ModelMap model, Principal principal) {
		
		User loggedUser = userService.findByUsername(principal.getName());
		List<UserSearchHistory> findAllUserSearchHistoryByUserId = userService.findAllUserSearchHistoryByUserId(loggedUser.getId());
		UserSearchHistoryForm modelObject = new UserSearchHistoryForm();
		modelObject.setUserSearchHistory(findAllUserSearchHistoryByUserId);
		ModelAndView modelAndView = new ModelAndView("userSearchHistory", EOAConstants.KEY_USER_SEARCH_HISTORY_FORM, modelObject);
		return modelAndView;
	}
	
}
