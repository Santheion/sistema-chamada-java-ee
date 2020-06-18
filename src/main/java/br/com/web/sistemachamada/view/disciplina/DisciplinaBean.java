package br.com.web.sistemachamada.view.disciplina;

import br.com.web.sistemachamada.models.Disciplina;

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
import java.util.List;

@Named
@Stateful
@ConversationScoped
@Transactional
public class DisciplinaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Disciplina> disciplinas;
    private Disciplina disciplina;

    public void getAll() {
        CriteriaQuery<Disciplina> criteria = this.em.getCriteriaBuilder()
                .createQuery(Disciplina.class);

        this.disciplinas = this.em.createQuery(
                criteria.select(criteria.from(Disciplina.class))).getResultList();
    }

    public void retrieve(){
        System.out.println("retrieve");
        this.disciplina = new Disciplina();
    }

    public String create(){
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
        return "disciplina/list?faces-redirect=true";
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Object getDisciplina() {
        return disciplina;
    }
}
