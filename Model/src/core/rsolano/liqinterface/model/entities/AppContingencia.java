package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
{ 
@NamedQuery(name = "AppContingencia.findAll", query = "select o from AppContingencia o"),
@NamedQuery(name = "AppContingencia.findMaxId", query = "select o from AppContingencia o order by o.id DESC") 
  }
)
@Table(name = "APP_CONTINGENCIA")
public class AppContingencia implements Serializable {
    private static final long serialVersionUID = -6071697754131557138L;
    @Id
    private Integer id;
    @Column(nullable = false)
    private String aplicacion;
    @Column(nullable = false)
    private String nombre_Archivo;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private String origen;
    @Column(nullable = false)
    private String destino;
    @Column(nullable = false)
    private String servidor_Origen;
    @Column(nullable = false, length = 4)
    private String puerto_Origen;
    @Column(nullable = false)
    private String servidor_Destino;
    @Column(nullable = false , length = 4)
    private String puerto_Destino;
    @Column(nullable = true, length = 1)
    private char flag_Masivo;

    public AppContingencia() {
    }
    
    public AppContingencia(Integer id, String aplicacion, String nombreArchivo, Date fecha, String origen, String destino, String servidorOrigen, String puertoOrigen, String servidorDestino, String puertoDestino, char flagMasivo ) {
        this.id=id;
        this.aplicacion=aplicacion;
        this.nombre_Archivo=nombreArchivo;
        this.fecha=fecha;
        this.origen= origen;
        this.destino=destino;
        this.puerto_Origen=puertoOrigen;
        this.puerto_Destino=puertoDestino;
        this.servidor_Origen=servidorOrigen;
        this.servidor_Destino=servidorDestino;
        this.flag_Masivo=flagMasivo;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setNombre_Archivo(String nombre_Archivo) {
        this.nombre_Archivo = nombre_Archivo;
    }

    public String getNombre_Archivo() {
        return nombre_Archivo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setServidor_Origen(String servidor_Origen) {
        this.servidor_Origen = servidor_Origen;
    }

    public String getServidor_Origen() {
        return servidor_Origen;
    }

    public void setPuerto_Origen(String puerto_Origen) {
        this.puerto_Origen = puerto_Origen;
    }

    public String getPuerto_Origen() {
        return puerto_Origen;
    }

    public void setServidor_Destino(String servidor_Destino) {
        this.servidor_Destino = servidor_Destino;
    }

    public String getServidor_Destino() {
        return servidor_Destino;
    }

    public void setPuerto_Destino(String puerto_Destino) {
        this.puerto_Destino = puerto_Destino;
    }

    public String getPuerto_Destino() {
        return puerto_Destino;
    }

    public void setFlag_Masivo(char flag_Masivo) {
        this.flag_Masivo = flag_Masivo;
    }

    public char getFlag_Masivo() {
        return flag_Masivo;
    }
}
