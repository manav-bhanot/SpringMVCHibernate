/**
 * THIS CLASS IS NOT REQUIRED IN THIS SPRING WEB APPLICATION PROJECT
 * AS THE HIBERNATE FRAMEWORK IS NOT INSTANTIATED USING THE SPRING DI FRAMEWORK
 */
package edu.csulb.library.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Manav
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public HibernateUtil() {
	}

	public static SessionFactory getSesionFactory() {
		
		if (sessionFactory == null) {
			
			Configuration cfg = new Configuration().configure();

			sessionFactory = cfg.buildSessionFactory();
			cfg.addAnnotatedClass(edu.csulb.library.entity.Book.class);
		}
		
		return sessionFactory;
	}

}
