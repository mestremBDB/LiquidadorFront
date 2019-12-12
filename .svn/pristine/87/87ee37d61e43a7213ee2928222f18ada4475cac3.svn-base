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
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "AppEventos.findAll", query = "select o from AppEventos o") })
@Table(name = "APP_EVENTOS")
public class AppEventos implements Serializable {
    private static final long serialVersionUID = -7925985081322423878L;
    @Column(length = 200)
    private String descripcion;
    @Column(length = 4)
    private String estado;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(length = 50)
    private String nombre;
    @OneToMany(mappedBy = "appEventos", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfEventosproceso> confEventosprocesoList1;

    public AppEventos() {
    }

    public AppEventos(String descripcion, String estado, BigDecimal id, String nombre) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.id = id;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public List<ConfEventosproceso> getConfEventosprocesoList1() {
        return confEventosprocesoList1;
    }

    public void setConfEventosprocesoList1(List<ConfEventosproceso> confEventosprocesoList1) {
        this.confEventosprocesoList1 = confEventosprocesoList1;
    }

    public ConfEventosproceso addConfEventosproceso(ConfEventosproceso confEventosproceso) {
        getConfEventosprocesoList1().add(confEventosproceso);
        confEventosproceso.setAppEventos(this);
        return confEventosproceso;
    }

    public ConfEventosproceso removeConfEventosproceso(ConfEventosproceso confEventosproceso) {
        getConfEventosprocesoList1().remove(confEventosproceso);
        confEventosproceso.setAppEventos(null);
        return confEventosproceso;
    }
}
