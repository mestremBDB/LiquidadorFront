package core.rsolano.liqinterface.model.log;

import org.apache.log4j.Level;
import org.apache.log4j.net.SyslogAppender;

public class DebugAplLevel extends Level {
    public static final int DEBUGAPL_INT = DEBUG_INT + 10;
    public static final String DEBUGAPL_STR = "DEBUGAPL";
    public static final Level DEBUGAPL = new DebugAplLevel(DEBUGAPL_INT, DEBUGAPL_STR, SyslogAppender.LOG_LOCAL0);

    public DebugAplLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }

    public static Level toLevel(String s) {
        return toLevel(s, DebugAplLevel.DEBUGAPL);
    }

    public static Level toLevel(int i) {
        return toLevel(i, DebugAplLevel.DEBUGAPL);
    }

    public static Level toLevel(int i, Level level) {
        return (i == DEBUGAPL_INT) ? DebugAplLevel.DEBUGAPL : Level.toLevel(i, level);
    }

    public static Level toLevel(String s, Level level) {

		return (s == null) ? DebugAplLevel.DEBUGAPL : ((s.equalsIgnoreCase(DebugAplLevel.DEBUGAPL_STR)) ? DebugAplLevel.DEBUGAPL : Level.toLevel(s, level));
    }
}

