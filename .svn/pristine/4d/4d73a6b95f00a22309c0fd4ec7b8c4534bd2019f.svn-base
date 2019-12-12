package core.rsolano.liqinterface.model.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class OSHelper {
    
    public OSHelper() {
    }
    
    public static String[] ExcuteCommand(String Cmd, String directorio){
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        String line = "";
        String retvalue = "";
        String cmd = Cmd;
        
        String[] Response = new String[4];
        
        try{
            
            System.out.println(cmd);
            System.out.println(directorio);
            
            if(System.getProperty("os.name").contains("Windows")){
                p = rt.exec("cmd.exe /c " + cmd,null,new File(directorio));
            }else{
                p = rt.exec(cmd,null,new File(directorio));
            }
            
            StreamInfo output = new StreamInfo(p.getInputStream(), "OUTPUT");
            Response[2] = output.run();
            StreamInfo error = new StreamInfo(p.getErrorStream(), "ERROR");  
            Response[3] = error.run();
            Response[1] = Integer.toString(p.waitFor());
            Response[0] = "2";
            
            return Response;
        }catch (IOException e){
            Response[0] = "3";
            Response[1] = p != null ? Integer.toString(p.exitValue()) : "-200";
            Response[2] = "ERROR";
            Response[3] = e.getMessage();
            e.printStackTrace();
            return Response;
        }catch(InterruptedException ex){
            Response[0] = "3";
            Response[1] = p != null ? Integer.toString(p.exitValue()) : "-200";
            Response[2] = "ERROR";
            Response[3] = ex.getMessage();
            ex.printStackTrace();
            return Response;
        }catch(Exception ef){
            Response[0] = "3";
            Response[1] = p != null ? Integer.toString(p.exitValue()) : "-200";
            Response[2] = "ERROR";
            Response[3] = ef.getMessage();
            ef.printStackTrace();
            return Response;
        }
    }
    
    public static String getSepatartor() {
        if(System.getProperty("os.name").contains("Windows"))
            return "\\";
        else
            return "/";
    }
    
    public static String getServerName() {
        String Host = "";
        try{
            Host = InetAddress.getLocalHost().getHostName();
            return Host;
        }catch(UnknownHostException e){
            return "ERROR";    
        }
    }
    
    public static String getServerUser(){
        String user;
        try{
            return System.getProperty("user.name"); 
        }catch(Exception e){
            e.printStackTrace();
            return "anonymous";
        }
    }
        
    
    public static String getSystemOS() {
        if(System.getProperty("os.name").contains("Windows"))
            return "WINDOWS";
        else
            return "LINUX";
    }
    
    public static FileSystem[] getDirectoryInfo(String path){
        FileSystem[] fs;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        fs = new FileSystem[listOfFiles.length + 1];
        
        fs[0] = new FileSystem("...","","","","/images/folder-icon.png");
        
        for (int i = 1; i < fs.length; i++) {
          String name = listOfFiles[i - 1].getName();
          String size = getFileSize(listOfFiles[i - 1]);
          String date = getlastModified(listOfFiles[i - 1]);
          String type = getFileExtension(listOfFiles[i - 1]);
          String icon = getIcon(type); 
            
          if (listOfFiles[i - 1].isFile()) {
              fs[i] = new FileSystem(name,size,date,type,icon);
          } else if (listOfFiles[i - 1].isDirectory()) {
              fs[i] = new FileSystem(name,size,date,type,icon);
          }
        }
        return fs;
    }
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0 &&
            file.isFile())
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    
    private static String getlastModified(File file) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return sdf.format(file.lastModified()).toString();
    }
        
    private static String getFileSize(File file){
        
        String ret_value = "";
        double bytes = file.length();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);
        double gigabytes = (megabytes / 1024);
        
        if(gigabytes > 1)
            ret_value = String.format("%1$.2f", gigabytes) + " GB";
        else if(megabytes > 1)
            ret_value = String.format("%1$.2f", megabytes) + " MB";
        else if(kilobytes  > 1)
            ret_value = String.format("%1$.2f", kilobytes) + " KB";
        else
            ret_value = String.format("%1$.2f", bytes) + " B";
        
        ret_value = ret_value.replaceAll(",", ".");
        if(ret_value.contains(".00"))
            ret_value = ret_value.replace(".00", "");
        return ret_value;
    }
    
    private static String getIcon(String ext){
    
        switch(ext.toLowerCase()){
            case "csv":
                return "/images/csv-icon.png";
            case "cmd":
                return "/images/cmd-icon.png";
            case "dll":
                return "/images/dll-icon.png";
            case "exe":
                return "/images/exe-icon.png";
            case "":
                return "/images/folder-icon.png";
            case "jar":
                return "/images/jar-icon.png";
            case "xls":
                return "/images/xls-icon.png";
            case "xlsx":
                return "/images/xls-icon.png";
            case "sh":
                return "/images/shell-icon.png";
            case "txt":
                return "/images/txt-icon.png";
            default:
                return "/images/other-icon.png";
        }
    }
    
    public static String getLastStringByToken(String path, String token){
        String Extension = null;
        StringTokenizer tokenizer = new StringTokenizer(path, token);
        
        while(tokenizer.hasMoreElements()) {
            Extension = tokenizer.nextElement().toString();
        }
        return Extension;
    }
    
    public static String GoBackDirectory(String directory){
        String separator = getSepatartor();
        String new_directory = "";
        String last = OSHelper.getLastStringByToken(directory, separator);
        if(last == null)
            return "";
        new_directory = directory.replaceAll(last, "");
        if(new_directory.equalsIgnoreCase(separator))
            return "";
        if(new_directory.endsWith(separator + separator))
            new_directory = new_directory.substring(0, new_directory.length() - 1);        
        return new_directory;
    }
    
    public static String GoIntoDirectory(String drive, String directory, String path){
        if((new File(drive + directory + path)).isFile())
            return directory;
        else
            return directory + path + getSepatartor();
    }
    
    public static String getLastByTokenizer(String path, String token){
        String Extension = null;
        StringTokenizer tokenizer = new StringTokenizer(path, token);
        
        while(tokenizer.hasMoreElements()) {
            Extension = tokenizer.nextElement().toString();
        }
        return Extension;
    }
    
    public static String getTile(String Title ) {
        String msg = "*******************************************************************************" + "\n";
        if(Title.equalsIgnoreCase("OUTPUT")){
            msg = msg + "********************************* OUTPUT **************************************" + "\n";
            msg = msg + "*******************************************************************************" + "\n\n";    
        }else if(Title.equalsIgnoreCase("ERROR")){
            msg = msg + "********************************* ERROR ***************************************" + "\n";    
            msg = msg + "*******************************************************************************" + "\n\n";    
        }
        return msg;
    }
    
    public static String getFileBody(String file){
        String response = "";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            while ((line = br.readLine()) != null) {
                response = response + line + "\n";
            }
        }catch (IOException e){
            e.printStackTrace();
            response = "no fue posible abrir el archivo \n\n";
            response = response + e.getMessage();
        }
        return response;
    }
    
    static public String displayCurrency( double value) {
        String ret_value = "";
        int separator = 0;
        Locale currentLocale = Locale.US;
        Double currencyAmount = new Double(value);
        Currency currentCurrency = Currency.getInstance(currentLocale);
        NumberFormat currencyFormatter = 
        NumberFormat.getCurrencyInstance(currentLocale);
        ret_value = currencyFormatter.format(currencyAmount).toString();
        separator = ret_value.indexOf(".");
        return ret_value.substring(0, separator).replace(",", ".") + ret_value.substring(separator).replace(".", ",");
    }
    
    static public int getYearFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    
    static public int getMonthFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }
    
    static public int getDayFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    static public String getMonthByName(String name){
        switch(name){
            case "Enero": return "01";    
            case "Febrero": return "02";
            case "Marzo": return "03";
            case "Abril": return "04";
            case "Mayo": return "05";
            case "Junio": return "06";
            case "Julio": return "07";
            case "Agosto": return "08";
            case "Septiembre": return "09";
            case "Octubre": return "10";
            case "Noviembre": return "11";
            case "Diciembre": return "12";
            default: return"01";
        }
    }
    
    static public String getMonthByNumber(int number){
        switch(number){
            case 1: return "Enero";    
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return"Enero";
        }
    }
    
}
