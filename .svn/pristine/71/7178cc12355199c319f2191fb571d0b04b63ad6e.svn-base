package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

import java.math.BigDecimal;

public class LiqTREPK implements Serializable{
    private BigDecimal estadotransaccion;
    private String idliq;

    public LiqTREPK() {
    }

    public LiqTREPK(BigDecimal estadotransaccion, String idliq) {
        this.estadotransaccion = estadotransaccion;
        this.idliq = idliq;
    }

    public boolean equals(Object other) {
        if (other instanceof LiqTREPK) {
            final LiqTREPK otherLiqTREPK = (LiqTREPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getEstadotransaccion() {
        return estadotransaccion;
    }

    public void setEstadotransaccion(BigDecimal estadotransaccion) {
        this.estadotransaccion = estadotransaccion;
    }

    public String getIdliq() {
        return idliq;
    }

    public void setIdliq(String idliq) {
        this.idliq = idliq;
    }
}
