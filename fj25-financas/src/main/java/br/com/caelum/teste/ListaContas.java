package br.com.caelum.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.dao.ContaDao;
import br.com.caelum.jpa.JpaUtil;
import br.com.caelum.modelo.Conta;

public class ListaContas {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();
		ContaDao contaDao = new ContaDao(em);
		
		List<Conta> contas = contaDao.buscaTodas();
		
		for (Conta conta : contas) {
			System.out.println("Id: " +  conta.getId());
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Numero: " + conta.getNumero());
		}
	}

}
