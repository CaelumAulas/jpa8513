package br.com.caelum.teste;

import javax.persistence.EntityManager;

import br.com.caelum.dao.ContaDao;
import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;

public class BuscaConta {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(em);
		
		Conta conta = contaDao.busca(4L);
		conta.setTitular("Mais um");
		conta.setAgencia("097");
		
		em.getTransaction().begin();
		
		System.out.println("commitando transacao");
		em.getTransaction().commit();
		System.out.println("depois de commitar");
	
		em.close();
	}
}
