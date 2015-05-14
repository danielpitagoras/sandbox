package internetmotors.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import internetmotors.util.ContextoUtil;
import internetmotors.usuario.*;
import internetmotors.veiculo.*;

@ManagedBean(name = "veiculoBean")
@RequestScoped

public class VeiculoBean {

	private Veiculo veiculo = new Veiculo();
	private Usuario usuarioLogado = null;
	private ContextoBean contextoBean = ContextoUtil.getContextoBean();
	private Veiculo veiculoSelecionado;
	private Veiculo veiculoInicial;
	private List<Veiculo> listadeVeiculos;
	private byte[] imgb = null;
	private Integer codVeiculo;
	private Veiculo veiculoSelOcorrencia;
	
	public StreamedContent getImgStream() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	//Checa se existe algum veículo selecionado.
	    	if(contextoBean.getVeiculoSelecionado() == null) {
				VeiculoRN veiculoRN = new VeiculoRN();
				this.usuarioLogado = contextoBean.getUsuarioLogado();
				this.veiculoInicial = veiculoRN.buscarUltimoAdicionado(this.usuarioLogado.getCodigo());
				this.imgb = this.veiculoInicial.getImagem1();
				
			} else {
				this.imgb = this.veiculoSelecionado.getImagem1();
			}
	    	
	    	if (imgb != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	
	public StreamedContent getImgStreamOc() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	//Apresenta imagem do veículo selecionado na interface de Ocorrência
	    	this.codVeiculo = contextoBean.getCodVeiculo();
	    	VeiculoRN veiculoRN = new VeiculoRN();
	    	this.veiculoSelecionado = veiculoRN.carregar(this.codVeiculo);
	    	this.imgb = this.veiculoSelecionado.getImagem1();
	    	
	    	if (imgb != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	
	
	public String excluirVeiculo() {
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		veiculoSelecionado = contextoBean.getVeiculoSelecionado();
		VeiculoRN veiculoRN = new VeiculoRN();
		veiculoRN.excluir(veiculoSelecionado);
		
		return "VeículoExcluído";
		
	}
	
	public String adImagens(){
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		veiculoSelecionado = contextoBean.getVeiculoSelecionado();
		
		this.veiculoSelecionado.setImagem1(contextoBean.getImgb1());
		this.veiculoSelecionado.setImagem2(contextoBean.getImgb2());
		this.veiculoSelecionado.setImagem3(contextoBean.getImgb3());
		this.veiculoSelecionado.setImagem4(contextoBean.getImgb4());
		this.veiculoSelecionado.setImagem5(contextoBean.getImgb5());
		
		VeiculoRN veiculoRN = new VeiculoRN();
		veiculoRN.atualizar(veiculoSelecionado);
		
		return "imgAdicionadas";
		
	}
	
	public String salvar() {	
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		
		VeiculoRN veiculoRN = new VeiculoRN();
		this.veiculo.setUsuario(usuarioLogado);
		this.veiculo.setDataCriacao(new Date());
		this.veiculo.setDataModificacao(new Date());
		veiculoRN.salvar(veiculo);
		
		return "veiculoCadSucesso";
		
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())) {
			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public ContextoBean getContextoBean() {
		return contextoBean;
	}
	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}
	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}
	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}
	
	public Veiculo getVeiculoInicial() {
		VeiculoRN veiculoRN = new VeiculoRN();
		this.veiculoInicial = veiculoRN.buscarUltimoAdicionado(contextoBean.getUsuarioLogado().getCodigo());
		return veiculoInicial;
	}

	public void setVeiculoInicial(Veiculo veiculoInicial) {
		this.veiculoInicial = veiculoInicial;
	}

	public List<Veiculo> getListadeVeiculos() {
		
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		this.listadeVeiculos = contextoBean.getListadeVeiculos();
		
		return listadeVeiculos;
	}
	public void setListadeVeiculos(List<Veiculo> listadeVeiculos) {
		this.listadeVeiculos = listadeVeiculos;
	}

	public Veiculo getVeiculoSelOcorrencia() {
		VeiculoRN veiculoRN = new VeiculoRN();
		this.veiculoSelOcorrencia = veiculoRN.carregar(contextoBean.getCodVeiculo());		
		return veiculoSelOcorrencia;
	}

	public void setVeiculoSelOcorrencia(Veiculo veiculoSelOcorrencia) {
		this.veiculoSelOcorrencia = veiculoSelOcorrencia;
	}
	
	
}
