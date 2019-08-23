package br.com.caelum.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Table(name = "movimentacoes")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoDaMovimentacao tipo;

	private LocalDateTime data;

	@JoinColumn(
		name = "conta_id",
		foreignKey = @ForeignKey(name = "fk_conta_id"),
		nullable = false
	)
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Conta conta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoDaMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDaMovimentacao tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", tipo=" + tipo + ", data="
				+ data + ", conta=" + conta + "]";
	}

	@PrePersist
	@PreUpdate
	public void setUpdateAt() {
		this.data = LocalDateTime.now();
	}
}
