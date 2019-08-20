package br.com.caelum.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static EntityManagerFactory getEMF() {
		return emf;
	}
}
