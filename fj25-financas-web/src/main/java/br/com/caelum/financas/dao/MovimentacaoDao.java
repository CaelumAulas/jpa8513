package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.TotalMovimentacaoMesEAno;

@Stateless
public class MovimentacaoDao {

	@Inject
	EntityManager manager;

	public void adiciona(Movimentacao movimentacao) {
		this.manager.persist(movimentacao);
	}

	public Movimentacao busca(Integer id) {
		return this.manager.find(Movimentacao.class, id);
	}

	public List<Movimentacao> lista() {
		return this.manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}
	
	public List<Movimentacao> listaComCategorias() {
		return this.manager.createQuery("select m from Movimentacao m "
				+ "join fetch m.categorias", Movimentacao.class).getResultList();
	}

	public List<Movimentacao> movimentacoesPorConta(Conta conta) {
		return this.manager.createQuery("select m from Movimentacao m where m.conta = :pConta", Movimentacao.class)
					.setParameter("pConta", conta)
					.getResultList();
	}
	
	public List<Movimentacao> movimentacoesPorValorETipo(BigDecimal valor, TipoMovimentacao tipoMovimentacao) {
		return this.manager.createQuery("select m from Movimentacao m where m.valor > :pValor "
				+ "and m.tipoMovimentacao = :pTipoMovimentacao", Movimentacao.class)
		.setParameter("pValor", valor)
		.setParameter("pTipoMovimentacao", tipoMovimentacao)
		.getResultList();
	}
	
	public List<Movimentacao> movimentacoesPorTitular(String nome) {
		return this.manager.createQuery("select m from Movimentacao m where "
				+ "m.conta.titular like :pNome", Movimentacao.class)
				.setParameter("pNome", "%" + nome + "%")
				.getResultList();
	}
	
	public BigDecimal totalMovimentacoes(Conta conta, TipoMovimentacao tipoMovimentacao) {
		return this.manager.createQuery("select sum(m.valor) from Movimentacao m "
				+ "where m.conta = :pConta and m.tipoMovimentacao = :pTipoMovimentacao", BigDecimal.class)
				.setParameter("pConta", conta)
				.setParameter("pTipoMovimentacao", tipoMovimentacao)
				.getSingleResult();
	}
	
	public List<TotalMovimentacaoMesEAno> totalDeMovimentacoesMesEAno(Conta conta, TipoMovimentacao tipoMovimentacao) {
		
		return this.manager.createQuery("select new br.com.caelum.financas.modelo.TotalMovimentacaoMesEAno("
				+ "month(m.data), year(m.data), sum(m.valor)) from Movimentacao m where m.conta = :pConta "
				+ "and m.tipoMovimentacao = :pTipoMovimentacao "
				+ "group by month(m.data), year(m.data)", TotalMovimentacaoMesEAno.class)
			.setParameter("pConta", conta)
			.setParameter("pTipoMovimentacao", tipoMovimentacao)
			.getResultList();
	}
	
	public void remove(Movimentacao movimentacao) {
		Movimentacao movimentacaoParaRemover = this.manager.find(Movimentacao.class, movimentacao.getId());
		this.manager.remove(movimentacaoParaRemover);
	}

}
