package com.infiniteskills.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.infiniteskills.data.entities.User;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(User.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("There was an error building the factory");
		}
	}
}
