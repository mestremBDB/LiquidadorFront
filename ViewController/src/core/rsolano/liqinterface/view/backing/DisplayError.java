package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.view.utils.JSFUtils;
import javax.annotation.PostConstruct;

public class DisplayError {
    public DisplayError() {
    }
    @PostConstruct
    public void init() {
        if(!JSFUtils.LoggedActive())
            return;
    }
    
    public String GoToIndex()
    {
        return "go_index";
    }
}
