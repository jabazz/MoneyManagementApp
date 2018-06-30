package com.sourabh.DAO;

import org.hibernate.Session;

import com.sourabh.Entity.MasterRecord;
import com.sourabh.Entity.Transaction;

public class RecordExpense {

	public static Integer insertTransaction(Transaction t) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + t.toString());
		return t.getId();
	}
	
	public static void insertMasterRecord(MasterRecord m) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + m.toString());
		
	}

}
