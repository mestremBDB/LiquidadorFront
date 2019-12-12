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

@Entity
@NamedQueries({ @NamedQuery(name = "ConfReceptorescorreos.findAll", query = "select o from ConfReceptorescorreos o") })
@Table(name = "CONF_RECEPTORESCORREOS")
public class ConfReceptorescorreos implements Serializable {
    private static final long serialVersionUID = 4212036209737791168L;
    @Id
    @Column(nullable = false, length = 45)
    private String id;
    @ManyToOne
    @JoinColumn(name = "IDAPLICACION")
    private AppAplicaciones appAplicaciones2;
    @ManyToOne
    @JoinColumn(name = "IDGRUPOCORREO")
    private ConfGruposcorreo confGruposcorreo;
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private ConfUsuarios confUsuarios;

    public ConfReceptorescorreos() {
    }

    public ConfReceptorescorreos(String id, AppAplicaciones appAplicaciones2, ConfGruposcorreo confGruposcorreo,
                                 ConfUsuarios confUsuarios) {
        this.id = id;
        this.appAplicaciones2 = appAplicaciones2;
        this.confGruposcorreo = confGruposcorreo;
        this.confUsuarios = confUsuarios;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public ConfGruposcorreo getConfGruposcorreo() {
        return confGruposcorreo;
    }

    public void setConfGruposcorreo(ConfGruposcorreo confGruposcorreo) {
        this.confGruposcorreo = confGruposcorreo;
    }

    public ConfUsuarios getConfUsuarios() {
        return confUsuarios;
    }

    public void setConfUsuarios(ConfUsuarios confUsuarios) {
        this.confUsuarios = confUsuarios;
    }

    public AppAplicaciones getAppAplicaciones2() {
        return appAplicaciones2;
    }

    public void setAppAplicaciones2(AppAplicaciones appAplicaciones2) {
        this.appAplicaciones2 = appAplicaciones2;
    }
    
    public String getAplicacion() {
        return this.getAppAplicaciones2().getId();
    }
    
    public String getCorreo() {
        return this.getConfUsuarios().getCorreo();
    }
    
    public Integer getEstado() {
        return this.getConfUsuarios().getEstado();
    }

    public Date getFechacreacion() {
        return this.getConfUsuarios().getFechacreacion();
    }

    public String getIdentificacion() {
        return this.getConfUsuarios().getIdentificacion();
    }

    public String getLogin() {
        return this.getConfUsuarios().getLogin();
    }

    public String getNombre() {
        return this.getConfUsuarios().getNombre();
    }
    
    public String getDescripcion() {
        return this.getConfGruposcorreo().getDescripcion();
    }

    public String getGrupo() {
        return this.getConfGruposcorreo().getNombre();
    }
}
