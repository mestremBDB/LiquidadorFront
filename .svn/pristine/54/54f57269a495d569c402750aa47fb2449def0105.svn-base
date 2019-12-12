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
@NamedQueries({ @NamedQuery(name = "LogRegistroserrados.findAll", query = "select o from LogRegistroserrados o") })
@Table(name = "LOG_REGISTROSERRADOS")
public class LogRegistroserrados implements Serializable {
    private static final long serialVersionUID = 968060013554698086L;
    @Column(length = 100)
    private String componente;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    @Column(length = 3000)
    private String linea;
    @Column(length = 3000)
    private String message;
    private BigDecimal registro;
    @ManyToOne
    @JoinColumn(name = "IDHISTACTIVIDAD")
    private HistActividadesProcesos histActividadesProcesos;

    public LogRegistroserrados() {
    }

    public LogRegistroserrados(String componente, Date fecha, String id,
                               HistActividadesProcesos histActividadesProcesos, String linea, String message,
                               BigDecimal registro) {
        this.componente = componente;
        this.fecha = fecha;
        this.id = id;
        this.histActividadesProcesos = histActividadesProcesos;
        this.linea = linea;
        this.message = message;
        this.registro = registro;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getRegistro() {
        return registro;
    }

    public void setRegistro(BigDecimal registro) {
        this.registro = registro;
    }

    public HistActividadesProcesos getHistActividadesProcesos() {
        return histActividadesProcesos;
    }

    public void setHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        this.histActividadesProcesos = histActividadesProcesos;
    }
    
    public String getHistActividadesProcesosEstado() {
        return this.getHistActividadesProcesos().getProcesosEstado();
    }

    public Date getHistActividadesProcesosFechafin() {
        return this.getHistActividadesProcesos().getFechafin();
    }

    public Date getHistActividadesProcesosFechainicio() {
        return this.getHistActividadesProcesos().getFechainicio();
    }

    public Date getHistActividadesProcesosFechanotificacion() {
        return this.getHistActividadesProcesos().getFechanotificacion();
    }

    public String getHistActividadesProcesosId() {
        return this.getHistActividadesProcesos().getId();
    }

    public Long getHistActividadesProcesosRegistroserrados() {
        return this.getHistActividadesProcesos().getRegistroserrados();
    }

    public Long getHistActividadesProcesosRegistrosprocesados() {
        return this.getHistActividadesProcesos().getRegistrosprocesados();
    }

    public Long getHistActividadesProcesosRegistrostotales() {
        return this.getHistActividadesProcesos().getRegistrostotales();
    }
}
