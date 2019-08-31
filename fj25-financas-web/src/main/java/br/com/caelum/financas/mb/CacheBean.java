package br.com.caelum.financas.mb;

import br.com.caelum.financas.modelo.Conta;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@RequestScoped
public class CacheBean {
	
	@Inject
	private EntityManager entityManager;
	
	private Integer id;
	private Conta conta;
	
	public void pesquisar() {
		System.out.println("Testando cache de segundo nivel");
		this.conta = entityManager.find(Conta.class, id);
		this.conta.getMovimentacoes().size();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Conta getConta() {
		return conta;
	}
}