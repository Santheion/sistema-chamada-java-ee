package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Presenca implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Integer idPresenca;
    //@NotNull
    @OneToOne
    @JoinColumn(name="matricula")
    public Aluno idAluno;
    @NotNull
    public boolean presente;

    public Presenca(){}

    public Presenca(boolean presente) {
        this.presente = presente;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }


    public Aluno getIdAluno() {
        return idAluno;
    }

    public String getIdAlunoNome() {
        return idAluno.nome;
    }

}
