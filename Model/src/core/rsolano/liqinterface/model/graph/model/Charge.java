package core.rsolano.liqinterface.model.graph.model;

import java.math.BigDecimal;

import java.util.Date;

public class Charge {
    private String Valor;
    private Date fecha;
    private BigDecimal Exitosos;
    private BigDecimal Fallidos;
    private int totaltransacciones;
    private double totalcobro;

    public Charge(){
    }
    
    public Charge(int totaltransacciones, double totalcobro, String Valor, Date fecha, BigDecimal Exitosos, BigDecimal Fallidos ){
        this.totaltransacciones = totaltransacciones;
        this.totalcobro = totalcobro;
        this.Valor = Valor;
        this.fecha = fecha;
        this.Exitosos = Exitosos;
        this.Fallidos = Fallidos;
    }
    
    public void setTotaltransacciones(int totaltransacciones) {
        this.totaltransacciones = totaltransacciones;
    }

    public int getTotaltransacciones() {
        return totaltransacciones;
    }

    public void setTotalcobro(double totalcobro) {
        this.totalcobro = totalcobro;
    }

    public double getTotalcobro() {
        return totalcobro;
    }    
    
    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getValor() {
        return Valor;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setExitosos(BigDecimal Exitosos) {
        this.Exitosos = Exitosos;
    }

    public BigDecimal getExitosos() {
        return Exitosos;
    }

    public void setFallidos(BigDecimal Fallidos) {
        this.Fallidos = Fallidos;
    }

    public BigDecimal getFallidos() {
        return Fallidos;
    }
}
