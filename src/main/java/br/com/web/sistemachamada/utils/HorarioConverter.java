package br.com.web.sistemachamada.utils;

import br.com.web.sistemachamada.models.Horario;
import br.com.web.sistemachamada.view.horario.HorarioBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "disciplinaConverter", forClass = Horario.class)
public class HorarioConverter implements javax.faces.convert.Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string != null && !string.isEmpty()) {
            HorarioBean bean = new HorarioBean();
            return bean.findById(Integer.valueOf(string));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Horario)) {
            return String.valueOf(((Horario) o).getIdHorario());
        }

        return null;
    }
}