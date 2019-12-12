package core.rsolano.liqinterface.model.utils;

import core.rsolano.liqinterface.model.log.Log;
import cryptovault.facade.CryptoVaultNativeJavaFacade;
import cryptovault.facade.ICryptoVaultNativeJavaFacade;
import cryptovault.util.CryptoVaultConstant;
import cryptovault.util.returnMessages.CryptoVaultException;
import cryptovault.util.returnMessages.ReturnMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import org.apache.log4j.Logger;


import javax.crypto.Cipher;


public class CryptoVaultManager {
    private static Logger log = Log.getLogger(CryptoVaultManager.class);
    public String keyStroname;
    public String keyStropass;
    public String keyStroalias;
    public String keyStrlog;
    public String keyPGPanme;
    public String keyPGPpass;
    public String _path;
    
    
    public CryptoVaultManager(){
    }
    
    public CryptoVaultManager(String path){
        this._path = path;
    }
    public static String EncryptUtility(String Path, String sFile, String dFile, String Pub, boolean Cipher, boolean Cflag  ){

      ReturnMessage ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(Path));
      if (ret.getCode() != 200)
      {
        return "NOK";    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        if(Cipher)
          facade.setEncryptedPassword(true);
        
        facade.usePGPSecretKey(true);
        
        if(Cflag)
          ret = facade.encryptAndSignDocument(sFile, dFile, Pub, CryptoVaultConstant.ENVELOPE_PGP);
        else
          ret = facade.decryptVerifyEnvelopeAndVerifySender(sFile, dFile, Pub,CryptoVaultConstant.ENVELOPE_PGP);
        
        if(ret.getCode() == 200)
            return "OK";
        else
            return ret.getDescription();
      }
      catch (CryptoVaultException e)
      {
        System.out.println(e.getMessage()); 
        return e.getMessage();
      }  
    }
    
    public int CreateKeyStore(String dir, String password, String alias) 
    {
      char[] pass = password.toCharArray();
      ReturnMessage ret;
      this._path = dir;
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault.", e);
        return -3;
      }
      
      if (ret.getCode() != 200)
      {
        return -1;    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        ret = facade.createKeystore("user.p12", alias, pass,"CN=Empresa, OU=Empresa, O=Empresa, L=Bogota, ST=Cundinamarca, C=CO");
        if (ret.getCode() != 200)
        {
            log.error("Error creando almacén de llaves. Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
            return -4;    
        }
        return 0;
      }
      catch (CryptoVaultException e)
      {
        log.error("Error creando almacén de llaves.", e);
        return -2;
      }
    }
    
    public int RenewRecipient(String Name, String Pub){
      ReturnMessage ret;
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault.", e);
        return -3;
      }
      
      if (ret.getCode() != 200)
      {
        return -1;    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        ret = facade.renewRecipient(Name, Pub);
        if (ret.getCode() != 200)
        {
            log.error("Error configurando firma " + Name + "@" + Pub + " en llavero. " +
                "Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
            return -2;    
        }
        return 0;
      }
      catch (CryptoVaultException e)
      {
        log.error("Error renovando firma en llavero", e);
        return -2;
      }  
    }
    
    public int AddRecipient(String Name, String Pub){
      ReturnMessage ret;
      String Path = _path;
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(Path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault.", e);
        return -3;
      }
      
      if (ret.getCode() != 200)
      {
        return -1;    
      }
      try
      {
        if(!Path.endsWith(OSHelper.getSepatartor()))
          Path = Path + OSHelper.getSepatartor();
          
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        ret = facade.renewRecipient(Name.toLowerCase(), Path + Pub);
         
          
        if (ret.getCode() != 200)
        {
            log.error("Error agregando firma"+ Name + "@" + Pub + " al llavero. Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
            return -2;    
        }
        return 0;
      }
      catch (CryptoVaultException e)
      {
        log.error("Error agregando firma al llavero.", e);
        return -2;
      }  
    }
    
    public String[] GetRecipientList() {
     
      ReturnMessage ret;
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault.", e);
        return null;
      }
      
      if (ret.getCode() != 200)
      {
        return null;    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        return facade.listRecipientAliases();
      }
      catch (CryptoVaultException e)
      {
        log.error("Error agregando firma al llavero.", e);
        return null;
      } 
    }
    
    public int DeleteRecipient(String name) {
      ReturnMessage ret;
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault.", e);
        return -1;
      }
      
      if (ret.getCode() != 200)
      {
        return -2;    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        ret = facade.removeRecipient(name);
        if (ret.getCode() != 200)
        {
            return -2;    
        }  
        log.error("Error borrando firma " + name + " del llavero. Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
          
        return 0;
      }
      catch (CryptoVaultException e)
      {
        log.error("Error borrando firma del llavero.", e);
        return -3;
      }
    }
    
    public int CreateOrUpdatePGPKey(String name) 
    {
        boolean retvalue = false;
        String Path = _path;
        ReturnMessage ret;
        try{
          ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
        }
        catch(Exception e) {
          log.error("Error al instanciar instalación de CryptoVault", e);
          return -3;
        }
        
        if (ret.getCode() != 200)
        {
          return -1;    
        }
        try
        {
          ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
            
          if(!Path.endsWith(OSHelper.getSepatartor()))
            Path = Path + OSHelper.getSepatartor();
          
          ret = facade.updatePGPSecretKeyPath(Path + name);
          if (ret.getCode() != 200)
          {
              log.error("Error estableciendo la llave PGP " + name + ". Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
              return -2;    
          }
          return 0;
        }
        catch (CryptoVaultException e)
        {
          log.error("Error cambiando el password del almacén de llaves.", e); 
          return -2;
        }      
    }
    
    public int ChangePgpPassKey(String key, boolean Cipher){
      char[] new_pass = key.toCharArray();
      ReturnMessage ret;
      
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault", e);
        return -3;
      }
      
      if (ret.getCode() != 200)
      {
        return -1;    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        if(Cipher)
          facade.setEncryptedPassword(true);
        
        ret = facade.updatePGPSecretKeyPassword(new_pass);
          
        if (ret.getCode() != 200)
        {
            log.error("Error cambiando el password de la llave privada PGP. Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
            return -2;    
        }  
        return 0;
      }
      catch (CryptoVaultException e)
      {
        log.error("Error cambiando el password de la llave privada PGP.", e); 
        return -2;
      }  
    }
    
    public int ChangePassKeyStrore(String OldPass, String NewPass, boolean Cipher){
      char[] new_pass = NewPass.toCharArray();
      char[] old_pass = OldPass.toCharArray();
      ReturnMessage ret;
      try{
        ret = CryptoVaultNativeJavaFacade.initApplicationEnvironment(new File(_path));
      }
      catch(Exception e) {
        log.error("Error al instanciar instalación de CryptoVault", e);
        return -3;
      }
      
      if (ret.getCode() != 200)
      {
        return -1;    
      }
      try
      {
        ICryptoVaultNativeJavaFacade facade = CryptoVaultNativeJavaFacade.getInstance();
        if(Cipher)
          facade.setEncryptedPassword(true);
          
        ret = facade.changePrivateKeyPassword(old_pass, new_pass);
        if (ret.getCode() != 200)
        {
            log.error("Error cambiando el password del almacén de llaves. Cod: " + ret.getCode() + "Des: "+ ret.getDescription());
            return -2;    
        }
        return 0;
      }
      catch (CryptoVaultException e)
      {
        log.error("Error cambiando el password del almacén de llaves.", e); 
        return -2;
      }
    }
    
    public class CustomFilter implements FilenameFilter {
      String _ex, _ig;
      public CustomFilter(String ex, String ig) {
        this._ex = ex;
        this._ig = ig;
      }
      public boolean accept(File dir, String name) 
      {
        String current_file = name.toLowerCase();
        if (current_file.endsWith(_ex) && !current_file.contains(_ig) )
              return true;
        else  
            return false;
      }   
    }
    public String[] getPGPkeys(String extension, String ignore)
    {
      String Path = _path;
      String[] KeysFiles;
      File f = new File(Path);
      FilenameFilter textFilter = new CustomFilter(extension, ignore);
      File[] files;
      int count = 0;
      
      files = f.listFiles(textFilter);
      
      if(files.length > 0)
      {
        KeysFiles = new String[files.length];
      
        for (File file : files) 
        {
          if (!file.isDirectory()) 
          {
            String match = Path.toLowerCase().endsWith(OSHelper.getSepatartor()) ? file.getName().replace(Path.toLowerCase(), "").replace(Path, "").replace(OSHelper.getSepatartor(), "") :
                          file.getName().replace(Path.toLowerCase(), "").replace(Path, "");
            KeysFiles[count] = match;
            count++;
          }
        }
      }
      else 
      {
        KeysFiles = new String[2];
        KeysFiles[0] = " ";
        KeysFiles[1] = "ninguna llave";
      }
      return KeysFiles;
    }
    
      public boolean updateCfgParamvalues() 
      {
        String Path = _path;
        BufferedReader br = null;
        FileReader reader = null;
        boolean retval = false;
        
        String logger = "";
        try {
            
            reader = new FileReader(Path.endsWith(OSHelper.getSepatartor()) ? Path + "keystore.cfg" : Path + OSHelper.getSepatartor() + "keystore.cfg" );
            br = new BufferedReader(reader);
            String line;
            
            keyStroname = null;
            keyStropass = null;
            keyStroalias = null;
            keyStrlog = null;
            keyPGPanme = null;
            keyPGPpass = null;
            
            while ((line = br.readLine()) != null) 
            {
                if(!line.startsWith("#") && line != null && line != "") 
                {
                  if(line.contains("keystore="))  
                    keyStroname = line.replaceAll("keystore=","");
                  else if(line.contains("password="))
                    keyStropass = line.replaceAll("password=","");
                  else if(line.contains("alias="))
                    keyStroalias = line.replaceAll("alias=","");
                  else if(line.contains("logPath="))
                    keyStrlog = line.replaceAll("logPath=","");
                  else if(line.contains("pgpSecKey=")){
                    keyPGPanme = line.replaceAll("pgpSecKey=","");
                    log.info("Nombre llave privada PGP: " + keyPGPanme);
                  }
                  else if(line.contains("pgpSecKeyPassword="))
                    keyPGPpass = line.replaceAll("pgpSecKeyPassword=","");
                  
                  
                }
            }
            reader.close();
            retval = true;
        }
        catch (IOException ex) 
        {
          log.error("Error abriendo keystore.cfg. ", ex);
          retval = false;
        }
        return retval;
      }
    
      public void setKeyStroname(String keyStroname) {
          this.keyStroname = keyStroname;
      }
      public String getKeyStroname() {
          return keyStroname;
      }
      public void setKeyStropass(String keyStropass) {
          this.keyStropass = keyStropass;
      }
      public String getKeyStropass() {
          return keyStropass;
      }
      public void setKeyPGPanme(String keyPGPanme) {
          this.keyPGPanme = keyPGPanme;
      }
      public String getKeyPGPanme() {
          return keyPGPanme;
      }
      public void setKeyPGPpass(String keyPGPpass) {
          this.keyPGPpass = keyPGPpass;
      }
      public String getKeyPGPpass() {
          return keyPGPpass;
      }
      public void setPath(String _path) {
          this._path = _path;
      }
      public String getPath() {
          return _path;
      }

      public void setKeyStroalias(String keyStroalias) {
          this.keyStroalias = keyStroalias;
      }

      public String getKeyStroalias() {
          return keyStroalias;
      }
}
