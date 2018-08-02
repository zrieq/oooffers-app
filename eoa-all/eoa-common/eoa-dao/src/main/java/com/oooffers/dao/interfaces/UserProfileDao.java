/**
 * 
 */
package com.oooffers.dao.interfaces;

import java.util.List;

import com.oooffers.dao.model.UserProfile;

/**
 * @author Zrieq
 * 
 */
public interface UserProfileDao {

	List<UserProfile> findAll();

	UserProfile findByType(String type);

	UserProfile findById(int id);
}
