package internetmotors.util;

import javax.faces.context.*;
import javax.servlet.http.HttpSession;
import internetmotors.web.ContextoBean;

public class ContextoUtil {

	public static ContextoBean getContextoBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);
		ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
		return contextoBean;
	}
}