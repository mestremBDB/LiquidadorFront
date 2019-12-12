package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.Date;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries
({ 
    @NamedQuery(name = "LogCryptolog.findAll", query = "select o from LogCryptolog o"),
    @NamedQuery(name = "LogCryptolog.findByFecha", query = "select o from LogCryptolog o WHERE o.fecha BETWEEN :startDate AND :endDate")
})
@Table(name = "LOG_CRYPTOLOG")
public class LogCryptolog implements Serializable {
    
    private static final long serialVersionUID = -6736037419367287048L;
    
    @Id
    @Column(nullable = false, length = 36)
    private String id;
    
    @Column(name = "ACCION", nullable = false)
    private String accion;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    private Date fecha;
    
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    
    @Column(name = "USUARIO", nullable = false)
    private String usuario;

    @Column(name = "DOMINIO", nullable = false)
    private String dominio;
    
    @Column(name = "NHOST", nullable = false)
    private String nhost;
    
    public LogCryptolog() {
    }

    public LogCryptolog(String accion, String descripcion, String usuario, String dominio, String nhost) {
        this.id = UUID.randomUUID().toString();
        this.fecha = new java.sql.Date((new Date()).getTime());
        this.accion = accion;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.dominio = dominio;
        this.nhost = nhost;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
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

    public String getNhost() {
        return nhost;
    }

    public void setNhost(String nhost) {
        this.nhost = nhost;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
