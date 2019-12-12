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
@NamedQueries({
              @NamedQuery(name = "HistActividadesProcesos.findAll",  query = "select o from HistActividadesProcesos o") })
@Table(name = "HIST_ACTIVIDADES_PROCESOS")
public class HistActividadesProcesos implements Serializable {
    private static final long serialVersionUID = -6968531344593529434L;
    @Column(length = 10)
    private String estado;
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Temporal(TemporalType.DATE)
    private Date fechanotificacion;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    private Long registroserrados;
    private Long registrosprocesados;
    private Long registrostotales;
    @ManyToOne
    @JoinColumn(name = "IDACTIVIDADPROCESO")
    private NotifActividadProceso notifActividadProceso;
    @OneToMany(mappedBy = "histActividadesProcesos", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<LogRegistroserrados> logRegistroserradosList;
    @ManyToOne
    @JoinColumn(name = "IDHISTPROCESOS")
    private HistProcesos histProcesos;

    public HistActividadesProcesos() {
    }

    public HistActividadesProcesos(String estado, Date fechafin, Date fechainicio, Date fechanotificacion, String id,
                                   NotifActividadProceso notifActividadProceso, HistProcesos histProcesos,
                                   Long registroserrados, Long registrosprocesados, Long registrostotales) {
        this.estado = estado;
        this.fechafin = fechafin;
        this.fechainicio = fechainicio;
        this.fechanotificacion = fechanotificacion;
        this.id = id;
        this.notifActividadProceso = notifActividadProceso;
        this.histProcesos = histProcesos;
        this.registroserrados = registroserrados;
        this.registrosprocesados = registrosprocesados;
        this.registrostotales = registrostotales;
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

    public Date getFechanotificacion() {
        return fechanotificacion;
    }

    public void setFechanotificacion(Date fechanotificacion) {
        this.fechanotificacion = fechanotificacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Long getRegistroserrados() {
        return registroserrados;
    }

    public void setRegistroserrados(Long registroserrados) {
        this.registroserrados = registroserrados;
    }

    public Long getRegistrosprocesados() {
        return registrosprocesados;
    }

    public void setRegistrosprocesados(Long registrosprocesados) {
        this.registrosprocesados = registrosprocesados;
    }

    public Long getRegistrostotales() {
        return registrostotales;
    }

    public void setRegistrostotales(Long registrostotales) {
        this.registrostotales = registrostotales;
    }

    public NotifActividadProceso getNotifActividadProceso() {
        return notifActividadProceso;
    }

    public void setNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        this.notifActividadProceso = notifActividadProceso;
    }

    public List<LogRegistroserrados> getLogRegistroserradosList() {
        return logRegistroserradosList;
    }

    public void setLogRegistroserradosList(List<LogRegistroserrados> logRegistroserradosList) {
        this.logRegistroserradosList = logRegistroserradosList;
    }

    public LogRegistroserrados addLogRegistroserrados(LogRegistroserrados logRegistroserrados) {
        getLogRegistroserradosList().add(logRegistroserrados);
        logRegistroserrados.setHistActividadesProcesos(this);
        return logRegistroserrados;
    }

    public LogRegistroserrados removeLogRegistroserrados(LogRegistroserrados logRegistroserrados) {
        getLogRegistroserradosList().remove(logRegistroserrados);
        logRegistroserrados.setHistActividadesProcesos(null);
        return logRegistroserrados;
    }

    public HistProcesos getHistProcesos() {
        return histProcesos;
    }

    public void setHistProcesos(HistProcesos histProcesos) {
        this.histProcesos = histProcesos;
    }

    public String getProcesosId(){
        return this.getHistProcesos().getId();
    }
    public String getProcesosEstado(){
        return this.getHistProcesos().getEstado();
    }
    public Date getProcesosFechaInicio(){
        return this.getHistProcesos().getFechainicio();
    }
    public Date getProcesosFechaFin(){
        return this.getHistProcesos().getFechafin();
    }
    
    public String getActividadId(){
        return this.getNotifActividadProceso().getId();
    }
    public String getActividadNombre(){
        return this.getNotifActividadProceso().getNombreactividad();
    }
    public String getActividadOrden(){
        return this.getNotifActividadProceso().getOrden();
    }
    public String getActividadDescripcion(){
        return this.getNotifActividadProceso().getDescripcionActividad();
    }
    public String getProcesoNombre(){
        return this.getNotifActividadProceso().getNombreproceso();
    }
    public String getProcesoDescripcion(){
        return this.getNotifActividadProceso().getDescripcionProceso();
    }
}
