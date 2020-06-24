package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Professor extends Usuario{

    @NotNull
    @Column(name = "idProfessor", updatable = false, nullable = false)
    public String idProfessor;

    public Professor(String nome, String email, String senha, String cpf, String sexo, String idProfessor) {
        super(nome, email, senha, cpf, sexo);
        this.idProfessor = idProfessor;
    }

    public Professor(){

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
    public List<Classe> classes;

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }
}
