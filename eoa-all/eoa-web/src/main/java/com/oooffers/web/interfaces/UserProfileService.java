/**
 * 
 */
package com.oooffers.web.interfaces;

import java.util.List;

import com.oooffers.domain.UserProfile;

/**
 * @author Zrieq
 *
 */
public interface UserProfileService {
	
	UserProfile findById(int id);
	 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
}
