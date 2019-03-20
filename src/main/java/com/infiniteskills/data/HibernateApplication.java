package com.infiniteskills.data;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infiniteskills.data.entities.Transaction;

public class HibernateApplication {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;
		
		int pageNumber = 2;
		int pageSize = 4;

		try {
			factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			
			// Creating CriteriaBuilder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Transaction> criteria = builder.createQuery(Transaction.class);
			Root<Transaction> root = criteria.from(Transaction.class);
			
			// Adding select and order by clause
			criteria.select(root)
					// Adding order by clause
					.orderBy(builder.desc(root.get("title")));
			
			List<Transaction> transactions = session.createQuery(criteria)
					.setFirstResult((pageNumber - 1) * pageSize)
					.setMaxResults(pageSize)
					.getResultList();

			for (Transaction t : transactions) {
				System.out.println(t.getTitle());
			}

			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			factory.close();
		}
	}
}
