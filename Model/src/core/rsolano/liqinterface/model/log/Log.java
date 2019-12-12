package core.rsolano.liqinterface.model.log;

import java.net.URL;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.Level;

public class Log {
    private static Logger ownLogger;

    static {
        try {
            URL url = Loader.getResource("/Resources/log4j.properties"); 
            PropertyConfigurator.configure(url);
            ownLogger = Logger.getLogger("CryptoKeyMangerLight");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * M�todo para obtener el log
     * @return Log para registrar trazas
     */
    public static Logger getLogger(Class clase) {
        ownLogger = Logger.getLogger(clase);
        return ownLogger;
    }

    public static void debug(String generador, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }

            if (ownLogger.isEnabledFor(DebugAplLevel.DEBUGAPL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.log(DebugAplLevel.DEBUGAPL, buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void debug(String generador, String parametros, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }

            if (ownLogger.isEnabledFor(DebugAplLevel.DEBUGAPL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.log(DebugAplLevel.DEBUGAPL, buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void debug(String generador, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }

            if (ownLogger.isEnabledFor(DebugAplLevel.DEBUGAPL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.log(DebugAplLevel.DEBUGAPL, buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void debug(String generador, String parametros, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }

            if (ownLogger.isEnabledFor(DebugAplLevel.DEBUGAPL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.log(DebugAplLevel.DEBUGAPL, buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void debug(String generador, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }

            if (ownLogger.isEnabledFor(DebugAplLevel.DEBUGAPL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.log(DebugAplLevel.DEBUGAPL, buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String generador, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.INFO)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String generador, String parametros, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.INFO)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String generador, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.INFO)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String generador, String parametros, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.INFO)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void info(String generador, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.INFO)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void warn(String generador, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.WARN)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.warn(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void warn(String generador, String parametros, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.WARN)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.warn(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void warn(String generador, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.WARN)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.warn(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void warn(String generador, String parametros, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.WARN)) {

                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.warn(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void warn(String generador, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.WARN)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void error(String generador, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.ERROR)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.error(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void error(String generador, String parametros, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.ERROR)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.error(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void error(String generador, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.ERROR)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.error(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void error(String generador, String parametros, String mensaje, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.ERROR)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.error(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void error(String generador, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.ERROR)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fatal(String generador, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.FATAL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.fatal(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fatal(String generador, String parametros, String mensaje) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.FATAL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                ownLogger.fatal(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fatal(String generador, String mensaje, Throwable fatal) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.FATAL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(fatal.getMessage());
                buffer.append("]");
                ownLogger.fatal(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fatal(String generador, String parametros, String mensaje, Throwable fatal) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.FATAL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Parametros: ");
                buffer.append(parametros);
                buffer.append("]");
                buffer.append("[Mensaje: ");
                buffer.append(mensaje);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(fatal.getMessage());
                buffer.append("]");
                ownLogger.fatal(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fatal(String generador, Throwable error) {
        try {
            if (ownLogger == null) {
                ownLogger = org.apache.log4j.Logger.getLogger("Log");
            }
            if (ownLogger.isEnabledFor(Level.FATAL)) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("[");
                buffer.append(generador);
                buffer.append("]");
                buffer.append("[Error: ");
                buffer.append(error.getMessage());
                buffer.append("]");
                ownLogger.info(buffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
