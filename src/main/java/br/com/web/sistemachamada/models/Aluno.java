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

    public Aluno(String nome, String email, String senha, Integer cpf, String sexo) {
        super(nome, email, senha, cpf, sexo);
    }

}
