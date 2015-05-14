package internetmotors.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import internetmotors.sinistro.Sinistro;

@FacesConverter(value = "conversorSinistro", forClass = Sinistro.class)

public class ConversorSinistro implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Sinistro) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Sinistro) {
			Sinistro sinistro = (Sinistro) value;
			if (sinistro != null && sinistro instanceof Sinistro && sinistro.getCodigo() != null) {
				uiComponent.getAttributes().put( sinistro.getCodigo().toString(), sinistro);
				return sinistro.getCodigo().toString();
			}
		}
		return "";
	}
	
}
