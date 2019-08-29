package br.com.caelum.financas.modelo;

import java.math.BigDecimal;

public class TotalMovimentacaoMesEAno {

	private Integer mes;
	private Integer ano;
	private BigDecimal valor;
	
	public TotalMovimentacaoMesEAno(Integer mes, Integer ano, BigDecimal total) {
		this.mes = mes;
		this.ano = ano;
		this.valor = total;
	}

	public Integer getMes() {
		return mes;
	}

	public Integer getAno() {
		return ano;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
