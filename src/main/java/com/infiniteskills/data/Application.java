package com.infiniteskills.data;

import org.hibernate.Session;

/**
 * Class created for testing purposes
 * @author brais
 *
 */
public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		session.close();
	}
}
