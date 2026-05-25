/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rizal
 * @param <T>
 */
public class BaseDao<T> {

    protected Class<T> domainClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        this.domainClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(T domain) {
        sessionFactory.getCurrentSession().save(domain);
    }

    public void update(T domain) {
        sessionFactory.getCurrentSession().update(domain);
    }

    public void merge(T domain) {
        sessionFactory.getCurrentSession().merge(domain);
    }

    public void delete(T domain) {
        sessionFactory.getCurrentSession().delete(domain);
    }

    @SuppressWarnings("unchecked")
    public T getFromCode(String c) {
        return (T) sessionFactory.getCurrentSession().getNamedQuery(domainClass.getSimpleName() + ".findByCode")
                .setParameter("code", c).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + domainClass.getName()).list();
    }
}
