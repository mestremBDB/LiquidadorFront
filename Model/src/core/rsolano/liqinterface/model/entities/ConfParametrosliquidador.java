package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries
({
    @NamedQuery(name = "ConfParametrosliquidador.findAll", query = "select o from ConfParametrosliquidador o"),
    @NamedQuery(name = "ConfParametrosliquidador.findByNombreCampo", query =  "select o from ConfParametrosliquidador o where o.nombrecampo =:varNombreCampo")
})

@Table(name = "CONF_PARAMETROSLIQUIDADOR")
public class ConfParametrosliquidador implements Serializable {
    
    private static final long serialVersionUID = 3153921320066927901L;
    
    @Id
    @Column(nullable = false, length = 45)
    private String id;
    @Column(name = "NOMBRECAMPO", nullable = true) 
    private String nombrecampo;
    @Column(name = "VALORCAMPO", nullable = true) 
    private String valorcampo;
    @Column(name = "DESCRIPCION", nullable = true)
    private String descripcion;
    @Column(name = "NOMBREGRUPO", nullable = true) 
    private String nombregrupo;
    
    public ConfParametrosliquidador() {
    }

    public ConfParametrosliquidador(String descripcion, String id, String nombrecampo, String nombregrupo,
                                    String valorcampo) {
        this.descripcion = descripcion;
        this.id = id;
        this.nombrecampo = nombrecampo;
        this.nombregrupo = nombregrupo;
        this.valorcampo = valorcampo;
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

    public String getNombrecampo() {
        return nombrecampo;
    }

    public void setNombrecampo(String nombrecampo) {
        this.nombrecampo = nombrecampo;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public String getValorcampo() {
        return valorcampo;
    }

    public void setValorcampo(String valorcampo) {
        this.valorcampo = valorcampo;
    }
}
