/**
 * 
 */
package com.oooffers.dao;


import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Zrieq
 *
 */
public abstract class AbstractDao {
	 
    @Resource
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
 
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
