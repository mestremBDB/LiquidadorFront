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
@NamedQueries({
    @NamedQuery(name = "AppAplicaciones.findAll", query = "select o from AppAplicaciones o"),
    @NamedQuery(name = "AppAplicaciones.findById", query = "select o from AppAplicaciones o where o.id = :custId"),
    @NamedQuery(name = "AppAplicaciones.findByProceso", query = "select o from AppAplicaciones o where o.nombre = :proceso")
    })
@Table(name = "APP_APLICACIONES")
public class AppAplicaciones implements Serializable {
    private static final long serialVersionUID = 6710723705501166146L;
    
    @Column(nullable = false, length = 10)
    private String abreviatura;
    @Column(length = 5)
    private String canal;
    @Column(length = 200)
    private String descripcion;
    @Column(length = 200)
    private String ftpescritura;
    @Column(length = 200)
    private String ftpslectura;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @Column(nullable = false, length = 80)
    private String nombre;
    @OneToMany(mappedBy = "appAplicaciones", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<NotifProceso> notifProcesoList;
    @OneToMany(mappedBy = "appAplicaciones1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfHerramientasapps> confHerramientasappsList1;
    @OneToMany(mappedBy = "appAplicaciones2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfReceptorescorreos> confReceptorescorreosList2;
    
    public AppAplicaciones() {
    }

    public AppAplicaciones(String abreviatura, String descripcion, String ftpescritura, String ftpslectura, String id, String nombre, String canal) {
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
        this.ftpescritura = ftpescritura;
        this.ftpslectura = ftpslectura;
        this.id = id;
        this.nombre = nombre;
        this.canal = canal;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFtpescritura() {
        return ftpescritura;
    }

    public void setFtpescritura(String ftpescritura) {
        this.ftpescritura = ftpescritura;
    }

    public String getFtpslectura() {
        return ftpslectura;
    }

    public void setFtpslectura(String ftpslectura) {
        this.ftpslectura = ftpslectura;
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

    public List<NotifProceso> getNotifProcesoList() {
        return notifProcesoList;
    }

    public void setNotifProcesoList(List<NotifProceso> notifProcesoList) {
        this.notifProcesoList = notifProcesoList;
    }

    public NotifProceso addNotifProceso(NotifProceso notifProceso) {
        getNotifProcesoList().add(notifProceso);
        notifProceso.setAppAplicaciones(this);
        return notifProceso;
    }

    public NotifProceso removeNotifProceso(NotifProceso notifProceso) {
        getNotifProcesoList().remove(notifProceso);
        notifProceso.setAppAplicaciones(null);
        return notifProceso;
    }

    public List<ConfHerramientasapps> getConfHerramientasappsList1() {
        return confHerramientasappsList1;
    }

    public void setConfHerramientasappsList1(List<ConfHerramientasapps> confHerramientasappsList1) {
        this.confHerramientasappsList1 = confHerramientasappsList1;
    }

    public ConfHerramientasapps addConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        getConfHerramientasappsList1().add(confHerramientasapps);
        confHerramientasapps.setAppAplicaciones1(this);
        return confHerramientasapps;
    }

    public ConfHerramientasapps removeConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        getConfHerramientasappsList1().remove(confHerramientasapps);
        confHerramientasapps.setAppAplicaciones1(null);
        return confHerramientasapps;
    }

    public List<ConfReceptorescorreos> getConfReceptorescorreosList2() {
        return confReceptorescorreosList2;
    }

    public void setConfReceptorescorreosList2(List<ConfReceptorescorreos> confReceptorescorreosList2) {
        this.confReceptorescorreosList2 = confReceptorescorreosList2;
    }

    public ConfReceptorescorreos addConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        getConfReceptorescorreosList2().add(confReceptorescorreos);
        confReceptorescorreos.setAppAplicaciones2(this);
        return confReceptorescorreos;
    }

    public ConfReceptorescorreos removeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        getConfReceptorescorreosList2().remove(confReceptorescorreos);
        confReceptorescorreos.setAppAplicaciones2(null);
        return confReceptorescorreos;
    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("abreviatura=");
        buffer.append(getAbreviatura());
        buffer.append(',');
        buffer.append("descripcion=");
        buffer.append(getDescripcion());
        buffer.append(',');
        buffer.append("ftpescritura=");
        buffer.append(getFtpescritura());
        buffer.append(',');
        buffer.append("ftpslectura=");
        buffer.append(getFtpslectura());
        buffer.append(',');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("nombre=");
        buffer.append(getNombre());
        buffer.append(',');
        buffer.append("canal=");
        buffer.append(getCanal());
        buffer.append(']');
        return buffer.toString();
    }
}
