package br.com.caelum.compra.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.caelum.compra.dao.CompraDao;
import br.com.caelum.compra.dao.ProdutoDao;
import br.com.caelum.compra.model.Compra;
import br.com.caelum.compra.model.Produto;
import br.com.caelum.compra.resource.input.CompraDto;

@Stateless
public class CompraService {

	@Inject
	private CompraDao compraDao;
	
	@Inject
	private ProdutoDao produtoDao;

	CompraService() {
	}

	@Transactional(value = TxType.REQUIRED)
	public Compra create(CompraDto compraDto) {

		Produto produto = produtoDao.busca(compraDto.getProdutoId());
		Compra compra = new Compra(produto, compraDto.getDescricao());
		
		compraDao.save(compra);
		produtoDao.daBaixa(compra.getProduto());

		return compra;
	}
}
