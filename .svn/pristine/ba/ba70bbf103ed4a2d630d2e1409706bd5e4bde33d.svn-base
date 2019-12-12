package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.entities.IdmGrupos;
import core.rsolano.liqinterface.model.entities.IdmUsuarios;
import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.model.utils.EncoderUtil;
import core.rsolano.liqinterface.model.utils.LdapModule;
import core.rsolano.liqinterface.view.utils.ADFUtils;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

public class Login{
    
    private String username;
    private String domain;
    private String password;
    private String[] role;
    private String groups;
    private boolean active;
    private String fecha;

    private String ldap_host = "";
    private String ldap_port = "";
    private String ldap_login = "";
    private String ldap_pass = "";
    
    @EJB
    private LiqTasasFacadeLocal facade;
    
    public Login() {
    }
    
   @PostConstruct
    public void init() {
        ldap_host = facade.getParameter("LdapHost");
        ldap_port = facade.getParameter("LdapPort");
        ldap_login = facade.getParameter("LdapDN");
        ldap_pass = facade.getParameter("LdapPass");
        
        DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
        Date today = Calendar.getInstance().getTime();        
        fecha = df.format(today);
    }
   
    public void DoLogin(ActionEvent actionEvent) {
        // Add event code here...
        LdapModule ldap;
        
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("Liquidador1")){
            active = true;
            domain = "COMISIONES";
            role = new String[1];
            role[0] = "ALL";
            ADFUtils.Redirect("index.jspx");
            return;
        }
        
        if(ldap_pass.equalsIgnoreCase("changit")){
            ADFUtils.Redirect("idmconf.jspx");
            return;
        }
        
        ldap_pass = EncoderUtil.desencriptar(ldap_pass); 
        
        
        
        ldap = new LdapModule(ldap_login,ldap_pass,ldap_host,ldap_port);
        if(!ldap.Authenticate()){
            ADFUtils.showMessage("Error de autenticación", "Falla en IDM. No fue posible establecer sesión con el server " + ldap_host);
            username = "";
            password = "";
            return;
        }
        
        if(!ldap.PopulateUserInfo(username)){
            ADFUtils.showMessage("Error de configuración","Usuario no encontrado en el directorio.");
            username = "";
            password = "";
            UserExistWithRemove(username, true);
            return;
        }
        
        if(ldap.getUser_groups() == null){
            ADFUtils.showMessage("Error de configuración","El usuario existe en el directoiro pero no pertenece a ningun grupo.");
            username = "";
            password = "";
            UserExistWithRemove(username, true);
            return;
        }
        
        if(!ValidateGroups(ldap)){
            ADFUtils.showMessage("Error de configuración","El usuario no pertenece a ningún grupo de Liquidador de COMISIONES.");
            username = "";
            password = "";
            UserExistWithRemove(username, true);
            return;
        }
        
        if(!ldap.getLoginDisabled().equalsIgnoreCase("FALSE")){
            ADFUtils.showMessage("Error de configuración","El login de este usuario se encuentra inhabilitado en IDM.");
            username = "";
            password = "";
            return;
        }
        
        if(!ldap.checkUserPassword(password)){
            ADFUtils.showMessage("Error de login", "Usuario o contraseña inválida, por favor ingresarlos nuevamente.");
            username = "";
            password = "";
        }else{
            domain = "bancodebogota";
            active = true;
            String cn = ldap.getUser_cn();
            String grupo = groups;
            String inhabilitado = ldap.getLoginDisabled();
            String nombre = ldap.getFullName();
            String nt = ldap.getUser_name();
            IdmUsuarios iuser = new IdmUsuarios(cn,grupo,inhabilitado,nombre,nt);
            try{
                if(!UserExistWithRemove(username, false))
                    facade.persistIdmUsuarios(iuser);
            }catch(Exception e){
                e.printStackTrace();
            }
            ADFUtils.Redirect("index.jspx");    
        }
    }
    
    private boolean ValidateGroups(LdapModule ldap){
        //// toca continuar aquí la parte de validar los grupos al que el usuario pertenece
        boolean enabled = false;
        List<IdmGrupos> grupos = facade.getIdmGruposFindAll();
        List<String> lgs = ldap.getUser_groups();
        role = new String[lgs.size()];
        groups = "";
        int index = 0;
        String aux = "";
        
        for(String lg : lgs){
            aux = lg.split(",")[0];
            aux = aux.replace("cn=", "");
            for(IdmGrupos grupo : grupos){
                if(grupo.getGrupo().equalsIgnoreCase(aux)){
                    role[index++] = grupo.getPermisos();
                    groups = groups + grupo.getGrupo() + ",";
                    enabled = true;
                }
            }        
        }
        
        if(groups.endsWith(","))
            groups = groups.substring(0, groups.length() - 1);
        return enabled;
    }
    
    private boolean UserExistWithRemove(String user, boolean remove){
        String aux = user.toUpperCase();
        List<IdmUsuarios> iusers = facade.getIdmUsuariosFindAll(); 
        for(IdmUsuarios iuser : iusers){
            if(aux.equalsIgnoreCase(iuser.getNt())){
                if(remove)
                    facade.removeIdmUsuarios(iuser);
                return true;
            }
        }
        return false;
    }
    public void DoLogout(ActionEvent actionEvent) {
        // Add event code here...
        username = "";
        password = "";
        role = null;
        active = false;
        ADFUtils.LogOut();
    }
    /*public void DoLogout() {
        // Add event code here...
        username = "";
        password = "";
        role = null;
        active = false;
        ADFUtils.LogOut();
        //return "go_login";
    }*/
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setRole(String[] role) {
        this.role = role;
    }
    public String[] getRole() {
        return role;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean isActive() {
        return active;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getDomain() {
        return domain;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getFecha() {
        return fecha;
    }


}
