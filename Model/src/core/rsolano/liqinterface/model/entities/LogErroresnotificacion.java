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
@NamedQueries({
              @NamedQuery(name = "LogErroresnotificacion.findAll", query = "select o from LogErroresnotificacion o") })
@Table(name = "LOG_ERRORESNOTIFICACION")
public class LogErroresnotificacion implements Serializable {
    private static final long serialVersionUID = -3461107192265110715L;
    @Column(length = 100)
    private String componente;
    @Column(length = 2000)
    private String errormessage;
    @Temporal(TemporalType.DATE)
    private Date fechaerror;
    @Id
    @Column(nullable = false, length = 45)
    private String id;
    @Column(length = 100)
    private String tipo;

    public LogErroresnotificacion() {
    }

    public LogErroresnotificacion(String componente, String errormessage, Date fechaerror, String id, String tipo) {
        this.componente = componente;
        this.errormessage = errormessage;
        this.fechaerror = fechaerror;
        this.id = id;
        this.tipo = tipo;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public Date getFechaerror() {
        return fechaerror;
    }

    public void setFechaerror(Date fechaerror) {
        this.fechaerror = fechaerror;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
