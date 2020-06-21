package br.com.web.sistemachamada.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Aluno extends Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Integer idAluno;

    public Aluno(String nome, String email, String senha, Integer cpf, String sexo, Integer idAluno) {
        super(nome, email, senha, cpf, sexo);
        this.idAluno = idAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }
}
