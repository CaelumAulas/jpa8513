package br.com.caelum.teste;

import java.time.Duration;
import java.time.Instant;

import javax.persistence.EntityManager;

import br.com.caelum.jpa.JpaUtil;

public class TempoConexao {

	public static void main(String[] args) {
		
		Instant inicio = Instant.now();
		
		for(int i = 0; i < 1000; i++) {
			EntityManager em = JpaUtil.getEntityManager();			
			em.getTransaction().begin();
			System.out.println("em " + i);
			em.getTransaction().commit();
			em.close();
		}
		
		Instant tempoFinal = Instant.now();
		
		long millis = Duration.between(inicio, tempoFinal).toMillis();
		System.out.println(millis);
	}
}
