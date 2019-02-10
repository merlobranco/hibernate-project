package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.User;

/**
 * Class created for testing purposes
 * @author brais
 *
 */
public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.getTransaction().begin();
		
		User user = new User();
		Date date = new Date();
		user.setBirthDate(date);
		user.setCreatedDate(date);
		user.setCreatedBy("Brais");
		user.setEmailAddress("brais@email.com");
		user.setFirstName("Brais");
		user.setLastName("Cidras");
		user.setLastUpdatedBy("Brais");
		user.setLastUpdatedDate(date);
		
		session.save(user);
		session.getTransaction().commit();
		session.close();

	}
}
