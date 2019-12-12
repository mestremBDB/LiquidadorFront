package core.rsolano.liqinterface.model.facades;

import core.rsolano.liqinterface.model.entities.AppAplicaciones;
import core.rsolano.liqinterface.model.entities.AppArchivos;
import core.rsolano.liqinterface.model.entities.AppCamposprocesoliq;
import core.rsolano.liqinterface.model.entities.AppHerramientas;
import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.entities.ConfCryptofirmas;
import core.rsolano.liqinterface.model.entities.ConfDiasfestivos;
import core.rsolano.liqinterface.model.entities.ConfDiasfestivosPK;
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
import core.rsolano.liqinterface.model.entities.TempRespuestahostPK;
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
import core.rsolano.liqinterface.model.graph.utils.GraphInterface;
import core.rsolano.liqinterface.model.utils.OSHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "LIQTL", mappedName = "LiqInterface-Model-LIQTL")
public class LIQTLBean implements LIQTL, LIQTLLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "LiquidadorTasas")
    private EntityManager em;

    public LIQTLBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public ConfParametrosliquidador persistConfParametrosliquidador(ConfParametrosliquidador confParametrosliquidador) {
        em.persist(confParametrosliquidador);
        return confParametrosliquidador;
    }

    public ConfParametrosliquidador mergeConfParametrosliquidador(ConfParametrosliquidador confParametrosliquidador) {
        return em.merge(confParametrosliquidador);
    }

    public void removeConfParametrosliquidador(ConfParametrosliquidador confParametrosliquidador) {
        confParametrosliquidador = em.find(ConfParametrosliquidador.class, confParametrosliquidador.getId());
        em.remove(confParametrosliquidador);
    }

    /** <code>select o from ConfParametrosliquidador o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfParametrosliquidador> getConfParametrosliquidadorFindAll() {
        return em.createNamedQuery("ConfParametrosliquidador.findAll", ConfParametrosliquidador.class).getResultList();
    }

    public LogCryptolog persistLogCryptolog(LogCryptolog logCryptolog) {
        em.persist(logCryptolog);
        return logCryptolog;
    }

    public LogCryptolog mergeLogCryptolog(LogCryptolog logCryptolog) {
        return em.merge(logCryptolog);
    }

    public void removeLogCryptolog(LogCryptolog logCryptolog) {
        logCryptolog = em.find(LogCryptolog.class, logCryptolog.getId());
        em.remove(logCryptolog);
    }

    /** <code>select o from LogCryptolog o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LogCryptolog> getLogCryptologFindAll() {
        return em.createNamedQuery("LogCryptolog.findAll", LogCryptolog.class).getResultList();
    }

    public ConfCryptoalmacen persistConfCryptoalmacen(ConfCryptoalmacen confCryptoalmacen) {
        em.persist(confCryptoalmacen);
        return confCryptoalmacen;
    }

    public ConfCryptoalmacen mergeConfCryptoalmacen(ConfCryptoalmacen confCryptoalmacen) {
        return em.merge(confCryptoalmacen);
    }

    public void removeConfCryptoalmacen(ConfCryptoalmacen confCryptoalmacen) {
        confCryptoalmacen = em.find(ConfCryptoalmacen.class, confCryptoalmacen.getId());
        em.remove(confCryptoalmacen);
    }

    /** <code>select o from ConfCryptoalmacen o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfCryptoalmacen> getConfCryptoalmacenFindAll() {
        return em.createNamedQuery("ConfCryptoalmacen.findAll", ConfCryptoalmacen.class).getResultList();
    }

    public ConfCryptofirmas persistConfCryptofirmas(ConfCryptofirmas confCryptofirmas) {
        em.persist(confCryptofirmas);
        return confCryptofirmas;
    }

    public ConfCryptofirmas mergeConfCryptofirmas(ConfCryptofirmas confCryptofirmas) {
        return em.merge(confCryptofirmas);
    }

    public void removeConfCryptofirmas(ConfCryptofirmas confCryptofirmas) {
        confCryptofirmas = em.find(ConfCryptofirmas.class, confCryptofirmas.getId());
        em.remove(confCryptofirmas);
    }

    /** <code>select o from ConfCryptofirmas o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfCryptofirmas> getConfCryptofirmasFindAll() {
        return em.createNamedQuery("ConfCryptofirmas.findAll", ConfCryptofirmas.class).getResultList();
    }

    public ConfSqlloader persistConfSqlloader(ConfSqlloader confSqlloader) {
        em.persist(confSqlloader);
        return confSqlloader;
    }

    public ConfSqlloader mergeConfSqlloader(ConfSqlloader confSqlloader) {
        return em.merge(confSqlloader);
    }

    public void removeConfSqlloader(ConfSqlloader confSqlloader) {
        confSqlloader = em.find(ConfSqlloader.class, confSqlloader.getId());
        em.remove(confSqlloader);
    }

    /** <code>select o from ConfSqlloader o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfSqlloader> getConfSqlloaderFindAll() {
        return em.createNamedQuery("ConfSqlloader.findAll", ConfSqlloader.class).getResultList();
    }

    public AppAplicaciones persistAppAplicaciones(AppAplicaciones appAplicaciones) {
        em.persist(appAplicaciones);
        return appAplicaciones;
    }

    public AppAplicaciones mergeAppAplicaciones(AppAplicaciones appAplicaciones) {
        return em.merge(appAplicaciones);
    }

    public void removeAppAplicaciones(AppAplicaciones appAplicaciones) {
        appAplicaciones = em.find(AppAplicaciones.class, appAplicaciones.getId());
        em.remove(appAplicaciones);
    }

    /** <code>select o from AppAplicaciones o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppAplicaciones> getAppAplicacionesFindAll() {
        return em.createNamedQuery("AppAplicaciones.findAll", AppAplicaciones.class).getResultList();
    }

    /** <code>select o from LogCryptolog o WHERE o.fecha BETWEEN :startDate AND :endDate</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LogCryptolog> getLogCryptologFindByFecha(Date startDate, Date endDate) {
        return em.createNamedQuery("LogCryptolog.findByFecha", LogCryptolog.class).setParameter("startDate",
                                                                                                startDate).setParameter("endDate",
                                                                                                                        endDate).getResultList();
    }

    public LogInicionotificacion persistLogInicionotificacion(LogInicionotificacion logInicionotificacion) {
        em.persist(logInicionotificacion);
        return logInicionotificacion;
    }

    public LogInicionotificacion mergeLogInicionotificacion(LogInicionotificacion logInicionotificacion) {
        return em.merge(logInicionotificacion);
    }

    public void removeLogInicionotificacion(LogInicionotificacion logInicionotificacion) {
        logInicionotificacion = em.find(LogInicionotificacion.class, logInicionotificacion.getId());
        em.remove(logInicionotificacion);
    }

    /** <code>select o from LogInicionotificacion o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LogInicionotificacion> getLogInicionotificacionFindAll() {
        return em.createNamedQuery("LogInicionotificacion.findAll", LogInicionotificacion.class).getResultList();
    }

    public TempTemppse persistTempTemppse(TempTemppse tempTemppse) {
        em.persist(tempTemppse);
        return tempTemppse;
    }

    public TempTemppse mergeTempTemppse(TempTemppse tempTemppse) {
        return em.merge(tempTemppse);
    }

    public void removeTempTemppse(TempTemppse tempTemppse) {
        tempTemppse = em.find(TempTemppse.class, tempTemppse.getCus());
        em.remove(tempTemppse);
    }

    /** <code>select o from TempTemppse o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TempTemppse> getTempTemppseFindAll() {
        return em.createNamedQuery("TempTemppse.findAll", TempTemppse.class).getResultList();
    }

    public ConfReceptorescorreos persistConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        em.persist(confReceptorescorreos);
        return confReceptorescorreos;
    }

    public ConfReceptorescorreos mergeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        return em.merge(confReceptorescorreos);
    }

    public void removeConfReceptorescorreos(ConfReceptorescorreos confReceptorescorreos) {
        confReceptorescorreos = em.find(ConfReceptorescorreos.class, confReceptorescorreos.getId());
        em.remove(confReceptorescorreos);
    }

    /** <code>select o from ConfReceptorescorreos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfReceptorescorreos> getConfReceptorescorreosFindAll() {
        return em.createNamedQuery("ConfReceptorescorreos.findAll", ConfReceptorescorreos.class).getResultList();
    }

    public LiqCorporate persistLiqCorporate(LiqCorporate liqCorporate) {
        em.persist(liqCorporate);
        return liqCorporate;
    }

    public LiqCorporate mergeLiqCorporate(LiqCorporate liqCorporate) {
        return em.merge(liqCorporate);
    }

    public void removeLiqCorporate(LiqCorporate liqCorporate) {
        liqCorporate = em.find(LiqCorporate.class, liqCorporate.getIdliq());
        em.remove(liqCorporate);
    }

    /** <code>select o from LiqCorporate o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LiqCorporate> getLiqCorporateFindAll() {
        return em.createNamedQuery("LiqCorporate.findAll", LiqCorporate.class).getResultList();
    }


    public LiqTRE persistLiqTRE(LiqTRE liqTRE) {
        em.persist(liqTRE);
        return liqTRE;
    }

    public LiqTRE mergeLiqTRE(LiqTRE liqTRE) {
        return em.merge(liqTRE);
    }

    public void removeLiqTRE(LiqTRE liqTRE) {
        liqTRE = em.find(LiqTRE.class, liqTRE.getIdliq());
        em.remove(liqTRE);
    }

    /** <code>select o from LiqTRE o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LiqTRE> getLiqTREFindAll() {
        return em.createNamedQuery("LiqTRE.findAll", LiqTRE.class).getResultList();
    }

    public HistProcesos persistHistProcesos(HistProcesos histProcesos) {
        em.persist(histProcesos);
        return histProcesos;
    }

    public HistProcesos mergeHistProcesos(HistProcesos histProcesos) {
        return em.merge(histProcesos);
    }

    public void removeHistProcesos(HistProcesos histProcesos) {
        histProcesos = em.find(HistProcesos.class, histProcesos.getId());
        em.remove(histProcesos);
    }

    /** <code>select o from HistProcesos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<HistProcesos> getHistProcesosFindAll() {
        return em.createNamedQuery("HistProcesos.findAll", HistProcesos.class).getResultList();
    }

    public LiqPse persistLiqPse(LiqPse liqPse) {
        em.persist(liqPse);
        return liqPse;
    }

    public LiqPse mergeLiqPse(LiqPse liqPse) {
        return em.merge(liqPse);
    }

    public void removeLiqPse(LiqPse liqPse) {
        liqPse = em.find(LiqPse.class, liqPse.getIdliq());
        em.remove(liqPse);
    }

    /** <code>select o from LiqPse o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LiqPse> getLiqPseFindAll() {
        return em.createNamedQuery("LiqPse.findAll", LiqPse.class).getResultList();
    }

    public LiqPseTotal persistLiqPseTotal(LiqPseTotal liqPseTotal) {
        em.persist(liqPseTotal);
        return liqPseTotal;
    }

    public LiqPseTotal mergeLiqPseTotal(LiqPseTotal liqPseTotal) {
        return em.merge(liqPseTotal);
    }

    public void removeLiqPseTotal(LiqPseTotal liqPseTotal) {
        liqPseTotal = em.find(LiqPseTotal.class, liqPseTotal.getIdliq());
        em.remove(liqPseTotal);
    }

    /** <code>select o from LiqPseTotal o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LiqPseTotal> getLiqPseTotalFindAll() {
        return em.createNamedQuery("LiqPseTotal.findAll", LiqPseTotal.class).getResultList();
    }

    public TaskFilesloader persistTaskFilesloader(TaskFilesloader taskFilesloader) {
        em.persist(taskFilesloader);
        return taskFilesloader;
    }

    public TaskFilesloader mergeTaskFilesloader(TaskFilesloader taskFilesloader) {
        return em.merge(taskFilesloader);
    }

    public void removeTaskFilesloader(TaskFilesloader taskFilesloader) {
        taskFilesloader = em.find(TaskFilesloader.class, taskFilesloader.getId());
        em.remove(taskFilesloader);
    }

    /** <code>select o from TaskFilesloader o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TaskFilesloader> getTaskFilesloaderFindAll() {
        return em.createNamedQuery("TaskFilesloader.findAll", TaskFilesloader.class).getResultList();
    }

    public LogRegistroserrados persistLogRegistroserrados(LogRegistroserrados logRegistroserrados) {
        em.persist(logRegistroserrados);
        return logRegistroserrados;
    }

    public LogRegistroserrados mergeLogRegistroserrados(LogRegistroserrados logRegistroserrados) {
        return em.merge(logRegistroserrados);
    }

    public void removeLogRegistroserrados(LogRegistroserrados logRegistroserrados) {
        logRegistroserrados = em.find(LogRegistroserrados.class, logRegistroserrados.getId());
        em.remove(logRegistroserrados);
    }

    /** <code>select o from LogRegistroserrados o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LogRegistroserrados> getLogRegistroserradosFindAll() {
        return em.createNamedQuery("LogRegistroserrados.findAll", LogRegistroserrados.class).getResultList();
    }

    public HistActividadesProcesos persistHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        em.persist(histActividadesProcesos);
        return histActividadesProcesos;
    }

    public HistActividadesProcesos mergeHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        return em.merge(histActividadesProcesos);
    }

    public void removeHistActividadesProcesos(HistActividadesProcesos histActividadesProcesos) {
        histActividadesProcesos = em.find(HistActividadesProcesos.class, histActividadesProcesos.getId());
        em.remove(histActividadesProcesos);
    }

    /** <code>select o from HistActividadesProcesos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<HistActividadesProcesos> getHistActividadesProcesosFindAll() {
        return em.createNamedQuery("HistActividadesProcesos.findAll", HistActividadesProcesos.class).getResultList();
    }

    public ConfGruposcorreo persistConfGruposcorreo(ConfGruposcorreo confGruposcorreo) {
        em.persist(confGruposcorreo);
        return confGruposcorreo;
    }

    public ConfGruposcorreo mergeConfGruposcorreo(ConfGruposcorreo confGruposcorreo) {
        return em.merge(confGruposcorreo);
    }

    public void removeConfGruposcorreo(ConfGruposcorreo confGruposcorreo) {
        confGruposcorreo = em.find(ConfGruposcorreo.class, confGruposcorreo.getId());
        em.remove(confGruposcorreo);
    }

    /** <code>select o from ConfGruposcorreo o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfGruposcorreo> getConfGruposcorreoFindAll() {
        return em.createNamedQuery("ConfGruposcorreo.findAll", ConfGruposcorreo.class).getResultList();
    }

    public NotifProceso persistNotifProceso(NotifProceso notifProceso) {
        em.persist(notifProceso);
        return notifProceso;
    }

    public NotifProceso mergeNotifProceso(NotifProceso notifProceso) {
        return em.merge(notifProceso);
    }

    public void removeNotifProceso(NotifProceso notifProceso) {
        notifProceso = em.find(NotifProceso.class, notifProceso.getId());
        em.remove(notifProceso);
    }

    /** <code>select o from NotifProceso o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<NotifProceso> getNotifProcesoFindAll() {
        return em.createNamedQuery("NotifProceso.findAll", NotifProceso.class).getResultList();
    }

    public NotifActividades persistNotifActividades(NotifActividades notifActividades) {
        em.persist(notifActividades);
        return notifActividades;
    }

    public NotifActividades mergeNotifActividades(NotifActividades notifActividades) {
        return em.merge(notifActividades);
    }

    public void removeNotifActividades(NotifActividades notifActividades) {
        notifActividades = em.find(NotifActividades.class, notifActividades.getId());
        em.remove(notifActividades);
    }

    /** <code>select o from NotifActividades o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<NotifActividades> getNotifActividadesFindAll() {
        return em.createNamedQuery("NotifActividades.findAll", NotifActividades.class).getResultList();
    }

    public TempTemppse1 persistTempTemppse1(TempTemppse1 tempTemppse1) {
        em.persist(tempTemppse1);
        return tempTemppse1;
    }

    public TempTemppse1 mergeTempTemppse1(TempTemppse1 tempTemppse1) {
        return em.merge(tempTemppse1);
    }

    public void removeTempTemppse1(TempTemppse1 tempTemppse1) {
        tempTemppse1 = em.find(TempTemppse1.class, tempTemppse1.getCus());
        em.remove(tempTemppse1);
    }

    /** <code>select o from TempTemppse1 o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TempTemppse1> getTempTemppse1FindAll() {
        return em.createNamedQuery("TempTemppse1.findAll", TempTemppse1.class).getResultList();
    }

    public ConfDiasfestivos persistConfDiasfestivos(ConfDiasfestivos confDiasfestivos) {
        em.persist(confDiasfestivos);
        return confDiasfestivos;
    }

    public ConfDiasfestivos mergeConfDiasfestivos(ConfDiasfestivos confDiasfestivos) {
        return em.merge(confDiasfestivos);
    }

    public void removeConfDiasfestivos(ConfDiasfestivos confDiasfestivos) {
        confDiasfestivos =
            em.find(ConfDiasfestivos.class,
                    new ConfDiasfestivosPK(confDiasfestivos.getAno(), confDiasfestivos.getDia(),
                                           confDiasfestivos.getMes()));
        em.remove(confDiasfestivos);
    }

    /** <code>select o from ConfDiasfestivos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfDiasfestivos> getConfDiasfestivosFindAll() {
        return em.createNamedQuery("ConfDiasfestivos.findAll", ConfDiasfestivos.class).getResultList();
    }

    public LogErroresliq persistLogErroresliq(LogErroresliq logErroresliq) {
        em.persist(logErroresliq);
        return logErroresliq;
    }

    public LogErroresliq mergeLogErroresliq(LogErroresliq logErroresliq) {
        return em.merge(logErroresliq);
    }

    public void removeLogErroresliq(LogErroresliq logErroresliq) {
        logErroresliq = em.find(LogErroresliq.class, logErroresliq.getId());
        em.remove(logErroresliq);
    }

    /** <code>select o from LogErroresliq o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LogErroresliq> getLogErroresliqFindAll() {
        return em.createNamedQuery("LogErroresliq.findAll", LogErroresliq.class).getResultList();
    }

    public NotifActividadProceso persistNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        em.persist(notifActividadProceso);
        return notifActividadProceso;
    }

    public NotifActividadProceso mergeNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        return em.merge(notifActividadProceso);
    }

    public void removeNotifActividadProceso(NotifActividadProceso notifActividadProceso) {
        notifActividadProceso = em.find(NotifActividadProceso.class, notifActividadProceso.getId());
        em.remove(notifActividadProceso);
    }

    /** <code>select o from NotifActividadProceso o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<NotifActividadProceso> getNotifActividadProcesoFindAll() {
        return em.createNamedQuery("NotifActividadProceso.findAll", NotifActividadProceso.class).getResultList();
    }

    public TempTemppse2 persistTempTemppse2(TempTemppse2 tempTemppse2) {
        em.persist(tempTemppse2);
        return tempTemppse2;
    }

    public TempTemppse2 mergeTempTemppse2(TempTemppse2 tempTemppse2) {
        return em.merge(tempTemppse2);
    }

    public void removeTempTemppse2(TempTemppse2 tempTemppse2) {
        tempTemppse2 = em.find(TempTemppse2.class, tempTemppse2.getCus());
        em.remove(tempTemppse2);
    }

    /** <code>select o from TempTemppse2 o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TempTemppse2> getTempTemppse2FindAll() {
        return em.createNamedQuery("TempTemppse2.findAll", TempTemppse2.class).getResultList();
    }

    public TempRespuestahost persistTempRespuestahost(TempRespuestahost tempRespuestahost) {
        em.persist(tempRespuestahost);
        return tempRespuestahost;
    }

    public TempRespuestahost mergeTempRespuestahost(TempRespuestahost tempRespuestahost) {
        return em.merge(tempRespuestahost);
    }

    public void removeTempRespuestahost(TempRespuestahost tempRespuestahost) {
        tempRespuestahost =
            em.find(TempRespuestahost.class,
                    new TempRespuestahostPK(tempRespuestahost.getFecha(), tempRespuestahost.getNumident(),
                                            tempRespuestahost.getNumprod(), tempRespuestahost.getTipoident(),
                                            tempRespuestahost.getTipoprod(), tempRespuestahost.getValor()));
        em.remove(tempRespuestahost);
    }

    /** <code>select o from TempRespuestahost o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<TempRespuestahost> getTempRespuestahostFindAll() {
        return em.createNamedQuery("TempRespuestahost.findAll", TempRespuestahost.class).getResultList();
    }

    public ConfHerramientasapps persistConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        em.persist(confHerramientasapps);
        return confHerramientasapps;
    }

    public ConfHerramientasapps mergeConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        return em.merge(confHerramientasapps);
    }

    public void removeConfHerramientasapps(ConfHerramientasapps confHerramientasapps) {
        confHerramientasapps = em.find(ConfHerramientasapps.class, confHerramientasapps.getId());
        em.remove(confHerramientasapps);
    }

    /** <code>select o from ConfHerramientasapps o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfHerramientasapps> getConfHerramientasappsFindAll() {
        return em.createNamedQuery("ConfHerramientasapps.findAll", ConfHerramientasapps.class).getResultList();
    }

    public AppCamposprocesoliq persistAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq) {
        em.persist(appCamposprocesoliq);
        return appCamposprocesoliq;
    }

    public AppCamposprocesoliq mergeAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq) {
        return em.merge(appCamposprocesoliq);
    }

    public void removeAppCamposprocesoliq(AppCamposprocesoliq appCamposprocesoliq) {
        appCamposprocesoliq = em.find(AppCamposprocesoliq.class, appCamposprocesoliq.getId());
        em.remove(appCamposprocesoliq);
    }

    /** <code>select o from AppCamposprocesoliq o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppCamposprocesoliq> getAppCamposprocesoliqFindAll() {
        return em.createNamedQuery("AppCamposprocesoliq.findAll", AppCamposprocesoliq.class).getResultList();
    }


    public AppArchivos persistAppArchivos(AppArchivos appArchivos) {
        em.persist(appArchivos);
        return appArchivos;
    }

    public AppArchivos mergeAppArchivos(AppArchivos appArchivos) {
        return em.merge(appArchivos);
    }

    public void removeAppArchivos(AppArchivos appArchivos) {
        appArchivos = em.find(AppArchivos.class, appArchivos.getId());
        em.remove(appArchivos);
    }

    /** <code>select o from AppArchivos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppArchivos> getAppArchivosFindAll() {
        return em.createNamedQuery("AppArchivos.findAll", AppArchivos.class).getResultList();
    }

    public LogErroresnotificacion persistLogErroresnotificacion(LogErroresnotificacion logErroresnotificacion) {
        em.persist(logErroresnotificacion);
        return logErroresnotificacion;
    }

    public LogErroresnotificacion mergeLogErroresnotificacion(LogErroresnotificacion logErroresnotificacion) {
        return em.merge(logErroresnotificacion);
    }

    public void removeLogErroresnotificacion(LogErroresnotificacion logErroresnotificacion) {
        logErroresnotificacion = em.find(LogErroresnotificacion.class, logErroresnotificacion.getId());
        em.remove(logErroresnotificacion);
    }

    /** <code>select o from LogErroresnotificacion o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LogErroresnotificacion> getLogErroresnotificacionFindAll() {
        return em.createNamedQuery("LogErroresnotificacion.findAll", LogErroresnotificacion.class).getResultList();
    }

    public ConfUsuarios persistConfUsuarios(ConfUsuarios confUsuarios) {
        em.persist(confUsuarios);
        return confUsuarios;
    }

    public ConfUsuarios mergeConfUsuarios(ConfUsuarios confUsuarios) {
        return em.merge(confUsuarios);
    }

    public void removeConfUsuarios(ConfUsuarios confUsuarios) {
        confUsuarios = em.find(ConfUsuarios.class, confUsuarios.getId());
        em.remove(confUsuarios);
    }

    /** <code>select o from ConfUsuarios o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ConfUsuarios> getConfUsuariosFindAll() {
        return em.createNamedQuery("ConfUsuarios.findAll", ConfUsuarios.class).getResultList();
    }

    public LiqBusiness persistLiqBusiness(LiqBusiness liqBusiness) {
        em.persist(liqBusiness);
        return liqBusiness;
    }

    public LiqBusiness mergeLiqBusiness(LiqBusiness liqBusiness) {
        return em.merge(liqBusiness);
    }

    public void removeLiqBusiness(LiqBusiness liqBusiness) {
        liqBusiness = em.find(LiqBusiness.class, liqBusiness.getIdliq());
        em.remove(liqBusiness);
    }

    /** <code>select o from LiqBusiness o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<LiqBusiness> getLiqBusinessFindAll() {
        return em.createNamedQuery("LiqBusiness.findAll", LiqBusiness.class).getResultList();
    }

    public AppHerramientas persistAppHerramientas(AppHerramientas appHerramientas) {
        em.persist(appHerramientas);
        return appHerramientas;
    }

    public AppHerramientas mergeAppHerramientas(AppHerramientas appHerramientas) {
        return em.merge(appHerramientas);
    }

    public void removeAppHerramientas(AppHerramientas appHerramientas) {
        appHerramientas = em.find(AppHerramientas.class, appHerramientas.getId());
        em.remove(appHerramientas);
    }

    /** <code>select o from AppHerramientas o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppHerramientas> getAppHerramientasFindAll() {
        return em.createNamedQuery("AppHerramientas.findAll", AppHerramientas.class).getResultList();
    }

    public IdmGrupos persistIdmGrupos(IdmGrupos idmGrupos) {
        em.persist(idmGrupos);
        return idmGrupos;
    }

    public IdmGrupos mergeIdmGrupos(IdmGrupos idmGrupos) {
        return em.merge(idmGrupos);
    }

    public void removeIdmGrupos(IdmGrupos idmGrupos) {
        idmGrupos = em.find(IdmGrupos.class, idmGrupos.getId());
        em.remove(idmGrupos);
    }

    /** <code>select o from IdmGrupos o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<IdmGrupos> getIdmGruposFindAll() {
        return em.createNamedQuery("IdmGrupos.findAll", IdmGrupos.class).getResultList();
    }

    public IdmUsuarios persistIdmUsuarios(IdmUsuarios idmUsuarios) {
        em.persist(idmUsuarios);
        return idmUsuarios;
    }

    public IdmUsuarios mergeIdmUsuarios(IdmUsuarios idmUsuarios) {
        return em.merge(idmUsuarios);
    }

    public void removeIdmUsuarios(IdmUsuarios idmUsuarios) {
        idmUsuarios = em.find(IdmUsuarios.class, idmUsuarios.getId());
        em.remove(idmUsuarios);
    }

    /** <code>select o from IdmUsuarios o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<IdmUsuarios> getIdmUsuariosFindAll() {
        return em.createNamedQuery("IdmUsuarios.findAll", IdmUsuarios.class).getResultList();
    }

    /********************************************************************************************/
    /******************************* Graph Queries **********************************************/
    /********************************************************************************************/

    ////////////////// Aplicaiones por Nombre //////////////////////////////////////////////
    private AppAplicaciones GetApplicationByName(String name) {
        List<AppAplicaciones> apps = getAppAplicacionesFindAll();
        for (AppAplicaciones app : apps) {
            if (name.equalsIgnoreCase(app.getNombre()))
                return app;
        }
        return null;
    }

    ////////////////////////// Archivo aplicaciones por aplicacion  ////////////////////////////
    private NotifProceso getNotifProcesoByAplicacion(String aplicacion) {
        List<NotifProceso> list = getNotifProcesoFindAll();
        for (NotifProceso obj : list) {
            if (aplicacion.equalsIgnoreCase(obj.getAplicacionId()))
                return obj;
        }
        return null;
    }
    ////////// Total Cobros /////////////
    public List<Charge> getCharges(String app) {
        AppAplicaciones appApps = GetApplicationByName(app);
        NotifProceso notifProc = getNotifProcesoByAplicacion(appApps.getId());
        String table = notifProc.getNombretablareporte();

            String query = "select p.estadotransaccion, count(*) as totaltransacciones, sum(valcobro) as totalcobro, ap.fecha";
        query = query + " from hist_insumoliq ap, " + table + " p";
        query = query + " where ap.id = p.insumoliq ";
        query = query + "and p.estadotransaccion in (0,1)";
        query = query + " group by p.estadotransaccion, ap.fecha";
        query = query + " order by ap.fecha ";
        List results = em.createNativeQuery(query).getResultList();
        return GraphInterface.getCharges(results);
    }

    ////////// Cobros por período ////////////////
    public List<ChargeByPeriod> getChargeByPeriod(String app, String date, String dateI, String dateF) {
        AppAplicaciones appApps = GetApplicationByName(app);
        NotifProceso notifProc = getNotifProcesoByAplicacion(appApps.getId());
        String table = notifProc.getNombretablareporte();

        String query = "select p.estadotransaccion, count(*) as totaltransacciones, sum(valcobro) as totalcobro from hist_insumoliq ap, ";
        query = query + table + " p where ap.id = p.insumoliq ";
        query = query + "and p.estadotransaccion in (0,1)";
        if (dateI != null && dateF != null){
            query += " and " + getDateFilterRange(dateI,dateF, "ap");
        }else{
            query = query + " and " + getDateFilter("ap", app, date);
        }
        query = query + " group by p.estadotransaccion";
        List results = em.createNativeQuery(query).getResultList();
        return GraphInterface.getChargeByPeriod(results);
    }

    /////////////////// Razones de rechazos ///////////////////
    public List<FailChargeDetils> getFailChargeDetils(String app, String date, String dateI, String dateF) {
        AppAplicaciones appApps = GetApplicationByName(app);
        NotifProceso notifProc = getNotifProcesoByAplicacion(appApps.getId());
        String table = notifProc.getNombretablareporte();

        String query = "select p.descripcionestado, count(*) as totaltransacciones, sum(valcobro) as totalcobro from hist_insumoliq ap, ";
        query = query + table + " p where ap.id = p.insumoliq and p.estadotransaccion = 1 ";
        if (dateI != null && dateF != null){
            query += " and " + getDateFilterRange(dateI,dateF, "ap");
        }else {
            query = query + " and " + getDateFilter("ap", app, date);
        }
        query = query + " group by p.descripcionestado";
        List results = em.createNativeQuery(query).getResultList();
        return GraphInterface.getFailChargeDetils(results);
    }

    ////////////////////////// Modalidades del servicio ///////////////////////////////////////////////////////////
    private List<String> getModalitiesFromService(String abr) {
        String query = "select ac.nombre from app_camposprocesoliq ac, notif_proceso npr where ac.idproceso = npr.id " +
                       "and (select ap.abreviatura from app_aplicaciones ap where npr.aplicacion = ap.id) = '" + abr + "' and ac.cobrado = 1";
        List results = em.createNativeQuery(query).getResultList();
        return GraphInterface.getModalitiesFromService(results);
    }

    //////////////////////////////////////////// Carga por modalidad ////////////////////////////////////////////////
    public List<ChargeByModalities> getChargeByModality(String app, String date, String dateI, String dateF) {
        AppAplicaciones appApps = GetApplicationByName(app);
        NotifProceso notifProc = getNotifProcesoByAplicacion(appApps.getId());
        List<ChargeByModalities> charges = new ArrayList<ChargeByModalities>();
        List<String> modalities = getModalitiesFromService(appApps.getAbreviatura());
        String query;
        String cmp_key;


        
        for (String modality : modalities) {

            /////////////////// OJO ESTO ES CÓDIGO QUEMADO ///////////////////////
            cmp_key = modality.toLowerCase().contains("valorcompra") ? "0" : "3";
            //////////////////////////////////////////////////////////////////////

            query = "select count(r." + modality + ") as transacciones, sum(r.valcobro) as cobrototal " + 
                    "from hist_insumoliq ap, " + notifProc.getNombretablareporte() + " r where ap.id = r.insumoliq and (" ;
            if (dateI != null && dateF != null){
                query += getDateFilterRange(dateI , dateF, "ap") + ")";
            }else {
                query += getDateFilter( "ap", app, date) + ")" ;
            }
                    query += " and r." + modality + " <> '" + cmp_key + "'";

            List results = em.createNativeQuery(query).getResultList();
            charges.add(GraphInterface.getChargeByModality(results, modality));
        }
        return charges;
    }

    //////////////////////////////////////// Cargos /////////////////////////////////////////////////

    public List<CustomerCharges> getCustomerCharges(String date, String app, String dateI, String dateF) {
        AppAplicaciones appApps = GetApplicationByName(app);
        NotifProceso notifProc = getNotifProcesoByAplicacion(appApps.getId());
        String query = "select p.tipoident, p.numident, p.nomempresa, p.tipoprod, p.numprod, sum(p.valcobro) as totalcobro, p.estadotransaccion as EstadoCobro, p.valesperado as valoresperado";
        if (appApps.getAbreviatura().equals("PSE")) {
            query += ", p.tipotarifa ,  " +
                "case when p.valorcompra_i <> 0 then 'Interno' when p.valorcompra_e <> 0 then 'Externo' else 'No aplica' end as tiporecaudo";
        }
        query += " from " + notifProc.getNombretablareporte() +
            " p where p.insumoliq in (select iq.id from hist_insumoliq iq, notif_proceso np where iq.idproceso = np.id" +
            " and (select ap.abreviatura from app_aplicaciones ap where np.aplicacion = ap.id) = '" +
            appApps.getAbreviatura() + "' and ";
        if (dateI != null && dateF !=null) { 
            query += getDateFilterRange(dateI, dateF, "iq");
        } else {
            query += getDateFilter("iq", app, date);
        }
        query += " ) group by p.tipoident, p.numident, p.tipoprod, p.numprod,  p.estadotransaccion, p.nomempresa , p.valesperado";
        if (appApps.getAbreviatura().equals("PSE")) {
            query += " , p.tipotarifa , p.valorcompra_i, p.valorcompra_e";
        }
        query += " order by totalcobro desc";
        List results = em.createNativeQuery(query).getResultList();
        return GraphInterface.getCustomerCharges(results);
    }

    public List<CustomerWithoutCharges> getCustomerWithoutCharges(String app, String date, String dateI, String dateF) {
        AppAplicaciones appApps = GetApplicationByName(app);
        NotifProceso notifProceso = getNotifProcesoByAplicacion(appApps.getId());
        String camposReporte = getCampoReporte(appApps.getId(), "p");
        List results = new ArrayList();
        if (camposReporte.contains("CLIENTEPOPE")) {
            String query = "select p.tipoident, p.numident, p.valcobro, p.valesperado" + camposReporte;
            if (appApps.getAbreviatura().equals("PSE")) {
                query += ", case when p.valorcompra_i <> 0 then 'Interno' when p.valorcompra_e <> 0 then 'Externo' else 'No aplica' end as tiporecaudo";
            }
            query += " from " + notifProceso.getNombretablareporte() + " p where p.clientepope = 1 " +
                "and p.insumoliq in (select hi.id from hist_insumoliq hi where  ";
            if (dateI != null && dateF != null) {
                query += getDateFilterRange(dateI , dateF, "hi") + ")";
            } else {
                query += getDateFilter("hi", app, date) + ")";
            }
            query += "group by p.tipoident, p.numident, p.valcobro, p.valesperado" + camposReporte;
            if (appApps.getAbreviatura().equals("PSE")){
                query += ",p.valorcompra_e, p.valorcompra_i";
                }
            results = em.createNativeQuery(query).getResultList();
        }
        return GraphInterface.getCustomerWithoutCharges(results);
    }

    ///////////////////////////////////// date utilities ////////////////////////////////////////////
    private String getDateFilter(String tabla, String app, String date) {
        String dateFilter = " to_char(" + tabla + ".fecha, 'mmyyyy') = '" + date + "'";
        List<NotifProceso> procesos = getNotifProcesoFindAll();
        List<String> dailyApps = new ArrayList<String>();
        for (NotifProceso proc : procesos) {
            if (proc.getTipoliquidacion().equals("3"))
                dailyApps.add(proc.getAplicacionNombre());
        }
        if(date.length() == "ddmmyyyy".length() &&(dailyApps.contains(app)))
        {
            dateFilter = "to_char(" + tabla + ".fecha, 'ddmmyyyy') = '" + date + "'";
        }
        return dateFilter;
    }

    /////////Filtro para un rango de fechas
     private String getDateFilterRange(String date1 , String date2, String tabla){
         String dateFilter = "";
        if(date1 != null && date2 != null){
            dateFilter = tabla + ".fecha between to_date('" + date1 + " 00:00:00', 'DD/MM/YY HH24:MI:SS')" +
                " and to_date('" + date2 + " 23:59:59', 'DD/MM/YY HH24:MI:SS')";
        }
        return dateFilter;
    }

    private String getCampoReporte(String app, String tabla) {
        NotifProceso notifProceso = getNotifProcesoByAplicacion(app);
        String camposReporte = notifProceso.getCamposreporte();
        String utilizados = "";
        if (camposReporte != null) {
            if (camposReporte.contains(";")) {
                String[] campos = camposReporte.split(";");
                for (String campo : campos)
                    utilizados += "," + tabla + "." + campo;
                return utilizados;
            } else {
                utilizados = "," + tabla + "." + camposReporte;
                return utilizados;
            }
        } else {
            return "";
        }
    }


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    private List<String> getDatesAppArchivos() {
        String query = "select distinct(trunc(fecha,'YYYY')) as years from hist_insumoliq order by years desc";
        List results = em.createNativeQuery(query).getResultList();
        List<String> ret = null;
        Object[] r;
        Date aux;

        if (results != null) {
            Calendar calendar = Calendar.getInstance();
            ret = new ArrayList<String>();
            for (Object result : results) {
                aux = (Date) result;
                calendar.setTime(aux);
                ret.add(String.valueOf(calendar.get(Calendar.YEAR)));
            }
        }
        return ret;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    private List<String> getDatesDaysAppArchivos() {
        String query = "select distinct(trunc(fecha,'DD')) as days from hist_insumoliq order by days desc";
        List results = em.createNativeQuery(query).getResultList();
        List<String> ret = null;
        Object[] r;
        Date aux;

        if (results != null) {
            Calendar calendar = Calendar.getInstance();
            ret = new ArrayList<String>();
            for (Object result : results) {
                aux = (Date) result;
                calendar.setTime(aux);
                ret.add(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            }
        }
        return ret;
    }

    public List<cYear> getYears() {
        List<cYear> lcy = new ArrayList<cYear>();
        Date date = new Date();
        int year = OSHelper.getYearFromDate(date);
        List<String> aay = getDatesAppArchivos();
        lcy.add(new cYear(Integer.toString(year), "mm" + Integer.toString(year)));

        for (String syear : aay) {
            if (Integer.valueOf(syear).intValue() != year)
                lcy.add(new cYear(syear, "mm" + syear));
        }
        return lcy;
    }

    public List<cMonth> getMonths() {
        List<cMonth> cm = new ArrayList<cMonth>();
        cm.add(new cMonth("Enero", "01"));
        cm.add(new cMonth("Febrero", "02"));
        cm.add(new cMonth("Marzo", "03"));
        cm.add(new cMonth("Abril", "04"));
        cm.add(new cMonth("Mayo", "05"));
        cm.add(new cMonth("Junio", "06"));
        cm.add(new cMonth("Julio", "07"));
        cm.add(new cMonth("Agosto", "08"));
        cm.add(new cMonth("Septiembre", "09"));
        cm.add(new cMonth("Octubre", "10"));
        cm.add(new cMonth("Noviembre", "11"));
        cm.add(new cMonth("Diciembre", "12"));
        return cm;
    }

    public List<cDay> getDays(String dateselected, String app) {
        List<cDay> lcy = new ArrayList<cDay>();
        Date date = new Date();
        int day = OSHelper.getDayFromDate(date);
        List<String> aad = getDatesDaysAppArchivos();
        lcy.add(new cDay(Integer.toString(day), "dd" + Integer.toString(day)));

        for (String sday : aad) {
            if (Integer.valueOf(sday).intValue() != day)
                lcy.add(new cDay(sday, "dd" + sday));
        }
        return lcy;
    }
}
