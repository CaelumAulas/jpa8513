package br.com.caelum.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

// @BatchSize(size = 30)
@Entity
public class Conta {

	// @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String titular;

	// @Size(min = 6, message = "Agencia deve ter pelo menos 6 caracteres")
	private String agencia;
	
	@Column(name = "num", unique = true)
	private String numero;

	@Column(columnDefinition = "text")
	private String observacao;
	
	@JoinColumn(unique = true)
	@OneToOne
	private Gerente gerente;
	
	@OneToMany(mappedBy = "conta")
	private List<Movimentacao> movimentacoes = new ArrayList<>();
	
	public Long getId() {
		return id;
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
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return Collections.unmodifiableList(movimentacoes);
	}
	
	public Gerente getGerente() {
		return gerente;
	}
	
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", titular=" + titular + ", agencia=" + agencia + ", numero=" + numero + "]";
	}

	public void adicionaMovimentacao(Movimentacao movimentacao) {
		movimentacao.setConta(this);
		movimentacoes.add(movimentacao);
	}

	public void removeMovimentacao(Movimentacao movimentacao) {
		movimentacao.setConta(null);
		movimentacoes.remove(movimentacao);
	}
}
