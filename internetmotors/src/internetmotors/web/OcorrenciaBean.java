package internetmotors.web;

import java.io.IOException;
import java.util.List;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import internetmotors.util.ContextoUtil;
import internetmotors.ocorrencia.*;
import internetmotors.usuario.*;
import internetmotors.veiculo.*;

@ManagedBean(name = "ocorrenciaBean")
@RequestScoped 

public class OcorrenciaBean {

	private Usuario usuario = new Usuario();
	private Veiculo veiculo = new Veiculo();
	private Ocorrencia ocorrencia = new Ocorrencia();
	private Veiculo veiculoSelecionado;
	private Usuario usuarioLogado;
	private ContextoBean contextoBean = ContextoUtil.getContextoBean();
	private List<Ocorrencia> listadeOcorrencias;

	public String salvar() {
	
		FacesContext context = FacesContext.getCurrentInstance();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		VeiculoRN veiculoRN = new VeiculoRN();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		this.veiculoSelecionado = veiculoRN.carregar(contextoBean.getCodVeiculo());
		
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		this.ocorrencia.setUsuario(this.usuarioLogado);
		this.ocorrencia.setVeiculo(this.veiculoSelecionado);
		this.ocorrencia.setDataCriacao(new Date());
		this.ocorrencia.setDataModificacao(new Date());
		String operacao = this.ocorrencia.getOperacao();
		ocorrenciaRN.salvar(ocorrencia);
		
	    if (operacao.equalsIgnoreCase("alterarpropriedade")) {
	    	try {
	    		context.getExternalContext().redirect("/InternetMotors/restrito/alterarPropriedadeOcorrencia.jsf?codOcorrencia=" + this.ocorrencia.getCodigo());
	    		context.responseComplete();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    } 
	    if (operacao.equalsIgnoreCase("servico")) {
	    	try {
	    		context.getExternalContext().redirect("/InternetMotors/restrito/servicoOcorrencia.jsf?codOcorrencia=" + this.ocorrencia.getCodigo());
	    		context.responseComplete();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    if (operacao.equalsIgnoreCase("sinistro")) {
	    	try { 
	    		context.getExternalContext().redirect("/InternetMotors/restrito/sinistroOcorrencia.jsf?codOcorrencia=" + this.ocorrencia.getCodigo());
	    		context.responseComplete();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    	
	    	return this.ocorrencia.getOperacao();
		
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}
	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}
	public ContextoBean getContextoBean() {
		return contextoBean;
	}
	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}
	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public List<Ocorrencia> getListadeOcorrencias() {
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		VeiculoRN veiculoRN = new VeiculoRN();
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		this.listadeOcorrencias = ocorrenciaRN.listarPorVeiculo(veiculoRN.buscarUltimoAdicionado(this.usuarioLogado.getCodigo()));
		
		return listadeOcorrencias;
	}

	public void setListadeOcorrencias(List<Ocorrencia> listadeOcorrencias) {
		this.listadeOcorrencias = listadeOcorrencias;
	}

	
	
}
