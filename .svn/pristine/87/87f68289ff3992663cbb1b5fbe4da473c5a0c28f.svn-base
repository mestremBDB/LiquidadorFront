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

@Entity
@NamedQueries({ @NamedQuery(name = "ConfFuenteinsumofile.findAll", query = "select o from ConfFuenteinsumofile o") })
@Table(name = "CONF_FUENTEINSUMOFILE")
public class ConfFuenteinsumofile implements Serializable {
    private static final long serialVersionUID = 3297381618931712752L;
    @Column(length = 50)
    private String entidadtabla;
    @Column(length = 50)
    private String esquemadestanqueo;
    @Column(length = 10)
    private String extension;
    @Column(length = 10)
    private String extensionauxiliar;
    @Column(length = 10)
    private String extensionexterna;
    private String flagcarpeta;
    @Column(length = 40)
    private String formatofecha;
    @Column(length = 40)
    private String formatofechacarpeta;
    private String hashfile;
    @Id
    @Column(nullable = false, length = 38)
    private String id;
    @Column(length = 60)
    private String nombrearchivo;
    @Column(length = 60)
    private String nombreauxiliar;
    @Column(length = 200)
    private String rutaraiz;
    private String sep;
    @Column(length = 1)
    private String separador;
    @Column(length = 50)
    private String tabla;
    private String todasextsinput;
    @ManyToOne
    @JoinColumn(name = "IDEVENTOPROCESO")
    private ConfEventosproceso confEventosproceso;

    public ConfFuenteinsumofile() {
    }

    public ConfFuenteinsumofile(String entidadtabla, String esquemadestanqueo, String extension,
                                String extensionauxiliar, String extensionexterna, String flagcarpeta,
                                String formatofecha, String formatofechacarpeta, String hashfile, String id,
                                ConfEventosproceso confEventosproceso, String nombrearchivo, String nombreauxiliar,
                                String rutaraiz, String sep, String separador, String tabla, String todasextsinput) {
        this.entidadtabla = entidadtabla;
        this.esquemadestanqueo = esquemadestanqueo;
        this.extension = extension;
        this.extensionauxiliar = extensionauxiliar;
        this.extensionexterna = extensionexterna;
        this.flagcarpeta = flagcarpeta;
        this.formatofecha = formatofecha;
        this.formatofechacarpeta = formatofechacarpeta;
        this.hashfile = hashfile;
        this.id = id;
        this.confEventosproceso = confEventosproceso;
        this.nombrearchivo = nombrearchivo;
        this.nombreauxiliar = nombreauxiliar;
        this.rutaraiz = rutaraiz;
        this.sep = sep;
        this.separador = separador;
        this.tabla = tabla;
        this.todasextsinput = todasextsinput;
    }

    public String getEntidadtabla() {
        return entidadtabla;
    }

    public void setEntidadtabla(String entidadtabla) {
        this.entidadtabla = entidadtabla;
    }

    public String getEsquemadestanqueo() {
        return esquemadestanqueo;
    }

    public void setEsquemadestanqueo(String esquemadestanqueo) {
        this.esquemadestanqueo = esquemadestanqueo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtensionauxiliar() {
        return extensionauxiliar;
    }

    public void setExtensionauxiliar(String extensionauxiliar) {
        this.extensionauxiliar = extensionauxiliar;
    }

    public String getExtensionexterna() {
        return extensionexterna;
    }

    public void setExtensionexterna(String extensionexterna) {
        this.extensionexterna = extensionexterna;
    }

    public String getFlagcarpeta() {
        return flagcarpeta;
    }

    public void setFlagcarpeta(String flagcarpeta) {
        this.flagcarpeta = flagcarpeta;
    }

    public String getFormatofecha() {
        return formatofecha;
    }

    public void setFormatofecha(String formatofecha) {
        this.formatofecha = formatofecha;
    }

    public String getFormatofechacarpeta() {
        return formatofechacarpeta;
    }

    public void setFormatofechacarpeta(String formatofechacarpeta) {
        this.formatofechacarpeta = formatofechacarpeta;
    }

    public String getHashfile() {
        return hashfile;
    }

    public void setHashfile(String hashfile) {
        this.hashfile = hashfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public String getNombreauxiliar() {
        return nombreauxiliar;
    }

    public void setNombreauxiliar(String nombreauxiliar) {
        this.nombreauxiliar = nombreauxiliar;
    }

    public String getRutaraiz() {
        return rutaraiz;
    }

    public void setRutaraiz(String rutaraiz) {
        this.rutaraiz = rutaraiz;
    }

    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getTodasextsinput() {
        return todasextsinput;
    }

    public void setTodasextsinput(String todasextsinput) {
        this.todasextsinput = todasextsinput;
    }

    public ConfEventosproceso getConfEventosproceso() {
        return confEventosproceso;
    }

    public void setConfEventosproceso(ConfEventosproceso confEventosproceso) {
        this.confEventosproceso = confEventosproceso;
    }
}
