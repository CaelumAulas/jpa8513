package br.com.caelum.financas.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;

// @Startup
// @Singleton
public class TestaAgendamento {

	@Schedule(hour = "*", minute = "*", second = "*/5", 
			persistent = false, info = "meu agendador com anotacao")
	public void executa(Timer timer) {
		System.out.println("executando timer 3.0: " + timer.getInfo());
	} 
}
