package br.com.web.sistemachamada.view.horario;

import br.com.web.sistemachamada.models.Aula;
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
import java.util.List;

@Named
@Stateful
@ConversationScoped
@Transactional
public class HorarioBean implements Serializable{
    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Horario> horarios;
    private Horario horario = new Horario();

    public void getAll() {
        CriteriaQuery<Horario> criteria = this.em.getCriteriaBuilder()
                .createQuery(Horario.class);

        this.horarios = this.em.createQuery(
                criteria.select(criteria.from(Horario.class))).getResultList();

        Gson gson = new Gson();
        System.out.println(gson.toJson(this.horarios));
    }

    public void retrieve(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
    }

    public void create(){
        em.persist(horario);
        this.conversation.end();
    }
    public List<Horario> getHorarios() {
        return horarios;
    }

    public Horario getHorario() {
        return horario;
    }

}
