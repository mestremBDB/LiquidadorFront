package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "IdmGrupos.findAll", query = "select o from IdmGrupos o") })
@Table(name = "IDM_GRUPOS")
public class IdmGrupos implements Serializable {
    private static final long serialVersionUID = -3822404806794034983L;
    @Column(nullable = false, length = 200)
    private String grupo;
    
    //IDM_SEQ
    
    @Id
    @Column(nullable = false, length = 100)
    @GeneratedValue(generator = "Idm", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="Idm", sequenceName = "IDM_SEQ", allocationSize = 1)
    private String id;
    
    
    @Column(nullable = false, length = 2000)
    private String permisos;
    
    public IdmGrupos() {
    }

    //public IdmGrupos(String grupo, String id, String permisos)
    public IdmGrupos(String grupo, String permisos) {
        this.grupo = grupo;
        //this.id = id;
        this.permisos = permisos;
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

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }
}
