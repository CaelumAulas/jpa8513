package br.com.caelum.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.modelo.Conta;

public class ContaDao {
	
	private EntityManager entityManager;

	public ContaDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void persist(Conta conta) {
		entityManager.persist(conta);
	}

	public Conta busca(Long id) {
		Conta conta = entityManager.find(Conta.class, id);
		return conta;
	}

	public void remove(Conta contaParaRemocao) {
		entityManager.remove(contaParaRemocao);
	}
	
	public List<Conta> buscaTodas() {
		// JPQL - Java Persistence Query Language 
		return entityManager
			.createQuery("select c from Conta c", Conta.class)
			.getResultList();
	}
	
}
