package core.rsolano.liqinterface.model.graph.model;

public class cMonth {
    
    private String month;
    private String format;
    
    public cMonth(String month, String format) {
        this.month = month;
        this.format = format;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
