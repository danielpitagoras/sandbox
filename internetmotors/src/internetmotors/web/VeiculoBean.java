package internetmotors.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
	private List<Veiculo> listadeVeiculos;
	
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
	public List<Veiculo> getListadeVeiculos() {
		
		this.usuarioLogado = contextoBean.getUsuarioLogado();
		this.listadeVeiculos = contextoBean.getListadeVeiculos();
		
		return listadeVeiculos;
	}
	public void setListadeVeiculos(List<Veiculo> listadeVeiculos) {
		this.listadeVeiculos = listadeVeiculos;
	}
	
	
}
