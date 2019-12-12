package core.rsolano.liqinterface.model.facades;

//import core.rsolano.liqinterface.model.entities.AppArchivosaplicaciones;
import core.rsolano.liqinterface.model.entities.AppAplicaciones;
import core.rsolano.liqinterface.model.entities.AppArchivos;
import core.rsolano.liqinterface.model.entities.AppCamposprocesoliq;
import core.rsolano.liqinterface.model.entities.AppHerramientas;
import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.entities.ConfCryptofirmas;
import core.rsolano.liqinterface.model.entities.ConfDiasfestivos;
import core.rsolano.liqinterface.model.entities.ConfGruposcorreo;
import core.rsolano.liqinterface.model.entities.ConfHerramientasapps;
import core.rsolano.liqinterface.model.entities.ConfParametrosliquidador;
import core.rsolano.liqinterface.model.entities.ConfReceptorescorreos;
import core.rsolano.liqinterface.model.entities.ConfSqlloader;
import core.rsolano.liqinterface.model.entities.ConfUsuarios;
import core.rsolano.liqinterface.model.entities.HistActividadesProcesos;
import core.rsolano.liqinterface.model.entities.HistProcesos;
import core.rsolano.liqinterface.model.entities.IdmGrupos;
import core.rsolano.liqinterface.model.entities.IdmUsuarios;
import core.rsolano.liqinterface.model.entities.LiqBusiness;
import core.rsolano.liqinterface.model.entities.LiqCorporate;
import core.rsolano.liqinterface.model.entities.LiqPse;
import core.rsolano.liqinterface.model.entities.LiqPseTotal;
import core.rsolano.liqinterface.model.entities.LiqTRE;
import core.rsolano.liqinterface.model.entities.LogCryptolog;
import core.rsolano.liqinterface.model.entities.LogErroresliq;
import core.rsolano.liqinterface.model.entities.LogErroresnotificacion;
import core.rsolano.liqinterface.model.entities.LogInicionotificacion;
import core.rsolano.liqinterface.model.entities.LogRegistroserrados;
import core.rsolano.liqinterface.model.entities.NotifActividadProceso;
import core.rsolano.liqinterface.model.entities.NotifActividades;
import core.rsolano.liqinterface.model.entities.NotifProceso;
import core.rsolano.liqinterface.model.entities.TaskFilesloader;
import core.rsolano.liqinterface.model.entities.TempRespuestahost;
import core.rsolano.liqinterface.model.entities.TempTemppse;
import core.rsolano.liqinterface.model.entities.TempTemppse1;
import core.rsolano.liqinterface.model.entities.TempTemppse2;
import core.rsolano.liqinterface.model.graph.model.Charge;
import core.rsolano.liqinterface.model.graph.model.ChargeByModalities;
import core.rsolano.liqinterface.model.graph.model.ChargeByPeriod;
import core.rsolano.liqinterface.model.graph.model.CustomerCharges;
import core.rsolano.liqinterface.model.graph.model.CustomerWithoutCharges;
import core.rsolano.liqinterface.model.graph.model.FailChargeDetils;
import core.rsolano.liqinterface.model.graph.model.cDay;
import core.rsolano.liqinterface.model.graph.model.cMonth;
import core.rsolano.liqinterface.model.graph.model.cYear;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface LIQTLLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    ConfParametrosliquidador persistConfParametrosliquidador(ConfParametrosliquidador confParametrosliquidador);

    ConfParametrosliquidador mergeConfParametrosliquidador(ConfParametrosliquidador confParametrosliquidador);

    void removeConfParametrosliquidador(ConfParametrosliquidador confParametrosliquidador);

    List<ConfParametrosliquidador> getConfParametrosliquidadorFindAll();

    LogCryptolog persistLogCryptolog(LogCryptolog logCryptolog);

    LogCryptolog mergeLogCryptolog(LogCryptolog logCryptolog);

    void removeLogCryptolog(LogCryptolog logCryptolog);

    List<LogCryptolog> getLogCryptologFindAll();

    ConfCryptoalmacen persistConfCryptoalmacen(ConfCryptoalmacen confCryptoalmacen);

    ConfCryptoalmacen mergeConfCryptoalmacen(ConfCryptoalmacen confCryptoalmacen);

    void removeConfCryptoalmacen(ConfCryptoalmacen confCryptoalmacen);

    List<ConfCryptoalmacen> getConfCryptoalmacenFindAll();

    ConfCryptofirmas persistConfCryptofirmas(ConfCryptofirmas confCryptofirmas);

    ConfCryptofirmas mergeConfCryptofirmas(ConfCryptofirmas confCryptofirmas);

    void removeConfCryptofirmas(ConfCryptofirmas confCryptofirmas);

    List<ConfCryptofirmas> getConfCryptofirmasFindAll();

    ConfSqlloader persistConfSqlloader(ConfSqlloader confSqlloader);

    ConfSqlloader mergeConfSqlloader(ConfSqlloader confSqlloader);

    void removeConfSqlloader(ConfSqlloader confSqlloader);

    List<ConfSqlloader> getConfSqlloaderFindAll();

    AppAplicaciones persistAppAplicaciones(AppAplicaciones appAplicaciones);

    AppAplicaciones mergeAppAplicaciones(AppAplicaciones appAplicaciones);

    void removeAppAplicaciones(AppAplicaciones appAplicaciones);

    List<AppAplicaciones> getAppAplicacionesFindAll();

    List<LogCryptolog> getLogCryptologFindByFecha(Date startDate, Date endDate);

    LogInicionotificacion persistLogInicionotificacion(LogInicionotificacion logInicionotificacion);

    LogInicionotificacion mergeLogInicionotificacion(LogInicionotificacion logInicionotificacion);

    void removeLogInicionotificacion(LogInicionotificacion logInicionotificacion);

    List<LogInicionotificacion> getLogInicionotificacionFindAll();

    TempTemppse persistTempTemppse(TempTemppse tempTemppse);

    TempTemppse mergeTempTemppse(TempTemppse tempTemppse);

    void removeTempTemppse(TempTemppse tempTemppse);

    List<TempTemppse> getTempTemppseFindAll();

    ConfReceptorescorreos persistConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos);

    ConfReceptorescorreos mergeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos);

    void removeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos);

    List<ConfReceptorescorreos> getConfReceptorescorreosFindAll();

    LiqCorporate persistLiqCorporate(LiqCorporate liqCorporate);

    LiqCorporate mergeLiqCorporate(LiqCorporate liqCorporate);

    void removeLiqCorporate(LiqCorporate liqCorporate);

    List<LiqCorporate> getLiqCorporateFindAll();
    
    LiqTRE persistLiqTRE(LiqTRE liqTRE);

    LiqTRE mergeLiqTRE(LiqTRE liqTRE);

    void removeLiqTRE(LiqTRE liqTRE);

    List<LiqTRE> getLiqTREFindAll();

    HistProcesos persistHistProcesos(HistProcesos histProcesos);

    HistProcesos mergeHistProcesos(HistProcesos histProcesos);

    void removeHistProcesos(HistProcesos histProcesos);

    List<HistProcesos> getHistProcesosFindAll();

    LiqPse persistLiqPse(LiqPse liqPse);

    LiqPse mergeLiqPse(LiqPse liqPse);

    void removeLiqPse(LiqPse liqPse);

    List<LiqPse> getLiqPseFindAll();

    LiqPseTotal persistLiqPseTotal(LiqPseTotal liqPseTotal);

    LiqPseTotal mergeLiqPseTotal(LiqPseTotal liqPseTotal);

    void removeLiqPseTotal(LiqPseTotal liqPseTotal);

    List<LiqPseTotal> getLiqPseTotalFindAll();
    
    TaskFilesloader persistTaskFilesloader(TaskFilesloader taskFilesloader);

    TaskFilesloader mergeTaskFilesloader(TaskFilesloader taskFilesloader);

    void removeTaskFilesloader(TaskFilesloader taskFilesloader);

    List<TaskFilesloader> getTaskFilesloaderFindAll();

    LogRegistroserrados persistLogRegistroserrados(LogRegistroserrados logRegistroserrados);

    LogRegistroserrados mergeLogRegistroserrados(LogRegistroserrados logRegistroserrados);

    void removeLogRegistroserrados(LogRegistroserrados logRegistroserrados);

    List<LogRegistroserrados> getLogRegistroserradosFindAll();

    HistActividadesProcesos persistHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos);

    HistActividadesProcesos mergeHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos);

    void removeHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos);

    List<HistActividadesProcesos> getHistActividadesProcesosFindAll();

    ConfGruposcorreo persistConfGruposcorreo(ConfGruposcorreo confGruposcorreo);

    ConfGruposcorreo mergeConfGruposcorreo(ConfGruposcorreo confGruposcorreo);

    void removeConfGruposcorreo(ConfGruposcorreo confGruposcorreo);

    List<ConfGruposcorreo> getConfGruposcorreoFindAll();

    NotifProceso persistNotifProceso(NotifProceso notifProceso);

    NotifProceso mergeNotifProceso(NotifProceso notifProceso);

    void removeNotifProceso(NotifProceso notifProceso);

    List<NotifProceso> getNotifProcesoFindAll();

    NotifActividades persistNotifActividades(NotifActividades notifActividades);

    NotifActividades mergeNotifActividades(NotifActividades notifActividades);

    void removeNotifActividades(NotifActividades notifActividades);

    List<NotifActividades> getNotifActividadesFindAll();

    //AppArchivosaplicaciones persistAppArchivosaplicaciones(AppArchivosaplicaciones appArchivosaplicaciones);

    //AppArchivosaplicaciones mergeAppArchivosaplicaciones(AppArchivosaplicaciones appArchivosaplicaciones);

    //void removeAppArchivosaplicaciones(AppArchivosaplicaciones appArchivosaplicaciones);

    //List<AppArchivosaplicaciones> getAppArchivosaplicacionesFindAll();

    TempTemppse1 persistTempTemppse1(TempTemppse1 tempTemppse1);

    TempTemppse1 mergeTempTemppse1(TempTemppse1 tempTemppse1);

    void removeTempTemppse1(TempTemppse1 tempTemppse1);

    List<TempTemppse1> getTempTemppse1FindAll();

    ConfDiasfestivos persistConfDiasfestivos(ConfDiasfestivos confDiasfestivos);

    ConfDiasfestivos mergeConfDiasfestivos(ConfDiasfestivos confDiasfestivos);

    void removeConfDiasfestivos(ConfDiasfestivos confDiasfestivos);

    List<ConfDiasfestivos> getConfDiasfestivosFindAll();

    LogErroresliq persistLogErroresliq(LogErroresliq logErroresliq);

    LogErroresliq mergeLogErroresliq(LogErroresliq logErroresliq);

    void removeLogErroresliq(LogErroresliq logErroresliq);

    List<LogErroresliq> getLogErroresliqFindAll();

    NotifActividadProceso persistNotifActividadProceso(NotifActividadProceso notifActividadProceso);

    NotifActividadProceso mergeNotifActividadProceso(NotifActividadProceso notifActividadProceso);

    void removeNotifActividadProceso(NotifActividadProceso notifActividadProceso);

    List<NotifActividadProceso> getNotifActividadProcesoFindAll();

    TempTemppse2 persistTempTemppse2(TempTemppse2 tempTemppse2);

    TempTemppse2 mergeTempTemppse2(TempTemppse2 tempTemppse2);

    void removeTempTemppse2(TempTemppse2 tempTemppse2);

    List<TempTemppse2> getTempTemppse2FindAll();

    TempRespuestahost persistTempRespuestahost(TempRespuestahost tempRespuestahost);

    TempRespuestahost mergeTempRespuestahost(TempRespuestahost tempRespuestahost);

    void removeTempRespuestahost(TempRespuestahost tempRespuestahost);

    List<TempRespuestahost> getTempRespuestahostFindAll();

    ConfHerramientasapps persistConfHerramientasapps(ConfHerramientasapps confHerramientasapps);

    ConfHerramientasapps mergeConfHerramientasapps(ConfHerramientasapps confHerramientasapps);

    void removeConfHerramientasapps(ConfHerramientasapps confHerramientasapps);

    List<ConfHerramientasapps> getConfHerramientasappsFindAll();

    AppCamposprocesoliq persistAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq);

    AppCamposprocesoliq mergeAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq);

    void removeAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq);

    List<AppCamposprocesoliq> getAppCamposprocesoliqFindAll();


    AppArchivos persistAppArchivos(AppArchivos appArchivos);

    AppArchivos mergeAppArchivos(AppArchivos appArchivos);

    void removeAppArchivos(AppArchivos appArchivos);

    List<AppArchivos> getAppArchivosFindAll();

    LogErroresnotificacion persistLogErroresnotificacion(LogErroresnotificacion logErroresnotificacion);

    LogErroresnotificacion mergeLogErroresnotificacion(LogErroresnotificacion logErroresnotificacion);

    void removeLogErroresnotificacion(LogErroresnotificacion logErroresnotificacion);

    List<LogErroresnotificacion> getLogErroresnotificacionFindAll();

    ConfUsuarios persistConfUsuarios(ConfUsuarios confUsuarios);

    ConfUsuarios mergeConfUsuarios(ConfUsuarios confUsuarios);

    void removeConfUsuarios(ConfUsuarios confUsuarios);

    List<ConfUsuarios> getConfUsuariosFindAll();

    LiqBusiness persistLiqBusiness(LiqBusiness liqBusiness);

    LiqBusiness mergeLiqBusiness(LiqBusiness liqBusiness);

    void removeLiqBusiness(LiqBusiness liqBusiness);

    List<LiqBusiness> getLiqBusinessFindAll();

    AppHerramientas persistAppHerramientas(AppHerramientas appHerramientas);

    AppHerramientas mergeAppHerramientas(AppHerramientas appHerramientas);

    void removeAppHerramientas(AppHerramientas appHerramientas);

    List<AppHerramientas> getAppHerramientasFindAll();

    IdmGrupos persistIdmGrupos(IdmGrupos idmGrupos);

    IdmGrupos mergeIdmGrupos(IdmGrupos idmGrupos);

    void removeIdmGrupos(IdmGrupos idmGrupos);

    List<IdmGrupos> getIdmGruposFindAll();

    IdmUsuarios persistIdmUsuarios(IdmUsuarios idmUsuarios);

    IdmUsuarios mergeIdmUsuarios(IdmUsuarios idmUsuarios);

    void removeIdmUsuarios(IdmUsuarios idmUsuarios);

    List<IdmUsuarios> getIdmUsuariosFindAll();
    
    List<Charge> getCharges(String app);
    
    List<ChargeByPeriod> getChargeByPeriod(String app, String date, String dateI, String dateF);
    
    List<FailChargeDetils> getFailChargeDetils(String app, String date, String dateI, String dateF);
    
    List<ChargeByModalities> getChargeByModality(String app, String date, String dateI, String dateF);
    
    List<CustomerCharges> getCustomerCharges(String app, String date, String dateI, String dateF);
    
    List<CustomerWithoutCharges> getCustomerWithoutCharges (String app, String date, String dateI, String dateF);
    
    
    //List<AppArchivosaplicaciones> getAppArchivosaplicacionesByApp(String appId);
    
    List<cYear> getYears();
    List<cMonth> getMonths();
    List<cDay> getDays(String dateselected, String app);
}
