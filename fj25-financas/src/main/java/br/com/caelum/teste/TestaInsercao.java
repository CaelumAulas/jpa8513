package br.com.caelum.teste;

import java.time.Duration;
import java.time.Instant;

import javax.persistence.EntityManager;

import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;

public class TestaInsercao {

	public static void main(String[] args) {

		Instant inicio = Instant.now();
		
		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setAgencia("7897-9");
		conta.setNumero("9088");
		
		JpaUtil jpaUtil = new JpaUtil();
		EntityManager em = jpaUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		
		Instant tempoFinal = Instant.now();
		
		long milis = Duration.between(inicio, tempoFinal)
				.toMillis();
		System.out.println("tempo em milissegundos: " + milis);
	}
}
