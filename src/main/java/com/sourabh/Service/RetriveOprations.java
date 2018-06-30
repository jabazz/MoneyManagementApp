package com.sourabh.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sourabh.DAO.HibernateUtil;

public class RetriveOprations {

	public static void moneyOwnedPair(String moneyOwnedBy, String moneyOwnedTo){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "SELECT SUM(E.amount) FROM MasterRecord E " +
	             "WHERE  E.moneyOwnedBy = :moneyOwnedBy AND E.moneyOwnedTo = :moneyOwnedTo";
	   Query query = session.createQuery(hql);
	   query.setParameter("moneyOwnedBy", moneyOwnedBy);
	   query.setParameter("moneyOwnedTo", moneyOwnedTo);
	   List results = query.list();
	   
		session.getTransaction().commit();
		session.close();
		if(results.get(0) == null){
			results.set(0, 0.0);
		}
		System.out.println(moneyOwnedBy+" will pay to"+"------->"+ moneyOwnedTo +":"+ results.get(0));
		}
	
	public static void individualBalance(String moneyOwnedBy){

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "SELECT DISTINCT(E.moneyOwnedTo) FROM MasterRecord E ";
		Query query = session.createQuery(hql);
		List results = query.list();
		
		System.out.println(results);
		
		for(Object ownedTo: results ){
			moneyOwnedPair(moneyOwnedBy,(String) ownedTo);
			}
		session.getTransaction().commit();
		session.close();
	}
	
}
