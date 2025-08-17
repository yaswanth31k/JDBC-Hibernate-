package in.careerit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static  SessionFactory sessionFactory = null;
	static {

			sessionFactory = new Configuration()
					.configure("/in/careerit/config/hibernate.cfg.xml")
					.buildSessionFactory();		

	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}