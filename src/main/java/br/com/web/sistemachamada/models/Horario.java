package br.com.web.sistemachamada.models;

import br.com.web.sistemachamada.enums.DiasDaSemana;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "horario")

public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Enumerated(EnumType.STRING)
    @Column(name = "idHorario", updatable = false, nullable = false)
    public DiasDaSemana id;

    @NotNull
    @Column( name = "dia_semana")
    public String diaSemana;

    @NotNull
    @Column(name ="hora_inicial")
    public String horaInicial;

    @NotNull
    @Column(name ="hora_final")
    public String horaFinal;

    @ManyToMany(fetch = FetchType.LAZY)
    public List<Classe> classes;

    public Horario(){}

    public Horario(String diaSemana, String horaInicial, String horaFinal){
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

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
}
