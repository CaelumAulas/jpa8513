package br.com.caelum.compra.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.caelum.compra.model.Compra;

@Stateless
public class CompraDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(value = TxType.REQUIRED)
	public void save(Compra compra) {
		entityManager.persist(compra);
		// throw new RuntimeException("aleatorio mesmo");
	}
}
