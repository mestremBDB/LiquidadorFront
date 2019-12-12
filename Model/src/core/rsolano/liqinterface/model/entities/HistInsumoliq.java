package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "HistInsumoliq.findAll", query = "select o from HistInsumoliq o") })
@Table(name = "HIST_INSUMOLIQ")
public class HistInsumoliq implements Serializable {
    private static final long serialVersionUID = 6406978431740615583L;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    @Column(length = 60)
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "IDPROCESO")
    private NotifProceso notifProceso3;
    @OneToMany(mappedBy = "histInsumoliq", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistProcesos> histProcesosList1;

    public HistInsumoliq() {
    }

    public HistInsumoliq(Date fecha, String id, NotifProceso notifProceso3, String nombre) {
        this.fecha = fecha;
        this.id = id;
        this.notifProceso3 = notifProceso3;
        this.nombre = nombre;
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

    public NotifProceso getNotifProceso3() {
        return notifProceso3;
    }

    public void setNotifProceso3(NotifProceso notifProceso3) {
        this.notifProceso3 = notifProceso3;
    }

    public List<HistProcesos> getHistProcesosList1() {
        return histProcesosList1;
    }

    public void setHistProcesosList1(List<HistProcesos> histProcesosList1) {
        this.histProcesosList1 = histProcesosList1;
    }

    public HistProcesos addHistProcesos(HistProcesos histProcesos) {
        getHistProcesosList1().add(histProcesos);
        histProcesos.setHistInsumoliq(this);
        return histProcesos;
    }

    public HistProcesos removeHistProcesos(HistProcesos histProcesos) {
        getHistProcesosList1().remove(histProcesos);
        histProcesos.setHistInsumoliq(null);
        return histProcesos;
    }
}