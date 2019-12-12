package core.rsolano.liqinterface.model.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
{ 
@NamedQuery(name = "AppContingenciaLiq.findAll", query = "select o from AppContingenciaLiq o"),
@NamedQuery(name = "AppContingenciaLiq.findMaxId", query = "select o from AppContingenciaLiq o order by o.id DESC") 
  }
)
@Table(name = "APP_CONTINGENCIA_LIQ")
public class AppContingenciaLiq implements Serializable {
    private static final long serialVersionUID = -6071697754131557138L;
    @Id
    private Integer id;
    @Column(nullable = true)
    private String aplicacion;
    @Column(nullable = true)
    private String nombre_Archivo;
    @Column(nullable = false)
    private String fecha;
    @Column(nullable = false, length = 1)
    private Long flag_Masivo;
    @Column(nullable = false, length = 1)
    private Long estado;
    @Column(nullable = true, length = 200)
    private String nombre_archivo_2;
    @Column(nullable = true, length = 200)
    private String nombre_archivo_principal;
    
    public AppContingenciaLiq() {
    }
    
    public AppContingenciaLiq(int id,String aplicacion, String nombreArchivo, String fecha, Long estado, String nombre_archivo_2,String nombre_archivo_principal, Long flagMasivo ) {
        this.id=id;
        this.aplicacion=aplicacion;
        this.nombre_Archivo=nombreArchivo;
        this.fecha=fecha;
        this.estado=estado;
        this.nombre_archivo_2= nombre_archivo_2;
        this.nombre_archivo_principal=nombre_archivo_principal;
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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }


    public void setFlag_Masivo(Long flag_Masivo) {
        this.flag_Masivo = flag_Masivo;
    }

    public Long getFlag_Masivo() {
        return flag_Masivo;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Long getEstado() {
        return estado;
    }

    public void setNombre_archivo_2(String nombre_archivo_2) {
        this.nombre_archivo_2 = nombre_archivo_2;
    }

    public String getNombre_archivo_2() {
        return nombre_archivo_2;
    }

    public void setNombre_archivo_principal(String nombre_archivo_principal) {
        this.nombre_archivo_principal = nombre_archivo_principal;
    }

    public String getNombre_archivo_principal() {
        return nombre_archivo_principal;
    }
}
