package com.rutko.golf.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

public abstract class HibernateDAO<T, ID extends java.io.Serializable>
{
	private Class<T> persistentClass;
	
	public HibernateDAO(Class c)
	{
		persistentClass = c;
	}
	
	public Session startSession()
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
		return session;
	}
	
	public List<T> findAll() {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		return crit.list() ;
	}
	
	public List<T> findAllOrder(String order) {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		crit.addOrder(Order.asc(order));
		return crit.list() ;
	}
	
	public List<T> findAllOrderDesc(String order) {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		crit.addOrder(Order.desc(order));
		return crit.list() ;
	}
	
	public List<T> findAll(String id, String value) {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		crit.add(Restrictions.eq(id, value));
		return 	crit.list() ;
	}
	
	public List<T> findAll(String id, String value, String id2, String val2, String id3, String val3, String id4, Date lower, Date upper, String order) {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		if (!(value.equals("")))
		crit.add(Restrictions.eq(id, value));
		if (!(val2.equals("")))
		crit.add(Expression.like(id2, "%"+val2+"%").ignoreCase());
		if (!(val3.equals("")))
		crit.add(Expression.like(id3, "%"+val3+"%").ignoreCase());
		if(!(upper==null)&& !(lower==null))
		{
			crit.add(Expression.between(id4, lower, upper));
			
		}
		crit.addOrder(Order.desc(order));
		return 	crit.list() ;
	}
	
	public List<T> findAllOrder(String id, String value, String order) {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		crit.add(Restrictions.eq(id, value));
		crit.addOrder(Order.asc(order));
		return 	crit.list() ;
	}
	
	public List<T> findAll(String id, int value) {
		Session s = startSession() ;
		Criteria crit = s.createCriteria(persistentClass);
		crit.add(Restrictions.eq(id, value));
		return 	crit.list() ;
	}
	
	public void evictObject(Object item) {
		Session session = startSession();
		session.evict(item) ;
		session.getTransaction().commit() ;
	}
	
	public void save(Object item) {
		Session session = startSession();
		session.beginTransaction();
		session.saveOrUpdate(item) ;
		session.getTransaction().commit() ;
	}
	
	public void deleteObjectByPID(Class c, int key){
		Session session=startSession();
		Object item =session.load(c, key);
		session.delete(item);	
		session.getTransaction().commit() ;
	}
	
	public void deleteObjectByPID(Class c, String key){
		Session session=startSession();
		Object item =session.load(c, key);
		session.delete(item);	
		session.getTransaction().commit() ;
	}
	
	public void delete(Object item) {
		Session session=startSession();
		session.delete(item);	
		session.getTransaction().commit();
	}
	
	public void deleteObjectByPID(Object item, String key){
		Session session=startSession();
		session.load(item, key);
		session.delete(item);		
		session.getTransaction().commit() ;
	}
	
	public T getObjectByPID(Class c, int key){
		Session session=startSession();
		return (T) session.load(c, key);
	}
	
	public T getObjectByPID(Class c, String key){
		Session session=startSession();
		return (T) session.load(c, key);
	}
	
	public void updateAll(String hsql)
	{
		Session session=startSession();
		Query q=session.createQuery(hsql);
		q.executeUpdate();
		session.getTransaction().commit() ;
	}
	
	public int count(String hsql)
	{
		Session session=startSession();
		Query query = session.createQuery(hsql);
		return Integer.parseInt(query.uniqueResult().toString());
	}
	
	public void sqlDelete(String hsql)
	{
		Session session=startSession();
		Query query=session.createQuery(hsql);
		query.executeUpdate();
	}

	public boolean checkExist(String hsql) {
		Session session=startSession();
		Query query = session.createQuery(hsql);
		Integer x= Integer.parseInt(query.uniqueResult().toString());
		if (x==0)
			return false;
		else
			return true;
	}

	public List<T> findRecent() {
		Session s = startSession() ;
		DetachedCriteria maxQuery = DetachedCriteria.forClass(persistentClass);
		maxQuery.setProjection( Projections.max( "occured" ) );
		Criteria crit = s.createCriteria(persistentClass);
		crit.add( Property.forName( "occured" ).eq( maxQuery ) );
		return 	crit.list() ;
	}

	public Integer getMax(String hsql) {
		Session session=startSession();
		Query query = session.createQuery(hsql);
		return Integer.parseInt(query.uniqueResult().toString());
	}
	
}