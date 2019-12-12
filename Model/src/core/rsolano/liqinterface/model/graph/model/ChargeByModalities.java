package core.rsolano.liqinterface.model.graph.model;

public class ChargeByModalities {
    
    private String valor;
    private String modalidad;
    private int totaltransacciones;
    private double totalcobro;
    
    public ChargeByModalities(){
    }
    
    public ChargeByModalities(String valor, String modalidad, int totaltransacciones, double totalcobro){
        this.valor = valor;
        this.modalidad = modalidad;
        this.totaltransacciones = totaltransacciones;
        this.totalcobro = totalcobro;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setTotaltransacciones(int totaltransacciones) {
        this.totaltransacciones = totaltransacciones;
    }

    public int getTotaltransacciones() {
        return totaltransacciones;
    }

    public void setTotalcobro(double totalcobro) {
        this.totalcobro = totalcobro;
    }

    public double getTotalcobro() {
        return totalcobro;
    }
    
}
