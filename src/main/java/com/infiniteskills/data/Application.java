package com.infiniteskills.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.Bank;
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
			
			Bank bank = new Bank();
			bank.setName("Federal Trust");
			bank.setAddressLine1("33 Wall Street");
			bank.setAddressLine2("Suite 233");
			bank.setCity("New York");
			bank.setState("NY");
			bank.setZipCode("12345");
			bank.setInternational(false);
			bank.setCreatedBy("Kevin");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Kevin");
			bank.setLastUpdatedDate(new Date());
			bank.getContacts().put("MANAGER", "Joe");
			bank.getContacts().put("TELLER", "Mary");
			
			session.save(bank);
			
			session.getTransaction().commit();
			
//			Date date = new Date();
//			User user = new User();
//			user.setBirthDate(getMyBirthday());
//			user.setCreatedBy("Brais");
//			user.setCreatedDate(date);
//			user.setEmailAddress("brais@email.com");
//			user.setFirstName("Brais");
//			user.setLastName("Cidras");
//			user.setLastUpdatedBy("Brais");
//			user.setLastUpdatedDate(date);
//			
//			Address address = new Address();
//			address.setAddressLine1("Blood");
//			address.setAddressLine2("Rage");
//			address.setCity("Madrid");
//			address.setState("28");
//			address.setZipCode("28000");
//			user.setAddress(address);
//			
//			session.save(user);
//			session.getTransaction().commit();
//			
//			session.refresh(user);
//			
//			System.out.println(user.getAge());
			
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
