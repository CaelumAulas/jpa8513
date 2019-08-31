package br.com.caelum.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.dao.ContaDao;
import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;
import br.com.caelum.modelo.Movimentacao;
import br.com.caelum.modelo.TipoDaMovimentacao;

public class BuscaConta {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(em);
		
		em.getTransaction().begin();
		
		Movimentacao cinema = new Movimentacao();
		cinema.setDescricao("Avengers");
		cinema.setValor(new BigDecimal("40"));
		cinema.setTipo(TipoDaMovimentacao.SAIDA);
		
		em.persist(cinema);
		
		Conta conta = contaDao.busca(1l);
		// conta.adicionaMovimentacao(cinema);
		System.out.println("depois de buscar");
		
		System.out.println(conta.getMovimentacoes());
		
		em.getTransaction().commit();
	}
}
