package core.rsolano.liqinterface.view.backing;

import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.view.utils.JSFUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.annotation.PostConstruct;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.render.ClientEvent;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.context.AdfFacesContext;

public class LiqConsole{
    
    private String commands;
    private String history;
    private String path;
    private String user;
    private String server;
    private String systemOS;
    private String style;

    private RichInputText txtinput;
    private RichInputText txthistory;
    private RichInputText txtpath;
    
    int timeout = 10;
    
    public LiqConsole() {
    }
    
    @PostConstruct
    public void init() {
        if(!JSFUtils.LoggedActive())
            return;
        commands = "";
        systemOS = OSHelper.getSystemOS(); 
        path = (systemOS.equalsIgnoreCase("WINDOWS") ? "C:" : "") + OSHelper.getSepatartor();
        user = OSHelper.getServerUser();
        history = systemOS.equalsIgnoreCase("WINDOWS") ? path + ">" :  user + "@" + path + ":$ ";
        server = OSHelper.getServerName();
        style = "background-color:Black;color:Lime;";
        
    }
    
    public String AnalyseCMD(String cmd){
        
        if(cmd.isEmpty())
            return "nocmd";
        
        String result = "";
        String separator = OSHelper.getSepatartor();
        String command = cmd;
        String[] word = command.split(" ");
        String analyse = word[0];
        String aux = "";
            
        if(analyse.equalsIgnoreCase("cd") && word.length > 1){
            if(word[1].equalsIgnoreCase(".."))
                analyse = "cd..";
        }
        
        if(analyse.equalsIgnoreCase("cd..")){
            if( (path.equalsIgnoreCase(separator)) || (path.contains(":" + separator) && path.length() == 3 ) )
                return "OK, path actual: " + "\n" + path + "\n\n";
        }
        
        switch(analyse){
            case "cd..":
                aux = OSHelper.getLastByTokenizer(path, separator); 
                aux = aux + separator;
                path = path.replace(aux,"");
                return "OK, path actual: " + "\n" + path + "\n\n";
            case "cd":
                if(!(new File(path + word[1] + separator)).exists())
                    return "El folder " + word[1] + " no existe. El path actual es: \n" + path + "\n\n";
                path = word[1].startsWith(separator) ? path + word[1].substring(1) : path + word[1];
                    
                if(!word[1].endsWith(separator))
                    path = path  + separator;
                return "OK, path actual: " + "\n" + path + "\n\n";
            case "liqtimeout":
                if(word.length != 2)
                    return "El comando debe recibir un parámetro";
                try{
                    timeout = Integer.parseInt(word[1]);
                    if(timeout < 1)
                        return "Se ha configurado el timeout por defector de 10 segundos."; 
                }catch(Exception e){
                    return "El parametro debe ser numérico";
                }
                return "Timeout de sesión configurado a " + timeout + " segundos";
            case "nano":
                if(!(new File(path + word[1]).exists()))
                    return "El archivo " + word[1] + " no existe";
                return OSHelper.getFileBody(path + word[1]);             
            case "vi":
                if(!(new File(path + word[1]).exists()))
                    return "El archivo " + word[1] + " no existe";
                return OSHelper.getFileBody(path + word[1]);             
            case "cls":
                return "clear";
            case "clear":
                return "clear";
            default:
                return "normal";
        }
    }
    
    public void handleEnterEven(ClientEvent clientEvent) {
        // Add event code here...
        String analyse = AnalyseCMD(commands);
        if(analyse.equalsIgnoreCase("normal"))
            history = ExecuteCommand(commands);
        else if(analyse.equalsIgnoreCase("clear")){
            history = "";
        }else if(analyse.equalsIgnoreCase("nocmd")){
            return;
        }else{
            history = analyse;   
        }
        commands = "";
        AdfFacesContext.getCurrentInstance().addPartialTarget(txtinput);
        AdfFacesContext.getCurrentInstance().addPartialTarget(txthistory);
    }
    
    public String ExecuteCommand(String cmd){
        Process process;
        ProcessBuilder builder;
        BufferedReader reader;
        BufferedWriter writer;
        String line = "";
        String response = "";
        boolean flag = false;
        boolean timer_out = false;
        
        
        try{
            builder = systemOS.equalsIgnoreCase("WINDOWS") ? new ProcessBuilder("cmd.exe") : new ProcessBuilder("/bin/bash");
            builder.redirectErrorStream(true);
            builder.directory(new File(path));
            process = builder.start();
            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader (new InputStreamReader(process.getInputStream()));
            writer.write("((" + cmd + ") && echo --EOF--) || echo --EOF--\n");
            writer.flush();
            
            Thread timer = new Thread(new Runnable() {
                 public void run() {
                    try {
                        for(int count = 0; count < timeout; count++)
                            Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("terminado hilo con timeout de " + timeout + " segundos");
                 }
            });
            timer.start();
            
            while(!reader.ready() && timer.isAlive()){
                if(!flag){
                    System.out.println("Esperando datos desde el Input Stream Reader...");
                    flag = true;
                }
            }
            System.out.println("El buffer ha respondido, se procede a capturar los datos.");
            
            if(!timer.isAlive()){
                process.destroy();
                timer_out = true;
                return "El programa " + cmd + "ha caído en un bucle sin fin o esta esperando datos de entrada."; 
            }
            
            line = reader.readLine();
            
            while (line != null && ! line.trim().equals("--EOF--")) {
                if(!line.contains("((" + cmd + ") && echo --EOF--) || echo --EOF--"))
                    response = response + line + "\n";
                
                while(!reader.ready() && timer.isAlive()){}
                
                if(!timer.isAlive()){
                    process.destroy();
                    timer_out = true;
                    line = null;
                    response = response + "\n";
                    response = response + "El comando " + cmd + " ha caído en un bucle sin fin o esta esperando datos de entrada.";
                    response = response + " La ejecución se cancela por timeout \n";
                    break;
                }
                line = reader.readLine();
            }
            
            if(!timer_out)
                process.destroy();
            
        }catch (IOException e) {
            e.printStackTrace();
            response = e.getMessage();
        }
        return response;
    }
    
    public void setCommands(String commands) {
        this.commands = commands;
    }
    public String getCommands() {
        return commands;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public String getHistory() {
        return history;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getUser() {
        return user;
    }
    public void setServer(String server) {
        this.server = server;
    }
    public String getServer() {
        return server;
    }
    public void setTxtinput(RichInputText txtinput) {
        this.txtinput = txtinput;
    }
    public RichInputText getTxtinput() {
        return txtinput;
    }
    public void setTxthistory(RichInputText txthistory) {
        this.txthistory = txthistory;
    }
    public RichInputText getTxthistory() {
        return txthistory;
    }
    public void setTxtpath(RichInputText txtpath) {
        this.txtpath = txtpath;
    }
    public RichInputText getTxtpath() {
        return txtpath;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public String getStyle() {
        return style;
    }
}
