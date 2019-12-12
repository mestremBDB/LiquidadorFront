package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({ @NamedQuery(name = "ConfProcesosContingencia.findAll", query = "select o from ConfProcesosContingencia o"), 
                @NamedQuery(name = "ConfProcesosContingencia.findByIdProcesoC", query = "select o from ConfProcesosContingencia o where o.id_Proceso=:idProceso")
             })
@Table(name = "conf_procesos_contingencia")
public class ConfProcesosContingencia implements Serializable {
    private static final long serialVersionUID = 1346589217036991062L;
    @Id
    @Column(length = 50)
    private String id_Proceso;
    @Column(length = 50)
    private String doc_Uid;
    @Column(length = 10)
    private String hash_type;
    @Column(length = 50)
    private String file_Content;
    @Column(length = 50)
    private String bank_Id;
    @Column(length = 50)
    private String rq_Uid;
    @Column(length = 50)
    private String network_Ref_Id;
    @Column(length = 50)
    private String doc_Type;
    @Column(length = 50)
    private String servidor_Origen;
    @Column(length = 100)
    private String ruta_Origen;
    @Column(length = 50)
    private String servidor_Destino;
    @Column(length = 100)
    private String ruta_Destino;
    @Column(length = 50)
    private String puerto_Destino;
    @Column(length = 50)
    private String aplicacion;
    @Column(length = 200)
    private String ruta_Parcial;
    @Column(length = 50)
    private String archivo_Masivo_1;
    @Column(length = 50)
    private String archivo_Masivo_2;
    @Column(length = 50)
    private String formato;

    public void setId_Proceso(String id_Proceso) {
        this.id_Proceso = id_Proceso;
    }

    public String getId_Proceso() {
        return id_Proceso;
    }

    public void setDoc_Uid(String doc_Uid) {
        this.doc_Uid = doc_Uid;
    }

    public String getDoc_Uid() {
        return doc_Uid;
    }

    public void setHash_type(String hash_type) {
        this.hash_type = hash_type;
    }

    public String getHash_type() {
        return hash_type;
    }

    public void setFile_Content(String file_Content) {
        this.file_Content = file_Content;
    }

    public String getFile_Content() {
        return file_Content;
    }

    public void setBank_Id(String bank_Id) {
        this.bank_Id = bank_Id;
    }

    public String getBank_Id() {
        return bank_Id;
    }

    public void setRq_Uid(String rq_Uid) {
        this.rq_Uid = rq_Uid;
    }

    public String getRq_Uid() {
        return rq_Uid;
    }

    public void setNetwork_Ref_Id(String network_Ref_Id) {
        this.network_Ref_Id = network_Ref_Id;
    }

    public String getNetwork_Ref_Id() {
        return network_Ref_Id;
    }

    public void setDoc_Type(String doc_Type) {
        this.doc_Type = doc_Type;
    }

    public String getDoc_Type() {
        return doc_Type;
    }

    public void setServidor_Origen(String servidor_Origen) {
        this.servidor_Origen = servidor_Origen;
    }

    public String getServidor_Origen() {
        return servidor_Origen;
    }

    public void setRuta_Origen(String ruta_Origen) {
        this.ruta_Origen = ruta_Origen;
    }

    public String getRuta_Origen() {
        return ruta_Origen;
    }

    public void setServidor_Destino(String servidor_Destino) {
        this.servidor_Destino = servidor_Destino;
    }

    public String getServidor_Destino() {
        return servidor_Destino;
    }

    public void setRuta_Destino(String ruta_Destino) {
        this.ruta_Destino = ruta_Destino;
    }

    public String getRuta_Destino() {
        return ruta_Destino;
    }

    public void setPuerto_Destino(String puerto_Destino) {
        this.puerto_Destino = puerto_Destino;
    }

    public String getPuerto_Destino() {
        return puerto_Destino;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setRuta_Parcial(String ruta_Parcial) {
        this.ruta_Parcial = ruta_Parcial;
    }

    public String getRuta_Parcial() {
        return ruta_Parcial;
    }

    public void setArchivo_Masivo_1(String archivo_Masivo_1) {
        this.archivo_Masivo_1 = archivo_Masivo_1;
    }

    public String getArchivo_Masivo_1() {
        return archivo_Masivo_1;
    }

    public void setArchivo_Masivo_2(String archivo_Masivo_2) {
        this.archivo_Masivo_2 = archivo_Masivo_2;
    }

    public String getArchivo_Masivo_2() {
        return archivo_Masivo_2;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }
}


