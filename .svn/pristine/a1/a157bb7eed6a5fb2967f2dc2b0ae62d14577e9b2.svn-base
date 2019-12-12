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

@Entity
@NamedQueries({ @NamedQuery(name = "HistProcesos.findAll", query = "select o from HistProcesos o") })
@Table(name = "HIST_PROCESOS")
public class HistProcesos implements Serializable {
    private static final long serialVersionUID = 5164139522642063984L;
    @Column(length = 10)
    private String estado;
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @ManyToOne
    @JoinColumn(name = "IDPROCESO", referencedColumnName = "ID")
    private NotifProceso notifProceso4;
    @ManyToOne
    @JoinColumn(name = "IDINSUMOLIQ", referencedColumnName = "ID")
    private HistInsumoliq histInsumoliq;
    @OneToMany(mappedBy = "histProcesos", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistActividadesProcesos> histActividadesProcesosList1;

    public HistProcesos() {
    }

    public HistProcesos(String estado, Date fechafin, Date fechainicio, String id, HistInsumoliq histInsumoliq,
                        NotifProceso notifProceso4) {
        this.estado = estado;
        this.fechafin = fechafin;
        this.fechainicio = fechainicio;
        this.id = id;
        this.histInsumoliq = histInsumoliq;
        this.notifProceso4 = notifProceso4;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public NotifProceso getNotifProceso4() {
        return notifProceso4;
    }

    public void setNotifProceso4(NotifProceso notifProceso4) {
        this.notifProceso4 = notifProceso4;
    }

    public HistInsumoliq getHistInsumoliq() {
        return histInsumoliq;
    }

    public void setHistInsumoliq(HistInsumoliq histInsumoliq) {
        this.histInsumoliq = histInsumoliq;
    }

    public List<HistActividadesProcesos> getHistActividadesProcesosList1() {
        return histActividadesProcesosList1;
    }

    public void setHistActividadesProcesosList1(List<HistActividadesProcesos> histActividadesProcesosList1) {
        this.histActividadesProcesosList1 = histActividadesProcesosList1;
    }

    public HistActividadesProcesos addHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        getHistActividadesProcesosList1().add(histActividadesProcesos);
        histActividadesProcesos.setHistProcesos(this);
        return histActividadesProcesos;
    }

    public HistActividadesProcesos removeHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        getHistActividadesProcesosList1().remove(histActividadesProcesos);
        histActividadesProcesos.setHistProcesos(null);
        return histActividadesProcesos;
    }
    
    public String getNotifProcesoId(){
        return this.getNotifProceso4().getId();
    }
    
    public String getNotifProcesoNombreentidadliq(){
        return this.getNotifProceso4().getNombreentidadliq();
    }    
    
    public String getNotifProcesoCodtransaccion() {
        return this.getNotifProceso4().getCodtransaccion();
    }

    public String getNotifProcesoDescripcion() {
        return this.getNotifProceso4().getDescripcion();
    }

    public String getNotifProcesoEsquemacobro() {
        return this.getNotifProceso4().getEsquemacobro();
    }

    public String getNotifProcesoEsquemadestanqueo() {
        return this.getNotifProceso4().getEsquemadestanqueo();
    }

    public String getNotifProcesoNombreproceso() {
        return this.getNotifProceso4().getNombreproceso();
    }

    public String getNotifProcesoNombretablaliq() {
        return this.getNotifProceso4().getNombretablaliq();
    }

    public String getNotifProcesoTipoliquidacion() {
        return this.getNotifProceso4().getTipoliquidacion();
    }
    
    public String getHistInsumoliqId(){
        return this.getHistInsumoliq().getId();
    }
    
    public String getHistInsumoliqNombre(){
        return this.getHistInsumoliq().getNombre();
    }
    
    public Date getHistInsumoliqFecha(){
        return this.getHistInsumoliq().getFecha();
    }
}
