package core.rsolano.liqinterface.view.managed;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import org.apache.myfaces.trinidad.model.RowKeySet;
import oracle.adf.view.rich.component.rich.input.RichInputText;

public class SelectDriveBean implements Serializable {
    
    private RowKeySet selected;
    private List<SelectItem> _driveLetter;
    private String _choice;
    boolean _driveActive;
    File[] roots;
    String _directory;
    RichTable table;
    RichInputText txtinput;
    
    private String dir;

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }


    public List<SelectItem> getDriveLetter() {
        if(_driveLetter == null) 
        {
          _driveLetter = new ArrayList<SelectItem>();
          
          for(File root : roots)
            _driveLetter.add(new SelectItem(root));
        }
        return _driveLetter;
    }
    
    public void setDriveActive(boolean driveActive) {
        this._driveActive = driveActive;
    }

    public boolean isDriveActive() {
        return _driveActive;
    }
    public void setChoice(String _choice) {
        if(!_choice.equalsIgnoreCase(this._choice))
            _directory = "";
        this._choice = _choice;
    }

    public String getChoice() {
        return _choice;
    }
    
    public void setDirectory(String _directory) {
        this._directory = _directory;
        selected = table.getSelectedRowKeys();
        selected.clear();
        dir = _choice + _directory;
        AdfFacesContext.getCurrentInstance().addPartialTarget(table);
        AdfFacesContext.getCurrentInstance().addPartialTarget(txtinput);
    }

    public String getDirectory() {
        return _directory;
    }
    
    public void setTable(RichTable table) {
        this.table = table;
    }

    public RichTable getTable() {
        return table;
    }
    
    public void setSelected(RowKeySet selected) {
        this.selected = selected;
    }

    public RowKeySet getSelected() {
        return selected;
    }
    
    public void setTxtinput(RichInputText txtinput) {
        this.txtinput = txtinput;
    }

    public RichInputText getTxtinput() {
        return txtinput;
    }

    public SelectDriveBean() {
        roots = File.listRoots();
        _directory = "";
    }
    
    public void setDriveLetter(List<SelectItem> _driveLetter) {
        this._driveLetter = _driveLetter;
    }

}
