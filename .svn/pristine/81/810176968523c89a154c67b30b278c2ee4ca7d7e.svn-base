package core.rsolano.liqinterface.view.backing;
import core.rsolano.liqinterface.model.entities.ConfSqlloader;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.EncoderUtil;
import core.rsolano.liqinterface.model.utils.LoaderHelper;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.utils.ADFUtils;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;


public class SqlLoader {
    
    @EJB
    private LiqTasasFacadeLocal facade;
    private String confirm;

    private boolean active;
    private boolean required;
    
    private String user;
    private String domain;
    
    public SqlLoader() {
    }
    
    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
        
        user = JSFUtils.getUserName();
        domain = JSFUtils.getUserDomain();
        
        active = false;
        required = false;
    }

    public void SaveConf(ActionEvent actionEvent){
        // Add event code here...
        String control = ""; 
        String password = "";
        String Id = "";
        String[] ret;
        
        active = false;
        required = false;
        
        Id = ADFUtils.GetBindingValue("id1");
        password = ADFUtils.GetBindingValue("password");
        control = ADFUtils.GetBindingValue("controlRoot");
        if(!password.equalsIgnoreCase(confirm)){
            ADFUtils.showMessage("Error de contraseña","Es necesario confirmar la contraseña de base de datos para la configuración de " +
                "sql loader que esta intentando crear.");
            ADFUtils.RefreshIterator("confSqlloaderFindAllIterator");
            return;
        }
        
        ConfSqlloader cfg = new ConfSqlloader();
        
        cfg.setPassword(password);
        cfg.setControlRoot(control);
        cfg.setNdatabase(ADFUtils.GetBindingValue("ndatabase"));
        cfg.setUsername(ADFUtils.GetBindingValue("username"));
        cfg.setInstallRoot(ADFUtils.GetBindingValue("installRoot"));
        cfg.setInfileRoot(ADFUtils.GetBindingValue("infileRoot"));
        cfg.setLogfileRoot(ADFUtils.GetBindingValue("logfileRoot"));
        cfg.setNhost(OSHelper.getServerName());
        
        //Hay que dejar el archivo de pruebas parametrizable
        ret = LoaderHelper.TestSQLloader(cfg,"test.csv");
        if(!ret[1].equalsIgnoreCase("0")){
            if(!ret[3].isEmpty())
                ADFUtils.showMessage("Error SQL Loader", ret[3]);
            else
                ADFUtils.showMessage("Error SQL Loader", ret[2]);
            facade.insertLog("ERROR", user, domain, "Carga test.csv errada en servidor " + OSHelper.getServerName());
            ADFUtils.RefreshIterator("confSqlloaderFindAllIterator");
            return;
        }
        
        cfg.setPassword(EncoderUtil.encriptar(password));
        
        try{
            if(Id.isEmpty()){
                facade.persistConfSqlloader(cfg);
                facade.insertLog("AGREGAR", user, domain, "Se agrega configuración SQLLDR para el archivo " + control + " en el servidor " + OSHelper.getServerName());
            }else{
                cfg.setId(Id);
                facade.mergeEntity(cfg);
                facade.insertLog("ACTUALIZAR", user, domain, "Se actualiza configuración SQLLDR para el archivo " + control + " en el servidor " + OSHelper.getServerName());
            }
            
            facade.ExecuteQueryUpdate("delete from temp_temppse1");
            facade.ExecuteQueryUpdate("delete from temp_temppse2");
            
        }catch(Exception e){
            e.printStackTrace();
            facade.insertLog("ERROR", user, domain, "Error persintiendo configuración sql loader, chequear el log del servidor " + OSHelper.getServerName());
            ADFUtils.showMessage("Error BD", "Error persintiendo configuración sql loader. Mensaje: " + e.getMessage());
        }
        
        ADFUtils.RefreshIterator("confSqlloaderFindAllIterator");
    }

    public void DeleteConf(ActionEvent actionEvent) {
        // Add event code here...
        String control = ADFUtils.GetBindingValue("controlRoot");
        String server = OSHelper.getServerName();
        ADFUtils.ExecuteBindMethod("Delete1");
        facade.insertLog("BORRAR", user, domain, "Se elimina configuración SQLLDR para el archivo " + control + " en el servidor " + server);
    }
    
    public void ActiveLogin() {
        active = true;
        required = true;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean isActive() {
        return active;
    }
    public void setRequired(boolean required) {
        this.required = required;
    }
    public boolean isRequired() {
        return required;
    }
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    public String getConfirm() {
        return confirm;
    }
}
