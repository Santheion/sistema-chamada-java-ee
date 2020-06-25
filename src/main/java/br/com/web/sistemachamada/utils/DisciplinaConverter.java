package br.com.web.sistemachamada.utils;

import br.com.web.sistemachamada.models.Disciplina;
import br.com.web.sistemachamada.view.disciplina.DisciplinaBean;
import com.google.gson.Gson;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.persistence.Converter;

@FacesConverter(value = "disciplinaConverter", forClass = Disciplina.class)
public class DisciplinaConverter implements javax.faces.convert.Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println("getAsObject" + string);
        if (string != null && !string.isEmpty()) {
            DisciplinaBean bean = new DisciplinaBean();
            Disciplina disciplina = bean.findById(Integer.valueOf(string));
            return disciplina;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Disciplina)) {
            Disciplina disciplina = (Disciplina) o;
            System.out.println("disciplina = " + disciplina);
            return String.valueOf(disciplina.id);
        }

        return null;
    }
}