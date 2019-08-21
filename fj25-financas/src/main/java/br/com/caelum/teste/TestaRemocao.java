package br.com.caelum.teste;

import javax.persistence.EntityManager;

import br.com.caelum.dao.ContaDao;
import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;

public class TestaRemocao {

	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(em);
		
		Conta contaParaRemocao = contaDao.busca(3L);

		em.getTransaction().begin();
		contaDao.remove(contaParaRemocao);
		em.getTransaction().commit();
		em.close();
	}

}
