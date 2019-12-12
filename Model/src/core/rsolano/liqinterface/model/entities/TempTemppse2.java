package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "TempTemppse2.findAll", query = "select o from TempTemppse2 o") })
@Table(name = "TEMP_TEMPPSE2")
public class TempTemppse2 implements Serializable {
    private static final long serialVersionUID = 6191680059981232981L;
    @Column(nullable = false, length = 500)
    private String autorizacion;
    @Column(nullable = false)
    private Long basetarifa;
    @Column(nullable = false)
    private Integer ciclo;
    @Id
    @Column(nullable = false, length = 15)
    private String cus;
    @Column(nullable = false, length = 100)
    private String empresa;
    @Column(nullable = false, length = 20)
    private String entidadautorizadora;
    @Column(nullable = false, length = 20)
    private String entidadrecaudadora;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private Long iva;
    @Column(nullable = false)
    private Long neto;
    @Column(nullable = false, length = 15)
    private String nit;
    @Column(nullable = false, length = 10)
    private String tarifaaplicada;
    @Column(nullable = false)
    private Long tarifacobradabr;
    @Column(nullable = false)
    private Long tarifacobradaefr;
    @Column(nullable = false, length = 10)
    private String tipotarifa;
    @Column(nullable = false)
    private Long valortarifa;
    @Column(nullable = false)
    private Long valortransaccion;

    public TempTemppse2() {
    }

    public TempTemppse2(String autorizacion, Long basetarifa, Integer ciclo, String cus, String empresa,
                        String entidadautorizadora, String entidadrecaudadora, Date fecha, Long iva, Long neto,
                        String nit, String tarifaaplicada, Long tarifacobradabr, Long tarifacobradaefr,
                        String tipotarifa, Long valortarifa, Long valortransaccion) {
        this.autorizacion = autorizacion;
        this.basetarifa = basetarifa;
        this.ciclo = ciclo;
        this.cus = cus;
        this.empresa = empresa;
        this.entidadautorizadora = entidadautorizadora;
        this.entidadrecaudadora = entidadrecaudadora;
        this.fecha = fecha;
        this.iva = iva;
        this.neto = neto;
        this.nit = nit;
        this.tarifaaplicada = tarifaaplicada;
        this.tarifacobradabr = tarifacobradabr;
        this.tarifacobradaefr = tarifacobradaefr;
        this.tipotarifa = tipotarifa;
        this.valortarifa = valortarifa;
        this.valortransaccion = valortransaccion;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Long getBasetarifa() {
        return basetarifa;
    }

    public void setBasetarifa(Long basetarifa) {
        this.basetarifa = basetarifa;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public String getCus() {
        return cus;
    }

    public void setCus(String cus) {
        this.cus = cus;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEntidadautorizadora() {
        return entidadautorizadora;
    }

    public void setEntidadautorizadora(String entidadautorizadora) {
        this.entidadautorizadora = entidadautorizadora;
    }

    public String getEntidadrecaudadora() {
        return entidadrecaudadora;
    }

    public void setEntidadrecaudadora(String entidadrecaudadora) {
        this.entidadrecaudadora = entidadrecaudadora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIva() {
        return iva;
    }

    public void setIva(Long iva) {
        this.iva = iva;
    }

    public Long getNeto() {
        return neto;
    }

    public void setNeto(Long neto) {
        this.neto = neto;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTarifaaplicada() {
        return tarifaaplicada;
    }

    public void setTarifaaplicada(String tarifaaplicada) {
        this.tarifaaplicada = tarifaaplicada;
    }

    public Long getTarifacobradabr() {
        return tarifacobradabr;
    }

    public void setTarifacobradabr(Long tarifacobradabr) {
        this.tarifacobradabr = tarifacobradabr;
    }

    public Long getTarifacobradaefr() {
        return tarifacobradaefr;
    }

    public void setTarifacobradaefr(Long tarifacobradaefr) {
        this.tarifacobradaefr = tarifacobradaefr;
    }

    public String getTipotarifa() {
        return tipotarifa;
    }

    public void setTipotarifa(String tipotarifa) {
        this.tipotarifa = tipotarifa;
    }

    public Long getValortarifa() {
        return valortarifa;
    }

    public void setValortarifa(Long valortarifa) {
        this.valortarifa = valortarifa;
    }

    public Long getValortransaccion() {
        return valortransaccion;
    }

    public void setValortransaccion(Long valortransaccion) {
        this.valortransaccion = valortransaccion;
    }
}
