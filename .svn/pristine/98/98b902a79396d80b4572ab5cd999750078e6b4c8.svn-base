package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "LogErroresliq.findAll", query = "select o from LogErroresliq o") })
@Table(name = "LOG_ERRORESLIQ")
public class LogErroresliq implements Serializable {
    private static final long serialVersionUID = 5282157964100843027L;
    @Column(length = 100)
    private String componente;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Id
    @Column(nullable = false, length = 45)
    private String id;
    @Column(length = 2000)
    private String mensaje;
    @Column(length = 50)
    private String severidad;
    @Column(length = 100)
    private String tipo;

    public LogErroresliq() {
    }

    public LogErroresliq(String componente, Date fecha, String id, String mensaje, String severidad, String tipo) {
        this.componente = componente;
        this.fecha = fecha;
        this.id = id;
        this.mensaje = mensaje;
        this.severidad = severidad;
        this.tipo = tipo;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
