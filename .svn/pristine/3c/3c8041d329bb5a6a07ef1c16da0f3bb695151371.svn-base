package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "TempRespuestahost.findAll", query = "select o from TempRespuestahost o") })
@Table(name = "TEMP_RESPUESTAHOST")
@IdClass(TempRespuestahostPK.class)
public class TempRespuestahost implements Serializable {
    private static final long serialVersionUID = 4693843430896899568L;
    @Column(length = 50)
    private String descripcionestado;
    @Column(length = 1)
    private String estadotrasaccion;
    @Id
    @Column(nullable = false, length = 6)
    private String fecha;
    @Id
    @Column(nullable = false, length = 11)
    private String numident;
    @Id
    @Column(nullable = false, length = 17)
    private String numprod;
    @Id
    @Column(nullable = false, length = 1)
    private String tipoident;
    @Id
    @Column(nullable = false, length = 1)
    private String tipoprod;
    @Id
    @Column(nullable = false, length = 15)
    private String valor;

    public TempRespuestahost() {
    }

    public TempRespuestahost(String descripcionestado, String estadotrasaccion, String fecha, String numident,
                             String numprod, String tipoident, String tipoprod, String valor) {
        this.descripcionestado = descripcionestado;
        this.estadotrasaccion = estadotrasaccion;
        this.fecha = fecha;
        this.numident = numident;
        this.numprod = numprod;
        this.tipoident = tipoident;
        this.tipoprod = tipoprod;
        this.valor = valor;
    }

    public String getDescripcionestado() {
        return descripcionestado;
    }

    public void setDescripcionestado(String descripcionestado) {
        this.descripcionestado = descripcionestado;
    }

    public String getEstadotrasaccion() {
        return estadotrasaccion;
    }

    public void setEstadotrasaccion(String estadotrasaccion) {
        this.estadotrasaccion = estadotrasaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
