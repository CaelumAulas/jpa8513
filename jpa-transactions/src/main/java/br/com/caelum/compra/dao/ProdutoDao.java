package br.com.caelum.compra.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.caelum.compra.model.Produto;

@Stateless
public class ProdutoDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Produto busca(Long produtoId) {
		return entityManager.find(Produto.class, produtoId);
	}

	@Transactional(value = TxType.REQUIRED)
	public void daBaixa(Produto produto) {
		Produto produtoDoBanco = entityManager.merge(produto);
		produtoDoBanco.tiraDoEstoque();
	}
}
