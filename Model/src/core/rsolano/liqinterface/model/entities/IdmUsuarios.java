package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.Date;

import java.util.UUID;

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
@NamedQueries({ @NamedQuery(name = "IdmUsuarios.findAll", query = "select o from IdmUsuarios o") })
@Table(name = "IDM_USUARIOS")
public class IdmUsuarios implements Serializable {
    private static final long serialVersionUID = 3958422165504333317L;
    @Column(nullable = false, length = 50)
    private String cn;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false, length = 200)
    private String grupo;
    @Id
    @Column(nullable = false, length = 100)
    private String id;
    @Column(nullable = false, length = 50)
    private String inhabilitado;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String nt;
    
    public IdmUsuarios() {
    }


    //    public IdmUsuarios(String cn, Date fecha, String grupo, String id, IdmGrupos idmGrupos, String inhabilitado,String nombre, String nt) {
    
    public IdmUsuarios(String cn, String grupo, String inhabilitado, String nombre, String nt) {
        this.cn = cn;
        this.fecha = new java.sql.Date((new Date()).getTime());
        this.grupo = grupo;
        this.id = UUID.randomUUID().toString();
        this.inhabilitado = inhabilitado;
        this.nombre = nombre;
        this.nt = nt;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getInhabilitado() {
        return inhabilitado;
    }

    public void setInhabilitado(String inhabilitado) {
        this.inhabilitado = inhabilitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

}
