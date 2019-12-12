package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "AppCamposprocesoliq.findAll", query = "select o from AppCamposprocesoliq o") })
@Table(name = "APP_CAMPOSPROCESOLIQ")
public class AppCamposprocesoliq implements Serializable {
    private static final long serialVersionUID = -3569878854841157687L;
    private Long alineacion;
    private Long automatico;
    @Column(length = 2)
    private String caracterrelleno;
    @Column(nullable = false)
    private Long cobrado;
    @Column(length = 2)
    private String decimales;
    @Column(length = 50)
    private String dependencia;
    private String dependiente;
    @Column(nullable = false, length = 50)
    private String enviar;
    @Column(nullable = false)
    private Long exportar;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false)
    private Long orden;
    @Column(nullable = false)
    private Long partefija;
    @Column(nullable = false)
    private String relleno;
    @Column(nullable = false)
    private Long tamanio;
    private String texto;
    private Long validacion;
    @ManyToOne
    @JoinColumn(name = "IDPROCESO")
    private NotifProceso notifProceso2;


    public AppCamposprocesoliq() {
    }

    public AppCamposprocesoliq(Long alineacion, Long automatico, String caracterrelleno, Long cobrado, String decimales,
                               String dependencia, String dependiente, String enviar, Long exportar, String id,
                               NotifProceso notifProceso2, String nombre, Long orden, Long partefija, String relleno,
                               Long tamanio, String texto, Long validacion) {
        this.alineacion = alineacion;
        this.automatico = automatico;
        this.caracterrelleno = caracterrelleno;
        this.cobrado = cobrado;
        this.decimales = decimales;
        this.dependencia = dependencia;
        this.dependiente = dependiente;
        this.enviar = enviar;
        this.exportar = exportar;
        this.id = id;
        this.notifProceso2 = notifProceso2;
        this.nombre = nombre;
        this.orden = orden;
        this.partefija = partefija;
        this.relleno = relleno;
        this.tamanio = tamanio;
        this.texto = texto;
        this.validacion = validacion;
    }

    public Long getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(Long alineacion) {
        this.alineacion = alineacion;
    }

    public Long getAutomatico() {
        return automatico;
    }

    public void setAutomatico(Long automatico) {
        this.automatico = automatico;
    }

    public String getCaracterrelleno() {
        return caracterrelleno;
    }

    public void setCaracterrelleno(String caracterrelleno) {
        this.caracterrelleno = caracterrelleno;
    }

    public Long getCobrado() {
        return cobrado;
    }

    public void setCobrado(Long cobrado) {
        this.cobrado = cobrado;
    }

    public String getDecimales() {
        return decimales;
    }

    public void setDecimales(String decimales) {
        this.decimales = decimales;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getDependiente() {
        return dependiente;
    }

    public void setDependiente(String dependiente) {
        this.dependiente = dependiente;
    }

    public String getEnviar() {
        return enviar;
    }

    public void setEnviar(String enviar) {
        this.enviar = enviar;
    }

    public Long getExportar() {
        return exportar;
    }

    public void setExportar(Long exportar) {
        this.exportar = exportar;
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

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }

    public Long getPartefija() {
        return partefija;
    }

    public void setPartefija(Long partefija) {
        this.partefija = partefija;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public Long getTamanio() {
        return tamanio;
    }

    public void setTamanio(Long tamanio) {
        this.tamanio = tamanio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getValidacion() {
        return validacion;
    }

    public void setValidacion(Long validacion) {
        this.validacion = validacion;
    }

    public NotifProceso getNotifProceso2() {
        return notifProceso2;
    }

    public void setNotifProceso2(NotifProceso notifProceso2) {
        this.notifProceso2 = notifProceso2;
    }
    
    public String getNotifProcesoId(){
        return this.getNotifProceso2().getId();
    }
    
    public String getNotifProcesoNombreproceso(){
        return this.getNotifProceso2().getNombreproceso();
    }
}
