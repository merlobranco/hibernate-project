package com.infiniteskills.data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.infiniteskills.data.entities.Transaction;

public class HqlApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;
		
		try{
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Transaction> query = session.createQuery("select t from Transaction t "
															+ "where t.amount > ? and t.transactionType = 'Withdrawl'", Transaction.class);
			
			System.out.println("Please specify amount");
			
			query.setParameter(0, new BigDecimal(scanner.next()));
			
			List<Transaction> transactions = query.list();
			
			for(Transaction t:transactions){
				System.out.println(t.getTitle());
			}
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
			factory.close();
			scanner.close();
		}
	}
}

