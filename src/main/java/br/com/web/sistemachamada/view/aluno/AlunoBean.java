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
    private static final long serialVersionUID = 1L;

    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Aluno> alunos;
    private Aluno aluno = new Aluno();
    private Aluno canLogIn;

    public void setAlunos(List<Aluno> alunos) {
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

    public String create(){
        em.persist(aluno);
        this.conversation.end();
        return "list?faces-redirect=true";
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Aluno findUserByEmail(String email){
        canLogIn = em.createQuery(
                "SELECT u from Aluno u WHERE u.email = :email", Aluno.class).
                setParameter("email", email).getSingleResult();
        return canLogIn;
    }

    public String loginAluno(){
        Aluno userByEmail = findUserByEmail(this.aluno.email);
        Gson gson = new Gson();
        System.out.println(gson.toJson(userByEmail));

        if(userByEmail != null){
            return "/aluno/index.html?faces-redirect=true";
        }
        else{
            return "/aluno/login?faces-redirect=true";
        }
    }

}
