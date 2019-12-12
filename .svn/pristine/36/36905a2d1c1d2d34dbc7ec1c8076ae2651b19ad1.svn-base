package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.CryptoVaultManager;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichImage;


public class PgpConfigure {
    
    //Variable de entrada para cryptovault
    private String _crypto_password;
    private String _crypto_confirm;
    private String _choice;
    
    //Variable para outputs
    private RichOutputText bmsgText;
    private RichImage bmsgImage;
    private String msgText;
    private String msgImage;
    private String msgStyle;
    boolean msgActive;

    //Variable de objeto cryptovault
    int CryptoResult = -99;
    CryptoVaultManager crypto;
    String path = "nopath";
    
    //variables de objeto facade bean
    @EJB
    private LiqTasasFacadeLocal facade;
    
    private String user;
    private String domain;

    String _crypto_directory_modify;

    public PgpConfigure() {
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
            keysPGP = crypto.getPGPkeys(".asc","pub");
            msgActive = false;
        }else{
            msgText = "No se ha creado el almacén de llaves";
            msgImage = "/images/error.png";
            msgStyle = "color:Red;font-weight:bold;";
            msgActive = true;
        }
        
    }
    
    public void UpdatePrivatePGP(ActionEvent actionEvent) {
        // Add event code here...
        
        boolean success_1 = false;
        boolean success_2 = false;
        String temp_pass = "";
        String temp_name = "";
        String ant_name = "";
        
        if(!facade.KeyStoreExist()){
            ErrorMsg("No se ha creado alamacén de llaves");
            return;
        }
        if(!_crypto_confirm.equalsIgnoreCase(_crypto_password)){
            ErrorMsg("Se deben validar las contraseñas ingresadas");
            return;
        }
        if(_choice.equalsIgnoreCase(" ")  || _choice.equalsIgnoreCase("ninguna llave")){
            ErrorMsg("No existen llaves para configurar");
            return;
        }
        
        CryptoResult = crypto.CreateOrUpdatePGPKey(_choice);
        
        if(CryptoResult == 0){
            success_1 = true;
            CryptoResult = crypto.ChangePgpPassKey(_crypto_password, true);
            if(CryptoResult == 0)
                success_2 = true;
        }
                 
        crypto.updateCfgParamvalues();
        _crypto_password = "";
        _crypto_confirm = "";
        
        if(success_1 && success_2) 
        {
            facade.insertLog("MODIFICACIÓN", user, domain, "Modificación de contraseña en llave PGP " + _choice);
            SuccessMsg();
        }
        else 
        {
            facade.insertLog("MODIFICACIÓN", user, domain, "Error en la modificación de la llave " + _choice + 
                           ". Param: nombre=" + crypto.getKeyPGPanme());
            ErrorMsg("Error configurando llave PGP." + _choice);
        }
    }
    
    public void SuccessMsg(){
        msgText = "Configuración exitosa!!!";
        msgImage = "/images/success.png";
        msgStyle = "color:Green;font-weight:bold;";
        msgActive = true;;
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
    public void setCrypto_password(String _crypto_password) {
        this._crypto_password = _crypto_password;
    }
    public String getCrypto_password() {
        return _crypto_password;
    }
    public void setCrypto_confirm(String _crypto_confirm) {
        this._crypto_confirm = _crypto_confirm;
    }
    public String getCrypto_confirm() {
        return _crypto_confirm;
    }
    public void setChoice(String _choice) {
        this._choice = _choice;
    }
    public String getChoice() {
        return _choice;
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
    
    
    public List<SelectItem> getPgpKeys() {
        if(_pgpKeys == null) 
        {
          _pgpKeys = new ArrayList<SelectItem>();
          
          for(String key : keysPGP)
            _pgpKeys.add(new SelectItem(key));
        }
        return _pgpKeys;
    }
    private List<SelectItem> _pgpKeys;
    String[] keysPGP;

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
