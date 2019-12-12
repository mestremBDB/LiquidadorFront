package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "LiqCorporate.findAll", query = "select o from LiqCorporate o") })
@Table(name = "LIQ_CORPORATE")
public class LiqCorporate implements Serializable {
    private static final long serialVersionUID = -3687789419710873191L;
    private Long adicionales;
    @Column(length = 50)
    private String cargo;
    @Column(length = 5)
    private String ceoi;
    private Long descargas;
    @Column(length = 200)
    private String descripcionestado;
    @Column(name = "DET_ADICIONALES", length = 100)
    private String detAdicionales;
    @Column(name = "DET_CARGO", length = 100)
    private String detCargo;
    @Column(name = "DET_DESCARGAS", length = 100)
    private String detDescargas;
    private BigDecimal estadotransaccion;
    @Temporal(TemporalType.DATE)
    private Date fechacargar;
    @Temporal(TemporalType.DATE)
    private Date fechadestanquear;
    @Temporal(TemporalType.DATE)
    private Date fechaexportar;
    @Temporal(TemporalType.DATE)
    private Date fechaprocesar;
    @Temporal(TemporalType.DATE)
    private Date fechareciprocidad;
    @Temporal(TemporalType.DATE)
    private Date fechaverificar;
    private String flagdestanquear;
    private String flagexportar;
    private String flagprocesar;
    private String flagreciprocidad;
    private String flagverificar;
    @Column(length = 38)
    private String id;
    @Id
    @Column(nullable = false, length = 38)
    private String idliq;
    @Column(length = 38)
    private String insumoliq;
    @Column(length = 100)
    private String nomempresa;
    @Column(length = 12)
    private String numident;
    @Column(length = 15)
    private String numprod;
    @Column(length = 7)
    private String periodo;
    @Column(length = 4)
    private String tipoident;
    @Column(length = 10)
    private String tipoprod;
    private double valcobro;
    private double valesperado;
    private double valreal;

    public LiqCorporate() {
    }

    public LiqCorporate(Long adicionales, String cargo, String ceoi, Long descargas, String descripcionestado,
                        String detAdicionales, String detCargo, String detDescargas, BigDecimal estadotransaccion,
                        Date fechacargar, Date fechadestanquear, Date fechaexportar, Date fechaprocesar,
                        Date fechareciprocidad, Date fechaverificar, String flagdestanquear, String flagexportar,
                        String flagprocesar, String flagreciprocidad, String flagverificar, String id, String idliq,
                        String insumoliq, String nomempresa, String numident, String numprod, String periodo,
                        String tipoident, String tipoprod, double valcobro, double valesperado, double valreal) {
        this.adicionales = adicionales;
        this.cargo = cargo;
        this.ceoi = ceoi;
        this.descargas = descargas;
        this.descripcionestado = descripcionestado;
        this.detAdicionales = detAdicionales;
        this.detCargo = detCargo;
        this.detDescargas = detDescargas;
        this.estadotransaccion = estadotransaccion;
        this.fechacargar = fechacargar;
        this.fechadestanquear = fechadestanquear;
        this.fechaexportar = fechaexportar;
        this.fechaprocesar = fechaprocesar;
        this.fechareciprocidad = fechareciprocidad;
        this.fechaverificar = fechaverificar;
        this.flagdestanquear = flagdestanquear;
        this.flagexportar = flagexportar;
        this.flagprocesar = flagprocesar;
        this.flagreciprocidad = flagreciprocidad;
        this.flagverificar = flagverificar;
        this.id = id;
        this.idliq = idliq;
        this.insumoliq = insumoliq;
        this.nomempresa = nomempresa;
        this.numident = numident;
        this.numprod = numprod;
        this.periodo = periodo;
        this.tipoident = tipoident;
        this.tipoprod = tipoprod;
        this.valcobro = valcobro;
        this.valesperado = valesperado;
        this.valreal = valreal;
    }

    public Long getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(Long adicionales) {
        this.adicionales = adicionales;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCeoi() {
        return ceoi;
    }

    public void setCeoi(String ceoi) {
        this.ceoi = ceoi;
    }

    public Long getDescargas() {
        return descargas;
    }

    public void setDescargas(Long descargas) {
        this.descargas = descargas;
    }

    public String getDescripcionestado() {
        return descripcionestado;
    }

    public void setDescripcionestado(String descripcionestado) {
        this.descripcionestado = descripcionestado;
    }

    public String getDetAdicionales() {
        return detAdicionales;
    }

    public void setDetAdicionales(String detAdicionales) {
        this.detAdicionales = detAdicionales;
    }

    public String getDetCargo() {
        return detCargo;
    }

    public void setDetCargo(String detCargo) {
        this.detCargo = detCargo;
    }

    public String getDetDescargas() {
        return detDescargas;
    }

    public void setDetDescargas(String detDescargas) {
        this.detDescargas = detDescargas;
    }

    public BigDecimal getEstadotransaccion() {
        return estadotransaccion;
    }

    public void setEstadotransaccion(BigDecimal estadotransaccion) {
        this.estadotransaccion = estadotransaccion;
    }

    public Date getFechacargar() {
        return fechacargar;
    }

    public void setFechacargar(Date fechacargar) {
        this.fechacargar = fechacargar;
    }

    public Date getFechadestanquear() {
        return fechadestanquear;
    }

    public void setFechadestanquear(Date fechadestanquear) {
        this.fechadestanquear = fechadestanquear;
    }

    public Date getFechaexportar() {
        return fechaexportar;
    }

    public void setFechaexportar(Date fechaexportar) {
        this.fechaexportar = fechaexportar;
    }

    public Date getFechaprocesar() {
        return fechaprocesar;
    }

    public void setFechaprocesar(Date fechaprocesar) {
        this.fechaprocesar = fechaprocesar;
    }

    public Date getFechareciprocidad() {
        return fechareciprocidad;
    }

    public void setFechareciprocidad(Date fechareciprocidad) {
        this.fechareciprocidad = fechareciprocidad;
    }

    public Date getFechaverificar() {
        return fechaverificar;
    }

    public void setFechaverificar(Date fechaverificar) {
        this.fechaverificar = fechaverificar;
    }

    public String getFlagdestanquear() {
        return flagdestanquear;
    }

    public void setFlagdestanquear(String flagdestanquear) {
        this.flagdestanquear = flagdestanquear;
    }

    public String getFlagexportar() {
        return flagexportar;
    }

    public void setFlagexportar(String flagexportar) {
        this.flagexportar = flagexportar;
    }

    public String getFlagprocesar() {
        return flagprocesar;
    }

    public void setFlagprocesar(String flagprocesar) {
        this.flagprocesar = flagprocesar;
    }

    public String getFlagreciprocidad() {
        return flagreciprocidad;
    }

    public void setFlagreciprocidad(String flagreciprocidad) {
        this.flagreciprocidad = flagreciprocidad;
    }

    public String getFlagverificar() {
        return flagverificar;
    }

    public void setFlagverificar(String flagverificar) {
        this.flagverificar = flagverificar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdliq() {
        return idliq;
    }

    public void setIdliq(String idliq) {
        this.idliq = idliq;
    }

    public String getInsumoliq() {
        return insumoliq;
    }

    public void setInsumoliq(String insumoliq) {
        this.insumoliq = insumoliq;
    }

    public String getNomempresa() {
        return nomempresa;
    }

    public void setNomempresa(String nomempresa) {
        this.nomempresa = nomempresa;
    }

    public String getNumident() {
        return numident;
    }

    public void setNumident(String numident) {
        this.numident = numident;
    }

    public String getNumprod() {
        return numprod;
    }

    public void setNumprod(String numprod) {
        this.numprod = numprod;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTipoident() {
        return tipoident;
    }

    public void setTipoident(String tipoident) {
        this.tipoident = tipoident;
    }

    public String getTipoprod() {
        return tipoprod;
    }

    public void setTipoprod(String tipoprod) {
        this.tipoprod = tipoprod;
    }

    public double getValcobro() {
        return valcobro;
    }

    public void setValcobro(double valcobro) {
        this.valcobro = valcobro;
    }

    public double getValesperado() {
        return valesperado;
    }

    public void setValesperado(double valesperado) {
        this.valesperado = valesperado;
    }

    public double getValreal() {
        return valreal;
    }

    public void setValreal(double valreal) {
        this.valreal = valreal;
    }
}
