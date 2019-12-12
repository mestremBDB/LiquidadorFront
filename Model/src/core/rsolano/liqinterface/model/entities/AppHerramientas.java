package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "AppHerramientas.findAll", query = "select o from AppHerramientas o") })
@Table(name = "APP_HERRAMIENTAS")
public class AppHerramientas implements Serializable {
    private static final long serialVersionUID = -2176718877254303325L;
    @Column(length = 200)
    private String descripcion;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    @Column(length = 100)
    private String metodo;
    @Column(nullable = false, length = 80)
    private String nombre;
    @OneToMany(mappedBy = "appHerramientas", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfHerramientasapps> confHerramientasappsList;

    public AppHerramientas() {
    }

    public AppHerramientas(String descripcion, String id, String metodo, String nombre) {
        this.descripcion = descripcion;
        this.id = id;
        this.metodo = metodo;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ConfHerramientasapps> getConfHerramientasappsList() {
        return confHerramientasappsList;
    }

    public void setConfHerramientasappsList(List<ConfHerramientasapps> confHerramientasappsList) {
        this.confHerramientasappsList = confHerramientasappsList;
    }

    public ConfHerramientasapps addConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        getConfHerramientasappsList().add(confHerramientasapps);
        confHerramientasapps.setAppHerramientas(this);
        return confHerramientasapps;
    }

    public ConfHerramientasapps removeConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        getConfHerramientasappsList().remove(confHerramientasapps);
        confHerramientasapps.setAppHerramientas(null);
        return confHerramientasapps;
    }
}
