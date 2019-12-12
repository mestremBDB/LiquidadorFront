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
@NamedQueries({ @NamedQuery(name = "LogInicionotificacion.findAll", query = "select o from LogInicionotificacion o") })
@Table(name = "LOG_INICIONOTIFICACION")
public class LogInicionotificacion implements Serializable {
    private static final long serialVersionUID = -490164745058615336L;
    @Column(length = 30)
    private String algoritmo;
    @Column(length = 300)
    private String canal;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechanotificacion;
    @Column(nullable = false, length = 200)
    private String guidmessage;
    @Column(length = 300)
    private String hash;
    @Id
    @Column(nullable = false, length = 45)
    private String id;
    @Column(length = 200)
    private String nombrearchivo;
    @Column(length = 300)
    private String tipoarchivo;

    public LogInicionotificacion() {
    }

    public LogInicionotificacion(String algoritmo, String canal, Date fechanotificacion, String guidmessage,
                                 String hash, String id, String nombrearchivo, String tipoarchivo) {
        this.algoritmo = algoritmo;
        this.canal = canal;
        this.fechanotificacion = fechanotificacion;
        this.guidmessage = guidmessage;
        this.hash = hash;
        this.id = id;
        this.nombrearchivo = nombrearchivo;
        this.tipoarchivo = tipoarchivo;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Date getFechanotificacion() {
        return fechanotificacion;
    }

    public void setFechanotificacion(Date fechanotificacion) {
        this.fechanotificacion = fechanotificacion;
    }

    public String getGuidmessage() {
        return guidmessage;
    }

    public void setGuidmessage(String guidmessage) {
        this.guidmessage = guidmessage;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public String getTipoarchivo() {
        return tipoarchivo;
    }

    public void setTipoarchivo(String tipoarchivo) {
        this.tipoarchivo = tipoarchivo;
    }
}
