package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "aula")

public class Aula implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer id;

    @NotNull
    @Column( name = "dia")
    public Date dia;

    public Aula(){}

    public Aula(Date dia){
        this.dia = dia;
    }

    public Date getDia(){
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
}
