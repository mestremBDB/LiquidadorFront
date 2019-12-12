package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ConfGruposcorreo.findAll", query = "select o from ConfGruposcorreo o") })
@Table(name = "CONF_GRUPOSCORREO")
public class ConfGruposcorreo implements Serializable {
    private static final long serialVersionUID = -1633532304793258228L;
    @Column(length = 500)
    private String descripcion;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "confGruposcorreo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfReceptorescorreos> confReceptorescorreosList;

    public ConfGruposcorreo() {
    }

    public ConfGruposcorreo(String descripcion, BigDecimal id, String nombre) {
        this.descripcion = descripcion;
        this.id = id;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ConfReceptorescorreos> getConfReceptorescorreosList() {
        return confReceptorescorreosList;
    }

    public void setConfReceptorescorreosList(List<ConfReceptorescorreos> confReceptorescorreosList) {
        this.confReceptorescorreosList = confReceptorescorreosList;
    }

    public ConfReceptorescorreos addConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        getConfReceptorescorreosList().add(confReceptorescorreos);
        confReceptorescorreos.setConfGruposcorreo(this);
        return confReceptorescorreos;
    }

    public ConfReceptorescorreos removeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        getConfReceptorescorreosList().remove(confReceptorescorreos);
        confReceptorescorreos.setConfGruposcorreo(null);
        return confReceptorescorreos;
    }
}
