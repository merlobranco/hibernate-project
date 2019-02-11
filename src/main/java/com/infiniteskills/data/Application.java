package com.infiniteskills.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.TimeTest;
import com.infiniteskills.data.entities.User;

/**
 * Class created for testing purposes
 * @author brais
 *
 */
public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		try {
			session.getTransaction().begin();
			
			Date date = new Date();
			User user = new User();
			user.setBirthDate(getMyBirthday());
			user.setCreatedBy("Brais");
			user.setCreatedDate(date);
			user.setEmailAddress("brais@email.com");
			user.setFirstName("Kevin");
			user.setLastName("Cidras");
			user.setLastUpdatedBy("Brais");
			user.setLastUpdatedDate(date);
			
			session.save(user);
			session.getTransaction().commit();
			
			session.refresh(user);
			
			System.out.println(user.getAge());
			
//			TimeTest test = new TimeTest(new Date());
//			session.save(test);
//			session.getTransaction().commit();
//			
//			// For getting the timeTest ID
//			session.refresh(test);
//			
//			System.out.println(test.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			HibernateUtil.getSessionfactory().close();
		}
	}
	
	private static Date getMyBirthday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 1981);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 27);
		return calendar.getTime();
	}
}
