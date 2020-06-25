package br.com.web.sistemachamada.view.professor;
import br.com.web.sistemachamada.models.Aluno;
import br.com.web.sistemachamada.models.Disciplina;
import br.com.web.sistemachamada.models.Professor;
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

public class ProfessorBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Conversation conversation;
    @PersistenceContext(unitName = "sistemaChamadaPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private List<Professor> professors;
    private Professor professor = new Professor();
    private Professor canLogIn;

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public void getAll() {
        CriteriaQuery<Professor> criteria = this.em.getCriteriaBuilder()
                .createQuery(Professor.class);

        this.professors = this.em.createQuery(
                criteria.select(criteria.from(Professor.class))).getResultList();
    }

    public void retrieve(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        this.conversation.begin();
        this.conversation.setTimeout(1800000L);
    }

    public String create(){
        em.persist(professor);
        this.conversation.end();
        return "/professor/login?faces-redirect=true";
    }

    public Professor findUserByEmail(String email){
        canLogIn = em.createQuery(
                "SELECT u from Professor u WHERE u.email = :email", Professor.class).
                setParameter("email", email).getSingleResult();
        return canLogIn;
    }

    public String loginProfessor() {
        Professor userByEmail = findUserByEmail(this.professor.email);
        if (userByEmail != null) {
            return "/professor/list?faces-redirect=true";
        } else {
            return "/professor/login?faces-redirect=true";
        }

    }
    public Professor findById(Integer id) {
        return this.em.find(Professor.class, id);
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public Professor getProfessor() {
        return professor;
    }
}
