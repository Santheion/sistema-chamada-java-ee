package br.com.web.sistemachamada.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Table(name = "user")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(sequenceName="SEQ_INHERITANCE_TABLE_PER_CLASS",
        name="seqTPC", initialValue=0, allocationSize=1)
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Integer id;

    @NotNull
    public String nome;
    @NotNull
    public String email;
    @NotNull
    @Min(6)
    public String senha;
    @NotNull
    public Integer cpf;
    @NotNull
    @Max(1)
    public String sexo;

    public Usuario(String nome, String email, String senha, Integer cpf, String sexo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public Usuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
