package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ConfHerramientasapps.findAll", query = "select o from ConfHerramientasapps o") })
@Table(name = "CONF_HERRAMIENTASAPPS")
public class ConfHerramientasapps implements Serializable {
    private static final long serialVersionUID = 2724482112482422876L;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    private Long orden;
    private Long validacionproceso;
    private Long validacionws;
    @Column(length = 10)
    private String valor;
    @ManyToOne
    @JoinColumn(name = "IDHERRAMIENTA", referencedColumnName="ID")
    private AppHerramientas appHerramientas;
    @ManyToOne
    @JoinColumn(name = "IDAPP", referencedColumnName="ID")
    private AppAplicaciones appAplicaciones1;

    public ConfHerramientasapps() {
    }

    public ConfHerramientasapps(String id, AppAplicaciones appAplicaciones1, AppHerramientas appHerramientas,
                                Long orden, Long validacionproceso, Long validacionws, String valor) {
        this.id = id;
        this.appAplicaciones1 = appAplicaciones1;
        this.appHerramientas = appHerramientas;
        this.orden = orden;
        this.validacionproceso = validacionproceso;
        this.validacionws = validacionws;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public Long getValidacionproceso() {
        return validacionproceso;
    }

    public void setValidacionproceso(Long validacionproceso) {
        this.validacionproceso = validacionproceso;
    }

    public Long getValidacionws() {
        return validacionws;
    }

    public void setValidacionws(Long validacionws) {
        this.validacionws = validacionws;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public AppHerramientas getAppHerramientas() {
        return appHerramientas;
    }

    public void setAppHerramientas(AppHerramientas appHerramientas) {
        this.appHerramientas = appHerramientas;
    }

    public AppAplicaciones getAppAplicaciones1() {
        return appAplicaciones1;
    }

    public void setAppAplicaciones1(AppAplicaciones appAplicaciones1) {
        this.appAplicaciones1 = appAplicaciones1;
    }

    //APLICACIONES
    public String getAplicacionesDescripcion() {
        return this.getAppAplicaciones1().getDescripcion();
    }

    public String getAplicacionesId() {
        return this.getAppAplicaciones1().getId();
    }

    public String getAplicacionesAbreviatura() {
        return this.getAppAplicaciones1().getAbreviatura();
    }

    public String getAplicacionesNombre() {
        return this.getAppAplicaciones1().getNombre();
    }
    
    public String getAplicacionesCanal() {
        return this.getAppAplicaciones1().getCanal();
    }
    
    public String getAplicacionesFtpslectura() {
        return this.getAppAplicaciones1().getFtpslectura();
    }
    
    public String getAplicacionesFtpescritura() {
        return this.getAppAplicaciones1().getFtpescritura();
    }
    
    //HERRAMIENTAS
    public String getHerramientasId() {
        return this.getAppHerramientas().getId();
    }
    
    public String getHerramientasDescripcion() {
        return this.getAppHerramientas().getDescripcion();
    }
    
    public String getHerramientasMetodo() {
        return this.getAppHerramientas().getMetodo();
    }
    
    public String getHerramientasNombre(){
        return this.getAppHerramientas().getNombre();
    }
}
