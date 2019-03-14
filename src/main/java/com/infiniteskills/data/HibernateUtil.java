package com.infiniteskills.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory buildSessionFactory() {
		try {
			// Create registry
			registry = new StandardServiceRegistryBuilder().configure().build();
            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);
            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();
            // Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
			throw new RuntimeException("There was an error building the factory");
		}
	}
}
