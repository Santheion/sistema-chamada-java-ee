package br.com.web.sistemachamada.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.Serializable;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "recurso")

public class Recurso implements Serializable {
    @NotNull
    public String justificativa;

    @NotNull
    public File anexo;

    public Recurso(){}

    public Recurso(String justificativa, File anexo) {
        this.justificativa = justificativa;
        this.anexo = anexo;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public File getAnexo() {
        return anexo;
    }

    public void setAnexo(File anexo) {
        this.anexo = anexo;
    }
}
