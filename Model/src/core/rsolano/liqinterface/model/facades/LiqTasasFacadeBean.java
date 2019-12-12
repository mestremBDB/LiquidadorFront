package core.rsolano.liqinterface.model.facades;

import core.rsolano.liqinterface.model.entities.AppAplicaciones;
import core.rsolano.liqinterface.model.entities.AppArchivos;
import core.rsolano.liqinterface.model.entities.AppArchivosaplicaciones;
import core.rsolano.liqinterface.model.entities.AppContingencia;
import core.rsolano.liqinterface.model.entities.AppContingenciaLiq;
import core.rsolano.liqinterface.model.entities.ConfCryptoalmacen;
import core.rsolano.liqinterface.model.entities.ConfCryptofirmas;
import core.rsolano.liqinterface.model.entities.ConfEventosproceso;
import core.rsolano.liqinterface.model.entities.ConfParametrosliquidador;
import core.rsolano.liqinterface.model.entities.ConfProcesosContingencia;
import core.rsolano.liqinterface.model.entities.ConfSqlloader;
import core.rsolano.liqinterface.model.entities.LogCryptolog;
import core.rsolano.liqinterface.model.utils.NetworkHelper;
import core.rsolano.liqinterface.model.utils.OSHelper;
import core.rsolano.liqinterface.model.entities.IdmGrupos;
import core.rsolano.liqinterface.model.entities.IdmUsuarios;

import core.rsolano.liqinterface.model.entities.NotifProceso;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "LiqTasasFacade", mappedName = "LiqInterface-Model-LiqTasasFacade")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LiqTasasFacadeBean implements LiqTasasFacade, LiqTasasFacadeLocal {
    
    @Resource
    SessionContext sessionContext;

    @PersistenceContext(unitName = "LiquidadorTasas")
    private EntityManager em;
    
    private String ServerName = "";
    private String UserName = "";
    private String UserDomain = "";
    

    public LiqTasasFacadeBean() {
    }
    
    @PostConstruct
    private void init(){
        ServerName = OSHelper.getServerName();
        //UserName = NetworkHelper.GetUser(); 
        //UserDomain = NetworkHelper.GetDomain();
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
    
    ///////////////////////////////// TABLA CONF_PARAMETROS ///////////////////////////////////////////////////////
    public String getParameter(String nombrecampo) {
        ConfParametrosliquidador parameters = (ConfParametrosliquidador)em.createNamedQuery("ConfParametrosliquidador.findByNombreCampo").setParameter("varNombreCampo", nombrecampo).getResultList().get(0);
        return parameters.getValorcampo();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int updateParameter(String nombrecampo, String valorcampo) {
       ConfParametrosliquidador parameters = (ConfParametrosliquidador)em.createNamedQuery("ConfParametrosliquidador.findByNombreCampo").setParameter("varNombreCampo", nombrecampo).getResultList().get(0);
       parameters.setValorcampo(valorcampo);
       //em.persist(parameters);
       em.merge(parameters);
       return 0;
    }
    
    /** <code>select o from ParametrosLiquidador o where o.nombreCampo =:varNombreCampo</code> */
    public List<ConfParametrosliquidador> getParametersAll() {
        List<ConfParametrosliquidador> list = em.createNamedQuery("ConfParametrosliquidador.findAll").getResultList(); 
        return list;
    }
    ///////////////////////////////// TABLA CONF_PARAMETROS ///////////////////////////////////////////////////////
    
    
    
    ///////////////////////////////// TABLA CONF_CRYPTOFIRMAS ///////////////////////////////////////////////////////
    
    public List<ConfCryptofirmas> getCryptofirmasByNhost() {
        List<ConfCryptofirmas> list = em.createNamedQuery("ConfCryptofirmas.findByNhost").setParameter("varNhost", ServerName).getResultList(); 
        return list;
    }
    
    public List<ConfCryptofirmas> getCryptofirmasAll() {
        List<ConfCryptofirmas> list = em.createNamedQuery("ConfCryptofirmas.findAll").getResultList(); 
        return list;
    }
    
    public ConfCryptofirmas  getSign(String aliaspub) {
        ConfCryptofirmas firma = (ConfCryptofirmas)em.createNamedQuery("ConfCryptofirmas.findByAliasPUB").setParameter("varAliaspub", aliaspub).setParameter("varNhost", ServerName).getResultList().get(0);
        return firma;
    }
        
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int insertSign(String nombrepub, String aliaspub, String aplicacion) {
        ConfCryptofirmas firmas = new ConfCryptofirmas(nombrepub, aliaspub, aplicacion, ServerName);
        em.persist(firmas);
        return 0;
    }
        
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int removeSign(String aliaspub) {
        ConfCryptofirmas firma = (ConfCryptofirmas)em.createNamedQuery("ConfCryptofirmas.findByAliasPUB").setParameter("varAliaspub", aliaspub).setParameter("varNhost", ServerName).getResultList().get(0);
        em.remove(firma);
        return 0;
    }
    ///////////////////////////////// TABLA CONF_CRYPTOFIRMAS ///////////////////////////////////////////////////////


    ///////////////////////////////// TABLA CONF_CRYPTOALMACEN ///////////////////////////////////////////////////////
    public ConfCryptoalmacen  getKeyStore() {
        List<ConfCryptoalmacen> almacen = em.createNamedQuery("ConfCryptoalmacen.findByNhost").setParameter("varNhost", ServerName).getResultList();
        if(!almacen.isEmpty()){ 
            return (ConfCryptoalmacen)em.createNamedQuery("ConfCryptoalmacen.findByNhost").setParameter("varNhost", ServerName).getResultList().get(0);
        }else{ 
            return null;
        }
    }
    
    public List<ConfCryptoalmacen> getKeyStores() {
        List<ConfCryptoalmacen> almacen = em.createNamedQuery("ConfCryptoalmacen.findAll").getResultList();
        if(!almacen.isEmpty()){ 
            return almacen;
        }else{ 
            return null;
        }
    }
    
    public List<ConfCryptoalmacen> getKeyStoresHost() {
        return em.createNamedQuery("ConfCryptoalmacen.findByNhost").setParameter("varNhost", ServerName).getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int insertKeyStore(String nombre, String ruta, String activo, String aplicacion) {
        ConfCryptoalmacen alamcen = new ConfCryptoalmacen(nombre, ServerName, ruta, activo, aplicacion);
        em.persist(alamcen);
        return 0;
    }
        
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int removeKeyStore() {
        ConfCryptoalmacen almacen = (ConfCryptoalmacen)em.createNamedQuery("ConfCryptoalmacen.findByNhost").setParameter("varNhost", ServerName).getResultList().get(0);
        em.remove(almacen);
        return 0;
    }
    
    public boolean KeyStoreExist(){
        boolean active = false;
        if(getKeyStore() != null){
          if(getKeyStore().getActivo().equalsIgnoreCase("1")) {
              active = true;
          }
        }
        return active;
    }
    
    ///////////////////////////////// TABLA CONF_EVENTOSPROCESO ///////////////////////////////////////////////////////
    public List<ConfEventosproceso> findByIdProceso(String idProceso){
      return  em.createNamedQuery("ConfEventosproceso.findByIdProceso").setParameter("idProceso", idProceso).getResultList();
    }
        
        
    ///////////////////////////////// TABLA CONF_CRYPTOALMACEN ///////////////////////////////////////////////////////
    
    ///////////////////////////////// TABLA LOG_CRYPTOLOG ///////////////////////////////////////////////////////
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public int insertLog(String accion, String user, String domain, String descripcion) {
        LogCryptolog log = new LogCryptolog(accion, descripcion, user, domain, ServerName);
        em.persist(log);
        return 0;
    }
    ///////////////////////////////// TABLA LOG_CRYPTOLOG ///////////////////////////////////////////////////////
    
    ///////////////////////////////// TABLA APP_APLICACIONES ///////////////////////////////////////////////////////
    
    /** <code>select o from AppAplicaciones o where o.id = :custId</code> */
    public List<AppAplicaciones> getAppAplicacionesFindById(String custId) {
        if (custId != null) {
            Long custIdLong = new Long(custId);
            return em.createNamedQuery("AppAplicaciones.findById").setParameter("custId", custIdLong).getResultList();
        }else {
           return getAppAplicacionesFindAll();
        }
    }
     
    /** <code>select o from AppAplicaciones o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppAplicaciones> getAppAplicacionesFindAll() {
        return em.createNamedQuery("AppAplicaciones.findAll", AppAplicaciones.class).getResultList();
    }
    
    public AppAplicaciones GetApplicationByName(String name){
        List<AppAplicaciones> apps = getAppAplicacionesFindAll();
        for(AppAplicaciones app : apps){
            if(name.equalsIgnoreCase(app.getNombre()))
                return app;
        }
        return null;
    }
    
    public String[] GetApplications(){
        List<AppAplicaciones> list = getAppAplicacionesFindAll();
        String[] apps = new String[list.size()];
        int index = 0;
        for( AppAplicaciones obj : list){
            apps[index++] = obj.getNombre();
        }
        return apps;
    }
    ///////////////////////////////// TABLA APP_APLICACIONES ///////////////////////////////////////////////////////
    
    ///////////////////////////////// TABLA APP_ARCHIVOSAPLICACIONES ////////////////////////////////////////////////
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppArchivosaplicaciones> getAppArchivosaplicacionesFindAll() {
        return em.createNamedQuery("AppArchivosaplicaciones.findAll", AppArchivosaplicaciones.class).getResultList();
    }
    
    public AppArchivosaplicaciones getAppArchAppsByAplicacion(String aplicacion){
        List<AppArchivosaplicaciones> list = getAppArchivosaplicacionesFindAll();
        for(AppArchivosaplicaciones obj : list){
            if(aplicacion.equalsIgnoreCase(obj.getAplicacion()))
                return obj;
        }
        return null;
    }
    
    ///////////////////////////////// TABLA APP_ARCHIVOSAPLICACIONES ////////////////////////////////////////////////
    
    
    
    
    ///////////////////////////////// TABLA CONF_SQLLOADER ///////////////////////////////////////////////////////
    public ConfSqlloader persistConfSqlloader(ConfSqlloader confSqlloader) {
        em.persist(confSqlloader);
        return confSqlloader;
    }
    ///////////////////////////////// TABLA CONF_SQLLOADER ///////////////////////////////////////////////////////
    
    ///////////////////////////////// TABLA IDM_GRUPOS ///////////////////////////////////////////////////////
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
    ///////////////////////////////// TABLA IDM_GRUPOS ///////////////////////////////////////////////////////
    
    ///////////////////////////////// TABLA IDM_USUARIOS /////////////////////////////////////////////////////
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
    ///////////////////////////////// TABLA IDM_USUARIOS ///////////////////////////////////////////////////////
    
    ///////////////////////////////// TABLA APP_ARCHIVOS ///////////////////////////////////////////////////////
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> getDatesAppArchivos() {
        /*String query = "select distinct(trunc(fecha,'YYYY')) from app_archivos";
        List results = em.createNativeQuery(query).getResultList();
        List<String> ret = null;
        Object[] r;
        BigDecimal aux;
        
        if(results != null){
            ret = new ArrayList<String>();
            for(Object result : results ){
                r = (Object[])result;
                aux = (BigDecimal)r[0];
                ret.add(String.valueOf(aux.intValue()));
            }
        }
        return ret; */   
        return null;
    }
    
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<AppArchivos> getAppArchivosAll() {
        return em.createNamedQuery("AppArchivos.findAll", AppArchivos.class).getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public AppArchivos getAppArchivosByIndex(boolean first) {
        List<AppArchivos> apparchivos = em.createNamedQuery("AppArchivos.findByIndex", AppArchivos.class).getResultList(); 
        int last = apparchivos.size() - 1;
        if(!first)
            return apparchivos.get(0);
        else
            return apparchivos.get(last);
    }
    
    ///////////////////////////////// TABLA IDM_USUARIOS ///////////////////////////////////////////////////////
    
    
    ///////////////////////////////// TABLA AppAplicaciones ///////////////////////////////////////////////////////
    public List<NotifProceso> listaProcesos() {
        return em.createNamedQuery("NotifProceso.findAllContingencia").getResultList();
    }
    
    public List<AppAplicaciones> findByProceso(String proceso) {
        return em.createNamedQuery("AppAplicaciones.findByProceso").setParameter("proceso", proceso).getResultList();
    }
    
    ///////////////////////////////// TABLA NOTIF_PROCESO ///////////////////////////////////////////////////////
   
    
    ///////////////////////////////// TABLA APP_CONTINGENCIA  ///////////////////////////////////////////////////////
    public AppContingenciaLiq persistContingencia(AppContingenciaLiq contingencia) {
        em.persist(contingencia);
        return contingencia;
    }
    
    public List<AppContingenciaLiq> maxId(){
        return em.createNamedQuery("AppContingenciaLiq.findMaxId").getResultList();
    }
    
    ///////////////////////////////// NATIVE QUERY //////////////////////////////////////////////////////////////
    public String ExecuteQueryUpdate(String query){
        String ret = "";
        try{
            Integer number = em.createNativeQuery(query).executeUpdate();
            ret = "success." + number.toString();
        }catch(Exception e){
            e.printStackTrace();
            ret = "error." + e.getMessage();
        }
        return ret;
    }
    
    public List<Object[]> getSQLQuery(String query ) {     
        List<Object[]> result = em.createNativeQuery(query).getResultList();
        return result;
    }
    
    public List<ConfProcesosContingencia> findByIdProcesoC(String idProceso){
        return  em.createNamedQuery("ConfProcesosContingencia.findByIdProcesoC").setParameter("idProceso", idProceso).getResultList();
    }
}
