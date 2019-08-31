package br.com.caelum.financas.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String agencia;
	private String numero;
	private String banco;

	@Version
	private Integer versao;
	
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@OneToMany(mappedBy = "conta")
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void adicionaMovimentacao(Movimentacao movimentacao) { 
		movimentacoes.add(movimentacao);
		movimentacao.setConta(this);
	}
	
	public void removeMovimentacao(Movimentacao movimentacao) {
		movimentacoes.remove(movimentacao);
		movimentacao.setConta(null);
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return Collections.unmodifiableList(movimentacoes);
	}
}
