package br.com.caelum.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;
import br.com.caelum.modelo.Movimentacao;
import br.com.caelum.modelo.TipoDaMovimentacao;

public class TestaInsercaoMovimentacao {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setAgencia("7897-9");
		conta.setNumero("9088");
		
		Movimentacao cinema = new Movimentacao();
		cinema.setDescricao("Miranha");
		cinema.setData(LocalDateTime.now());
		cinema.setValor(new BigDecimal("50"));
		cinema.setTipo(TipoDaMovimentacao.SAIDA);
		cinema.setConta(conta);
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cinema);
		
		em.getTransaction().commit();
		em.close();
	}
}
