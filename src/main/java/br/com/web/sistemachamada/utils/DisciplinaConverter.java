package br.com.web.sistemachamada.utils;

import br.com.web.sistemachamada.models.Disciplina;
import br.com.web.sistemachamada.view.disciplina.DisciplinaBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "disciplinaConverter", forClass = Disciplina.class)
public class DisciplinaConverter implements javax.faces.convert.Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string != null && !string.isEmpty()) {
            DisciplinaBean bean = new DisciplinaBean();
            return bean.findById(Integer.valueOf(string));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Disciplina)) {
            return String.valueOf(((Disciplina) o).getId());
        }

        return null;
    }
}
