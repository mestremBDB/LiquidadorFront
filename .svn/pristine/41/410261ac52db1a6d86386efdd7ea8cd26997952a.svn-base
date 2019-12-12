package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQueries
({ 
    @NamedQuery(name = "ConfCryptofirmas.findAll", query = "select o from ConfCryptofirmas o"), 
    @NamedQuery(name = "ConfCryptofirmas.findByNhost", query = "select o from ConfCryptofirmas o where o.nhost =:varNhost"), 
    @NamedQuery(name = "ConfCryptofirmas.findByAliasPUB", query =  "select o from ConfCryptofirmas o where o.aliaspub =:varAliaspub and o.nhost =:varNhost ")
})
@Table(name = "CONF_CRYPTOFIRMAS")
public class ConfCryptofirmas implements Serializable {
    
    private static final long serialVersionUID = -5484489863105492905L;
    
    @Id
    @Column(nullable = false, length = 36)
    @GeneratedValue(generator = "KeySign", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="KeySign", sequenceName = "SIGN_SEQ", allocationSize = 1)
    private String id;
    
    @Column(name = "NOMBREPUB", nullable = false)
    private String nombrepub;

    @Column(name = "ALIASPUB", nullable = false)
    private String aliaspub;
    
    @Column(name = "APLICACION", nullable = false, length = 25)
    private String aplicacion;
    
    @Column(name = "NHOST", nullable = true)
    private String nhost;
    
    public ConfCryptofirmas() {
    }

    public ConfCryptofirmas(String nombrepub, String aliaspub, String aplicacion, String nhost) {
        //this.id = UUID.randomUUID().toString();
        this.nombrepub = nombrepub;
        this.aliaspub = aliaspub;
        this.aplicacion = aplicacion;
        this.nhost = nhost;
        
    }

    public String getAliaspub() {
        return aliaspub;
    }

    public void setAliaspub(String aliaspub) {
        this.aliaspub = aliaspub;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
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

    public String getNombrepub() {
        return nombrepub;
    }

    public void setNombrepub(String nombrepub) {
        this.nombrepub = nombrepub;
    }
}
