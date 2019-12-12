package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries
({ 
    @NamedQuery(name = "ConfCryptoalmacen.findAll", query = "select o from ConfCryptoalmacen o"),
    @NamedQuery(name = "ConfCryptoalmacen.findByNhost", query =  "select o from ConfCryptoalmacen o where o.nhost =:varNhost")
})
@Table(name = "CONF_CRYPTOALMACEN")
public class ConfCryptoalmacen implements Serializable {
    
    private static final long serialVersionUID = 4633742388296536346L;
    @Id
    @Column(nullable = false, length = 36)
    @GeneratedValue(generator = "KeyStore", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="KeyStore", sequenceName = "STORE_SEQ", allocationSize = 1)
    private String id;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "NHOST", nullable = false)
    private String nhost;
    
    @Column(name = "RUTA", nullable = false, length = 512)
    private String ruta;

    @Column(name = "ACTIVO", nullable = false, length = 25)
    private String activo;
    
    @Column(name = "APLICACION", nullable = false, length = 25)
    private String aplicacion;

    public ConfCryptoalmacen() {
    }

    public ConfCryptoalmacen(String nombre, String nhost, String ruta, String activo, String aplicacion) {
        //this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.nhost = nhost;
        this.ruta = ruta;        
        this.activo = activo;
        this.aplicacion = aplicacion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }
}
