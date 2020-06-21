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
@Table(name = "horario")

public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Integer id;

    @NotNull
    @Column( name = "dia_semana")
    public Date diaSemana;

    @NotNull
    @Column(name ="hora_inicial")
    public long horaIncicial;

    @NotNull
    @Column(name ="hora_final")
    public long horaFinal;

    public Horario(){}

    public Horario(Date diaSemana, long horaIncicial, long horaFinal){
        this.diaSemana = diaSemana;
        this.horaIncicial = horaIncicial;
        this.horaFinal = horaFinal;
    }

    public Date getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Date diaSemana) {
        this.diaSemana = diaSemana;
    }

    public long getHoraIncicial() {
        return horaIncicial;
    }

    public void setHoraIncicial(long horaIncicial) {
        this.horaIncicial = horaIncicial;
    }

    public long getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(long horaFinal) {
        this.horaFinal = horaFinal;
    }
}
