package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "LiqPse.findAll", query = "select o from LiqPse o") })
@Table(name = "LIQ_PSE")
public class LiqPse implements Serializable {
    private static final long serialVersionUID = 3509953709681584320L;
    @Column(length = 20)
    private String autorizador;
    private Long basetarifa;
    @Column(length = 5)
    private String ceoi;
    @Column(unique = true, length = 20)
    private String cus;
    @Column(length = 200)
    private String descripcionestado;
    @Column(name = "DET_RANGOMICROPAGO_E", length = 100)
    private String detRangomicropagoE;
    @Column(name = "DET_RANGOMICROPAGO_I", length = 100)
    private String detRangomicropagoI;
    @Column(name = "DET_VALORCOMPRA_E", length = 100)
    private String detValorcompraE;
    @Column(name = "DET_VALORCOMPRA_I", length = 100)
    private String detValorcompraI;
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
    @Column(name = "RANGOMICROPAGO_E")
    private Long rangomicropagoE;
    @Column(name = "RANGOMICROPAGO_I")
    private Long rangomicropagoI;
    @Column(length = 20)
    private String recaudador;
    @Column(length = 4)
    private String tipoident;
    @Column(length = 10)
    private String tipoprod;
    @Column(length = 10)
    private String tipotarifa;
    private double valcobro;
    private double valesperado;
    @Column(name = "VALORCOMPRA_E")
    private Long valorcompraE;
    @Column(name = "VALORCOMPRA_I")
    private Long valorcompraI;
    private Long valortransaccion;
    private double valreal;
    @Column(name = "CLIENTEPOPE")
    private Long clientepope;
    

    public LiqPse() {
    }

    public LiqPse(String autorizador, Long basetarifa, String ceoi, String cus, String descripcionestado,
                  String detRangomicropagoE, String detRangomicropagoI, String detValorcompraE, String detValorcompraI,
                  BigDecimal estadotransaccion, Date fechacargar, Date fechadestanquear, Date fechaexportar,
                  Date fechaprocesar, Date fechareciprocidad, Date fechaverificar, String flagdestanquear,
                  String flagexportar, String flagprocesar, String flagreciprocidad, String flagverificar, String idliq,
                  String insumoliq, String nomempresa, String numident, String numprod, String periodo,
                  Long rangomicropagoE, Long rangomicropagoI, String recaudador, String tipoident, String tipoprod,
                  String tipotarifa, double valcobro, double valesperado, Long valorcompraE, Long valorcompraI,
                  Long valortransaccion, double valreal, Long clientepope) {
        this.autorizador = autorizador;
        this.basetarifa = basetarifa;
        this.ceoi = ceoi;
        this.cus = cus;
        this.descripcionestado = descripcionestado;
        this.detRangomicropagoE = detRangomicropagoE;
        this.detRangomicropagoI = detRangomicropagoI;
        this.detValorcompraE = detValorcompraE;
        this.detValorcompraI = detValorcompraI;
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
        this.idliq = idliq;
        this.insumoliq = insumoliq;
        this.nomempresa = nomempresa;
        this.numident = numident;
        this.numprod = numprod;
        this.periodo = periodo;
        this.rangomicropagoE = rangomicropagoE;
        this.rangomicropagoI = rangomicropagoI;
        this.recaudador = recaudador;
        this.tipoident = tipoident;
        this.tipoprod = tipoprod;
        this.tipotarifa = tipotarifa;
        this.valcobro = valcobro;
        this.valesperado = valesperado;
        this.valorcompraE = valorcompraE;
        this.valorcompraI = valorcompraI;
        this.valortransaccion = valortransaccion;
        this.valreal = valreal;
        this.clientepope = clientepope;
    }

    public String getAutorizador() {
        return autorizador;
    }

    public void setAutorizador(String autorizador) {
        this.autorizador = autorizador;
    }

    public Long getBasetarifa() {
        return basetarifa;
    }

    public void setBasetarifa(Long basetarifa) {
        this.basetarifa = basetarifa;
    }

    public String getCeoi() {
        return ceoi;
    }

    public void setCeoi(String ceoi) {
        this.ceoi = ceoi;
    }

    public String getCus() {
        return cus;
    }

    public void setCus(String cus) {
        this.cus = cus;
    }

    public String getDescripcionestado() {
        return descripcionestado;
    }

    public void setDescripcionestado(String descripcionestado) {
        this.descripcionestado = descripcionestado;
    }

    public String getDetRangomicropagoE() {
        return detRangomicropagoE;
    }

    public void setDetRangomicropagoE(String detRangomicropagoE) {
        this.detRangomicropagoE = detRangomicropagoE;
    }

    public String getDetRangomicropagoI() {
        return detRangomicropagoI;
    }

    public void setDetRangomicropagoI(String detRangomicropagoI) {
        this.detRangomicropagoI = detRangomicropagoI;
    }

    public String getDetValorcompraE() {
        return detValorcompraE;
    }

    public void setDetValorcompraE(String detValorcompraE) {
        this.detValorcompraE = detValorcompraE;
    }

    public String getDetValorcompraI() {
        return detValorcompraI;
    }

    public void setDetValorcompraI(String detValorcompraI) {
        this.detValorcompraI = detValorcompraI;
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

    public Long getRangomicropagoE() {
        return rangomicropagoE;
    }

    public void setRangomicropagoE(Long rangomicropagoE) {
        this.rangomicropagoE = rangomicropagoE;
    }

    public Long getRangomicropagoI() {
        return rangomicropagoI;
    }

    public void setRangomicropagoI(Long rangomicropagoI) {
        this.rangomicropagoI = rangomicropagoI;
    }

    public String getRecaudador() {
        return recaudador;
    }

    public void setRecaudador(String recaudador) {
        this.recaudador = recaudador;
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

    public String getTipotarifa() {
        return tipotarifa;
    }

    public void setTipotarifa(String tipotarifa) {
        this.tipotarifa = tipotarifa;
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

    public Long getValorcompraE() {
        return valorcompraE;
    }

    public void setValorcompraE(Long valorcompraE) {
        this.valorcompraE = valorcompraE;
    }

    public Long getValorcompraI() {
        return valorcompraI;
    }

    public void setValorcompraI(Long valorcompraI) {
        this.valorcompraI = valorcompraI;
    }

    public Long getValortransaccion() {
        return valortransaccion;
    }

    public void setValortransaccion(Long valortransaccion) {
        this.valortransaccion = valortransaccion;
    }

    public double getValreal() {
        return valreal;
    }

    public void setValreal(double valreal) {
        this.valreal = valreal;
    }

    public void setClientepope(Long clientepope) {
        this.clientepope = clientepope;
    }

    public Long getClientepope() {
        return clientepope;
    }
}
