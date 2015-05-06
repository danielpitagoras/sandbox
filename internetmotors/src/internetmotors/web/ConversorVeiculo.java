package internetmotors.web;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import internetmotors.veiculo.Veiculo;

@FacesConverter(value = "conversorVeiculo", forClass = Veiculo.class)

public class ConversorVeiculo implements Converter{

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (Veiculo) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof Veiculo) {
			Veiculo veiculo = (Veiculo) value;
			if (veiculo != null && veiculo instanceof Veiculo && veiculo.getCodigo() != null) {
				uiComponent.getAttributes().put( veiculo.getCodigo().toString(), veiculo);
				return veiculo.getCodigo().toString();
			}
		}
		return "";
	}
	
}
