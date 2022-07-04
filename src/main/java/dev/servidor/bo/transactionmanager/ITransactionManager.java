package dev.servidor.bo.transactionmanager;

public interface ITransactionManager {
	
	public void beginTransaction();
	
	public void commit();
	
	public void rollback();
	
        public void createSessionFactory();
}
