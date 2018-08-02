/**
 * 
 */
package com.oooffers.web.model;

import java.util.List;

import com.oooffers.domain.UserSearchHistory;

/**
 * @author Zrieq
 *
 */
public class UserSearchHistoryForm {
	
	private List<UserSearchHistory> userSearchHistory;

	public List<UserSearchHistory> getUserSearchHistory() {
		return userSearchHistory;
	}

	public void setUserSearchHistory(List<UserSearchHistory> userSearchHistory) {
		this.userSearchHistory = userSearchHistory;
	}
	
}
