package internetmotors.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import internetmotors.servico.Servico;

@FacesConverter(value = "conversorServico", forClass = Servico.class)

public class ConversorServico implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Servico) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Servico) {
			Servico servico = (Servico) value;
			if (servico != null && servico instanceof Servico && servico.getCodigo() != null) {
				uiComponent.getAttributes().put( servico.getCodigo().toString(), servico);
				return servico.getCodigo().toString();
			}
		}
		return "";
	}
	
	
}
