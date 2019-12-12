package core.rsolano.liqinterface.view.custom.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class None implements Validator  {
    
    None(){
        
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    
        if(false){
            FacesMessage msg =  new FacesMessage("none", "none");
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            throw new ValidatorException(msg);
        }
    }
}
