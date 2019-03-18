package com.infiniteskills.data.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import com.infiniteskills.data.HibernateUtil;
import com.infiniteskills.data.dao.interfaces.Dao;

public class AbstractDao<T,ID extends Serializable> implements Dao<T,ID> {

	private Class<T> persistentClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	protected Session getSession(){
		if(this.session == null){
			this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		}
		return this.session;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	protected List<T> findByCriteria(Criterion ... criterion) {
		
		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<T> query = builder.createQuery(this.getPersistentClass());
		
		// Define a range variable in FROM clause
		Root<T> root = query.from(this.getPersistentClass());
		
		CriteriaQuery<T> all = query.select(root);
		
		TypedQuery<T> allQuery = session.createQuery(all);
		return allQuery.getResultList();
	}
	
	public T findById(ID id) {
		return (T) getSession().load(this.getPersistentClass(), id);
	}

	public List<T> findAll() {
		return this.findByCriteria();
	}

	
	public T save(T entity) {
		this.getSession().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	public void flush() {
		this.getSession().flush();
	}

	public void clear() {
		this.getSession().clear();
	}
}
