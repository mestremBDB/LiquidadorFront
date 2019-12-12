package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.CryptoVaultManager;

import core.rsolano.liqinterface.model.utils.LdapModule;

import core.rsolano.liqinterface.view.utils.ADFUtils;

import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;

public class CreateKeystore {
    public CreateKeystore() {
    }
    
    //Variables de radio boton y controles activos
    String  _radio;
    boolean _ks_created;
    boolean _validators;
    
    //Variable de entrada para cryptovault
    String _crypto_directory_modify;
    String _crypto_directory;
    String _crypto_password;
    String _crypto_confirm;
    String _crypto_oldpass;
    
    //Variable para ouputs
    private RichOutputText bmsgText;
    private RichImage bmsgImage;
    private String msgText;
    private String msgImage;
    private String msgStyle;
    boolean msgActive;

    //Instanciamiento de base de datos
    @EJB
    private LiqTasasFacadeLocal facade;
    
    //Objeto que ataca la instlación de cryptovault
    private CryptoVaultManager manager;
    int CryptoVaultResult;
    String path = "nopath";
    
    //Variables de sesión
    Login logged;
    private String user;
    private String domain;
    
    private List<SelectItem> almacen;
    private boolean crearMode;
    
    private List<SelectItem> _Apps;
    private String _appchoice;
    String[] liqApps;
    

    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
        
        user = JSFUtils.getUserName();
        domain = JSFUtils.getUserDomain();
        setAlmacenesHost();
        liqApps = facade.GetApplications();
        
        if(facade.KeyStoreExist()) {
              this._ks_created = true;
              this.path = facade.getKeyStore().getRuta();
        }else{
            this._ks_created = false;
        }
        this.msgActive = false;
    }
    
    public void CreateKeyStoreOnClick(ActionEvent actionEvent){
        
        if(_radio.equalsIgnoreCase("Crear"))
            CreateKeyStore();
        else if(_radio.equalsIgnoreCase("Modificar"))
            ModifyKeyStore();
    }
    
    public void CreateKeyStore(){
        if(!_crypto_password.equalsIgnoreCase(_crypto_confirm)){
            ErrorMsg("Los campos de contraseña y confirmar deben ser iguales");
            return;
        }
        if(!new File(_crypto_directory).exists()){
            ErrorMsg("El directorio de instalación ingresado no existe");
            return;
        }
        manager = new CryptoVaultManager();
        CryptoVaultResult = manager.CreateKeyStore(_crypto_directory, "123456789","banbogota");
        
        switch(CryptoVaultResult){
            case 0:
                manager.ChangePassKeyStrore("123456789", _crypto_password, true);
                facade.insertKeyStore("banbogota", _crypto_directory, "1", _appchoice);
                JSFUtils.storeOnSession("currentCryptodirectory", _crypto_directory);
                SuccessMsg();
                break;
            case -50000:
                ErrorMsg("Los campos de contraseña no son iguales.");
                break;
            case -50001:
                ErrorMsg("El almacén de llaves ya existente.");
                break;
            case -50002:
                ErrorMsg("Directorio de instalación no es correcto.");
                break;
            case -3:
                ErrorMsg("Directorio de instalación no es correcto");
                break;
            default:
                facade.insertLog("ERROR", user, domain, "Error en creación del almacen de llaves banbogota");
                ErrorMsg("Falla al crear el alamacén de llaves");
                break;
            }
    }
    
    public void ModifyKeyStore(){
        boolean success = false;
        String temp_pass = "";
        
        if(!facade.KeyStoreExist()){
            ErrorMsg("No se ha creado un almacen de llaves");
            return;
        }
        if(!_crypto_password.equalsIgnoreCase(_crypto_confirm)){
            ErrorMsg("Los campos de contraseña y confirmar deben ser iguales");
            return;
        }
        if(!new File(path).exists()){
            ErrorMsg("El directorio de cryptovault no existe");
            return;
        }
        if(_crypto_password.equalsIgnoreCase(_crypto_oldpass)){
            ErrorMsg("Antigua y nueva contraseña debe ser diferentes");
            return;
        }
        
        manager = new CryptoVaultManager(getDirectoryToMod());
        manager.updateCfgParamvalues();
        temp_pass = manager.getKeyStropass(); 
        CryptoVaultResult = manager.ChangePassKeyStrore(_crypto_oldpass, _crypto_password, true);
        manager.updateCfgParamvalues();
        success = manager.getKeyStropass() != null && temp_pass.equalsIgnoreCase(manager.getKeyStropass()) ? false : true;
        
        if(CryptoVaultResult == 0 && (success) ) 
        {
            facade.insertLog("MODIFICACIÓN", user, domain, "Modificaión de contraseña del almacén de llaves");
            SuccessMsg();
        }
        else 
        {
            facade.insertLog("ERROR", user, domain, "Error modificaión de contraseña del almacén de llaves, revise el log de aplicación CryptoVaultManger.log");
            ErrorMsg("Error modificando contraseña del almacén de llaves.");
        }
        
    }
    
    public void Cancel(ActionEvent actionEvent) {
        // Add event code here...
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
    
    //Getters and Setters
    public void setRadio(String _radio) {
        this._radio = _radio;
    }
    public String getRadio() {
        return _radio;
    }

    public void setKs_created(boolean _ks_created) {
        this._ks_created = _ks_created;
    }
    public boolean isKs_created() {
        return _ks_created;
    }
    public void setValidators(boolean _validators) {
        this._validators = _validators;
    }
    public boolean isValidators() {
        return _validators;
    }
    public void setCrypto_directory(String _crypto_directory) {
        this._crypto_directory = _crypto_directory;
    }
    public String getCrypto_directory() {
        return _crypto_directory;
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
    public void setCrypto_oldpass(String _crypto_oldpass) {
        this._crypto_oldpass = _crypto_oldpass;
    }
    public String getCrypto_oldpass() {
        return _crypto_oldpass;
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
    
    public void setCrypto_directory_modify(String _crypto_directory_modify) {
        this._crypto_directory_modify = _crypto_directory_modify;
    }

    public String getCrypto_directory_modify() {
        return _crypto_directory_modify;
    }
    
    public void setCrearMode(boolean crearMode) {
        this.crearMode = crearMode;
    }

    public boolean isCrearMode() {
        return crearMode;
    }
    
    public void setAlmacen(List<SelectItem> almacen) {
        this.almacen = almacen;
    }

    public List<SelectItem> getAlmacen() {
        return almacen;
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

    public void setAppchoice(String _appchoice) {
        this._appchoice = _appchoice;
    }

    public String getAppchoice() {
        return _appchoice;
    }

    
    
    public void keystoreUpdate(ValueChangeEvent valueChangeEvent) {
        try {
            this._radio = valueChangeEvent.getNewValue().toString();
            if (_radio.equalsIgnoreCase("Crear")) {
                this.crearMode = true;
                this._validators = true;
            } else if (_radio.equalsIgnoreCase("Modificar")) {
                this.crearMode = false;
                this._validators = false;
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    private void setAlmacenesHost() {
        List<ConfCryptoalmacen> keyStores = facade.getKeyStoresHost();
        List<SelectItem> newAlmacen = new ArrayList<SelectItem>();
        for(ConfCryptoalmacen key: keyStores){
            newAlmacen.add(new SelectItem(key.getId(), key.getRuta()));
        }
        almacen = newAlmacen;
    }

    private String getDirectoryToMod() {
        
        List<ConfCryptoalmacen> keyStores = facade.getKeyStores();
        for(ConfCryptoalmacen key: keyStores){
            if(key.getId().equals(_crypto_directory_modify)){
                return key.getRuta();    
            }
        }
        return "";
    }

    public void methodSelect(ValueChangeEvent valueChangeEvent) {
        // Add event code here...        
        _crypto_directory_modify = valueChangeEvent.getNewValue().toString();
        JSFUtils.storeOnSession("currentCryptodirectory", getDirectoryToMod());
    }
}
