package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.IdmGrupos;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.utils.ADFUtils;
import core.rsolano.liqinterface.view.utils.JSFUtils;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

public class UserManager {
    
    private String user;
    private String domain;
    
    @EJB
    private LiqTasasFacadeLocal facade;
    
    
    public UserManager() {
    }
    
    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
        user = JSFUtils.getUserName();
        domain = JSFUtils.getUserDomain();
    }

    
    public void SaveConf(ActionEvent actionEvent) {
        // Add event code here...
        String Id = "";
        String Group = "";
        String Grants = "";
        
        Id = ADFUtils.GetBindingValue("id2");
        Group = ADFUtils.GetBindingValue("grupo");
        Grants = ADFUtils.GetBindingValue("permisos");
        
        if(Group.isEmpty() || Grants.isEmpty()){
            ADFUtils.showMessage("Error de contraseña","No es posible actualizar campos vacíos.");
            ADFUtils.RefreshIterator("idmGruposFindAllIterator");
            return;
        }
        
        IdmGrupos igroup = new IdmGrupos();
        
        igroup.setGrupo(Group);
        igroup.setPermisos(Grants);
        
        try{
            if(Id.isEmpty()){
                facade.persistIdmGrupos(igroup);
                facade.insertLog("AGREGAR", user, domain, "Se agrega el grupo IDM " + Group + ". Servidor" + OSHelper.getServerName());
            }else{
                igroup.setId(Id);
                facade.mergeIdmGrupos(igroup);
                facade.insertLog("ACTUALIZAR", user, domain, "Se actualiza el grupo IDM " + Group + ". Servidor" + OSHelper.getServerName());
            }
        }catch(Exception e){
            e.printStackTrace();
            facade.insertLog("ERROR", user, domain, "Problemas insertando grupo IDM " + Group + " en la base de datos desde el servidor " 
                            + OSHelper.getServerName()  + ". Revisar logs de welogic.");
        }
        
        ADFUtils.RefreshIterator("idmGruposFindAllIterator");
    }
}
