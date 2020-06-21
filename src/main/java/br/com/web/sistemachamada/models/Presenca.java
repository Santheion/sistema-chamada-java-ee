package br.com.web.sistemachamada.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Presenca implements Serializable {
    @OneToOne
    public Aula idAula;
    @ManyToMany
    public Aluno idAluno;
    @NotNull
    public boolean presente;

    public Presenca(){}

    public Presenca(Aula idAula, Aluno idAluno, boolean presente) {
        this.idAula = idAula;
        this.idAluno = idAluno;
        this.presente = presente;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
