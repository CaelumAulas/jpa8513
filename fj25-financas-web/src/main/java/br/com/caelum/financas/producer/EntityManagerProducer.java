package br.com.caelum.financas.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.Session;

@ApplicationScoped
public class EntityManagerProducer {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Produces @RequestScoped
	public Session getEntityManager() {
		return emf.createEntityManager().unwrap(Session.class);
	}
	
	public void close(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
