package internetmotors.web;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;

import internetmotors.util.ContextoUtil;
import internetmotors.pagamento.*;
import internetmotors.autorizacao.*;


@ManagedBean(name = "pagamentoBean")
@RequestScoped

public class PagamentoBean {

	private Pagamento pagamento = new Pagamento();
	private Integer codAutorizacao;

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Integer getCodAutorizacao() {
		return codAutorizacao;
	}

	public void setCodAutorizacao(Integer codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}

	public void salvar() {
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();
		PagamentoRN pagamentoRN = new PagamentoRN();
		
		this.pagamento.setUsuario(contextoBean.getUsuarioLogado());
		this.pagamento.setAutorizacaoExibicao(autorizacaoExibicaoRN.carregar(codAutorizacao));
		
		//Inteface que submete a instituição responsável
		this.pagamento.setStatusPagamento("AUTORIZADO");
		
		pagamentoRN.salvar(pagamento);
		
	}
	
}
