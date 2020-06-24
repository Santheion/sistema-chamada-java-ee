package br.com.web.sistemachamada.view.classe;

import br.com.web.sistemachamada.models.Classe;
import br.com.web.sistemachamada.models.Disciplina;
import br.com.web.sistemachamada.models.Professor;
import br.com.web.sistemachamada.models.Horario;
import com.google.gson.Gson;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Stateful
@ConversationScoped
@Transactional
public class ClasseBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Classe> classes;
    private Classe classe = new Classe();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();
    private List<Horario> horarios = new ArrayList<>();

    public void getAllRelationShips(){
        CriteriaQuery<Disciplina> criteriaDisciplinas = this.em.getCriteriaBuilder()
                .createQuery(Disciplina.class);
        this.disciplinas = this.em.createQuery(
                criteriaDisciplinas.select(criteriaDisciplinas.from(Disciplina.class))).getResultList();

        CriteriaQuery<Professor> criteriaProfessores = this.em.getCriteriaBuilder()
                .createQuery(Professor.class);
        this.professors = this.em.createQuery(
                criteriaProfessores.select(criteriaProfessores.from(Professor.class))).getResultList();

        CriteriaQuery<Horario> criteriaHorarios = this.em.getCriteriaBuilder()
                .createQuery(Horario.class);
        this.horarios = this.em.createQuery(
                criteriaHorarios.select(criteriaHorarios.from(Horario.class))).getResultList();
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public void getAll() {
        CriteriaQuery<Classe> criteria = this.em.getCriteriaBuilder()
                .createQuery(Classe.class);

        this.classes = this.em.createQuery(
                criteria.select(criteria.from(Classe.class))).getResultList();
    }

    public void retrieve(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
        getAllRelationShips();
    }

    public String create(){
        Gson gson = new Gson();
        System.out.println("create classe bean");
        System.out.println(gson.toJson(classe));
        em.persist(classe);
        this.conversation.end();
        return "list?faces-redirect=true";
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public Classe getClasse() {
        return classe;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
