package core.rsolano.liqinterface.model.entities;

import java.math.BigDecimal;
import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "LiqTRE.findAll", query = "select o from LiqTRE o") })
@Table(name = "LIQ_TRE")
@IdClass(LiqTREPK.class)
public class LiqTRE implements Serializable{
    private static final long serialVersionUID = -5008849855672798938L;
    @Column(length = 7)
    private String canttarjetas;
    @Column(length = 5)
    private String ceoi;
    @Column(length = 10)
    private String codigounidad;
    @Column(length = 200)
    private String descripcionestado;
    @Column(name = "DET_CANTTARJETAS", length = 100)
    private String detCanttarjetas;
    @Id
    @Column(nullable = false)
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
    @Column(length = 10)
    private String fuente;
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
    @Column(length = 38)
    private String rquid;
    @Column(length = 4)
    private String tipoident;
    @Column(length = 10)
    private String tipoprod;
    private Integer tipotarjeta;
    private double valcobro;
    private double valesperado;
    private double valreal;

    public LiqTRE() {
    }

    public LiqTRE(String canttarjetas, String ceoi, String codigounidad, String descripcionestado,
                  String detCanttarjetas, BigDecimal estadotransaccion, Date fechacargar, Date fechadestanquear,
                  Date fechaexportar, Date fechaprocesar, Date fechareciprocidad, Date fechaverificar,
                  String flagdestanquear, String flagexportar, String flagprocesar, String flagreciprocidad,
                  String flagverificar, String fuente, String idliq, String insumoliq, String nomempresa,
                  String numident, String numprod, String periodo, String rquid, String tipoident, String tipoprod,
                  Integer tipotarjeta, double valcobro, double valesperado, double valreal) {
        this.canttarjetas = canttarjetas;
        this.ceoi = ceoi;
        this.codigounidad = codigounidad;
        this.descripcionestado = descripcionestado;
        this.detCanttarjetas = detCanttarjetas;
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
        this.fuente = fuente;
        this.idliq = idliq;
        this.insumoliq = insumoliq;
        this.nomempresa = nomempresa;
        this.numident = numident;
        this.numprod = numprod;
        this.periodo = periodo;
        this.rquid = rquid;
        this.tipoident = tipoident;
        this.tipoprod = tipoprod;
        this.tipotarjeta = tipotarjeta;
        this.valcobro = valcobro;
        this.valesperado = valesperado;
        this.valreal = valreal;
    }

    public String getCanttarjetas() {
        return canttarjetas;
    }

    public void setCanttarjetas(String canttarjetas) {
        this.canttarjetas = canttarjetas;
    }

    public String getCeoi() {
        return ceoi;
    }

    public void setCeoi(String ceoi) {
        this.ceoi = ceoi;
    }

    public String getCodigounidad() {
        return codigounidad;
    }

    public void setCodigounidad(String codigounidad) {
        this.codigounidad = codigounidad;
    }

    public String getDescripcionestado() {
        return descripcionestado;
    }

    public void setDescripcionestado(String descripcionestado) {
        this.descripcionestado = descripcionestado;
    }

    public String getDetCanttarjetas() {
        return detCanttarjetas;
    }

    public void setDetCanttarjetas(String detCanttarjetas) {
        this.detCanttarjetas = detCanttarjetas;
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

    public String getFuente() {
        return fuente;
    }

    public void setFuente(String fuente) {
        this.fuente = fuente;
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

    public String getRquid() {
        return rquid;
    }

    public void setRquid(String rquid) {
        this.rquid = rquid;
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

    public Integer getTipotarjeta() {
        return tipotarjeta;
    }

    public void setTipotarjeta(Integer tipotarjeta) {
        this.tipotarjeta = tipotarjeta;
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
