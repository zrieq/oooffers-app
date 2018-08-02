/**
 * 
 */
package com.oooffers.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.oooffers.dao.AbstractDao;
import com.oooffers.dao.interfaces.UserProfileDao;
import com.oooffers.dao.model.UserProfile;

/**
 * @author Zrieq
 *
 */
public class UserProfileDaoImpl extends AbstractDao implements UserProfileDao {
	 
    public UserProfile findById(int id) {
        return (UserProfile)getSession().load(UserProfile.class, id);
    }
 
    public UserProfile findByType(String type) {
        Criteria crit = getSession().createCriteria(UserProfile.class);
        crit.add(Restrictions.eq("type", type));
        return (UserProfile) crit.uniqueResult();
    }
     
    @SuppressWarnings("unchecked")
    public List<UserProfile> findAll(){
        Criteria crit = getSession().createCriteria(UserProfile.class);
        crit.addOrder(Order.asc("type"));
        return (List<UserProfile>)crit.list();
    }
     
}
