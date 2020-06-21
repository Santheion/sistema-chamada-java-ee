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
    public Integer idClasse;
    @NotNull
    @OneToOne
    public Professor idProfessor;
    @NotNull
    @OneToMany
    public Aluno idAluno;
    @ManyToMany
    public Horario idHorario;

    public Classe(){}

    public Classe(Professor idProfessor, Aluno idAluno, Horario idHorario) {
        this.idProfessor = idProfessor;
        this.idAluno = idAluno;
        this.idHorario = idHorario;
    }

    public Professor getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Professor idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }
}
