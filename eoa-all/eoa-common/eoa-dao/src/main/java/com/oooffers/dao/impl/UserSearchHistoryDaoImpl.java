/**
 * 
 */
package com.oooffers.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.oooffers.dao.AbstractDao;
import com.oooffers.dao.interfaces.UserSearchHistoryDao;
import com.oooffers.dao.model.UserSearchHistory;

/**
 * @author Zrieq
 * 
 */
@Component(value = "userSearchHistoryDao")
public class UserSearchHistoryDaoImpl extends AbstractDao implements UserSearchHistoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public  List<UserSearchHistory> findByUserId(int userId) {
		Criteria crit = getSession().createCriteria(UserSearchHistory.class);
		crit.add(Restrictions.eq("userId", userId));
        return (List<UserSearchHistory>)crit.list();
	}

	@Override
	public void save(UserSearchHistory userSearchHistory) {
		persist(userSearchHistory);
	}

}
