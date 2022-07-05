package dev.servidor.bo.transactionmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TransactionManager implements ITransactionManager{
    
        public SessionFactory sessionFactory;
        
        private ServiceRegistry serviceRegistry;
        
        private Session session;

        public TransactionManager() {
            System.out.println("Creating Session Factory");
            createSessionFactory();
        }
    
	public void beginTransaction() {
            this.session.beginTransaction();
	}

	public void commit() {
            this.session.getTransaction().commit();
	}

	public void rollback() {
            this.session.getTransaction().rollback();
	}
        
        public void openSession() {
            System.out.println("[openSession()]");
            this.session = this.sessionFactory.openSession();
        }
        
        public void closeSession(){
            System.out.println("[closeSession()]");
            this.session.close();
        }
        
        public void closeSessionFactory(){
            System.out.println("[closeSessionFactory()]");
            this.sessionFactory.close();
        }

        public Session getSession() {
            return session;
        }

        public void createSessionFactory() {
                Configuration configuration = new Configuration();
                configuration.configure();
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);      
        }

}
