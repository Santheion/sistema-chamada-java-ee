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
    @Column(name = "idHorario", updatable = false, nullable = false)
    public Integer id;

    @NotNull
    @Column( name = "dia_semana")
    public String diaSemana;

    @NotNull
    @Column(name ="hora_inicial")
    public long horaInicial;

    @NotNull
    @Column(name ="hora_final")
    public long horaFinal;

    public Horario(){}

    public Horario(String diaSemana, long horaInicial, long horaFinal){
        this.diaSemana = diaSemana;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public long getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(long horaInicial) {
        this.horaInicial = horaInicial;
    }

    public long getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(long horaFinal) {
        this.horaFinal = horaFinal;
    }
}
