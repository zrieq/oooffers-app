/**
 * 
 */
package com.oooffers.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;

import com.oooffers.dao.interfaces.UserProfileDao;
import com.oooffers.domain.User;
import com.oooffers.domain.UserProfile;
import com.oooffers.web.interfaces.UserProfileService;

/**
 * @author Zrieq
 * 
 */
public class UserProfileServiceImpl implements UserProfileService {

	@Resource
	UserProfileDao dao;

	@Resource(name = "webDozerMapper")
	private Mapper mapper;

	public UserProfile findById(int id) {
		return mapper.map(dao.findById(id), UserProfile.class);
	}

	public UserProfile findByType(String type) {
		return mapper.map(dao.findByType(type), UserProfile.class);
	}

	public List<UserProfile> findAll() {
		List<com.oooffers.dao.model.UserProfile> userProfiles = dao.findAll();
		List<UserProfile> userProfilesList = new ArrayList<>();
		for (com.oooffers.dao.model.UserProfile userProfile : userProfiles) {
			userProfilesList.add(mapper.map(userProfile, UserProfile.class));
		}
		return userProfilesList;
	}
}
