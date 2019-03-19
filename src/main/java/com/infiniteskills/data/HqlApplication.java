package com.infiniteskills.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.infiniteskills.data.entities.Account;

public class HqlApplication {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;
		
		try{
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			
			// Using implicit form of the join
			Query query = session.getNamedQuery("Account.largeDeposits");
			
		
			List<Account> accounts = query.list();
			
			for(Account a:accounts){
				System.out.println(a.getName());
			}
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
			factory.close();
		}
	}
}

