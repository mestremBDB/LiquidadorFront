package core.rsolano.liqinterface.model.utils;

import java.io.*;

public class StreamInfo {
    
    InputStream is;
    String type;
    
    public StreamInfo(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }
    
    public String run()
    {
        String retvalue = "";
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line=null;
            while ( (line = br.readLine()) != null){
                retvalue = retvalue + line + "\n";
            }
            
            retvalue = type +  ": \n" + retvalue;
        }catch (IOException ioe){
            ioe.printStackTrace();  
        }
        return retvalue;
    }
}
