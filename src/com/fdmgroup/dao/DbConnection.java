package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnection {
	private static final String PERSISTENCE_UNIT = "Spring_Ecom";
private EntityManagerFactory emf = null;
	
	
	public DbConnection() {
	super();
	}
	
	public String getPersistenceName() {
	return PERSISTENCE_UNIT;
	}


	private void init() {
	if (emf == null || !emf.isOpen()) {
	emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}
	}
	public EntityManager getEntityManager() {
	init();
	return emf.createEntityManager();
	}
	public void close() {
	if (emf != null && emf.isOpen()) {
	emf.close();
	}
	}




}
