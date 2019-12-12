package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
              @NamedQuery(name = "ConfFuenteinsumostructure.findAll",
                          query = "select o from ConfFuenteinsumostructure o") })
@Table(name = "CONF_FUENTEINSUMOSTRUCTURE")
public class ConfFuenteinsumostructure implements Serializable {
    private static final long serialVersionUID = -7071735788255715462L;
    @Column(length = 50)
    private String entidadtabla;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    @Column(length = 50)
    private String nombrebd;
    @Column(length = 60)
    private String nombreestructura;
    @Column(length = 50)
    private String nombretabla;
    @Column(length = 50)
    private String unidadpersistencia;
    @ManyToOne
    @JoinColumn(name = "IDEVENTOPROCESO")
    private ConfEventosproceso confEventosproceso1;
    @Column(name = "FORMATOFECHA")
    private String formatofecha;

    public ConfFuenteinsumostructure() {
    }

    public ConfFuenteinsumostructure(String entidadtabla, String id, ConfEventosproceso confEventosproceso1,
                                     String nombrebd, String nombreestructura, String nombretabla,
                                     String unidadpersistencia) {
        this.entidadtabla = entidadtabla;
        this.id = id;
        this.confEventosproceso1 = confEventosproceso1;
        this.nombrebd = nombrebd;
        this.nombreestructura = nombreestructura;
        this.nombretabla = nombretabla;
        this.unidadpersistencia = unidadpersistencia;
    }

    public void setFormatofecha(String formatofecha) {
        this.formatofecha = formatofecha;
    }

    public String getFormatofecha() {
        return formatofecha;
    } 


    public String getEntidadtabla() {
        return entidadtabla;
    }

    public void setEntidadtabla(String entidadtabla) {
        this.entidadtabla = entidadtabla;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNombrebd() {
        return nombrebd;
    }

    public void setNombrebd(String nombrebd) {
        this.nombrebd = nombrebd;
    }

    public String getNombreestructura() {
        return nombreestructura;
    }

    public void setNombreestructura(String nombreestructura) {
        this.nombreestructura = nombreestructura;
    }

    public String getNombretabla() {
        return nombretabla;
    }

    public void setNombretabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    public String getUnidadpersistencia() {
        return unidadpersistencia;
    }

    public void setUnidadpersistencia(String unidadpersistencia) {
        this.unidadpersistencia = unidadpersistencia;
    }

    public ConfEventosproceso getConfEventosproceso1() {
        return confEventosproceso1;
    }

    public void setConfEventosproceso1(ConfEventosproceso confEventosproceso1) {
        this.confEventosproceso1 = confEventosproceso1;
    }
}
