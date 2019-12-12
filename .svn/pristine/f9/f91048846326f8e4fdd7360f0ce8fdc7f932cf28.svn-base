package core.rsolano.liqinterface.view.utils;

import core.rsolano.liqinterface.model.log.Log;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import oracle.adf.controller.ControllerContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.adf.model.AttributeBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;
import oracle.jbo.Row;
import org.apache.log4j.Logger;


public class ADFUtils {
    
    private static Logger log = Log.getLogger(ADFUtils.class);
    
    public ADFUtils() {
    }
    
    public static void ReloadPage(){
        FacesContext fctx = FacesContext.getCurrentInstance();
        String page = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, page);
        UIV.setViewId(page); fctx.setViewRoot(UIV);
    }
    
    public static String GetBindingValue(String binding){
        BindingContainer bindings = null;
        AttributeBinding attr = null;
        String attribute = "";
        try{
            bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
            attr = (AttributeBinding)bindings.getControlBinding(binding);  
            attribute = attr.getInputValue().toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return attribute; 
    }
    
    public static String SetBindingValue(String binding, String value){
        BindingContainer bindings = null;
        AttributeBinding attr = null;
        String attribute = "";
        try{
            bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
            attr = (AttributeBinding)bindings.getControlBinding(binding);  
            attr.setInputValue(value);
        }catch(Exception e){
            e.printStackTrace();
        }
        return attribute; 
    }
    
    public static void ExecuteMethodParam(String name_method, String param, String value){
        BindingContainer bindings = null;
        OperationBinding method = null;
        try{
            bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
            method = bindings.getOperationBinding(name_method);  
            Map paramsMap = method.getParamsMap();  
            paramsMap.put(param,value);        
            method.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            List errors = method.getErrors();
            for(Object error : errors)
                log.error(error);    
        }
    }
    
    public static void ExecuteBindMethod(String name_method){
        BindingContainer bindings = null;
        OperationBinding method = null;
        try{
            bindings = BindingContext.getCurrent().getCurrentBindingsEntry(); 
            method = bindings.getOperationBinding(name_method);  
            method.execute();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            List errors = method.getErrors();
            for(Object error : errors)
                log.error(error);    
        }
    }
    
    public static Row[] GetDataTable(String bindTable){
        DCBindingContainer dcBindings = null;
        FacesCtrlHierBinding treeData = null;
        try{
            dcBindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
            treeData = (FacesCtrlHierBinding)dcBindings.getControlBinding(bindTable); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return treeData.getAllRowsInRange();    
    }
    
    public static String GetAttributeFromIterator(String iterator, String attr){
        DCBindingContainer dcBindings = null;
        DCIteratorBinding iterBind = null;
        String attribute = "";
        try{
            dcBindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
            iterBind = (DCIteratorBinding)dcBindings.get(iterator); 
            attribute = (String)iterBind.getCurrentRow().getAttribute(attr);
        }catch(Exception e){
            e.printStackTrace();
        }
        log.equals(iterBind.getError().getMessage());    
        return attribute; 
    }
    
    public static Row[] GetAllIteratorRow(String iterator){
        DCBindingContainer dcBindings = null;
        DCIteratorBinding iterBind = null;
        Row[] rows = null;
        try{
            dcBindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
            iterBind = (DCIteratorBinding)dcBindings.get(iterator); 
            rows = iterBind.getAllRowsInRange();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(iterBind.getError() != null){
                log.equals(iterBind.getError().getMessage());    
            }
        return rows; 
        /* TestData dataRow = null; for (Row row : rows) { dataRow = (TestData)((DCDataRow)row).getDataProvider(); */
    }
    
    public static void RefreshIterator(String iterator){
        // refresh the iterator  
        DCBindingContainer dcBindings = null;
        DCIteratorBinding iterBind = null;
        try{
            dcBindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry(); 
            iterBind = (DCIteratorBinding)dcBindings.get(iterator); 
            dcBindings.refreshControl();  
            iterBind.executeQuery();  
            iterBind.refresh(DCIteratorBinding.RANGESIZE_UNLIMITED); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static String showMessage(String sum, String msg) {
        FacesMessage fm = new FacesMessage();
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        fm.setSummary(sum);
        fm.setDetail(msg);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        return null;
    }
    
    public static void Redirect(String view){
        FacesContext fctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = fctx.getExternalContext();
        ControllerContext controllerCtx = null;
        controllerCtx = ControllerContext.getInstance();
        String activityURL = controllerCtx.getGlobalViewActivityURL(view);
        try{
            ectx.redirect(activityURL);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void LogOut(){
        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession)ectx.getSession(false);
        session.invalidate();
        Redirect("login.jspx");
        //requestContext.getPageFlowScope().clear();
    }
}
