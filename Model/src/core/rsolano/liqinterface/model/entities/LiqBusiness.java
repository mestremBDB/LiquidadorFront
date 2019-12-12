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
@NamedQueries({ @NamedQuery(name = "LiqBusiness.findAll", query = "select o from LiqBusiness o") })
@Table(name = "LIQ_BUSINESS")
public class LiqBusiness implements Serializable {
    private static final long serialVersionUID = -1756887678850533081L;
    @Column(length = 6)
    private String cantidadtransacciones;
    @Column(length = 5)
    private String ceoi;
    private double costoplan;
    private double costotransaccionadicional;
    @Column(length = 200)
    private String descripcionestado;
    @Column(name = "DET_PLANES", length = 100)
    private String detPlanes;
    @Column(name = "DET_TRANSACCIONESADICIONALES", length = 100)
    private String detTransaccionesadicionales;
    private BigDecimal estadotransaccion;
    @Column(length = 20)
    private String fechaactivacionempresa;
    @Temporal(TemporalType.DATE)
    private Date fechacargar;
    @Temporal(TemporalType.DATE)
    private Date fechadestanquear;
    @Temporal(TemporalType.DATE)
    private Date fechaexportar;
    @Column(length = 10)
    private String fechafacturacion;
    @Column(length = 10)
    private String fechafacturacion2;
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
    @Column(length = 30)
    private String gerente;
    @Column(unique = true, length = 10)
    private String idinterno;
    @Id
    @Column(nullable = false, length = 38)
    private String idliq;
    @Column(unique = true, length = 38)
    private String insumoliq;
    @Column(length = 10)
    private String nit;
    @Column(length = 100)
    private String nomempresa;
    @Column(unique = true, length = 12)
    private String numident;
    @Column(length = 15)
    private String numprod;
    @Column(length = 20)
    private String paquete;
    @Column(length = 7)
    private String periodo;
    @Column(length = 3)
    private String planes;
    @Column(length = 40)
    private String region;
    @Column(length = 30)
    private String segmento;
    @Column(unique = true, length = 4)
    private String tipoident;
    @Column(length = 10)
    private String tipoprod;
    @Column(length = 6)
    private String transaccionesadicionales;
    private double valcobro;
    private double valesperado;
    private double valreal;

    public LiqBusiness() {
    }

    public LiqBusiness(String cantidadtransacciones, String ceoi, double costoplan, double costotransaccionadicional,
                       String descripcionestado, String detPlanes, String detTransaccionesadicionales,
                       BigDecimal estadotransaccion, String fechaactivacionempresa, Date fechacargar,
                       Date fechadestanquear, Date fechaexportar, String fechafacturacion, String fechafacturacion2,
                       Date fechaprocesar, Date fechareciprocidad, Date fechaverificar, String flagdestanquear,
                       String flagexportar, String flagprocesar, String flagreciprocidad, String flagverificar,
                       String gerente, String idinterno, String idliq, String insumoliq, String nit, String nomempresa,
                       String numident, String numprod, String paquete, String periodo, String planes, String region,
                       String segmento, String tipoident, String tipoprod, String transaccionesadicionales,
                       double valcobro, double valesperado, double valreal) {
        this.cantidadtransacciones = cantidadtransacciones;
        this.ceoi = ceoi;
        this.costoplan = costoplan;
        this.costotransaccionadicional = costotransaccionadicional;
        this.descripcionestado = descripcionestado;
        this.detPlanes = detPlanes;
        this.detTransaccionesadicionales = detTransaccionesadicionales;
        this.estadotransaccion = estadotransaccion;
        this.fechaactivacionempresa = fechaactivacionempresa;
        this.fechacargar = fechacargar;
        this.fechadestanquear = fechadestanquear;
        this.fechaexportar = fechaexportar;
        this.fechafacturacion = fechafacturacion;
        this.fechafacturacion2 = fechafacturacion2;
        this.fechaprocesar = fechaprocesar;
        this.fechareciprocidad = fechareciprocidad;
        this.fechaverificar = fechaverificar;
        this.flagdestanquear = flagdestanquear;
        this.flagexportar = flagexportar;
        this.flagprocesar = flagprocesar;
        this.flagreciprocidad = flagreciprocidad;
        this.flagverificar = flagverificar;
        this.gerente = gerente;
        this.idinterno = idinterno;
        this.idliq = idliq;
        this.insumoliq = insumoliq;
        this.nit = nit;
        this.nomempresa = nomempresa;
        this.numident = numident;
        this.numprod = numprod;
        this.paquete = paquete;
        this.periodo = periodo;
        this.planes = planes;
        this.region = region;
        this.segmento = segmento;
        this.tipoident = tipoident;
        this.tipoprod = tipoprod;
        this.transaccionesadicionales = transaccionesadicionales;
        this.valcobro = valcobro;
        this.valesperado = valesperado;
        this.valreal = valreal;
    }

    public String getCantidadtransacciones() {
        return cantidadtransacciones;
    }

    public void setCantidadtransacciones(String cantidadtransacciones) {
        this.cantidadtransacciones = cantidadtransacciones;
    }

    public String getCeoi() {
        return ceoi;
    }

    public void setCeoi(String ceoi) {
        this.ceoi = ceoi;
    }

    public double getCostoplan() {
        return costoplan;
    }

    public void setCostoplan(double costoplan) {
        this.costoplan = costoplan;
    }

    public double getCostotransaccionadicional() {
        return costotransaccionadicional;
    }

    public void setCostotransaccionadicional(double costotransaccionadicional) {
        this.costotransaccionadicional = costotransaccionadicional;
    }

    public String getDescripcionestado() {
        return descripcionestado;
    }

    public void setDescripcionestado(String descripcionestado) {
        this.descripcionestado = descripcionestado;
    }

    public String getDetPlanes() {
        return detPlanes;
    }

    public void setDetPlanes(String detPlanes) {
        this.detPlanes = detPlanes;
    }

    public String getDetTransaccionesadicionales() {
        return detTransaccionesadicionales;
    }

    public void setDetTransaccionesadicionales(String detTransaccionesadicionales) {
        this.detTransaccionesadicionales = detTransaccionesadicionales;
    }

    public BigDecimal getEstadotransaccion() {
        return estadotransaccion;
    }

    public void setEstadotransaccion(BigDecimal estadotransaccion) {
        this.estadotransaccion = estadotransaccion;
    }

    public String getFechaactivacionempresa() {
        return fechaactivacionempresa;
    }

    public void setFechaactivacionempresa(String fechaactivacionempresa) {
        this.fechaactivacionempresa = fechaactivacionempresa;
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

    public String getFechafacturacion() {
        return fechafacturacion;
    }

    public void setFechafacturacion(String fechafacturacion) {
        this.fechafacturacion = fechafacturacion;
    }

    public String getFechafacturacion2() {
        return fechafacturacion2;
    }

    public void setFechafacturacion2(String fechafacturacion2) {
        this.fechafacturacion2 = fechafacturacion2;
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

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getIdinterno() {
        return idinterno;
    }

    public void setIdinterno(String idinterno) {
        this.idinterno = idinterno;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPlanes() {
        return planes;
    }

    public void setPlanes(String planes) {
        this.planes = planes;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
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

    public String getTransaccionesadicionales() {
        return transaccionesadicionales;
    }

    public void setTransaccionesadicionales(String transaccionesadicionales) {
        this.transaccionesadicionales = transaccionesadicionales;
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
