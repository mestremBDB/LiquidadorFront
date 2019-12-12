package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.CryptoVaultManager;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.component.rich.nav.RichButton;

public class Test {
    

    //Variable para outputs
    private RichOutputText bmsgText;
    private RichImage bmsgImage;
    private String msgText;
    private String msgImage;
    private String msgStyle;
    boolean msgActive;
    
    //Variable para inputs
    private List<SelectItem> _pgpKeys;
    private String _choice;
    String[] keysPGP;
    String _inputFile;


    //Variables para cryptovault
    CryptoVaultManager crypto;
    
    //Variables de facade
    @EJB
    private LiqTasasFacadeLocal facade;
    String path;
    
    private String user;
    private String domain;

    String _crypto_directory_modify;
    
    public Test() {
    }
    
    @PostConstruct
    public void init() {
         
        if(!JSFUtils.LoggedActive())
            return;
        
        user = JSFUtils.getUserName();
        domain = JSFUtils.getUserDomain();

         if(facade.KeyStoreExist()) {
            _crypto_directory_modify = JSFUtils.getFromSession("currentCryptodirectory") != null ? JSFUtils.getFromSession("currentCryptodirectory").toString() : "";
            path = _crypto_directory_modify != "" ? _crypto_directory_modify  : facade.getKeyStore().getRuta();
            crypto = new CryptoVaultManager(path);
            keysPGP = crypto.GetRecipientList();
            msgActive = false;
        }else{
            msgText = "No se ha creado el almacén de llaves";
            msgImage = "/images/error.png";
            msgStyle = "color:Red;font-weight:bold;";
            msgActive = true;
        }
    }
    
    public void ExecuteDecrypt(ActionEvent actionEvent) {
        // Add event code here...
        
        boolean success = false;
        String temp_pass = "";
        msgActive = true;
        
        if(!facade.KeyStoreExist()){
            ErrorMsg("No se ha creado alamacén de llaves");
            return;
        }
        
        if(_choice.equalsIgnoreCase(" ")  || _choice.equalsIgnoreCase("ninguna llave")) 
        {
            ErrorMsg("Ninguna firma para prueba descifrar");
            return;
        }
        
        String sfile = "", dfile = "";
        String retMessage = "";
            
        if(path.endsWith(OSHelper.getSepatartor())){
            sfile = path + "test" + OSHelper.getSepatartor() + _inputFile;
            dfile = path + "test" + OSHelper.getSepatartor() +  _inputFile.replace(".pgp", "");
        }else{
            sfile = path +  OSHelper.getSepatartor() + "test" + OSHelper.getSepatartor() + _inputFile;
            dfile = path +  OSHelper.getSepatartor() + "test" + OSHelper.getSepatartor() +  _inputFile.replace(".pgp", "");
        }
            
        retMessage = crypto.EncryptUtility(path,sfile,dfile,_choice.replace("Firma ",""), true, false);
            
        if(retMessage.equalsIgnoreCase("OK")){
            facade.insertLog("PRUEBA", user, domain, "Prueba de desencripción archivo " + sfile);
            SuccessMsg();
        }else 
        {
            facade.insertLog("ERROR", user, domain, "No es posible desencriptar el archivo " + _inputFile + ", revise el log de aplicación CryptoVaultManger.log");
            ErrorMsg("Error al desencriptar archivo " + _inputFile + ". " + retMessage);
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
    
    
    
    public void setInputFile(String _inputFile) {
        this._inputFile = _inputFile;
    }
    public String getInputFile() {
        return _inputFile;
    }
    public void setChoice(String _choice) {
      this._choice = _choice;
    }
    public String getChoice() {
      return _choice;
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
