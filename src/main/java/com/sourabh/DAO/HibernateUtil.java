package com.sourabh.DAO;

import java.util.logging.Level;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;

	}

}
