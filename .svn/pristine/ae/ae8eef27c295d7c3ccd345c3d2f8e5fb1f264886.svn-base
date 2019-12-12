package core.rsolano.liqinterface.model.utils;

import core.rsolano.liqinterface.model.entities.ConfSqlloader;
import java.io.File;

public class LoaderHelper {
    
    public static String[] TestSQLloader(ConfSqlloader cfg, String test_file){
        
        String ldr_inspath = "";
        String ldr_srcfile = "";
        String ldr_dsnname = "";
        String ldr_strpass = "";
        String ldr_ctlfile = "";
        String ldr_logfile = "";
        String ldr_badfile = "";
        String ldr_disfile = "";
        String ldr_usrname = "";
        String ldr_command;
        
        ldr_inspath = cfg.getInstallRoot();
        ldr_srcfile = cfg.getInfileRoot().endsWith(OSHelper.getSepatartor()) ? cfg.getInfileRoot() : cfg.getInfileRoot() + OSHelper.getSepatartor();
        ldr_dsnname = cfg.getNdatabase();
        ldr_strpass = cfg.getPassword();
        ldr_ctlfile = cfg.getControlRoot();
        ldr_logfile = cfg.getLogfileRoot();
        ldr_badfile = cfg.getLogfileRoot().replace(".log",".bad");
        ldr_disfile = cfg.getLogfileRoot().replace(".log",".dis");
        ldr_usrname = "userid=" + cfg.getUsername() + "/" + ldr_strpass + "@" + ldr_dsnname;
        ldr_command = "";
        
        ldr_command = "sqlldr " + ldr_usrname + ",data=" + ldr_srcfile + test_file + ",control=" +  ldr_ctlfile + 
                      ",log=" + ldr_logfile + ",bad=" + ldr_badfile + ",discard=" + ldr_disfile;
        
        String[] ret = OSHelper.ExcuteCommand(ldr_command, ldr_inspath);
        
        File log = new File(ldr_logfile);
        File bad = new File(ldr_badfile);
        File dis = new File(ldr_disfile);
        File src = new File(ldr_srcfile);
        
            
        if(log.exists()){
            log.delete();
        }
        if(bad.exists()){
            bad.delete();
        }
        if(dis.exists()){
            dis.delete();
        }
        return ret;
    }
    
}
