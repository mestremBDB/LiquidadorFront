package core.rsolano.liqinterface.model.graph.model;

public class FailChargeDetils {
    
    private String valor;
    private String descripcion;
    private int totaltransacciones;
    
    public FailChargeDetils(){
    }
    
    public FailChargeDetils( String descripcion, int totaltransacciones, String valor){
        this.descripcion = descripcion;
        this.totaltransacciones = totaltransacciones;
        this.valor = valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
        
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setTotaltransacciones(int totaltransacciones) {
        this.totaltransacciones = totaltransacciones;
    }

    public int getTotaltransacciones() {
        return totaltransacciones;
    }

}
