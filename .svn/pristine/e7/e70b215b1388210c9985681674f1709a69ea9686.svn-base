package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

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
@NamedQueries({ 
@NamedQuery(name = "AppArchivos.findAll", query = "select o from AppArchivos o"),
@NamedQuery(name = "AppArchivos.findByIndex", query = "select o from AppArchivos o order by o.fecha asc") 
})
@Table(name = "APP_ARCHIVOS")
public class AppArchivos implements Serializable {
    private static final long serialVersionUID = 5819667564773465506L;
   
    @Column(length = 40)
    private String aplicacion;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @Column(nullable = false, length = 50)
    private String nombre;

    public AppArchivos() {
    }

    public AppArchivos(String aplicacion, Date fecha, String id, String nombre) {
        this.aplicacion = aplicacion;
        this.fecha = fecha;
        this.id = id;
        this.nombre = nombre;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
