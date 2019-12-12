package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "TaskFilesloader.findAll", query = "select o from TaskFilesloader o") })
@Table(name = "TASK_FILESLOADER")
public class TaskFilesloader implements Serializable {
    private static final long serialVersionUID = 1574777659888988228L;
    @Column(nullable = false, length = 50)
    private String aplicacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "END_TIME_TASK")
    private Date endTimeTask;
    @Id
    @Column(nullable = false, length = 50)
    private String id;
    @Column(name = "MSG_ID", length = 50)
    private String msgId;
    @Temporal(TemporalType.DATE)
    @Column(name = "MSG_TIME")
    private Date msgTime;
    @Column(nullable = false, length = 50)
    private String nombrearchivo;
    @Temporal(TemporalType.DATE)
    @Column(name = "START_TIME_TASK")
    private Date startTimeTask;
    @Column(length = 2)
    private String status;

    public TaskFilesloader() {
    }

    public TaskFilesloader(String aplicacion, Date endTimeTask, String id, String msgId, Date msgTime,
                           String nombrearchivo, Date startTimeTask, String status) {
        this.aplicacion = aplicacion;
        this.endTimeTask = endTimeTask;
        this.id = id;
        this.msgId = msgId;
        this.msgTime = msgTime;
        this.nombrearchivo = nombrearchivo;
        this.startTimeTask = startTimeTask;
        this.status = status;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public Date getEndTimeTask() {
        return endTimeTask;
    }

    public void setEndTimeTask(Date endTimeTask) {
        this.endTimeTask = endTimeTask;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public String getNombrearchivo() {
        return nombrearchivo;
    }

    public void setNombrearchivo(String nombrearchivo) {
        this.nombrearchivo = nombrearchivo;
    }

    public Date getStartTimeTask() {
        return startTimeTask;
    }

    public void setStartTimeTask(Date startTimeTask) {
        this.startTimeTask = startTimeTask;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
