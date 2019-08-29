package br.com.caelum.compra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer qtde;
	
	public void tiraDoEstoque() {
		--qtde;
	}
	
	public Integer getQtde() {
		return qtde;
	}
	
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
}
