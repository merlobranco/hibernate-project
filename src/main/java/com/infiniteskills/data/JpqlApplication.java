package com.infiniteskills.data;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpqlApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			factory = Persistence
					.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Query query = em.createNamedQuery("Account.byWithdrawlAmount");
			query.setParameter("amount", new BigDecimal(99));
			
			List<Object[]> accounts = query.getResultList();
			
			// Retrieving the data through projection
			for(Object[] a:accounts){
				System.out.println(a[0] + " - " + a[1]);
			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
	}
}
