package internetmotors.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import internetmotors.util.ContextoUtil;
import internetmotors.ocorrencia.*;
import internetmotors.usuario.*;
import internetmotors.servico.*;

@ManagedBean(name = "servicoBean")
@RequestScoped

public class ServicoBean {

	private Ocorrencia ocorrenciaEmEdicao;
	private Servico servico = new Servico();
	private Servico servicoSelecionado;
	private List<Servico> listaServicos;
	private Usuario usuarioLogado;
	
	public String salvar() {
	
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		this.ocorrenciaEmEdicao = ocorrenciaRN.carregar(contextoBean.getCodOcorrencia());
		ServicoRN servicoRN = new ServicoRN();
		this.servico.setUsuario(this.usuarioLogado);
		this.servico.setOcorrencia(this.ocorrenciaEmEdicao);
		servicoRN.salvar(servico);
		
		return "ServicoCadSucesso";
	}
	
	public Ocorrencia getOcorrenciaEmEdicao() {
		return ocorrenciaEmEdicao;
	}
	public void setOcorrenciaEmEdicao(Ocorrencia ocorrenciaEmEdicao) {
		this.ocorrenciaEmEdicao = ocorrenciaEmEdicao;
	}
	public List<Servico> getListaServicos() {
		
		ServicoRN servicoRN = new ServicoRN();
		this.listaServicos = servicoRN.listar();
		return listaServicos;
		
	}
	public void setListaServicos(List<Servico> listaServicos) {
		this.listaServicos = listaServicos;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Servico getServicoSelecionado() {
		return servicoSelecionado;
	}

	public void setServicoSelecionado(Servico servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}
	
}
