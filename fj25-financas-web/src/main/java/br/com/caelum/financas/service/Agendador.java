package br.com.caelum.financas.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@AccessTimeout(unit = TimeUnit.SECONDS, value = 2)
@Singleton
public class Agendador {

	private static int totalCriado;

	@PostConstruct
	void posConstrucao() {
		System.out.println("criando agendador");
		totalCriado++;
	}
	
	void preDestruicao() {
		System.out.println("destruindo agendador");
	}
	
	public void executa() {
		System.out.printf("%d instancias criadas %n", totalCriado);

		// simulando demora de 4s na execucao
		try {
			System.out.printf("Executando %s %n", this);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}

}
