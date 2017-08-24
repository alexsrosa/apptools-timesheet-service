package br.com.tools.timesheet.domain.manager;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Consultores.
 */
@Entity
@Table(name = "consultores")
public class Consultor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "dataprimeiroregistro", nullable = false)
    private LocalDate dataprimeiroregistro;

    @NotNull
    @Column(name = "dataultimoregistro", nullable = false)
    private LocalDate dataultimoregistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Consultor nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataprimeiroregistro() {
        return dataprimeiroregistro;
    }

    public Consultor dataprimeiroregistro(LocalDate dataprimeiroregistro) {
        this.dataprimeiroregistro = dataprimeiroregistro;
        return this;
    }

    public void setDataprimeiroregistro(LocalDate dataprimeiroregistro) {
        this.dataprimeiroregistro = dataprimeiroregistro;
    }

    public LocalDate getDataultimoregistro() {
        return dataultimoregistro;
    }

    public Consultor dataultimoregistro(LocalDate dataultimoregistro) {
        this.dataultimoregistro = dataultimoregistro;
        return this;
    }

    public void setDataultimoregistro(LocalDate dataultimoregistro) {
        this.dataultimoregistro = dataultimoregistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Consultor consultores = (Consultor) o;
        if (consultores.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), consultores.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Consultores{" +
                "id=" + getId() +
                ", nome='" + getNome() + "'" +
                ", dataprimeiroregistro='" + getDataprimeiroregistro() + "'" +
                ", dataultimoregistro='" + getDataultimoregistro() + "'" +
                "}";
    }
}
