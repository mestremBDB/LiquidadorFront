package core.rsolano.liqinterface.model.graph.utils;

import core.rsolano.liqinterface.model.graph.model.Charge;
import core.rsolano.liqinterface.model.graph.model.ChargeByModalities;
import core.rsolano.liqinterface.model.graph.model.ChargeByPeriod;
import core.rsolano.liqinterface.model.graph.model.CustomerCharges;
import core.rsolano.liqinterface.model.graph.model.CustomerWithoutCharges;
import core.rsolano.liqinterface.model.graph.model.FailChargeDetils;
import core.rsolano.liqinterface.model.utils.OSHelper;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GraphInterface {

    GraphInterface() {
    }

    public static List<FailChargeDetils> getFailChargeDetils(List results) {
        List<FailChargeDetils> charges = new ArrayList<FailChargeDetils>();
        FailChargeDetils charge;
        Object[] r;

        BigDecimal aux;
        String descripcion;
        int totaltransacciones;
        double totalcobro;
        String valor;

        for (Object result : results) {
            r = (Object[]) result;

            descripcion = (String) r[0];
            aux = (BigDecimal) r[1];
            totaltransacciones = aux != null ? aux.intValue() : 0;
            aux = (BigDecimal) r[2];
            totalcobro = aux != null ? aux.doubleValue() : (new BigDecimal("0.00")).doubleValue();
            valor =
                "Cantidad: " + String.format("%,d", totaltransacciones) + " -> Valor: " +
                OSHelper.displayCurrency(totalcobro) + " pesos";
            charge = new FailChargeDetils(descripcion, totaltransacciones, valor);
            charges.add(charge);
        }
        return charges;
    }

    public static List<CustomerCharges> getCustomerCharges(List results) {
        List<CustomerCharges> charges = new ArrayList<CustomerCharges>();
        Object[] r;
        BigDecimal aux;
        String Record, TipoIdent, NumIdent, Nombre, TipoProd, NumProd, TotalCobro, EstadoCobro, ValorCobro;
        String TipoTarifa = "", TipoRecaudo = "";
        int count = 0;

        for (Object result : results) {
            r = (Object[]) result;
            Record = Integer.toString(count++);
            TipoIdent = (String) r[0];
            NumIdent = (String) r[1];
            Nombre = (String) r[2];
            TipoProd = (String) r[3];
            NumProd = (String) r[4];
            aux = (BigDecimal) r[5];
            ValorCobro = String.valueOf(r[7]);
            if (r.length > 8) {
                TipoTarifa = (String) r[8];
                TipoRecaudo = (String) r[9];
            }


            //TotalCobro = OSHelper.displayCurrency(aux != null ? aux.doubleValue() : (new BigDecimal("0.00")).doubleValue());
            TotalCobro = aux != null ? OSHelper.displayCurrency(aux.doubleValue()) : "nulo";

            aux = (BigDecimal) r[6];
            EstadoCobro = String.format("%,d", aux.intValue());
            charges.add(new CustomerCharges(Record, TipoIdent, NumIdent, Nombre, TipoProd, NumProd, TotalCobro,
                                            EstadoCobro, TipoTarifa, TipoRecaudo, ValorCobro));
        }

        return charges;
    }

    public static List<CustomerWithoutCharges> getCustomerWithoutCharges(List results) {
        List<CustomerWithoutCharges> charges = new ArrayList<CustomerWithoutCharges>();
        Object[] r;
        String Record, TipoIdent, NumIdent, TotalCobro,ValorEsperado, ClientePope;
        String TipoTarifa = "", TipoRecaudo = "";
        int count = 0;
        for (Object result : results) {
            r = (Object[]) result;
            Record = Integer.toString(count++);
            TipoIdent = (String) r[0];
            NumIdent = (String) r[1];
            TotalCobro = String.valueOf(r[2]);
            ValorEsperado = String.valueOf(r[3]);
            ClientePope = String.valueOf(r[4]);
            if (r.length > 5 ) {
                TipoTarifa = String.valueOf(r[5]);
                TipoRecaudo = (String) r[6];
            }
            charges.add(new CustomerWithoutCharges(Record, TipoIdent, NumIdent, TotalCobro, ValorEsperado,ClientePope, TipoTarifa, TipoRecaudo));
        }

        return charges;
    }

    public static List<Charge> getCharges(List results) {
        List<Charge> charges = new ArrayList<Charge>();
        Charge charge;
        Object[] r;

        String valor;
        int totaltransacciones;
        double totalcobro;
        for (Object result : getMontlhyResults(results)) {
            r = (Object[]) result;
            totaltransacciones = ((BigDecimal) r[0]).add((BigDecimal) r[2]).intValue();
            totalcobro = ((BigDecimal) r[1]).add((BigDecimal) r[3]).doubleValue();
            valor =
                "Cantidad: " + String.format("%,d", totaltransacciones) + " -> Valor: " +
                OSHelper.displayCurrency(totalcobro) + " pesos";
            Date fecha = (Date) r[4];
            String f = fecha.toString();
            BigDecimal success = (BigDecimal) r[1];
            BigDecimal failed = (BigDecimal) r[3];
            charge = new Charge(totaltransacciones, totalcobro, valor, fecha, success, failed);
            charges.add(charge);
        }
        return charges;
    }

    public static List<ChargeByPeriod> getChargeByPeriod(List results) {
        List<ChargeByPeriod> charges = new ArrayList<ChargeByPeriod>();
        ChargeByPeriod charge;
        Object[] r;

        BigDecimal aux;
        String serie;
        String color;
        String valor;
        int estadotransaccion;
        int totaltransacciones;
        double totalcobro;

        for (Object result : results) {
            r = (Object[]) result;
            aux = (BigDecimal) r[0];
            estadotransaccion = aux != null ? aux.intValue() : 0;
            aux = (BigDecimal) r[1];
            totaltransacciones = aux != null ? aux.intValue() : 0;
            aux = (BigDecimal) r[2];
            totalcobro = aux != null ? aux.doubleValue() : (new BigDecimal("0.00")).doubleValue();
            serie = estadotransaccion == 0 ? "Cobros exitosos " : "Cobros errados ";
            color = estadotransaccion == 0 ? "#00bb00" : "#bb0000";
            valor =
                "Cantidad: " + String.format("%,d", totaltransacciones) + " -> Valor: " +
                OSHelper.displayCurrency(totalcobro) + " pesos";
            charge = new ChargeByPeriod(estadotransaccion, totaltransacciones, totalcobro, serie, color, valor);
            charges.add(charge);
        }
        return charges;
    }

    public static ChargeByModalities getChargeByModality(List results, String modality) {
        ChargeByModalities charge = null;
        Object[] r;
        BigDecimal aux;

        String valor;
        String modalidad = modality;
        int totaltransacciones;
        double totalcobro;

        for (Object result : results) {
            r = (Object[]) result;
            aux = (BigDecimal) r[0];
            totaltransacciones = aux != null ? aux.intValue() : 0;
            aux = (BigDecimal) r[1];
            totalcobro = aux != null ? aux.doubleValue() : (new BigDecimal("0.00")).doubleValue();
            valor = OSHelper.displayCurrency(totalcobro);
            charge = new ChargeByModalities(valor, modalidad, totaltransacciones, totalcobro);
        }
        return charge;
    }

    public static List<String> getModalitiesFromService(List results) {
        List<String> modalities = new ArrayList<String>();
        for (Object result : results) {
            modalities.add(result.toString());
        }
        return modalities;
    }


    private static List getMontlhyResults(List results) {
        List<Object[]> monthlyResults = new ArrayList<Object[]>();
        int estadotransaccion;
        for (Object result : results) {
            Object[] r = (Object[]) result;
            Date fecha = (Date) r[3];
            String f = fecha.toString();
            estadotransaccion = r[0] != null ? ((BigDecimal) r[0]).intValue() : 0;

            //buscar si ya hay un registro para el mes
            boolean agregado = false;
            Object[] oldMonth = null;
            for (Object[] month : monthlyResults) {
                if (((Date) month[4]).equals(fecha)) {
                    agregado = true;
                    oldMonth = month;
                }
            }
            //agregar transacciones a objeto segun estado de transaccion
            if (agregado && oldMonth != null) {
                if (estadotransaccion == 0) {
                    oldMonth[0] = r[1];
                    oldMonth[1] = r[2];
                } else {
                    oldMonth[2] = r[1];
                    oldMonth[3] = r[2];
                }
            }
            //crear nuevo objeto para las transacciones del mes
            else {
                Object[] newMonth;
                if (estadotransaccion == 0) {
                    newMonth = new Object[] { r[1], r[2], new BigDecimal(0), new BigDecimal(0), fecha };
                } else {
                    newMonth = new Object[] { new BigDecimal(0), new BigDecimal(0), r[1], r[2], fecha };
                }
                monthlyResults.add(newMonth);
            }
        }
        //Collections.sort(yourList, Collections.reverseOrder());
        return monthlyResults;
    }
}
