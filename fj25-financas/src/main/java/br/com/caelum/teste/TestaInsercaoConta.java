package br.com.caelum.teste;

import javax.persistence.EntityManager;

import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;

public class TestaInsercaoConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setAgencia("7897-9");
		conta.setNumero("9088");
		
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
	}
}
