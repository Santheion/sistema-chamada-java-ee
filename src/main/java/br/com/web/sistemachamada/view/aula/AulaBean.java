package br.com.web.sistemachamada.view.aula;

import br.com.web.sistemachamada.models.Aula;
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
import java.util.List;

@Named
@Stateful
@ConversationScoped
@Transactional
public class AulaBean implements Serializable {
    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Aula> aulas;
    private Aula aula = new Aula();

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public void getAll() {
        CriteriaQuery<Aula> criteria = this.em.getCriteriaBuilder()
                .createQuery(Aula.class);

        this.aulas = this.em.createQuery(
                criteria.select(criteria.from(Aula.class))).getResultList();

        Gson gson = new Gson();
        System.out.println(gson.toJson(this.aulas));
    }

    public void retrieve(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
    }

    public void create(){
        em.persist(aula);
        this.conversation.end();
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public Aula getAula() {
        return aula;
    }
}
