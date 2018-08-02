/**
 * 
 */
package com.oooffers.domain;

import com.oooffers.common.util.constant.EOAConstants.UserProfileType;

/**
 * @author Zrieq
 *
 */
public class UserProfile {
	
	private Integer id;

	private String type = UserProfileType.USER.getUserProfileType();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
