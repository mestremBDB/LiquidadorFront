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

import core.rsolano.liqinterface.model.entities.IdmGrupos;
import core.rsolano.liqinterface.model.entities.IdmUsuarios;

import core.rsolano.liqinterface.model.entities.NotifProceso;

import java.util.List;
import javax.ejb.Local;

@Local
public interface LiqTasasFacadeLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);
    <T> T persistEntity(T entity);
    <T> T mergeEntity(T entity);
    
    ///////////////////////////////// TABLA CONF_PARAMETROS ///////////////////////////////////////////////////////
    int updateParameter(String nombrecampo, String valorcampo);
    String getParameter(String nombrecampo);
    List<ConfParametrosliquidador> getParametersAll();
    
    ///////////////////////////////// TABLA CONF_CRYPTOFIRMAA ///////////////////////////////////////////////////////
    List<ConfCryptofirmas> getCryptofirmasAll();
    ConfCryptofirmas  getSign(String aliaspub);
    int insertSign(String nombrepub, String aliaspub, String aplicacion);
    int removeSign(String aliaspub);
    
    ///////////////////////////////// TABLA CONF_CRYPTOALMACEN ///////////////////////////////////////////////////////
    ConfCryptoalmacen  getKeyStore();
    List<ConfCryptoalmacen>  getKeyStores();
    List<ConfCryptoalmacen> getKeyStoresHost();
    int insertKeyStore(String nombre, String ruta, String activo, String aplicacion);
    int removeKeyStore();
    boolean KeyStoreExist();
    
    ///////////////////////////////// TABLA CONF_EVENTOSPROCESO ///////////////////////////////////////////////////////
    public List<ConfEventosproceso> findByIdProceso(String idProceso);
    
    ///////////////////////////////// TABLA LOG_CRYPTOLOG ///////////////////////////////////////////////////////
    int insertLog(String accion, String user, String domain, String descripcion);
    
    ///////////////////////////////// TABLA APP_APLICACIONES ///////////////////////////////////////////////////////
    List<AppAplicaciones> getAppAplicacionesFindAll();
    String[] GetApplications();
    AppAplicaciones GetApplicationByName(String name);
    public List<AppAplicaciones> findByProceso(String proceso);
    
    //////////////////////////////// TABLA APP_ARCHIVOSAPLICACIONES ////////////////////////////////////////////////
    List<AppArchivosaplicaciones> getAppArchivosaplicacionesFindAll();
    AppArchivosaplicaciones getAppArchAppsByAplicacion(String aplicacion);
    
    ///////////////////////////////// TABLA CONF_SQLLOADER ///////////////////////////////////////////////////////
    ConfSqlloader persistConfSqlloader(ConfSqlloader confSqlloader);
    
    ///////////////////////////////// TABLA IDM_GRUPOS ///////////////////////////////////////////////////////
    IdmGrupos persistIdmGrupos(IdmGrupos idmGrupos);
    IdmGrupos mergeIdmGrupos(IdmGrupos idmGrupos);
    void removeIdmGrupos(IdmGrupos idmGrupos);
    List<IdmGrupos> getIdmGruposFindAll();
                    
    ///////////////////////////////// TABLA IDM_USUARIOS /////////////////////////////////////////////////////
    IdmUsuarios persistIdmUsuarios(IdmUsuarios idmUsuarios);
    IdmUsuarios mergeIdmUsuarios(IdmUsuarios idmUsuarios);
    void removeIdmUsuarios(IdmUsuarios idmUsuarios);
    List<IdmUsuarios> getIdmUsuariosFindAll();
    
    ///////////////////////////////// TABLA APP_ARCHIVOS ///////////////////////////////////////////////////////
    List<AppArchivos> getAppArchivosAll();
    AppArchivos getAppArchivosByIndex(boolean first);
    List<String> getDatesAppArchivos();
    
    ///////////////////////////////// NATIVE QUERY //////////////////////////////////////////////////////////////
    String ExecuteQueryUpdate(String query);
    List<Object[]> getSQLQuery(String query);
    
    ///////////////////////////////// TABLA NOTIF_PROCESOS ///////////////////////////////////////////////////////
    public List<NotifProceso> listaProcesos();
    
    ///////////////////////////////// TABLA APP_CONTINGENCIA_LIQ ///////////////////////////////////////////////////////
    public AppContingenciaLiq persistContingencia(AppContingenciaLiq contingencia);
    public List<AppContingenciaLiq> maxId();
    
    ///////////////////////////////// TABLA CONF_PROCESOS_CONTINGENCIA ///////////////////////////////////////////////////////
    public List<ConfProcesosContingencia> findByIdProcesoC(String idProceso);
}
