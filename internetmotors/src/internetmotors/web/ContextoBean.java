package internetmotors.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import internetmotors.endereco.Endereco;
import internetmotors.endereco.EnderecoRN;
import internetmotors.usuario.*;
import internetmotors.veiculo.*;

@ManagedBean(name = "contextoBean")
@SessionScoped

public class ContextoBean {

	private Integer codVeiculo;
	private Integer codOcorrencia;
	private Usuario usuarioLogado = null;
	private Veiculo veiculoSelecionado = null;
	private List<Endereco> listadeEnderecos = new ArrayList<Endereco>();
	private List<Veiculo> listadeVeiculos = new ArrayList<Veiculo>();
	private List<Veiculo> lista;
	private Part arqImagem1 = null;
	private Part arqImagem2 = null;
	private Part arqImagem3 = null;
	private Part arqImagem4 = null;
	private Part arqImagem5 = null;
	private byte[] imgb1 = null;
	private byte[] imgb2 = null;
	private byte[] imgb3 = null;
	private byte[] imgb4 = null;
	private byte[] imgb5 = null;
	
	
	//Interface de Ocorrências
	public StreamedContent getImgStream() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	        String id = context.getExternalContext().getRequestParameterMap().get("id");
	        
	        VeiculoRN veiculoRN = new VeiculoRN();
			this.lista = veiculoRN.listar();
	       
	        for (int i = 0; i < lista.size(); i++) {
	        	if (Integer.valueOf(id) == lista.get(i).getCodigo()) {
	    		   return new DefaultStreamedContent(new ByteArrayInputStream(lista.get(i).getImagem1()));
	    	   }	   
	       }
	        return new DefaultStreamedContent();
	    }
	}
	
	//Interface de Veículos
	public StreamedContent getImgStream1() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	if (imgb1 != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb1));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	
	public StreamedContent getImgStream2() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	if (imgb2 != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb2));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	
	public StreamedContent getImgStream3() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	if (imgb3 != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb3));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	
	public StreamedContent getImgStream4() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	if (imgb4 != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb4));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	
	public StreamedContent getImgStream5() throws IOException {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // Fase de renderização.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // Fase do browser solicitar a imagem.
	    	
	    	if (imgb5 != null) {
	    		return new DefaultStreamedContent(new ByteArrayInputStream(this.imgb5));
	    	}
	    	return new DefaultStreamedContent();
	    }
	}
	//Fim do Stream interface de veículos
	
	public List<Endereco> getListadeEnderecos() {
		
		if (this.listadeEnderecos.isEmpty()) {
			
			EnderecoRN enderecoRN = new EnderecoRN();
			
			if (this.usuarioLogado == null) {
				
			} else {
				this.listadeEnderecos = enderecoRN.listarPorUsuario(usuarioLogado);
				
			}
			
		}
		
		return listadeEnderecos;
	}
		
	public Usuario getUsuarioLogado(){
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
	
	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}

	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}

	public void setListadeEnderecos(List<Endereco> listadeEnderecos) {
		this.listadeEnderecos = listadeEnderecos;
	}

	public List<Veiculo> getListadeVeiculos() {
		
		if (this.listadeVeiculos.isEmpty()) {
			
			VeiculoRN veiculoRN = new VeiculoRN();
			
			if (this.usuarioLogado == null) {
				
			} else {
				this.listadeVeiculos = veiculoRN.listarPorUsuario(usuarioLogado);
				return listadeVeiculos;
			}
			
		}
	
		return listadeVeiculos;
	}

	public void setListadeVeiculos(List<Veiculo> listadeVeiculos) {
		this.listadeVeiculos = listadeVeiculos;
	}

	public Part getArqImagem1() {
		return arqImagem1;
	}

	public void setArqImagem1(Part arqImagem1) {
		
		this.arqImagem1 = arqImagem1;
		
		try {
			
			InputStream entradaimg1 = arqImagem1.getInputStream();
			imgb1 = IOUtils.toByteArray(entradaimg1);
		} catch (Throwable e){
			
			System.out.println(e);
		
		}
			
	}

	public Part getArqImagem2() {
		return arqImagem2;
	}

	public void setArqImagem2(Part arqImagem2) {
		this.arqImagem2 = arqImagem2;
		
		try {
			
			InputStream entradaimg2 = arqImagem2.getInputStream();
			imgb2 = IOUtils.toByteArray(entradaimg2);
		} catch (Throwable e){
			
			System.out.println(e);
		
		}
		
	}

	public Part getArqImagem3() {
		return arqImagem3;
	}

	public void setArqImagem3(Part arqImagem3) {
		this.arqImagem3 = arqImagem3;
		
		try {
			
			InputStream entradaimg3 = arqImagem3.getInputStream();
			imgb3 = IOUtils.toByteArray(entradaimg3);
		} catch (Throwable e){
			
			System.out.println(e);
		
		}
	}

	public Part getArqImagem4() {
		return arqImagem4;
	}

	public void setArqImagem4(Part arqImagem4) {
		this.arqImagem4 = arqImagem4;
		
		try {
			
			InputStream entradaimg4 = arqImagem4.getInputStream();
			imgb4 = IOUtils.toByteArray(entradaimg4);
		} catch (Throwable e){
			
			System.out.println(e);
		
		}
	}

	public Part getArqImagem5() {
		return arqImagem5;
	}

	public void setArqImagem5(Part arqImagem5) {
		this.arqImagem5 = arqImagem5;
		
		try {
			
			InputStream entradaimg5 = arqImagem5.getInputStream();
			imgb5 = IOUtils.toByteArray(entradaimg5);
		} catch (Throwable e){
			
			System.out.println(e);
		
		}
		
	}

	public byte[] getImgb1() {
		return imgb1;
	}

	public void setImgb1(byte[] imgb1) {
		this.imgb1 = imgb1;
	}

	public byte[] getImgb2() {
		return imgb2;
	}

	public void setImgb2(byte[] imgb2) {
		this.imgb2 = imgb2;
	}

	public byte[] getImgb3() {
		return imgb3;
	}

	public void setImgb3(byte[] imgb3) {
		this.imgb3 = imgb3;
	}

	public byte[] getImgb4() {
		return imgb4;
	}

	public void setImgb4(byte[] imgb4) {
		this.imgb4 = imgb4;
	}

	public byte[] getImgb5() {
		return imgb5;
	}

	public void setImgb5(byte[] imgb5) {
		this.imgb5 = imgb5;
	}

	public Integer getCodVeiculo() {
		return codVeiculo;
	}

	public void setCodVeiculo(Integer codVeiculo) {
		this.codVeiculo = codVeiculo;
	}

	public Integer getCodOcorrencia() {
		return codOcorrencia;
	}

	public void setCodOcorrencia(Integer codOcorrencia) {
		this.codOcorrencia = codOcorrencia;
	}
	
}
