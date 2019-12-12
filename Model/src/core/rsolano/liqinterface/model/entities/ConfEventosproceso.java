package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "ConfEventosproceso.findAll", query = "select o from ConfEventosproceso o"),
                @NamedQuery(name = "ConfEventosproceso.findByIdProceso", query = "select o from ConfEventosproceso o where o.nombremetodo = 'sendNotification' and o.notifProceso1.id = :idProceso")})
@Table(name = "CONF_EVENTOSPROCESO")
public class ConfEventosproceso implements Serializable {
    private static final long serialVersionUID = 712253736010552672L;
    @Column(length = 200)
    private String descripcion;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    @Column(length = 100)
    private String nombrclase;
    @Column(length = 100)
    private String nombremetodo;
    @Column(length = 50)
    private String tablafuente;
    @OneToMany(mappedBy = "confEventosproceso", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfFuenteinsumofile> confFuenteinsumofileList;
    @ManyToOne
    @JoinColumn(name = "IDPROCESO")
    private NotifProceso notifProceso1;
    @OneToMany(mappedBy = "confEventosproceso1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ConfFuenteinsumostructure> confFuenteinsumostructureList;
    @ManyToOne
    @JoinColumn(name = "IDEVENTO")
    private AppEventos appEventos;
    
    public ConfEventosproceso() {
    }

    public ConfEventosproceso(String descripcion, String id, AppEventos appEventos, NotifProceso notifProceso1,
                              String nombrclase, String nombremetodo, String tablafuente) {
        this.descripcion = descripcion;
        this.id = id;
        this.appEventos = appEventos;
        this.notifProceso1 = notifProceso1;
        this.nombrclase = nombrclase;
        this.nombremetodo = nombremetodo;
        this.tablafuente = tablafuente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNombrclase() {
        return nombrclase;
    }

    public void setNombrclase(String nombrclase) {
        this.nombrclase = nombrclase;
    }

    public String getNombremetodo() {
        return nombremetodo;
    }

    public void setNombremetodo(String nombremetodo) {
        this.nombremetodo = nombremetodo;
    }

    public String getTablafuente() {
        return tablafuente;
    }

    public void setTablafuente(String tablafuente) {
        this.tablafuente = tablafuente;
    }

    public List<ConfFuenteinsumofile> getConfFuenteinsumofileList() {
        return confFuenteinsumofileList;
    }

    public void setConfFuenteinsumofileList(List<ConfFuenteinsumofile> confFuenteinsumofileList) {
        this.confFuenteinsumofileList = confFuenteinsumofileList;
    }

    public ConfFuenteinsumofile addConfFuenteinsumofile(ConfFuenteinsumofile confFuenteinsumofile) {
        getConfFuenteinsumofileList().add(confFuenteinsumofile);
        confFuenteinsumofile.setConfEventosproceso(this);
        return confFuenteinsumofile;
    }

    public ConfFuenteinsumofile removeConfFuenteinsumofile(ConfFuenteinsumofile confFuenteinsumofile) {
        getConfFuenteinsumofileList().remove(confFuenteinsumofile);
        confFuenteinsumofile.setConfEventosproceso(null);
        return confFuenteinsumofile;
    }

    public NotifProceso getNotifProceso1() {
        return notifProceso1;
    }

    public void setNotifProceso1(NotifProceso notifProceso1) {
        this.notifProceso1 = notifProceso1;
    }

    public List<ConfFuenteinsumostructure> getConfFuenteinsumostructureList() {
        return confFuenteinsumostructureList;
    }

    public void setConfFuenteinsumostructureList(List<ConfFuenteinsumostructure> confFuenteinsumostructureList) {
        this.confFuenteinsumostructureList = confFuenteinsumostructureList;
    }

    public ConfFuenteinsumostructure addConfFuenteinsumostructure(ConfFuenteinsumostructure confFuenteinsumostructure) {
        getConfFuenteinsumostructureList().add(confFuenteinsumostructure);
        confFuenteinsumostructure.setConfEventosproceso1(this);
        return confFuenteinsumostructure;
    }

    public ConfFuenteinsumostructure removeConfFuenteinsumostructure(ConfFuenteinsumostructure confFuenteinsumostructure) {
        getConfFuenteinsumostructureList().remove(confFuenteinsumostructure);
        confFuenteinsumostructure.setConfEventosproceso1(null);
        return confFuenteinsumostructure;
    }

    public AppEventos getAppEventos() {
        return appEventos;
    }

    public void setAppEventos(AppEventos appEventos) {
        this.appEventos = appEventos;
    }
}
