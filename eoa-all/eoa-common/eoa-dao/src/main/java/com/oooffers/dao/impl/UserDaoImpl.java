/**
 * 
 */
package com.oooffers.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.oooffers.dao.AbstractDao;
import com.oooffers.dao.interfaces.UserDao;
import com.oooffers.dao.model.User;
import com.oooffers.dao.model.UserProfile;

/**
 * @author Zrieq
 *
 */
@Component(value = "userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {
 
    private final static Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
     
    public User findByUsername(String username) {
        LOG.info("Username : {}", username);
        Criteria crit = getSession().createCriteria(User.class);
        crit.add(Restrictions.eq("username", username));
        User user = (User)crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }
 
    public void save(User user) {
        persist(user);
    }

	@Override
	public User findById(int id) {
		return (User)getSession().load(User.class, id);
	}

}
