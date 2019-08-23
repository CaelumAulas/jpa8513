package br.com.caelum.dao;

import javax.persistence.EntityManager;

import br.com.caelum.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}
	
	public void salva(Movimentacao movimentacao) {
		em.persist(movimentacao);
	}
	
	public void remove(Movimentacao movimentacao) {
		em.remove(movimentacao);
	}
	
	public Movimentacao busca(Long id) {
		return em.find(Movimentacao.class, id);
	}
}
