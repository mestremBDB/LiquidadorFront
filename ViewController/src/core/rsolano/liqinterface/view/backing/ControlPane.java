package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.facades.LiqTasasFacadeLocal;
import core.rsolano.liqinterface.view.custom.objects.DBTable;
import core.rsolano.liqinterface.view.custom.objects.GenericTable;
import core.rsolano.liqinterface.view.utils.ADFUtils;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.annotation.PostConstruct;

import javax.ejb.EJB;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.render.ClientEvent;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class ControlPane {
    
    private DBTable[] tables = new DBTable[15];
    private String sel_table;
    private String myQuery;

    private GenericTable genericTable;
    
    @EJB
    private LiqTasasFacadeLocal facade;
    
    public ControlPane() {
    }
    
    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
        
        tables[0] = new DBTable("APP_APLICACIONES","APP");
        tables[1] = new DBTable("APP_ARCHIVOS","APP");
        tables[2] = new DBTable("APP_ARCHIVOSAPLICACIONES","APP");
        tables[3] = new DBTable("APP_CAMPOSPROCESOLIQ","APP");
        tables[4] = new DBTable("APP_HERRAMIENTAS","APP");
        tables[5] = new DBTable("CONF_DIASFESTIVOS","CONF");
        tables[6] = new DBTable("CONF_GRUPOSCORREO","CONF");
        tables[7] = new DBTable("CONF_HERRAMIENTASAPPS","CONF");
        tables[8] = new DBTable("CONF_PARAMETROSLIQUIDADOR","CONF");
        tables[9] = new DBTable("CONF_RECEPTORESCORREOS","CONF");
        tables[10] = new DBTable("CONF_USUARIOS","CONF");
        tables[11] = new DBTable("NOTIF_ACTIVIDADES","NOTIF");
        tables[12] = new DBTable("NOTIF_ACTIVIDAD_PROCESO","NOTIF");
        tables[13] = new DBTable("NOTIF_PROCESO","NOTIF");
        tables[14] = new DBTable("TASK_FILESLOADER","TASK");
        
        genericTable = new GenericTable();
    }
    
    public void QueryToDatabase(ActionEvent actionEvent) {
        // Add event code here...
        
        if(!JSFUtils.getUserName().equalsIgnoreCase("admin")){
            ADFUtils.showMessage("Error","No es posible ejecutar consultas.");
            return;
        }
            
        if(myQuery.startsWith("select") || myQuery.startsWith("SELECT") ){
            String line, aux;            
            List<String> columnsQuery = null;
            List<Object[]> result = null;                                 
            
            try{
                result = facade.getSQLQuery(myQuery);
                columnsQuery = getSelectedTableColumns(myQuery);
            }catch(Exception e){
                myQuery = "Error en consulta";
                ADFUtils.showMessage("Error","ERROR: " + e.getMessage());
                return;
            }
            
            System.out.println("Clave consulta liquidador");
            System.out.println(myQuery);
            
            if(result.size() < 1){
                myQuery = myQuery + "\n\n" + "no hay resultados";
                return;
            }
            
            boolean array_flag;
            try{
                Object verify = result.get(0);
                if(verify instanceof Object[]){
                    array_flag = true;
                }
                else{
                    array_flag = false;    
                }                
            }catch(Exception e){
                array_flag = false;
            }
            
            if(array_flag){
                for(Object[] objs : result){
                    line = "|";
                    for(Object obj : objs){                        
                        aux = obj != null ? obj.toString() : "null";
                        line = line + aux + "|"; 
                    }                    
                    System.out.println(line);
                }              
                genericTable = new GenericTable(result, columnsQuery);
            }else{
                for(Object obj : result){
                    aux = obj != null ? obj.toString() : "null";
                    System.out.println("|" + aux + "|");
                }
                genericTable = new GenericTable(result, columnsQuery);
            }
            
            myQuery = myQuery + "\n\n" + "Consula ejecutada." ;
            sel_table = "genericTable";
        }else{
            
            String result = ""; 
            String iterator = "";
            
            try{
                result = facade.ExecuteQueryUpdate(myQuery); 
            }catch(Exception e){
                myQuery = "Error en consulta";
                ADFUtils.showMessage("Error","ERROR: " + e.getMessage());
                return;
            }
            
            if(result.startsWith("error.")){
                ADFUtils.showMessage("Error",result.replace("error.", ""));
            }else{
                iterator = GetTableIterator(myQuery);
                myQuery = myQuery + "\n\n" + "Transacción ejecutada correctamente " + result.replace("success.","") + " filas actualizadas";
                ADFUtils.RefreshIterator(iterator);
            }
        }
    }
    
    
 
    public void selectedTable(SelectionEvent selectionEvent) {
        // Add event code here...
        RowKeySet sel = selectionEvent.getAddedSet();
        String[] _paths = sel.toString().replace("[","").replace("]","").split(",");
        int index = Integer.parseInt(_paths[0]);
        
        
        switch(index){
            case 0:
                sel_table = "app_aplicaciones"; break;
            case 1:
                sel_table = "app_archivos"; break;
            case 2:
                sel_table = "app_archivosaplicaciones"; break;
            case 3:
                sel_table = "app_camposprocesoliq"; break;
            case 4:
                sel_table = "app_herramientas"; break;
            case 5:
                sel_table = "conf_diasfestivos"; break;
            case 6:
                sel_table = "conf_gruposcorreo"; break;
            case 7:
                sel_table = "conf_herramientasapps"; break;
            case 8:
                sel_table = "conf_parametrosliquidador"; break;
            case 9:
                sel_table = "conf_receptorescorreos"; break;
            case 10:
                sel_table = "conf_usuarios"; break;
            case 11:
                sel_table = "notif_actividades"; break;
            case 12:
                sel_table = "notif_actividad_proceso"; break;
            case 13:
                sel_table = "notif_proceso"; break;
            case 14:
                sel_table = "task_filesloader"; break;
            default:
                break;
        }
    }
    
    public String GetTableIterator(String query){
        
        String name = "";
        String schema = "";
        String regex = query;
        
        if(regex.startsWith("INSERT TABLE "))
            regex = regex.replace("INSERT TABLE ", ""); 
        else if(regex.startsWith("insert table "))
            regex = regex.replace("insert table ", "");
        else if(regex.startsWith("INSERT "))
            regex = regex.replace("INSERT ", "");
        else if(regex.startsWith("insert "))
            regex = regex.replace("insert ", "");
        else if(regex.startsWith("UPDATE"))
            regex = regex.replace("UPDATE ", "");
        else if(regex.startsWith("update "))
            regex = regex.replace("update ", "");
        else
            return "no_refresh";
        
        
        for(int index = 0; index < tables.length; index++){
            name = tables[index].getName();
            schema = tables[index].getSchema();
            if(regex.toUpperCase().startsWith(name)){
                regex = name.replace(schema,"").replace("_", "");
                regex =  schema.toLowerCase() + regex.substring(0, 1) + regex.substring(1).toLowerCase() + "FindAllIterator";
            }
        }
        
        if(regex.endsWith("FindAllIterator"))
            return regex;
        else
            return "no_refresh";
    }
    
    public List<String> getSelectedTableColumns(String query){
            List<String> columnas = new ArrayList<String>();
            
            String table = query.substring(query.toLowerCase().indexOf("from ") + 5);
            table = table.contains(" ") ? table.substring(0, table.indexOf(" ")) : table;
            if (query.contains("select * from")) {
                String columnsQuery =
                    "SELECT column_name FROM user_tab_cols " + "WHERE UPPER(table_name) = '" + table.toUpperCase() + "'"
                    + " order by  internal_column_id";
    
                List<Object[]> columns = facade.getSQLQuery(columnsQuery);
                for (Object column : columns) {
                    columnas.add(column.toString());
                }
            }
            else{
                String filteredColummns = query.substring(query.indexOf(" ") + 1, query.toLowerCase().indexOf("from"));
                String[] cols = filteredColummns.split(",");
                for(String col: cols){
                    columnas.add(col.trim().toUpperCase());
                }
            }
            return columnas;
        }
    public void setTables(DBTable[] tables) {
        this.tables = tables;
    }

    public DBTable[] getTables() {
        return tables;
    }
    
    public void setSel_table(String sel_table) {
        this.sel_table = sel_table;
    }

    public String getSel_table() {
        return sel_table;
    }

    public void setMyQuery(String myQuery) {
        this.myQuery = myQuery;
    }
    
    public String getMyQuery() {
        return myQuery;
    }
    
    public void setGenericTable(GenericTable genericTable) {
        this.genericTable = genericTable;
    }
    
    public GenericTable getGenericTable() {
        return genericTable;
    }

    public void CleanQuery(ActionEvent actionEvent) {
        // Add event code here...
        myQuery = "";
    }
}
