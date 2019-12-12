package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({ 
    @NamedQuery(name = "ConfSqlloader.findAll", query = "select o from ConfSqlloader o")
})
@Table(name = "CONF_SQLLOADER")
public class ConfSqlloader implements Serializable {
    private static final long serialVersionUID = 5425080364863025178L;
    
    @Id
    @Column(nullable = false, length = 36)
    @GeneratedValue(generator = "SqlLdr", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="SqlLdr", sequenceName = "SQLLDR_SEQ", allocationSize = 1)
    private String id;
    @Column(name = "CONTROL_ROOT", nullable = false, length = 512)
    private String controlRoot;
    @Column(name = "INFILE_ROOT", nullable = false, length = 512)
    private String infileRoot;
    @Column(name = "LOGFILE_ROOT", nullable = false, length = 512)
    private String logfileRoot;
    @Column(name = "INSTALL_ROOT", nullable = false, length = 512)
    private String installRoot;
    @Column(nullable = false)
    private String ndatabase;
    @Column(nullable = false)
    private String nhost;
    @Column(nullable = false, length = 512)
    private String password;
    @Column(nullable = false)
    private String username;
    
    
    public ConfSqlloader() {
    }

    public ConfSqlloader(String controlRoot, String id, String infileRoot, String logfileRoot, 
                         String installRoot, String ndatabase, String nhost, String password, String username) {
        this.controlRoot = controlRoot;
        this.id = id;
        this.infileRoot = infileRoot;
        this.logfileRoot = logfileRoot;
        this.installRoot = installRoot;
        this.ndatabase = ndatabase;
        this.nhost = nhost;
        this.password = password;
        this.username = username;
    }
    
    public void setInstallRoot(String installRoot) {
        this.installRoot = installRoot;
    }

    public String getInstallRoot() {
        return installRoot;
    }
    
    public String getControlRoot() {
        return controlRoot;
    }

    public void setControlRoot(String controlRoot) {
        this.controlRoot = controlRoot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfileRoot() {
        return infileRoot;
    }

    public void setInfileRoot(String infileRoot) {
        this.infileRoot = infileRoot;
    }

    public String getLogfileRoot() {
        return logfileRoot;
    }

    public void setLogfileRoot(String logfileRoot) {
        this.logfileRoot = logfileRoot;
    }

    public String getNdatabase() {
        return ndatabase;
    }

    public void setNdatabase(String ndatabase) {
        this.ndatabase = ndatabase;
    }

    public String getNhost() {
        return nhost;
    }

    public void setNhost(String nhost) {
        this.nhost = nhost;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
