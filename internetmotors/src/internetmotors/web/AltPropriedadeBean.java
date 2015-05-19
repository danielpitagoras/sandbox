package internetmotors.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import internetmotors.util.ContextoUtil;
import internetmotors.ocorrencia.*;
import internetmotors.usuario.*;
import internetmotors.propriedade.*;

@ManagedBean(name = "altPropriedadeBean")
@RequestScoped

public class AltPropriedadeBean {

	private Ocorrencia ocorrenciaEmEdicao;
	private AlteracaoPropriedade alteracaoPropriedade = new AlteracaoPropriedade();
	private AlteracaoPropriedade alteracaoPropriedadeSelecionado;
	private List<AlteracaoPropriedade> listaAlteracaoPropriedade;
	private Usuario usuarioLogado;
	private Usuario usuarioDestino;
	private String emailNovoProprietario;
	private Boolean enviarEmail;
	private String situacaoAlteracaoPropriedade;
	
	public void transPropriedade() {
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		AlteracaoPropriedadeRN alteracaoPropriedadeRN = new AlteracaoPropriedadeRN();
		this.alteracaoPropriedadeSelecionado.setStatus("AACEITE");
		alteracaoPropriedadeRN.atualizarAceite(alteracaoPropriedadeSelecionado, contextoBean.getUsuarioLogado());

	}
	
	public void nTransPropriedade() {
	
		AlteracaoPropriedadeRN alteracaoPropriedadeRN = new AlteracaoPropriedadeRN();
		this.alteracaoPropriedadeSelecionado.setStatus("NACEITE");
		alteracaoPropriedadeRN.atualizar(alteracaoPropriedadeSelecionado);
		
	}
	
	public void salvar() {
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		this.ocorrenciaEmEdicao = ocorrenciaRN.carregar(contextoBean.getCodOcorrencia());
		AlteracaoPropriedadeRN alteracaoPropriedadeRN = new AlteracaoPropriedadeRN();
		
		// Status da requisição (RACEITE = Requisitado Aceite, NACEITE = Negado Aceite, AACEITE = Aprovado Aceite, LACEITE = Aceite Negado Visto)
		this.alteracaoPropriedade.setStatus("RACEITE");
		this.alteracaoPropriedade.setOcorrencia(this.ocorrenciaEmEdicao);
		this.alteracaoPropriedade.setUsuario(this.usuarioLogado);
		alteracaoPropriedadeRN.salvar(alteracaoPropriedade);
	}
	
	
	public void buscaEmailNovoProprietario(ValueChangeEvent vce) {
		
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioDestino = usuarioRN.buscarPorEmail((String) vce.getNewValue());
		
	}
	
	public Ocorrencia getOcorrenciaEmEdicao() {
		return ocorrenciaEmEdicao;
	}
	public void setOcorrenciaEmEdicao(Ocorrencia ocorrenciaEmEdicao) {
		this.ocorrenciaEmEdicao = ocorrenciaEmEdicao;
	}
	public AlteracaoPropriedade getAlteracaoPropriedade() {
		return alteracaoPropriedade;
	}
	public void setAlteracaoPropriedade(AlteracaoPropriedade alteracaoPropriedade) {
		this.alteracaoPropriedade = alteracaoPropriedade;
	}
	public AlteracaoPropriedade getAlteracaoPropriedadeSelecionado() {
		return alteracaoPropriedadeSelecionado;
	}
	public void setAlteracaoPropriedadeSelecionado(
			AlteracaoPropriedade alteracaoPropriedadeSelecionado) {
		this.alteracaoPropriedadeSelecionado = alteracaoPropriedadeSelecionado;
	}
	public List<AlteracaoPropriedade> getListaAlteracaoPropriedade() {
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		AlteracaoPropriedadeRN alteracaoPropriedadeRN = new AlteracaoPropriedadeRN();
		this.listaAlteracaoPropriedade = alteracaoPropriedadeRN.listarPorAlteracao(contextoBean.getUsuarioLogado());
		return listaAlteracaoPropriedade;
	}
	public void setListaAlteracaoPropriedade(
			List<AlteracaoPropriedade> listaAlteracaoPropriedade) {
		this.listaAlteracaoPropriedade = listaAlteracaoPropriedade;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public Usuario getUsuarioDestino() {
		return usuarioDestino;
	}
	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}
	public String getEmailNovoProprietario() {
		return emailNovoProprietario;
	}
	public void setEmailNovoProprietario(String emailNovoProprietario) {
		
		UsuarioRN usuarioRN = new UsuarioRN();
		this.alteracaoPropriedade.setEmailNovoProprietario(emailNovoProprietario);
		this.alteracaoPropriedade.setNomeNovoProprietario(usuarioRN.buscarPorEmail(emailNovoProprietario).getNome());
		//this.emailNovoProprietario = emailNovoProprietario;
	}

	public Boolean getEnviarEmail() {
		return enviarEmail;
	}

	public void setEnviarEmail(Boolean enviarEmail) {
		this.enviarEmail = enviarEmail;
	}


	public String getSituacaoAlteracaoPropriedade() {
		AlteracaoPropriedadeRN alteracaoPropriedadeRN = new AlteracaoPropriedadeRN();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		if (alteracaoPropriedadeRN.listarPorAlteracao(contextoBean.getUsuarioLogado()).isEmpty()) {
			this.situacaoAlteracaoPropriedade = null;
		} else {
			this.situacaoAlteracaoPropriedade = "Atenção - Exite veículo aguardando sua aprovação de propriedade. Clique aqui para aceitar";
		}
		
		return situacaoAlteracaoPropriedade;
	}


	public void setSituacaoAlteracaoPropriedade(String situacaoAlteracaoPropriedade) {
		this.situacaoAlteracaoPropriedade = situacaoAlteracaoPropriedade;
	}
	
	
	
}
