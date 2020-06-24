package br.com.web.sistemachamada.enums;

public enum DiasDaSemana {
    SEGUNDA("Segunda-feira", "SEGUNDA"),
    TERCA("Terça-feira", "TERCA"),
    QUARTA("Quarta-feira", "QUARTA"),
    QUINTA("Quinta-feira", "QUINTA"),
    SEXTA("Sexta-feira", "SEXTA"),
    SABADO("Sábado", "SABADO"),
    DOMINGO("Domingo", "DOMINGO");

    private String nome;
    private String codigo;

    private DiasDaSemana(String nome, String codigo) {
        this.nome = nome ;
        this.codigo = codigo ;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

}