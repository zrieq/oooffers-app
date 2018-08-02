/**
 * 
 */
package com.oooffers.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oooffers.domain.User;
import com.oooffers.domain.UserProfile;
import com.oooffers.web.interfaces.UserService;
/**
 * @author Zrieq
 * 
 */
@Component(value = "customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	private final static Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Resource
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		LOG.info("User : {}", user);
		if (user == null) {
			LOG.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true,
				getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : user.getUserProfiles()) {
			LOG.info("UserProfile : {}", userProfile);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		LOG.info("authorities : {}", authorities);
		return authorities;
	}

}
