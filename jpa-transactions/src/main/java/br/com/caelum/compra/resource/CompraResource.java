package br.com.caelum.compra.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.caelum.compra.dao.ProdutoDao;
import br.com.caelum.compra.model.Compra;
import br.com.caelum.compra.resource.input.CompraDto;
import br.com.caelum.compra.service.CompraService;

@Path("compras")
public class CompraResource {

	private CompraService compraService;
	
	private ProdutoDao produtoDao;

	@Inject
	public CompraResource(CompraService compraService, ProdutoDao produtoDao) {
		this.compraService = compraService;
		this.produtoDao = produtoDao;
	}

	CompraResource() {
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Compra create(CompraDto compraDto) {
		
		Compra compraSalva = compraService.create(compraDto);
		return compraSalva;
	}
}
