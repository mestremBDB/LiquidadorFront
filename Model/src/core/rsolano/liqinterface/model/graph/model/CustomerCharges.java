package core.rsolano.liqinterface.model.graph.model;

public class CustomerCharges {
    
    String Record;
    String TipoIdent;
    String NumIdent;
    String Nombre;
    String TipoProd;
    String NumProd;
    String TotalCobro;
    String EstadoCobro;
    String TipoTarifa;
    String TipoRecaudo;
    String ValorEsperado;
    
    
    public CustomerCharges(){
    }
    
    public CustomerCharges(String Record, String TipoIdent, String NumIdent, String Nombre, String TipoProd, String NumProd, String TotalCobro, String EstadoCobro,
                           String TipoTarifa, String TipoRecaudo, String ValorEsperado
                           ){
        this.Record = Record;
        this.TipoIdent = TipoIdent;
        this.NumIdent = NumIdent;
        this.Nombre = Nombre;
        this.TipoProd = TipoProd;
        this.NumProd = NumProd;
        this.TotalCobro = TotalCobro;
        this.EstadoCobro = EstadoCobro; 
        this.TipoTarifa = TipoTarifa;
        this.TipoRecaudo = TipoRecaudo;
        this.ValorEsperado = ValorEsperado;
    }

    public void setRecord(String Record) {
        this.Record = Record;
    }

    public String getRecord() {
        return Record;
    }

    public void setTipoIdent(String TipoIdent) {
        this.TipoIdent = TipoIdent;
    }

    public String getTipoIdent() {
        return TipoIdent;
    }

    public void setNumIdent(String NumIdent) {
        this.NumIdent = NumIdent;
    }

    public String getNumIdent() {
        return NumIdent;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setTipoProd(String TipoProd) {
        this.TipoProd = TipoProd;
    }

    public String getTipoProd() {
        return TipoProd;
    }

    public void setNumProd(String NumProd) {
        this.NumProd = NumProd;
    }

    public String getNumProd() {
        return NumProd;
    }

    public void setTotalCobro(String TotalCobro) {
        this.TotalCobro = TotalCobro;
    }

    public String getTotalCobro() {
        return TotalCobro;
    }

    public void setEstadoCobro(String EstadoCobro) {
        this.EstadoCobro = EstadoCobro;
    }

    public String getEstadoCobro() {
        return EstadoCobro;
    }

    public void setTipoTarifa(String TipoTarifa) {
        this.TipoTarifa = TipoTarifa;
    }

    public String getTipoTarifa() {
        return TipoTarifa;
    }

    public void setTipoRecaudo(String TipoRecaudo) {
        this.TipoRecaudo = TipoRecaudo;
    }

    public String getTipoRecaudo() {
        return TipoRecaudo;
    }

    public void setValorEsperado(String ValorEsperado) {
        this.ValorEsperado = ValorEsperado;
    }

    public String getValorEsperado() {
        return ValorEsperado;
    }


}
