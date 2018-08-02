/**
 * 
 */
package com.oooffers.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oooffers.dao.interfaces.UserDao;
import com.oooffers.dao.interfaces.UserSearchHistoryDao;
import com.oooffers.domain.User;
import com.oooffers.domain.UserSearchHistory;
import com.oooffers.web.interfaces.UserService;

/**
 * @author Zrieq
 * 
 */
@Component(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private UserSearchHistoryDao userSearchHistoryDao;

	@Resource(name = "webDozerMapper")
	private Mapper mapper;

	@Resource
	private PasswordEncoder passwordEncoder;

	public User findById(int id) {
		return mapper.map(userDao.findById(id), User.class);
	}

	public User findByUsername(String username) {
		com.oooffers.dao.model.User user = userDao.findByUsername(username);
		return mapper.map(user, User.class);
	}

	public void saveUser(User user) {
		com.oooffers.dao.model.User daoUser = mapper.map(user, com.oooffers.dao.model.User.class);
		daoUser.setPassword(passwordEncoder.encode(daoUser.getPassword()));
		userDao.save(daoUser);
	}

	public void saveUserSearchHistory(UserSearchHistory userSearchHistory) {
		com.oooffers.dao.model.UserSearchHistory daoUserSearchHistory = mapper.map(userSearchHistory, com.oooffers.dao.model.UserSearchHistory.class);
		userSearchHistoryDao.save(daoUserSearchHistory);
	}

	public boolean isUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

	@Override
	public List<UserSearchHistory> findAllUserSearchHistoryByUserId(Integer userId) {
		List<com.oooffers.dao.model.UserSearchHistory> userSearchHistorys = userSearchHistoryDao.findByUserId(userId);
		List<UserSearchHistory> userSearchHistoryList = new ArrayList<>(); 
		for (com.oooffers.dao.model.UserSearchHistory userSearchHistory : userSearchHistorys) {
			userSearchHistoryList.add(mapper.map(userSearchHistory, UserSearchHistory.class));
		}
		return userSearchHistoryList;
	}
}