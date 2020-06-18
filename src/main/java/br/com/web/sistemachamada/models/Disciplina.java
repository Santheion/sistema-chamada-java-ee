package br.com.web.sistemachamada.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "disciplinas")
public class Disciplina implements Serializable {
    public Disciplina(){}

    public Disciplina(String nome, String periodo){
        this.nome = nome;
        this.periodo = periodo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @NotNull
    public String nome;

    @NotNull
    public String periodo;

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
}
