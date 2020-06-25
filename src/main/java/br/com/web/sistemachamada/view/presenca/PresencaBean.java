package br.com.web.sistemachamada.view.presenca;

import br.com.web.sistemachamada.models.Presenca;
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
public class PresencaBean implements Serializable {
    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Presenca> presencas;
    private List<Integer> checkPresenca  = new ArrayList<Integer>();
    private Presenca presenca = new Presenca();

    public void setPresencas(List<Presenca> presencas) {

        this.presencas = presencas;
    }

    public void getAll() {
        CriteriaQuery<Presenca> criteria = this.em.getCriteriaBuilder()
                .createQuery(Presenca.class);

        this.presencas = this.em.createQuery(
                criteria.select(criteria.from(Presenca.class))).getResultList();
    }

    public void retrieve(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
    }

    public String create(){
        em.persist(presenca);
        this.conversation.end();
        return "list?faces-redirect=true";
    }

    public List<Presenca> getPresencas() {
        return presencas;
    }

    public Presenca getPresenca() {
        return presenca;
    }
}