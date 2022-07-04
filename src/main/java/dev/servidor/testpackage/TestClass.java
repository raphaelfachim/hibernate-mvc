package dev.servidor.testpackage;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TestClass {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static void main(String[] args) {
            Profile profile1 = new Profile();

            profile1.setName("Raphael");
            profile1.setLastName("Fachim");

            Session session = createSessionFactory().openSession();
            session.beginTransaction();
            session.save(profile1);
            session.getTransaction().commit();
            session.close();
            
            
	}
	
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
}
