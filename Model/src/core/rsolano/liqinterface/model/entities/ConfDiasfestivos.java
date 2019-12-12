package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ConfDiasfestivos.findAll", query = "select o from ConfDiasfestivos o") })
@Table(name = "CONF_DIASFESTIVOS")
@IdClass(ConfDiasfestivosPK.class)
public class ConfDiasfestivos implements Serializable {
    private static final long serialVersionUID = 7073998286304430838L;
    @Id
    @Column(nullable = false, length = 4)
    private String ano;
    @Id
    @Column(nullable = false, length = 2)
    private String dia;
    @Id
    @Column(nullable = false, length = 2)
    private String mes;

    public ConfDiasfestivos() {
    }

    public ConfDiasfestivos(String ano, String dia, String mes) {
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
