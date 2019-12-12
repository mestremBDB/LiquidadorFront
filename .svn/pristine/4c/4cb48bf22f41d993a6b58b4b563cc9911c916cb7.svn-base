package core.rsolano.liqinterface.view.managed;
import core.rsolano.liqinterface.model.utils.FileSystem;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.backing.CreateKeystore;
import core.rsolano.liqinterface.view.utils.JSFUtils;
import java.io.File;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;


public class FileSystemBean implements Serializable {
    
    //Variables para manejar select drive y su sctive
    FileSystem[] fsb;
    File[] roots;
    String _choice;
    String _directory;
    String _path;
    private SelectDriveBean drive;
    
    public FileSystemBean() {
        roots = File.listRoots();
    }
    
    @PostConstruct
    public void init() {
        
        drive = (SelectDriveBean)JSFUtils.getManagedBeanValue("sessionScope.drive");
        _choice = drive.getChoice();
        _directory = drive.getDirectory();
        _path = _choice + _directory;
        
        
        if(_choice != null){
            fsb = OSHelper.getDirectoryInfo(_path);
        }
        else
        {
            fsb = OSHelper.getDirectoryInfo(roots[0].toString());
        }
    }
    
    public void SelectRow(SelectionEvent event){
        RowKeySet sel = event.getAddedSet();
        String[] _paths = sel.toString().replace("[","").replace("]","").split(",");
        int index = Integer.parseInt(_paths[0]);
        if(index == 0)
            _directory = OSHelper.GoBackDirectory(_directory);
        else{
             _directory =  OSHelper.GoIntoDirectory(_choice, _directory, fsb[index].getName());
        }
        drive.setDirectory(_directory);
    }
    
    
    public void setFsb(FileSystem[] fsb) {
        this.fsb = fsb;
    }

    public FileSystem[] getFsb() {
        return fsb;
    }
}
