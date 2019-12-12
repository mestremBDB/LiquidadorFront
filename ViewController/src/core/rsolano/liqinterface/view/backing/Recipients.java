package core.rsolano.liqinterface.view.backing;


import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.CryptoVaultManager;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.utils.ADFUtils;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;


import oracle.adf.view.rich.context.AdfFacesContext;

public class Recipients {
    
    //Variables de entrada
    private List<SelectItem> _pgpKeys;
    private List<SelectItem> _Apps;
    private String _choice;
    private String _appchoice;
    String[] keysPGP;
    String[] liqApps;
    String aliasPub;

    //Variable para outputs
    private RichOutputText bmsgText;
    private RichImage bmsgImage;
    private String msgText;
    private String msgImage;
    private String msgStyle;
    boolean msgActive;
    
    CryptoVaultManager crypto;
    int CryptoResult = -99;
    
    @EJB
    private LiqTasasFacadeLocal facade;
    String path = "nopath";
    String _crypto_directory_modify;
    
    private String user;
    private String domain;

    public Recipients() {
    }
    
    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
        
        user = JSFUtils.getUserName();
        domain = JSFUtils.getUserDomain();
    
        if(facade.KeyStoreExist()){
            _crypto_directory_modify = JSFUtils.getFromSession("currentCryptodirectory") != null ? JSFUtils.getFromSession("currentCryptodirectory").toString() : "";
            path = _crypto_directory_modify != "" ? _crypto_directory_modify : facade.getKeyStore().getRuta();
            crypto = new CryptoVaultManager(path);
            keysPGP = crypto.getPGPkeys(".asc","priv");
            liqApps = facade.GetApplications();
            msgActive = false;
        }else{
            msgText = "No se ha creado el almacén de llaves";
            msgImage = "/images/error.png";
            msgStyle = "color:Red;font-weight:bold;";
            msgActive = true;
        }
    }
    
    public void CreateSign(ActionEvent actionEvent) {
        // Add event code here...
        boolean success = false;
        String temp_pass = "";
        msgActive = true;
        
        if(!facade.KeyStoreExist()){
            ErrorMsg("No se ha creado el almacén de llaves");
            return;
        }
        
        if(_choice.equalsIgnoreCase(" ")  || _choice.equalsIgnoreCase("ninguna llave")) 
        {
            ErrorMsg("No existen llaves para configurar.");
            return;
        }
        
        CryptoResult = crypto.AddRecipient(aliasPub, _choice);
        
        if(CryptoResult == 0){
            
            facade.insertSign(_choice, aliasPub, _appchoice);
            facade.insertLog("AGREGAR", user, domain, "Se agrega el destinatario con firma " + aliasPub);
            SuccessMsg();
            ADFUtils.RefreshIterator("confCryptofirmasFindAllIterator");
        }else{
            facade.insertLog("ERROR", user, domain, "Intentando crear la firma " + aliasPub + ", revise el log de aplicación CryptoVaultManger.log");
            ErrorMsg("Error al agregar la firma " + aliasPub + " al repositorio.");
        }
            
    }
    
    public void DeletePUB(ActionEvent actionEvent) {
        // Add event code here...
        String[] Signs = crypto.GetRecipientList();
        String nombrepub = ADFUtils.GetBindingValue("nombrepub");
        String aliaspub = ADFUtils.GetBindingValue("aliaspub");
        
        boolean flag = false;
        
        for(String sign : Signs)
        {
            if(aliaspub.equalsIgnoreCase(sign)){
                if(crypto.DeleteRecipient(aliaspub) == 0){
                    flag = true;
                    facade.insertLog("BORRAR", user, domain, "Fima con alias " + aliaspub + " borrada exitosamente.");
                    ADFUtils.ExecuteBindMethod("Delete");
                }else{
                    facade.insertLog("ERROR", user, domain, "Problemas para borrar el repositorio de firmas, revise el log de aplicación CryptoVaultManger.log");
                    ErrorMsg("Error borrando repositorio de firmas.");
                }
            }
        }
        
        if(!flag)
            ErrorMsg("No existe una firma con alias " + aliaspub +  " en este servidor " + OSHelper.getServerName());
    }
    
    public void SuccessMsg(){
        msgText = "Configuración exitosa!!!";
        msgImage = "/images/success.png";
        msgStyle = "color:Green;font-weight:bold;";
        msgActive = true;
        AdfFacesContext.getCurrentInstance().addPartialTarget(bmsgText);
        AdfFacesContext.getCurrentInstance().addPartialTarget(bmsgImage);
    }
    
    public void ErrorMsg(String error){
        msgText = error;
        msgImage = "/images/error.png";
        msgStyle = "color:Red;font-weight:bold;";
        msgActive = true;
        AdfFacesContext.getCurrentInstance().addPartialTarget(bmsgText);
        AdfFacesContext.getCurrentInstance().addPartialTarget(bmsgImage);
    }
    
    public void setPgpKeys(List<SelectItem> _pgpKeys) {
      this._pgpKeys = _pgpKeys;
    }
    public List<SelectItem> getPgpKeys() {
        if(_pgpKeys == null) 
        {
          _pgpKeys = new ArrayList<SelectItem>();
          
          for(String key : keysPGP)
            _pgpKeys.add(new SelectItem(key));
        }
      return _pgpKeys;
    }
    public void setApps(List<SelectItem> _Apps) {
        this._Apps = _Apps;
    }
    public List<SelectItem> getApps() {
        if(_Apps == null) 
        {
          _Apps = new ArrayList<SelectItem>();
          
          for(String app : liqApps)
            _Apps.add(new SelectItem(app));
        }
        return _Apps;
    }
    public void setChoice(String _choice) {
      this._choice = _choice;
    }
    public String getChoice() {
      return _choice;
    }
    public void setAppchoice(String _appchoice) {
        this._appchoice = _appchoice;
    }
    public String getAppchoice() {
        return _appchoice;
    }
    
    
    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
    public String getMsgText() {
        return msgText;
    }
    public void setBmsgText(RichOutputText bmsgText) {
        this.bmsgText = bmsgText;
    }
    public RichOutputText getBmsgText() {
        return bmsgText;
    }
    public void setBmsgImage(RichImage bmsgImage) {
        this.bmsgImage = bmsgImage;
    }
    public RichImage getBmsgImage() {
        return bmsgImage;
    }
    public void setMsgImage(String msgImage) {
        this.msgImage = msgImage;
    }
    public String getMsgImage() {
        return msgImage;
    }
    public void setMsgStyle(String msgStyle) {
        this.msgStyle = msgStyle;
    }
    public String getMsgStyle() {
        return msgStyle;
    }
    public void setMsgActive(boolean msgActive) {
        this.msgActive = msgActive;
    }
    public boolean isMsgActive() {
        return msgActive;
    }
    public void setAliasPub(String aliasPub) {
        this.aliasPub = aliasPub;
    }
    public String getAliasPub() {
        return aliasPub;
    }
    public void Cancel(ActionEvent actionEvent) {
        // Add event code here...
    }


    public void setCrypto_directory_modify(String _crypto_directory_modify) {
        this._crypto_directory_modify = _crypto_directory_modify;
    }

    public String getCrypto_directory_modify() {
        return _crypto_directory_modify;
    }
}
