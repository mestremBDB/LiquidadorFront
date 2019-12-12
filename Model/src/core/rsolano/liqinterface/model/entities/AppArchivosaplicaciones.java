package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
              @NamedQuery(name = "AppArchivosaplicaciones.findAll", query = "select o from AppArchivosaplicaciones o"),
              @NamedQuery(name = "AppArchivosaplicaciones.findByApp", query = "select o from AppArchivosaplicaciones o where o.aplicacion = :cus_app")})
@Table(name = "APP_ARCHIVOSAPLICACIONES")
public class AppArchivosaplicaciones implements Serializable {
    private static final long serialVersionUID = -5096376855269293703L;

    @Column(nullable = false, length = 40)
    private String aplicacion;
    @Column(length = 5)
    private String aplicacionorigen;
    @Column(length = 5)
    private String cajero;
    @Column(length = 50)
    private String descripcionampliada;
    @Column(length = 10)
    private String extension;
    @Column(length = 10)
    private String extensionauxiliar;
    @Column(length = 10)
    private String extensionexterna;
    private String flagbackdate;
    @Column(length = 100)
    private String formatofecha;
    @Column(length = 10)
    private String fuentetransaccion;
    private String hashfile;
    @Id
    @Column(nullable = false, length = 40)
    private String id;
    private String indicadorcalculocomision;
    private String indicadorcobrogmf;
    private String indicadoriva;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(length = 80)
    private String nombreauxiliar;
    @Column(length = 50)
    private String nombreentidad;
    @Column(length = 50)
    private String nombreesquemadestanqueo;
    @Column(length = 2)
    private String numerocamposmonetarios;
    @Column(length = 10)
    private String recaudos;
    @Column(length = 20)
    private String secuenciacorrectora;
    @Column(length = 20)
    private String secuenciasods;
    @Column(nullable = false)
    private String sep;
    @Column(length = 1)
    private String separador;
    @Column(nullable = false, length = 100)
    private String tabla;
    @Column(length = 100)
    private String tablaentradadatos;
    @Column(length = 100)
    private String tablakeyvalues;
    @Column(length = 100)
    private String tablalog;
    @Column(length = 100)
    private String tablatemporal;
    @Column(length = 5)
    private String terminal;
    private String todasextsinput;

    public AppArchivosaplicaciones() {
    }

    public AppArchivosaplicaciones(String aplicacion, String aplicacionorigen, String cajero,
                                   String descripcionampliada, String extension, String extensionauxiliar,
                                   String extensionexterna, String flagbackdate, String formatofecha,
                                   String fuentetransaccion, String hashfile, String id,
                                   String indicadorcalculocomision, String indicadorcobrogmf, String indicadoriva,
                                   String nombre, String nombreauxiliar, String nombreentidad,
                                   String nombreesquemadestanqueo, String numerocamposmonetarios, String recaudos,
                                   String secuenciacorrectora, String secuenciasods, String sep, String separador,
                                   String tabla, String tablaentradadatos, String tablakeyvalues, String tablalog,
                                   String tablatemporal, String terminal, String todasextsinput) {
        this.aplicacion = aplicacion;
        this.aplicacionorigen = aplicacionorigen;
        this.cajero = cajero;
        this.descripcionampliada = descripcionampliada;
        this.extension = extension;
        this.extensionauxiliar = extensionauxiliar;
        this.extensionexterna = extensionexterna;
        this.flagbackdate = flagbackdate;
        this.formatofecha = formatofecha;
        this.fuentetransaccion = fuentetransaccion;
        this.hashfile = hashfile;
        this.id = id;
        this.indicadorcalculocomision = indicadorcalculocomision;
        this.indicadorcobrogmf = indicadorcobrogmf;
        this.indicadoriva = indicadoriva;
        this.nombre = nombre;
        this.nombreauxiliar = nombreauxiliar;
        this.nombreentidad = nombreentidad;
        this.nombreesquemadestanqueo = nombreesquemadestanqueo;
        this.numerocamposmonetarios = numerocamposmonetarios;
        this.recaudos = recaudos;
        this.secuenciacorrectora = secuenciacorrectora;
        this.secuenciasods = secuenciasods;
        this.sep = sep;
        this.separador = separador;
        this.tabla = tabla;
        this.tablaentradadatos = tablaentradadatos;
        this.tablakeyvalues = tablakeyvalues;
        this.tablalog = tablalog;
        this.tablatemporal = tablatemporal;
        this.terminal = terminal;
        this.todasextsinput = todasextsinput;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
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

    public String getFlagbackdate() {
        return flagbackdate;
    }

    public void setFlagbackdate(String flagbackdate) {
        this.flagbackdate = flagbackdate;
    }

    public String getFormatofecha() {
        return formatofecha;
    }

    public void setFormatofecha(String formatofecha) {
        this.formatofecha = formatofecha;
    }

    public String getFuentetransaccion() {
        return fuentetransaccion;
    }

    public void setFuentetransaccion(String fuentetransaccion) {
        this.fuentetransaccion = fuentetransaccion;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreauxiliar() {
        return nombreauxiliar;
    }

    public void setNombreauxiliar(String nombreauxiliar) {
        this.nombreauxiliar = nombreauxiliar;
    }

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    public String getNombreesquemadestanqueo() {
        return nombreesquemadestanqueo;
    }

    public void setNombreesquemadestanqueo(String nombreesquemadestanqueo) {
        this.nombreesquemadestanqueo = nombreesquemadestanqueo;
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

    public String getTablaentradadatos() {
        return tablaentradadatos;
    }

    public void setTablaentradadatos(String tablaentradadatos) {
        this.tablaentradadatos = tablaentradadatos;
    }

    public String getTablakeyvalues() {
        return tablakeyvalues;
    }

    public void setTablakeyvalues(String tablakeyvalues) {
        this.tablakeyvalues = tablakeyvalues;
    }

    public String getTablalog() {
        return tablalog;
    }

    public void setTablalog(String tablalog) {
        this.tablalog = tablalog;
    }

    public String getTablatemporal() {
        return tablatemporal;
    }

    public void setTablatemporal(String tablatemporal) {
        this.tablatemporal = tablatemporal;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTodasextsinput() {
        return todasextsinput;
    }

    public void setTodasextsinput(String todasextsinput) {
        this.todasextsinput = todasextsinput;
    }
}
