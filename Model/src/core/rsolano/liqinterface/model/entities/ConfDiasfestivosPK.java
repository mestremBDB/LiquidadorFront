package core.rsolano.liqinterface.model.entities;

import java.io.Serializable;

public class ConfDiasfestivosPK implements Serializable {
    private String ano;
    private String dia;
    private String mes;

    public ConfDiasfestivosPK() {
    }

    public ConfDiasfestivosPK(String ano, String dia, String mes) {
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;
    }

    public boolean equals(Object other) {
        if (other instanceof ConfDiasfestivosPK) {
            final ConfDiasfestivosPK otherConfDiasfestivosPK = (ConfDiasfestivosPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
