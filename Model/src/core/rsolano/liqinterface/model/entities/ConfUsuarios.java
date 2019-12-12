package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "ConfUsuarios.findAll", query = "select o from ConfUsuarios o") })
@Table(name = "CONF_USUARIOS")
public class ConfUsuarios implements Serializable {
    private static final long serialVersionUID = 6772747042647229091L;
    @Column(length = 200)
    private String correo;
    private Integer estado;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechacreacion;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(length = 200)
    private String identificacion;
    @Column(nullable = false, unique = true, length = 20)
    private String login;
    @Column(nullable = false, length = 100)
    private String nombre;
    @OneToMany(mappedBy = "confUsuarios", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfReceptorescorreos> confReceptorescorreosList;

    public ConfUsuarios() {
    }

    public ConfUsuarios(String correo, Integer estado, Date fechacreacion, BigDecimal id, String identificacion,
                        String login, String nombre) {
        this.correo = correo;
        this.estado = estado;
        this.fechacreacion = fechacreacion;
        this.id = id;
        this.identificacion = identificacion;
        this.login = login;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
        confReceptorescorreos.setConfUsuarios(this);
        return confReceptorescorreos;
    }

    public ConfReceptorescorreos removeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        getConfReceptorescorreosList().remove(confReceptorescorreos);
        confReceptorescorreos.setConfUsuarios(null);
        return confReceptorescorreos;
    }
}
