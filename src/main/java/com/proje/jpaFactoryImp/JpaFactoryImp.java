package com.proje.jpaFactoryImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.jpaFactory.JpaFactory;

public class JpaFactoryImp implements JpaFactory{
	
	private EntityManager entityManager=null;

	public EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("persistence-unit");
		entityManager=factory.createEntityManager();
		return entityManager;
	}

	public EntityTransaction getEntityTransaction() {
		EntityTransaction transaction=entityManager.getTransaction();
		return transaction;
	}

}
