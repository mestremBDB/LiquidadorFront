package core.rsolano.liqinterface.view.backing;
import core.rsolano.liqinterface.view.custom.objects.DBTable;
import core.rsolano.liqinterface.view.utils.JSFUtils;
import javax.annotation.PostConstruct;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class Register {
    
    private DBTable[] tables = new DBTable[6];
    private String strTitle;
    private int widthTitle;
    private String sel_table;

    public Register() {
    }
    
    @PostConstruct
    public void init() {
        
        if(!JSFUtils.LoggedActive())
            return;
        
        tables[0] = new DBTable("LOG_ERRORESLIQ","LOG");
        tables[1] = new DBTable("LOG_ERRORESNOTIFICACION","LOG");
        tables[2] = new DBTable("LOG_INICIONOTIFICACION","LOG");
        tables[3] = new DBTable("LOG_REGISTROSERRADOS","LOG");
        tables[4] = new DBTable("HIST_ACTIVIDADES_PROCESOS","HIST");
        tables[5] = new DBTable("HIST_PROCESOS","HIST");
        
        sel_table = "log_errorresliq";
    }
    
    public void selectedTable(SelectionEvent selectionEvent) {
        // Add event code here...
        RowKeySet sel = selectionEvent.getAddedSet();
        String[] _paths = sel.toString().replace("[","").replace("]","").split(",");
        int index = Integer.parseInt(_paths[0]);
        
        switch(index){
            case 0:
                sel_table = "log_errorresliq";
                break;
            case 1:
                sel_table = "log_errorresnotificacion";
                break;
            case 2:
                sel_table = "log_inicionotificacion";
                break;
            case 3:
                sel_table = "log_resgistroserrados";
                break;
            case 4:
                sel_table = "hist_actividades_procesos";
                break;
            case 5:
                sel_table = "hist_procesos";
                break;
            default:
                break;
        }
         
    }
    
    public void setTables(DBTable[] tables) {
        this.tables = tables;
    }
    
    public DBTable[] getTables() {
        return tables;
    }
    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }
    public String getStrTitle() {
        return strTitle;
    }
    public void setWidthTitle(int widthTitle) {
        this.widthTitle = widthTitle;
    }
    public int getWidthTitle() {
        return widthTitle;
    }
    public void setSel_table(String sel_table) {
        this.sel_table = sel_table;
    }
    public String getSel_table() {
        return sel_table;
    }

}
