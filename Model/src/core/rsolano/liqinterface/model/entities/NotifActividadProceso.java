package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "NotifActividadProceso.findAll", query = "select o from NotifActividadProceso o") })
@Table(name = "NOTIF_ACTIVIDAD_PROCESO")
public class NotifActividadProceso implements Serializable {
    private static final long serialVersionUID = -6706969595276602229L;
    @Id
    @Column(nullable = false, length = 45)
    private String id;
    @Column(nullable = false, length = 10)
    private String orden;
    @OneToMany(mappedBy = "notifActividadProceso", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistActividadesProcesos> histActividadesProcesosList;
    @ManyToOne
    @JoinColumn(name = "IDACTIVIDAD", referencedColumnName="id")
    private NotifActividades notifActividades;
    @ManyToOne
    @JoinColumn(name = "IDPROCESO", referencedColumnName="id")
    private NotifProceso notifProceso;

    public NotifActividadProceso() {
    }

    public NotifActividadProceso(String id, NotifActividades notifActividades, NotifProceso notifProceso,
                                 String orden) {
        this.id = id;
        this.notifActividades = notifActividades;
        this.notifProceso = notifProceso;
        this.orden = orden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public List<HistActividadesProcesos> getHistActividadesProcesosList() {
        return histActividadesProcesosList;
    }

    public void setHistActividadesProcesosList(List<HistActividadesProcesos> histActividadesProcesosList) {
        this.histActividadesProcesosList = histActividadesProcesosList;
    }

    public HistActividadesProcesos addHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        getHistActividadesProcesosList().add(histActividadesProcesos);
        histActividadesProcesos.setNotifActividadProceso(this);
        return histActividadesProcesos;
    }

    public HistActividadesProcesos removeHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        getHistActividadesProcesosList().remove(histActividadesProcesos);
        histActividadesProcesos.setNotifActividadProceso(null);
        return histActividadesProcesos;
    }

    public NotifActividades getNotifActividades() {
        return notifActividades;
    }

    public void setNotifActividades(NotifActividades notifActividades) {
        this.notifActividades = notifActividades;
    }

    public NotifProceso getNotifProceso() {
        return notifProceso;
    }

    public void setNotifProceso(NotifProceso notifProceso) {
        this.notifProceso = notifProceso;
    }
    
    public String getNombreactividad() {
        return this.getNotifActividades().getNombreactividad();
    }
    
    public String getDescripcionActividad() {
       return this.getNotifActividades().getDescripcion();
    }
    
    public String getNombreproceso() {
        return this.getNotifProceso().getNombreproceso();
    }

    public String getDescripcionProceso() {
        return this.getNotifProceso().getDescripcion();
    }
}
