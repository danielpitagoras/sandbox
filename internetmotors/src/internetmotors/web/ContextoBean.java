package internetmotors.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import internetmotors.endereco.Endereco;
import internetmotors.endereco.EnderecoRN;
import internetmotors.usuario.*;

@ManagedBean(name = "contextoBean")
@SessionScoped

public class ContextoBean {

	private Usuario usuarioLogado = null;
	private List<Endereco> listadeEnderecos = new ArrayList<Endereco>();
	
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
	
}
