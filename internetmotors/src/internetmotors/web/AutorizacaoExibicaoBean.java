package internetmotors.web;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.faces.event.PhaseId;

import internetmotors.autorizacao.*;
import internetmotors.veiculo.*;
import internetmotors.util.ContextoUtil;

@ManagedBean(name = "autorizacaoExibicaoBean")
@RequestScoped

public class AutorizacaoExibicaoBean {

	private AutorizacaoExibicao autorizacaoExibicao = new AutorizacaoExibicao();
	private Integer codRVeiculo;
	

	
	public Integer getCodRVeiculo() {
		return codRVeiculo;
	}

	public void setCodRVeiculo(Integer codRVeiculo) {
		this.codRVeiculo = codRVeiculo;
	}

	public AutorizacaoExibicao getAutorizacaoExibicao() {
		return autorizacaoExibicao;
	}

	public void setAutorizacaoExibicao(AutorizacaoExibicao autorizacaoExibicao) {
		this.autorizacaoExibicao = autorizacaoExibicao;
	}

	public String getStatusAutorizacao(Integer codVeiculo) {
		
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		if(autorizacaoExibicaoRN.buscarUltimaPorUsuarioVeiculo(contextoBean.getUsuarioLogado().getCodigo(), codVeiculo) == null) {
			return "NÌO EXIBINDO";
		} else {
			return "EXIBINDO";
		}
		
	}
	
	public String getLinkAutorizacao(Integer codVeiculo) {
		
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		if(autorizacaoExibicaoRN.buscarUltimaPorUsuarioVeiculo(contextoBean.getUsuarioLogado().getCodigo(), codVeiculo) == null) {
			return "SEM LINK CADASTRADO";
		} else {
			
			return autorizacaoExibicaoRN.buscarUltimaPorUsuarioVeiculo(contextoBean.getUsuarioLogado().getCodigo(), codVeiculo).getEnderecoLink();
			
		}
		
	}
	
	public void salvaAutorizacao() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		VeiculoRN veiculoRN = new VeiculoRN();
		AutorizacaoExibicaoRN autorizacaoExibicaoRN = new AutorizacaoExibicaoRN();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		this.autorizacaoExibicao.setData(new Date());
		this.autorizacaoExibicao.setUsuario(contextoBean.getUsuarioLogado());
		this.autorizacaoExibicao.setVeiculo(veiculoRN.carregar(this.codRVeiculo));
		autorizacaoExibicaoRN.salvar(autorizacaoExibicao);
		
		try {
			context.getExternalContext().redirect("/InternetMotors/restrito/pagamento.jsf?codAutorizacao=" + this.autorizacaoExibicao.getCodigo());
    		context.responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
