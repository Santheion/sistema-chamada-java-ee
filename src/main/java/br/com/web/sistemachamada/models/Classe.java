package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Classe  implements Serializable {
    public Classe(){

    }

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "idClass", updatable = false, nullable = false)
    public Integer idClasse;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "idProfessor")
    public Professor professor;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idDisciplina")
    public Disciplina disciplina;

    @NotNull
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="idHorario")
    public List<Horario> horarios;


    public Classe(Integer idClasse, Professor professor, Disciplina disciplina, List<Horario> horarios) {
        this.idClasse = idClasse;
        this.professor = professor;
        this.disciplina = disciplina;
        this.horarios = horarios;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}