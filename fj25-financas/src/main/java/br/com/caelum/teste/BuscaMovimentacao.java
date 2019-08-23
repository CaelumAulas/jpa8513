package br.com.caelum.teste;

import javax.persistence.EntityManager;

import br.com.caelum.dao.MovimentacaoDao;
import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Movimentacao;

public class BuscaMovimentacao {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		
		em.getTransaction().begin();
		
		Movimentacao movimentacao = dao.busca(1l);
		
		movimentacao.setDescricao("nova descricao");
		
		System.out.println(movimentacao);
		System.out.println(movimentacao.getConta().getTitular());
		em.getTransaction().commit();
	}

}
