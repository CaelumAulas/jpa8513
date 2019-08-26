package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Startup
@Singleton
public class TestaAgendamento {

	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void postConstruct() {
		
		TimerConfig config = new TimerConfig();
		config.setPersistent(false);
		config.setInfo("meu agendador");
		
		ScheduleExpression schedule = new ScheduleExpression();
		schedule.hour("*");
		schedule.minute("*");
		schedule.second("*/5");
		
		timerService.createCalendarTimer(schedule, config);
	}
	
	@Timeout
	public void executa(Timer timer) {
		System.out.println("executando timer 3.0: " + timer.getInfo());
	} 
}
