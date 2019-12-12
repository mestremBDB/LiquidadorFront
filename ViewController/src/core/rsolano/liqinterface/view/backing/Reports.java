package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.AppAplicaciones;
import core.rsolano.liqinterface.model.entities.ConfEventosproceso;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.utils.ADFUtils;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.event.ActionEvent;

import oracle.adf.model.bean.DCDataRow;
import oracle.adf.view.rich.component.rich.input.RichInputDate;

import oracle.jbo.Row;

public class Reports {
    
    String chargesTitle;
    String failsTitle;
    private RichInputDate dayDate;
    String ShowColums;
    String DateI;
    String DateF;
    String ShowTable;
    String ShownTable2;
    String SelectedOp;
    String HeaderCharges;

    public Reports() {
    }
    
    @PostConstruct
    public void init() {
        if(!JSFUtils.LoggedActive())
            return;
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String today = String.format("%02d", month) + String.format("%04d", year);
       
        chargesTitle = "Cobros período de liquidación " + OSHelper.getMonthByNumber(month) + " de " + Integer.toString(year);
        failsTitle = "Rechazos período de liquidación " + OSHelper.getMonthByNumber(month) + " de " + Integer.toString(year);
        setSelectedOp("exitosos");
    }
    
    public void OnSearch(ActionEvent actionEvent) {
        // Add event code here...

        String month = OSHelper.getMonthByName(ADFUtils.GetBindingValue("months"));
        String year = ADFUtils.GetBindingValue("years");
        String bindingDateI = "";
        String bindingDateF = "";
        String bindingDate = month + year;
        setShowColums("false");
        
        String appName = ADFUtils.GetBindingValue("appAplicacionesFindAll");
        
        //obtener las aplicaciones que tienen liquidacion diaria
        String selectedday = "";
        List<String> dailyApps = new ArrayList<String>();
        Row[] apps = ADFUtils.GetAllIteratorRow("appAplicacionesFindAllIterator");
            for(Row approw : apps){

            AppAplicaciones appObject = (AppAplicaciones)((DCDataRow)approw).getDataProvider();
                //declarar un objeto de tipo confEventosProceso
                String fecha = "";
                //Obtener los proceso por evento de la aplicación
                for (ConfEventosproceso ev: appObject.getNotifProcesoList().get(0).getConfEventosprocesoList() ){ 
                    if(ev.getAppEventos().getEstado().equalsIgnoreCase("INIT")){
                        if(ev.getTablafuente().equalsIgnoreCase("conf_fuenteinsumofile")){
                           fecha = ev.getConfFuenteinsumofileList().get(0).getFormatofecha();
                           break;
                            
                        }else{
                                fecha = ev.getConfFuenteinsumostructureList().get(0).getFormatofecha();
                            }
                    }  
                }
                
                //Probar por formato fecha
                if(fecha.contains("d")){
                 dailyApps.add(appObject.getNombre());
                   
                    fecha = "";
                    }
        
            if(appObject.getNotifProcesoList().get(0).getTipoliquidacion().equals("3")){
                
            }
        }
        
        //fijar limites de calendario para liquidacion diaria
        if(dailyApps.contains(appName)){
            try {
                Date minDate = new Date(), maxDate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                minDate = formatter.parse(year + "-" + month + "-" + "01");
                Calendar c = Calendar.getInstance();
                c.setTime(minDate);
                c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
                c.add(Calendar.DAY_OF_MONTH, 1);
                maxDate = c.getTime();
                
                dayDate.setMinValue(minDate);
                dayDate.setMaxValue(maxDate);     
                dayDate.setVisible(true);
                
                //consultar dia para liquidacion diaria        
                if(dayDate.getValue() != null){
                        SimpleDateFormat dayformatter = new SimpleDateFormat("dd");                        
                        selectedday = dayformatter.format(dayDate.getValue());
                        bindingDate = selectedday + month + year;
                    }
            } catch (ParseException pe) {                
            }
        }
        else{
                dayDate.resetValue();
                dayDate.setVisible(false);
            }
        
        
        try{
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(getDateI());
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(getDateF());
            if(date1.before(date2) || date1.equals(date2)){
                bindingDateI = getDateI();
                bindingDateF = getDateF();   
                chargesTitle = "Cobros período de liquidación " + getDateI() + " a " + getDateF();
                failsTitle = "Rechazos período de liquidación " + getDateI() + " a " + getDateF();;
            }else{
                ADFUtils.showMessage("Fecha Incorrecta","La Fecha Fin no puede ser mayor a la Fecha Inicio.");   
                bindingDate = "000000";
                }            
        }catch (Exception e){
                chargesTitle = "Cobros período de liquidación " + month + " de " + year;
                failsTitle = "Rechazos período de liquidación " + month + " de " + year;
            }
        
        //Ver columnas segun tipo de aplicacion
        if (appName.equals("PSE")){
            setShowColums("true");
            }

        if (getSelectedOp().equals("exitosos")) {
            setShowTable("false");
            setShownTable2("true");
            setHeaderCharges("CLIENTES POR COBRO");
        } else {
            setShowTable("true");
            setShownTable2("false");
            setHeaderCharges("CLIENTES SIN COBRO");
        }


        //Cobros por período exitosos y fallidos
        ADFUtils.SetBindingValue("app",ADFUtils.GetBindingValue("appAplicacionesFindAll"));
        ADFUtils.SetBindingValue("date", bindingDate);
        ADFUtils.SetBindingValue("dateI", bindingDateI);
        ADFUtils.SetBindingValue("dateF", bindingDateF);
        ADFUtils.ExecuteBindMethod("ExecuteWithParams");
        
        //Razones de rechazos
        ADFUtils.SetBindingValue("app1", ADFUtils.GetBindingValue("appAplicacionesFindAll"));
        ADFUtils.SetBindingValue("date1", bindingDate);
        ADFUtils.SetBindingValue("dateI1", bindingDateI);
        ADFUtils.SetBindingValue("dateF1", bindingDateF);
        ADFUtils.ExecuteBindMethod("ExecuteWithParams1");
        
        ADFUtils.SetBindingValue("app2", ADFUtils.GetBindingValue("appAplicacionesFindAll"));
        ADFUtils.SetBindingValue("date2", bindingDate);
        ADFUtils.SetBindingValue("dateI2", bindingDateI);
        ADFUtils.SetBindingValue("dateF2", bindingDateF);
        ADFUtils.ExecuteBindMethod("ExecuteWithParams2");

        ADFUtils.SetBindingValue("app3", ADFUtils.GetBindingValue("appAplicacionesFindAll"));
        ADFUtils.SetBindingValue("date3", bindingDate);
        ADFUtils.SetBindingValue("dateI3", bindingDateI);
        ADFUtils.SetBindingValue("dateF3", bindingDateF);
        ADFUtils.ExecuteBindMethod("ExecuteWithParams3");

        ADFUtils.SetBindingValue("app4", ADFUtils.GetBindingValue("appAplicacionesFindAll"));
        ADFUtils.ExecuteBindMethod("ExecuteWithParams4");
        
        ADFUtils.SetBindingValue("app5", ADFUtils.GetBindingValue("appAplicacionesFindAll"));
        ADFUtils.SetBindingValue("date5", bindingDate);
        ADFUtils.SetBindingValue("dateI5", bindingDateI);
        ADFUtils.SetBindingValue("dateF5", bindingDateF);
        ADFUtils.ExecuteBindMethod("ExecuteWithParams5");
        
        ADFUtils.RefreshIterator("chargeByPeriodIterator");
        ADFUtils.RefreshIterator("failChargeDetilsIterator");
        ADFUtils.RefreshIterator("chargeByModalityIterator");
        ADFUtils.RefreshIterator("customerChargesIterator");
        ADFUtils.RefreshIterator("chargesIterator");
    
    }
    
    public void setChargesTitle(String chargesTitle) {
        this.chargesTitle = chargesTitle;
    }

    public String getChargesTitle() {
        return chargesTitle;
    }

    public void setFailsTitle(String failsTitle) {
        this.failsTitle = failsTitle;
    }

    public String getFailsTitle() {
        return failsTitle;
    }
    
    public void setDayDate(RichInputDate dayDate) {
        this.dayDate = dayDate;
    }

    public RichInputDate getDayDate() {
        return dayDate;
    }


    public void setShowColums(String ShowColums) {
        this.ShowColums = ShowColums;
    }

    public String getShowColums() {
        return ShowColums;
    }

    public void setDateI(String DateI) {
        this.DateI = DateI;
    }

    public String getDateI() {
        return DateI;
    }

    public void setDateF(String DateF) {
        this.DateF = DateF;
    }

    public String getDateF() {
        return DateF;
    }

    public void setShowTable(String ShowTable) {
        this.ShowTable = ShowTable;
    }

    public String getShowTable() {
        return ShowTable;
    }

    public void setSelectedOp(String SelectedOp) {
        this.SelectedOp = SelectedOp;
    }

    public String getSelectedOp() {
        return SelectedOp;
    }

    public void setShownTable2(String ShownTable2) {
        this.ShownTable2 = ShownTable2;
    }

    public String getShownTable2() {
        return ShownTable2;
    }

    public void setHeaderCharges(String HeaderCharges) {
        this.HeaderCharges = HeaderCharges;
    }

    public String getHeaderCharges() {
        return HeaderCharges;
    }


}
