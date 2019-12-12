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
@NamedQueries({ @NamedQuery(name = "NotifActividades.findAll", query = "select o from NotifActividades o") })
@Table(name = "NOTIF_ACTIVIDADES")
public class NotifActividades implements Serializable {
    private static final long serialVersionUID = -6571475021200188410L;
    private String descripcion;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @Column(nullable = false, length = 100)
    private String nombreactividad;
    @OneToMany(mappedBy = "notifActividades", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<NotifActividadProceso> notifActividadProcesoList;

    public NotifActividades() {
    }

    public NotifActividades(String descripcion, String id, String nombreactividad) {
        this.descripcion = descripcion;
        this.id = id;
        this.nombreactividad = nombreactividad;
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

    public String getNombreactividad() {
        return nombreactividad;
    }

    public void setNombreactividad(String nombreactividad) {
        this.nombreactividad = nombreactividad;
    }

    public List<NotifActividadProceso> getNotifActividadProcesoList() {
        return notifActividadProcesoList;
    }

    public void setNotifActividadProcesoList(List<NotifActividadProceso> notifActividadProcesoList) {
        this.notifActividadProcesoList = notifActividadProcesoList;
    }

    public NotifActividadProceso addNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        getNotifActividadProcesoList().add(notifActividadProceso);
        notifActividadProceso.setNotifActividades(this);
        return notifActividadProceso;
    }

    public NotifActividadProceso removeNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        getNotifActividadProcesoList().remove(notifActividadProceso);
        notifActividadProceso.setNotifActividades(null);
        return notifActividadProceso;
    }
}
