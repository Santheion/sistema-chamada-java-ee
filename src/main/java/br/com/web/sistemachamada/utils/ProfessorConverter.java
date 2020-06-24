package br.com.web.sistemachamada.utils;

import br.com.web.sistemachamada.models.Professor;
import br.com.web.sistemachamada.view.professor.ProfessorBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "professorConverter", forClass = Professor.class)
public class ProfessorConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string != null && !string.isEmpty()) {
            ProfessorBean bean = new ProfessorBean();
            return bean.findById(Integer.valueOf(string));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Professor)) {
            return String.valueOf(((Professor) o).getId());
        }

        return null;
    }

}
