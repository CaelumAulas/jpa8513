package br.com.caelum.compra.resource.input;

import javax.ejb.Stateless;

@Stateless
public class CompraDto {

	private Long produtoId;
	private String descricao;

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
