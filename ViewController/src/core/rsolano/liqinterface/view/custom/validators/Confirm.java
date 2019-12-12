package core.rsolano.liqinterface.view.custom.validators;


import core.rsolano.liqinterface.view.utils.ADFUtils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class Confirm implements Validator {
    
    
    public Confirm() {
       
    }
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        String confirmPassword = component.getAttributes().get("attribute").toString();
        String password = value.toString();
        if(!password.equalsIgnoreCase(confirmPassword)){
            FacesMessage msg =  new FacesMessage("Error en contraseña.", "Las contraseñas no son iguales");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
