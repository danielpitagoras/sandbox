package internetmotors.web;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "principalBean")
@RequestScoped

public class PrincipalBean {

	public void sair() {
		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    try {
			ec.redirect(ec.getRequestContextPath() + "/publico/principal.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
