package br.com.caelum.teste;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.internal.engine.ValidatorFactoryImpl;

import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;
import br.com.caelum.modelo.Gerente;

public class TestaInsercaoConta {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		/*Gerente g = new Gerente();
		g.setNome("Fernando");
		em.persist(g);*/
		
		Gerente g = em.find(Gerente.class, 1l);
		
		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setAgencia("79798-9");
		conta.setNumero("678");
		conta.setGerente(g);
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
	}
}
