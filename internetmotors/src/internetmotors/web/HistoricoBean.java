package internetmotors.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import internetmotors.autorizacao.*;
import internetmotors.util.ContextoUtil;
import internetmotors.veiculo.*;
import internetmotors.ocorrencia.*;

@ManagedBean(name = "historicoBean")
@RequestScoped

public class HistoricoBean {

	private List<Ocorrencia> listaOcorrenciasPExibir;
	private List<Ocorrencia> listaOcorrenciasPExibirPrivado;
	private Veiculo veiculoPExibir;
	private Veiculo veiculoSelecionado;
	private AutorizacaoExibicao autorizacaoExibicaoApres;
	private String codAutorizacao;
	private String codSeguranca;
	private Integer codVeiculoPExibir;
	
	public List<Ocorrencia> getListaOcorrenciasPExibir() {
		
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		
		if(autorizacaoExibicaoRN.carregar(Integer.parseInt(this.codAutorizacao)).getIdentificacao().equals(this.codSeguranca)) {
			listaOcorrenciasPExibir = ocorrenciaRN.listarPorVeiculo(autorizacaoExibicaoRN.carregar(Integer.parseInt(this.codAutorizacao)).getVeiculo());
		} else {
			
		}
		
		return listaOcorrenciasPExibir;
	}
	public List<Ocorrencia> getListaOcorrenciasPExibirPrivado() {
		
		if (this.listaOcorrenciasPExibirPrivado == null) {
			
			OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
			
			if(veiculoSelecionado == null) {
				
			} else {
				this.listaOcorrenciasPExibirPrivado = ocorrenciaRN.listarPorVeiculo(veiculoSelecionado);
			}
			
		}
	
		return listaOcorrenciasPExibirPrivado;
	}
	public void setListaOcorrenciasPExibirPrivado(
			List<Ocorrencia> listaOcorrenciasPExibirPrivado) {
		this.listaOcorrenciasPExibirPrivado = listaOcorrenciasPExibirPrivado;
	}
	public void setListaOcorrenciasPExibir(List<Ocorrencia> listaOcorrenciasPExibir) {
		this.listaOcorrenciasPExibir = listaOcorrenciasPExibir;
	}
	public Veiculo getVeiculoPExibir() {
		
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();

		if (autorizacaoExibicaoRN.carregar(Integer.parseInt(this.codAutorizacao)).getIdentificacao().equals(this.codSeguranca)) {
			this.veiculoPExibir = autorizacaoExibicaoRN.carregar(Integer.parseInt(this.codAutorizacao)).getVeiculo();
		}
		
		return veiculoPExibir;
	}
	public void setVeiculoPExibir(Veiculo veiculoPExibir) {
		this.veiculoPExibir = veiculoPExibir;
	}
	public AutorizacaoExibicao getAutorizacaoExibicaoApres() {
		return autorizacaoExibicaoApres;
	}
	public void setAutorizacaoExibicaoApres(
			AutorizacaoExibicao autorizacaoExibicaoApres) {
		this.autorizacaoExibicaoApres = autorizacaoExibicaoApres;
	}
	public String getCodAutorizacao() {
		return codAutorizacao;
	}
	public void setCodAutorizacao(String codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}
	public String getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	public Integer getCodVeiculoPExibir() {
		return codVeiculoPExibir;
	}
	public void setCodVeiculoPExibir(Integer codVeiculoPExibir) {
		this.codVeiculoPExibir = codVeiculoPExibir;
	}
	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}
	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}
	
	
	
}
