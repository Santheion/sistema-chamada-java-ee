package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Classe  implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "idClass", updatable = false, nullable = false)
    public Integer idClasse;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo")
    public Professor professor;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idDisciplina")
    public Disciplina disciplina;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idHorario")
    public Horario horario;

    public Classe(Integer idClasse, Professor professor, Disciplina disciplina, Horario horario) {
        this.idClasse = idClasse;
        this.professor = professor;
        this.disciplina = disciplina;
        this.horario = horario;
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

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}