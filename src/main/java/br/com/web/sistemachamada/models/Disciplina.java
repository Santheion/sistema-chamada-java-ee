package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "disciplina")
public class Disciplina implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDisciplina", updatable = false, nullable = false)
    public Integer id;

    @NotNull
    @Column(name = "nome")
    public String nome;

    @NotNull
    @Column(name = "periodo")
    public String periodo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "disciplina")
    public List<Classe> classes;

    public Disciplina(){}

    public Disciplina(String nome, String periodo){
        this.nome = nome;
        this.periodo = periodo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
}
