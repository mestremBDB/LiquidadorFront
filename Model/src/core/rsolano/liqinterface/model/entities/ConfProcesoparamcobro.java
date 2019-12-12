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
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "ConfProcesoparamcobro.findAll", query = "select o from ConfProcesoparamcobro o") })
@Table(name = "CONF_PROCESOPARAMCOBRO")
public class ConfProcesoparamcobro implements Serializable {
    private static final long serialVersionUID = 1346589217036991062L;
    @Column(length = 5)
    private String aplicacionorigen;
    @Column(length = 5)
    private String cajero;
    @Column(length = 50)
    private String descripcionampliada;
    private String flagbackdate;
    @Column(length = 10)
    private String fuentetransaccion;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    private String indicadorcalculocomision;
    private String indicadorcobrogmf;
    private String indicadoriva;
    @Column(length = 2)
    private String numerocamposmonetarios;
    @Column(length = 10)
    private String recaudos;
    @Column(length = 20)
    private String secuenciacorrectora;
    @Column(length = 20)
    private String secuenciasods;
    @Column(length = 5)
    private String terminal;
    @ManyToOne
    @JoinColumn(name = "IDPROCESO")
    private NotifProceso notifProceso5;

    public ConfProcesoparamcobro() {
    }

    public ConfProcesoparamcobro(String aplicacionorigen, String cajero, String descripcionampliada,
                                 String flagbackdate, String fuentetransaccion, String id, NotifProceso notifProceso5,
                                 String indicadorcalculocomision, String indicadorcobrogmf, String indicadoriva,
                                 String numerocamposmonetarios, String recaudos, String secuenciacorrectora,
                                 String secuenciasods, String terminal) {
        this.aplicacionorigen = aplicacionorigen;
        this.cajero = cajero;
        this.descripcionampliada = descripcionampliada;
        this.flagbackdate = flagbackdate;
        this.fuentetransaccion = fuentetransaccion;
        this.id = id;
        this.notifProceso5 = notifProceso5;
        this.indicadorcalculocomision = indicadorcalculocomision;
        this.indicadorcobrogmf = indicadorcobrogmf;
        this.indicadoriva = indicadoriva;
        this.numerocamposmonetarios = numerocamposmonetarios;
        this.recaudos = recaudos;
        this.secuenciacorrectora = secuenciacorrectora;
        this.secuenciasods = secuenciasods;
        this.terminal = terminal;
    }

    public String getAplicacionorigen() {
        return aplicacionorigen;
    }

    public void setAplicacionorigen(String aplicacionorigen) {
        this.aplicacionorigen = aplicacionorigen;
    }

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getDescripcionampliada() {
        return descripcionampliada;
    }

    public void setDescripcionampliada(String descripcionampliada) {
        this.descripcionampliada = descripcionampliada;
    }

    public String getFlagbackdate() {
        return flagbackdate;
    }

    public void setFlagbackdate(String flagbackdate) {
        this.flagbackdate = flagbackdate;
    }

    public String getFuentetransaccion() {
        return fuentetransaccion;
    }

    public void setFuentetransaccion(String fuentetransaccion) {
        this.fuentetransaccion = fuentetransaccion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getIndicadorcalculocomision() {
        return indicadorcalculocomision;
    }

    public void setIndicadorcalculocomision(String indicadorcalculocomision) {
        this.indicadorcalculocomision = indicadorcalculocomision;
    }

    public String getIndicadorcobrogmf() {
        return indicadorcobrogmf;
    }

    public void setIndicadorcobrogmf(String indicadorcobrogmf) {
        this.indicadorcobrogmf = indicadorcobrogmf;
    }

    public String getIndicadoriva() {
        return indicadoriva;
    }

    public void setIndicadoriva(String indicadoriva) {
        this.indicadoriva = indicadoriva;
    }

    public String getNumerocamposmonetarios() {
        return numerocamposmonetarios;
    }

    public void setNumerocamposmonetarios(String numerocamposmonetarios) {
        this.numerocamposmonetarios = numerocamposmonetarios;
    }

    public String getRecaudos() {
        return recaudos;
    }

    public void setRecaudos(String recaudos) {
        this.recaudos = recaudos;
    }

    public String getSecuenciacorrectora() {
        return secuenciacorrectora;
    }

    public void setSecuenciacorrectora(String secuenciacorrectora) {
        this.secuenciacorrectora = secuenciacorrectora;
    }

    public String getSecuenciasods() {
        return secuenciasods;
    }

    public void setSecuenciasods(String secuenciasods) {
        this.secuenciasods = secuenciasods;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public NotifProceso getNotifProceso5() {
        return notifProceso5;
    }

    public void setNotifProceso5(NotifProceso notifProceso5) {
        this.notifProceso5 = notifProceso5;
    }
}
