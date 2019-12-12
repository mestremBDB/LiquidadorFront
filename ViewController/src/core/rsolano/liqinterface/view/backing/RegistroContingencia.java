package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.AppAplicaciones;
import core.rsolano.liqinterface.model.entities.AppContingenciaLiq;
import core.rsolano.liqinterface.model.entities.ConfEventosproceso;
import core.rsolano.liqinterface.model.entities.ConfProcesosContingencia;
import core.rsolano.liqinterface.model.entities.NotifProceso;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;


import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.util.ArrayList;
import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.binding.AttributeContext;
import oracle.binding.RowContext;

import org.apache.myfaces.trinidad.event.SelectionEvent;

public class RegistroContingencia {

private String proceso;
private String nombreArchivo;
private String extension;
private Date fechaContingencia;
private java.util.Date fechaMin;
private java.util.Date fechaMax;
private java.util.Date fechaMaxA;
private List<AppAplicaciones> listaProcesos = new ArrayList<>();
private List<String> Extensiones = new ArrayList<String>();

    @EJB
    private LiqTasasFacadeLocal facade;
    
    public RegistroContingencia() {
    }
    
    @PostConstruct
    public void init() {
        if(!JSFUtils.LoggedActive())
            return;
       // listaProcesos = facade.listaProcesos().get(0).getAppAplicaciones();
        for(NotifProceso app: facade.listaProcesos()){
            listaProcesos.add(app.getAppAplicaciones());
        }
       // this.setListaProcesos(listaProcesos);
        Extensiones.add(0, ".txt");
        Extensiones.add(1, ".xlsx");
        Extensiones.add(2, ".zip");
        Extensiones.add(3, ".DAT.PGP");
        Extensiones.add(4, ".pgp");
        this.setExtensiones(Extensiones);
        Calendar cal = Calendar.getInstance();
        fechaMaxA = new java.util.Date();
        cal.setTime(fechaMaxA);
        cal.add(Calendar.DATE, +1);
        fechaMax = cal.getTime();
        fechaMin = calcularFechaMin(fechaMax);
        extension = "";
        nombreArchivo = "";
    }
    
    public void registrarContingencia() {
        AppContingenciaLiq contingencia = new AppContingenciaLiq();
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha registrado la contingencia correctamente!", "");
        String fechaFormato  = calcularFechaArchivo(proceso,fechaContingencia);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
        //String fecha = simpleDateFormat.format(fechaContingencia);
        nombreArchivo = traerNombreArchivo(proceso)+ fechaFormato + traerExtension(proceso);
        int id=1;
        if(!facade.maxId().isEmpty()){
          id = facade.maxId().get(0).getId() + 1;
        }
        java.util.Date fechaH = new java.util.Date();
        if(fechaFormato.equalsIgnoreCase("")){
        fechaFormato = simpleDateFormat.format(fechaH);
           nombreArchivo= nombreArchivo + "_";
        }
        /**if(fechaFormato.equalsIgnoreCase("")){
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "El proceso "+proceso+" no tiene formato de fecha!", "");
        }else{**/
            AppAplicaciones appAplicacion = facade.findByProceso(proceso).get(0);
            if(appAplicacion.getNotifProcesoList().get(0).getMasivo().equalsIgnoreCase("0")){
                /*if(appAplicacion.getNotifProcesoList().get(0).getAplicacionNombre().contains("RME")){
                    nombreArchivo=nombreArchivo.replace("_", "");
                }*/
                        contingencia = new AppContingenciaLiq(id, 
                                                           proceso, 
                                                           "",
                                                           fechaFormato,
                                                           new Long(0),
                                                           "",
                                                           nombreArchivo,
                                                           new Long(0)
                                                           );
            }else{
                ConfProcesosContingencia confP = facade.findByIdProcesoC(appAplicacion.getNotifProcesoList().get(0).getId()).get(0);
                String formatoFM1= confP.getFormato();
                SimpleDateFormat simpleDateFormatA = new SimpleDateFormat(formatoFM1);
                nombreArchivo = traerNombreArchivo(proceso)+ simpleDateFormatA.format(cambiarFecha(fechaContingencia, formatoFM1)) + traerExtension(proceso);
                    String fechaConFormatoM1 ="";
                    String fechaConFormatoM2 = "";
                    
                    if(confP.getArchivo_Masivo_1()!= null){
                        if(!confP.getArchivo_Masivo_1().equalsIgnoreCase("")){
                            fechaConFormatoM1 = confP.getArchivo_Masivo_1().replace(formatoFM1,simpleDateFormatA.format(fechaContingencia));
                        }else{
                            fechaConFormatoM1="";
                        }
                    }
                if(confP.getArchivo_Masivo_2()!= null){
                    if(!confP.getArchivo_Masivo_2().equalsIgnoreCase("")){
                        fechaConFormatoM2 = confP.getArchivo_Masivo_2().replace(formatoFM1,simpleDateFormatA.format(fechaContingencia));
                    }else{
                        fechaConFormatoM2="";
                    }
                }
                if(appAplicacion.getNotifProcesoList().get(0).getAplicacionNombre().contains("RME")){
                    fechaConFormatoM1=nombreArchivo;
                    fechaConFormatoM1=fechaConFormatoM1.replace("_", "");
                }
                contingencia = new AppContingenciaLiq(id, 
                                                   proceso, 
                                                   fechaConFormatoM1,
                                                   fechaFormato,
                                                   new Long(0),
                                                   fechaConFormatoM2,
                                                   nombreArchivo,
                                                   new Long(1)
                                                   );
            }
        facade.persistContingencia(contingencia);
       
       // }
            ctx.addMessage(null,fm);
        
    }
    
    public String calcularFechaArchivo(String proceso, java.util.Date fecha){
        String fechaConFormato = "";
        AppAplicaciones appAplicacion = facade.findByProceso(proceso).get(0);
        NotifProceso notifProceso = appAplicacion.getNotifProcesoList().get(0);
        ConfEventosproceso confEvento = facade.findByIdProceso(notifProceso.getId()).get(0);
        if(!confEvento.getConfFuenteinsumofileList().isEmpty()){
        String formatoFecha = confEvento.getConfFuenteinsumofileList().get(0).getFormatofecha();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatoFecha);

        fechaConFormato = simpleDateFormat.format(validarFecha(notifProceso.getTipoliquidacion(),fecha, formatoFecha));
        }
        return fechaConFormato;
    }
    
    public java.util.Date validarFecha(String tipoLiquidacion, java.util.Date fecha, String formatoFecha){
        if(tipoLiquidacion.equalsIgnoreCase("2") || tipoLiquidacion.equalsIgnoreCase("3")){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        System.out.println("Fecha antes de validar: "+  cal.getTime());
            if(formatoFecha.contains("dd") || formatoFecha.contains("DD")){
                System.out.println("Lleva dia "+ formatoFecha);
               cal.add(Calendar.DATE, -1);
            }else{
                System.out.println("Lleva mes "+ formatoFecha);
                cal.add(Calendar.MONTH, -1);
            }
            java.util.Date fechaValidada = cal.getTime();
            System.out.println("Fecha validada : "+ fechaValidada);
            this.setFechaContingencia(new java.sql.Date(cal.getTime().getTime()));
            return fechaValidada;
        }else{
            
            return fecha;
        }
    }
    
    public java.util.Date cambiarFecha(java.util.Date fecha, String formatoFecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        System.out.println("Fecha antes de validar: "+  cal.getTime());
            if(formatoFecha.contains("dd") || formatoFecha.contains("DD")){
                System.out.println("Lleva dia "+ formatoFecha);
               cal.add(Calendar.DATE, -1);
            }else{
                System.out.println("Lleva mes "+ formatoFecha);
                cal.add(Calendar.MONTH, -1);
            }
            java.util.Date fechaValidada = cal.getTime();
            System.out.println("Fecha validada : "+ fechaValidada);
            this.setFechaContingencia(new java.sql.Date(cal.getTime().getTime()));
            return fechaValidada;
    }
    
    public String traerExtension(String proceso){
        AppAplicaciones appAplicacion = facade.findByProceso(proceso).get(0);
        NotifProceso notifProceso = appAplicacion.getNotifProcesoList().get(0);
        ConfEventosproceso confEvento = facade.findByIdProceso(notifProceso.getId()).get(0);
        if(confEvento.getConfFuenteinsumofileList().isEmpty()){
            return "";
        }
        if(confEvento.getConfFuenteinsumofileList().get(0).getExtensionexterna()!= null){
            if(confEvento.getConfFuenteinsumofileList().get(0).getExtensionexterna().equalsIgnoreCase(this.extension))
            return this.extension;
            
        }
        if(confEvento.getConfFuenteinsumofileList().get(0).getExtensionauxiliar()!=null){
            if(confEvento.getConfFuenteinsumofileList().get(0).getExtensionauxiliar().equalsIgnoreCase(this.extension))
            return this.extension;
        }
        
        if(confEvento.getConfFuenteinsumofileList().get(0).getExtension()!=null){
            if(confEvento.getConfFuenteinsumofileList().get(0).getExtension().equalsIgnoreCase(this.extension)){
            return this.extension;
            } else{
             if(confEvento.getConfFuenteinsumofileList().get(0).getExtensionexterna()!= null){
             return confEvento.getConfFuenteinsumofileList().get(0).getExtensionexterna();
             }else if(confEvento.getConfFuenteinsumofileList().get(0).getExtensionauxiliar()!= null){
             return confEvento.getConfFuenteinsumofileList().get(0).getExtensionauxiliar();
             }else {
             return confEvento.getConfFuenteinsumofileList().get(0).getExtension();
             }
            }
        }
       
        return "";
        
    }
    
    public String traerNombreArchivo(String proceso){
        AppAplicaciones appAplicacion = facade.findByProceso(proceso).get(0);
        NotifProceso notifProceso = appAplicacion.getNotifProcesoList().get(0);
        ConfEventosproceso confEvento = facade.findByIdProceso(notifProceso.getId()).get(0);
        if(confEvento.getConfFuenteinsumofileList().isEmpty())
            return proceso;
        return confEvento.getConfFuenteinsumofileList().get(0).getNombrearchivo();
    }
    
    public java.util.Date calcularFechaMin(java.util.Date fechaHoy){
        String meses = facade.getParameter("MesesMaxContingencia");
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaHoy);
        if(meses != null || meses != ""){
        cal.add(Calendar.MONTH, - Integer.parseInt(meses));
        }else{
            cal.add(Calendar.MONTH, - 12);
        }
        return cal.getTime();
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getProceso() {
        return proceso;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setFechaContingencia(Date fechaContingencia) {
        this.fechaContingencia = fechaContingencia;
    }

    public Date getFechaContingencia() {
        return fechaContingencia;
    }

    public void setListaProcesos(List<AppAplicaciones> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public List<AppAplicaciones> getListaProcesos() {
        return listaProcesos;
    }


    public void setFechaMin(Date fechaMin) {
        this.fechaMin = fechaMin;
    }

    public java.util.Date getFechaMin() {
        return fechaMin;
    }

    public void setFechaMax(java.util.Date fechaMax) {
        this.fechaMax = fechaMax;
    }

    public java.util.Date getFechaMax() {
        return fechaMax;
    }


    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtensiones(List Extensiones) {
        this.Extensiones = Extensiones;
    }

    public List getExtensiones() {
        return Extensiones;
    }

}
