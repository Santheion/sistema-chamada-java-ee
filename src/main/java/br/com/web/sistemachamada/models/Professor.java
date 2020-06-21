package br.com.web.sistemachamada.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Professor  extends Usuario{

    public Professor(String nome, String email, String senha, Integer cpf, String sexo) {
        super(nome, email, senha, cpf, sexo);
    }

}
