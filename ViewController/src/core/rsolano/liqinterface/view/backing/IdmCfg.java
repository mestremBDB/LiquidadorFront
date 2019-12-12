package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.EncoderUtil;

import core.rsolano.liqinterface.model.utils.LdapModule;

import core.rsolano.liqinterface.view.utils.ADFUtils;

import javax.annotation.PostConstruct;

import javax.ejb.EJB;

import javax.faces.event.ActionEvent;

public class IdmCfg {
    
    private String password;
    private String confirm;
    private String query;
    
    private String ldap_host = "";
    private String ldap_port = "";
    private String ldap_login = "";
    private String ldap_pass = "";
    
    
    @EJB
    private LiqTasasFacadeLocal facade;
    
    public IdmCfg() {
    }
    
    @PostConstruct
     public void init() {
        ldap_host = facade.getParameter("LdapHost");
        ldap_port = facade.getParameter("LdapPort");
        ldap_login = facade.getParameter("LdapDN");
        ldap_pass = facade.getParameter("LdapPass");
    }
    
    public void DoLogin(ActionEvent actionEvent) {
        
        if(!ldap_pass.equalsIgnoreCase("changit")){
            ADFUtils.Redirect("login.jspx");
            return;
        }
        
        if(!password.equalsIgnoreCase(confirm)){
            ADFUtils.showMessage("Error de contraseña","Los campos de contraseña y confirmación no son iguales");
            confirm = "";
            password = "";
            return;
        }
        
        LdapModule ldap = new LdapModule(ldap_login,password,ldap_host,ldap_port);
        
        if(!ldap.Authenticate()){
            ADFUtils.showMessage("Error de autenticación", "El password de IDM loginDN es incorrecto");
            confirm = "";
            password = "";
            return;
        }
        ldap.Disconnect();
        
        password = EncoderUtil.encriptar(password);
        facade.updateParameter("LdapPass", password);
        ADFUtils.LogOut();
    }    
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getConfirm() {
        return confirm;
    }
}
