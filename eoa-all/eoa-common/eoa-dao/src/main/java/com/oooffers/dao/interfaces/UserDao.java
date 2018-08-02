/**
 * 
 */
package com.oooffers.dao.interfaces;

import com.oooffers.dao.model.User;

/**
 * @author Zrieq
 * 
 */
public interface UserDao {
	
	User findById(int id);
	
	User findByUsername(String username);

	void save(User user);

}
