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
@NamedQueries(
{ @NamedQuery(name = "NotifProceso.findAll", query = "select o from NotifProceso o"),
  @NamedQuery(name = "NotifProceso.findAllContingencia", query = "select o from NotifProceso o where o.contingencia=1")
})
@Table(name = "NOTIF_PROCESO")
public class NotifProceso implements Serializable {
    private static final long serialVersionUID = -1620497464271098293L;
    @Column(length = 10)
    private String codtransaccion;
    @Column(length = 200)
    private String descripcion;
    @Column(length = 2)
    private String esquemacobro;
    @Column(length = 50)
    private String esquemadestanqueo;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @Column(length = 50)
    private String nombreentidadliq;
    @Column(nullable = false, length = 100)
    private String nombreproceso;
    @Column(length = 50)
    private String nombretablaliq;
    @Column(length = 50)
    private String nombretablareporte;
    @Column(length = 2)
    private String tipoliquidacion;
    @Column(length = 200)
    private String camposreporte;
    @Column(length = 1)
    private String contingencia;
    @Column(length = 1)
    private String masivo;
    @ManyToOne
    @JoinColumn(name = "APLICACION")
    private AppAplicaciones appAplicaciones;
    @OneToMany(mappedBy = "notifProceso", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<NotifActividadProceso> notifActividadProcesoList1;
    @OneToMany(mappedBy = "notifProceso1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfEventosproceso> confEventosprocesoList;
    @OneToMany(mappedBy = "notifProceso2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<AppCamposprocesoliq> appCamposprocesoliqList;
    @OneToMany(mappedBy = "notifProceso3", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistInsumoliq> histInsumoliqList;
    @OneToMany(mappedBy = "notifProceso4", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<HistProcesos> histProcesosList;
    @OneToMany(mappedBy = "notifProceso5", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfProcesoparamcobro> confProcesoparamcobroList;

    public NotifProceso() {
    }

    public NotifProceso(AppAplicaciones appAplicaciones, String codtransaccion, String descripcion, String esquemacobro,
                        String esquemadestanqueo, String id, String nombreentidadliq, String nombreproceso,
                        String nombretablaliq, String nombretablareporte, String tipoliquidacion, String camposreporte) {
        this.appAplicaciones = appAplicaciones;
        this.codtransaccion = codtransaccion;
        this.descripcion = descripcion;
        this.esquemacobro = esquemacobro;
        this.esquemadestanqueo = esquemadestanqueo;
        this.id = id;
        this.nombreentidadliq = nombreentidadliq;
        this.nombreproceso = nombreproceso;
        this.nombretablaliq = nombretablaliq;
        this.nombretablareporte = nombretablareporte;
        this.tipoliquidacion = tipoliquidacion;
        this.camposreporte = camposreporte;
    }

    public String getCodtransaccion() {
        return codtransaccion;
    }

    public void setCodtransaccion(String codtransaccion) {
        this.codtransaccion = codtransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEsquemacobro() {
        return esquemacobro;
    }

    public void setEsquemacobro(String esquemacobro) {
        this.esquemacobro = esquemacobro;
    }

    public String getEsquemadestanqueo() {
        return esquemadestanqueo;
    }

    public void setEsquemadestanqueo(String esquemadestanqueo) {
        this.esquemadestanqueo = esquemadestanqueo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreentidadliq() {
        return nombreentidadliq;
    }

    public void setNombreentidadliq(String nombreentidadliq) {
        this.nombreentidadliq = nombreentidadliq;
    }

    public String getNombreproceso() {
        return nombreproceso;
    }

    public void setNombreproceso(String nombreproceso) {
        this.nombreproceso = nombreproceso;
    }

    public String getNombretablaliq() {
        return nombretablaliq;
    }

    public void setNombretablaliq(String nombretablaliq) {
        this.nombretablaliq = nombretablaliq;
    }
    
    public String getNombretablareporte() {
        return nombretablareporte;
    }

    public void setNombretablareporte(String nombretablareporte) {
        this.nombretablareporte = nombretablareporte;
    }

    public String getTipoliquidacion() {
        return tipoliquidacion;
    }

    public void setTipoliquidacion(String tipoliquidacion) {
        this.tipoliquidacion = tipoliquidacion;
    }

    public AppAplicaciones getAppAplicaciones() {
        return appAplicaciones;
    }

    public void setAppAplicaciones(AppAplicaciones appAplicaciones) {
        this.appAplicaciones = appAplicaciones;
    }

    public List<NotifActividadProceso> getNotifActividadProcesoList1() {
        return notifActividadProcesoList1;
    }

    public void setNotifActividadProcesoList1(List<NotifActividadProceso> notifActividadProcesoList1) {
        this.notifActividadProcesoList1 = notifActividadProcesoList1;
    }

    public NotifActividadProceso addNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        getNotifActividadProcesoList1().add(notifActividadProceso);
        notifActividadProceso.setNotifProceso(this);
        return notifActividadProceso;
    }

    public NotifActividadProceso removeNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        getNotifActividadProcesoList1().remove(notifActividadProceso);
        notifActividadProceso.setNotifProceso(null);
        return notifActividadProceso;
    }

    public List<ConfEventosproceso> getConfEventosprocesoList() {
        return confEventosprocesoList;
    }

    public void setConfEventosprocesoList(List<ConfEventosproceso> confEventosprocesoList) {
        this.confEventosprocesoList = confEventosprocesoList;
    }

    public ConfEventosproceso addConfEventosproceso(ConfEventosproceso confEventosproceso) {
        getConfEventosprocesoList().add(confEventosproceso);
        confEventosproceso.setNotifProceso1(this);
        return confEventosproceso;
    }

    public ConfEventosproceso removeConfEventosproceso(ConfEventosproceso confEventosproceso) {
        getConfEventosprocesoList().remove(confEventosproceso);
        confEventosproceso.setNotifProceso1(null);
        return confEventosproceso;
    }

    public List<AppCamposprocesoliq> getAppCamposprocesoliqList() {
        return appCamposprocesoliqList;
    }

    public void setAppCamposprocesoliqList(List<AppCamposprocesoliq> appCamposprocesoliqList) {
        this.appCamposprocesoliqList = appCamposprocesoliqList;
    }

    public AppCamposprocesoliq addAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq) {
        getAppCamposprocesoliqList().add(appCamposprocesoliq);
        appCamposprocesoliq.setNotifProceso2(this);
        return appCamposprocesoliq;
    }

    public AppCamposprocesoliq removeAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq) {
        getAppCamposprocesoliqList().remove(appCamposprocesoliq);
        appCamposprocesoliq.setNotifProceso2(null);
        return appCamposprocesoliq;
    }

    public List<HistInsumoliq> getHistInsumoliqList() {
        return histInsumoliqList;
    }

    public void setHistInsumoliqList(List<HistInsumoliq> histInsumoliqList) {
        this.histInsumoliqList = histInsumoliqList;
    }

    public HistInsumoliq addHistInsumoliq(HistInsumoliq histInsumoliq) {
        getHistInsumoliqList().add(histInsumoliq);
        histInsumoliq.setNotifProceso3(this);
        return histInsumoliq;
    }

    public HistInsumoliq removeHistInsumoliq(HistInsumoliq histInsumoliq) {
        getHistInsumoliqList().remove(histInsumoliq);
        histInsumoliq.setNotifProceso3(null);
        return histInsumoliq;
    }

    public List<HistProcesos> getHistProcesosList() {
        return histProcesosList;
    }

    public void setHistProcesosList(List<HistProcesos> histProcesosList) {
        this.histProcesosList = histProcesosList;
    }

    public HistProcesos addHistProcesos(HistProcesos histProcesos) {
        getHistProcesosList().add(histProcesos);
        histProcesos.setNotifProceso4(this);
        return histProcesos;
    }

    public HistProcesos removeHistProcesos(HistProcesos histProcesos) {
        getHistProcesosList().remove(histProcesos);
        histProcesos.setNotifProceso4(null);
        return histProcesos;
    }

    public List<ConfProcesoparamcobro> getConfProcesoparamcobroList() {
        return confProcesoparamcobroList;
    }

    public void setConfProcesoparamcobroList(List<ConfProcesoparamcobro> confProcesoparamcobroList) {
        this.confProcesoparamcobroList = confProcesoparamcobroList;
    }

    public ConfProcesoparamcobro addConfProcesoparamcobro(ConfProcesoparamcobro confProcesoparamcobro) {
        getConfProcesoparamcobroList().add(confProcesoparamcobro);
        confProcesoparamcobro.setNotifProceso5(this);
        return confProcesoparamcobro;
    }

    public ConfProcesoparamcobro removeConfProcesoparamcobro(ConfProcesoparamcobro confProcesoparamcobro) {
        getConfProcesoparamcobroList().remove(confProcesoparamcobro);
        confProcesoparamcobro.setNotifProceso5(null);
        return confProcesoparamcobro;
    }
    
    public String getAplicacionAbreviatura() {
        return this.getAppAplicaciones().getAbreviatura();
    }

    public String getAplicacionCanal() {
        return this.getAppAplicaciones().getCanal();
    }

    public String getAplicacionDescripcion() {
        return this.getAppAplicaciones().getDescripcion();
    }

    public String getAplicacionFtpescritura() {
        return this.getAppAplicaciones().getFtpescritura();
    }

    public String getAplicacionFtpslectura() {
        return this.getAppAplicaciones().getFtpslectura();
    }

    public String getAplicacionId() {
        return this.getAppAplicaciones().getId();
    }

    public String getAplicacionNombre() {
        return this.getAppAplicaciones().getNombre();
    }

    public void setCamposreporte(String camposreporte) {
        this.camposreporte = camposreporte;
    }

    public String getCamposreporte() {
        return camposreporte;
    }

    public void setMasivo(String masivo) {
        this.masivo = masivo;
    }

    public String getMasivo() {
        return masivo;
    }

    public void setContingencia(String contingencia) {
        this.contingencia = contingencia;
    }

    public String getContingencia() {
        return contingencia;
    }
}
