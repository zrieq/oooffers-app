/**
 * 
 */
package com.oooffers.dao.interfaces;

import java.util.List;

import com.oooffers.dao.model.UserSearchHistory;

/**
 * @author Zrieq
 * 
 */
public interface UserSearchHistoryDao {

	public List<UserSearchHistory> findByUserId(int userId);

	void save(UserSearchHistory userSearchHistory);
}
