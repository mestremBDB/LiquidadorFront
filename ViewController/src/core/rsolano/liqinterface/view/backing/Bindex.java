package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.view.utils.JSFUtils;
import javax.annotation.PostConstruct;

public class Bindex {
    public Bindex() {
    }
    
    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
    }
    
    public String GoToControl()
    {
        if(RouteAnalize("CONTROL"))
            return "go_control";
        else
            return "go_message";
    }
    
    public String GoToSecurity()
    {
        if(RouteAnalize("SECURITY"))
            return "go_security";
        else
            return "go_message";
        
    }
    
    public String GoToReports()
    {
        if(RouteAnalize("REPORTS"))
            return "go_reports";
        else
            return "go_message";
    }
    
    public String GoToRegistroContingencia()
    {
        if(RouteAnalize("REGISTRO_CONTINGENCIA"))
            return "go_registro_contingencia";
        else
            return "go_message";
    }
    
    boolean RouteAnalize(String page){
        String[] grants = JSFUtils.getUserRole();
        String[] pages;
        
        for(int i = 0; i < grants.length; i++){
            pages = grants[i].toUpperCase().split(",");
            for(int j = 0; j < pages.length; j++){
                if(pages[j].equalsIgnoreCase("ALL") || pages[j].equalsIgnoreCase(page))
                    return true;
            }
        }
        return false;
    }
}
