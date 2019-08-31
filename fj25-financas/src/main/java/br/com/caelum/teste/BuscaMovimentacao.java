package br.com.caelum.teste;

import javax.persistence.EntityManager;

import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Movimentacao;

public class BuscaMovimentacao {

	public static void main(String[] args) {
		
		EntityManager em1 = JpaUtil.getEntityManager();
		EntityManager em2 = JpaUtil.getEntityManager();		
		
		Movimentacao movimentacao1 = em1.find(Movimentacao.class, 4l);
		Movimentacao movimentacao2 = em2.find(Movimentacao.class, 4l);
		
		System.out.println(movimentacao1.getDescricao());
		System.out.println(movimentacao2.getDescricao());
	}

}
