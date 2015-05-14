package internetmotors.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import internetmotors.util.ContextoUtil;
import internetmotors.ocorrencia.*;
import internetmotors.usuario.*;
import internetmotors.sinistro.*;

@ManagedBean(name = "sinistroBean")
@RequestScoped

public class SinistroBean {

	private Ocorrencia ocorrenciaEmEdicao;
	private Usuario usuarioLogado;
	private List<Sinistro> listaSinistros;
	private Sinistro sinistroSelecionado;
	private Sinistro sinistro = new Sinistro();
	
	public String salvar() {
	
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		OcorrenciaRN ocorrenciaRN = new OcorrenciaRN();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		this.ocorrenciaEmEdicao = ocorrenciaRN.carregar(contextoBean.getCodOcorrencia());
		SinistroRN sinistroRN = new SinistroRN();
		this.sinistro.setUsuario(this.usuarioLogado);
		this.sinistro.setOcorrencia(this.ocorrenciaEmEdicao);
		sinistroRN.salvar(sinistro);
		
		return "SinistroCadSucesso";
		
	}
	
	public Ocorrencia getOcorrenciaEmEdicao() {
		return ocorrenciaEmEdicao;
	}
	public void setOcorrenciaEmEdicao(Ocorrencia ocorrenciaEmEdicao) {
		this.ocorrenciaEmEdicao = ocorrenciaEmEdicao;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public List<Sinistro> getListaSinistros() {
		
		SinistroRN sinistroRN = new SinistroRN();
		this.listaSinistros = sinistroRN.listar();
		return listaSinistros;
		
	}
	public void setListaSinistros(List<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	public Sinistro getSinistroSelecionado() {
		return sinistroSelecionado;
	}
	public void setSinistroSelecionado(Sinistro sinistroSelecionado) {
		this.sinistroSelecionado = sinistroSelecionado;
	}
	public Sinistro getSinistro() {
		return sinistro;
	}
	public void setSinistro(Sinistro sinistro) {
		this.sinistro = sinistro;
	}
	
}
