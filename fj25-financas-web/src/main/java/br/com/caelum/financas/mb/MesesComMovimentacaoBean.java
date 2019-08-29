package br.com.caelum.financas.mb;


import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.TotalMovimentacaoMesEAno;

@Named
@RequestScoped
public class MesesComMovimentacaoBean {

	private Conta conta = new Conta();

	private TipoMovimentacao tipoMovimentacao;
	
	@Inject
	private MovimentacaoDao movimentacaoDao;
	
	private List<TotalMovimentacaoMesEAno> valoresPorMesEAno;
	
	public void lista() {
		
		new TotalMovimentacaoMesEAno(6, 2018, new BigDecimal("50"));
		
		System.out.println("Listando as contas pelos valores movimentados no mes");
		this.valoresPorMesEAno = movimentacaoDao.totalDeMovimentacoesMesEAno(conta, tipoMovimentacao);
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}
	
	public List<TotalMovimentacaoMesEAno> getValoresPorMesEAno() {
		return valoresPorMesEAno;
	}
	
	public void setValoresPorMesEAno(List<TotalMovimentacaoMesEAno> valoresPorMesEAno) {
		this.valoresPorMesEAno = valoresPorMesEAno;
	}

}
