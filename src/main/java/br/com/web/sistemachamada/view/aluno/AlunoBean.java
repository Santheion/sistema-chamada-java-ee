package br.com.web.sistemachamada.view.aluno;

import br.com.web.sistemachamada.models.Aluno;
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
public class AlunoBean implements Serializable{
    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Aluno> alunos;
    private Aluno aluno = new Aluno();

    public void setAlunos(List<Aluno> alu) {
        this.alunos = alunos;
    }

    public void getAll() {
        CriteriaQuery<Aluno> criteria = this.em.getCriteriaBuilder()
                .createQuery(Aluno.class);

        this.alunos = this.em.createQuery(
                criteria.select(criteria.from(Aluno.class))).getResultList();

        Gson gson = new Gson();
        System.out.println(gson.toJson(this.alunos));
    }

    public void retrieve(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
    }

    public void create(){
        em.persist(aluno);
        this.conversation.end();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno getAluno() {
        return aluno;
    }
}
