package jasper.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Objects;

public class Debug {
    public static Logger
        info = Logger.create(System.out),
        warn = Logger.create(System.err);
    
    private Debug() {
        // do nothing
    }
    
    public static void info(Object event) {
        if(info != null)
            info.log("Info", event);
    }
    
    public static void info(Object trace, Object event) {
        if(info != null)
            info.log(trace, event);
    }
    
    public static void warn(Object event) {
        if(warn != null)
            warn.log("Warn", event);
    }
    
    public static void warn(Object trace, Object event) {
        if(warn != null)
            warn.log(trace, event);
    }
    
    public interface Logger {
        public void log(Object trace, Object event, Object... args);
        
        public static void log(PrintStream out, Object trace, Object event, Object...args) {
            String prefix;
            if (trace instanceof String)
                prefix = String.format("[%1$s]", trace);
            else {
                try {
                    String
                        _class = trace.getClass().getEnclosingMethod().getDeclaringClass().getName(),
                        _trace = trace.getClass().getEnclosingMethod()                    .getName();
                    prefix = String.format("[%1$s.%2$s]", _class, _trace);
                } catch (Exception na) {
                    prefix = String.format("[%1$s]", LocalDateTime.now());
                }
            }
            for (String message : format(event, args))
                out.printf("%1$s %2$s%n", prefix, message);
        }
        
        public static void log(PrintWriter out, Object trace, Object event, Object... args) {
            String prefix;
            if (trace instanceof String)
                prefix = String.format("[%1$s]", trace);
            else {
                try {
                    String
                        _class = trace.getClass().getEnclosingMethod().getDeclaringClass().getName(),
                        _trace = trace.getClass().getEnclosingMethod()                    .getName();
                    prefix = String.format("[%1$s.%2$s]", _class, _trace);
                } catch (Exception na) {
                    prefix = String.format("[%1$s]", LocalDateTime.now());
                }
            }
            for (String message : format(event, args))
                out.printf("%1$s %2$s%n", prefix, message);
        }
    
        private static String[] format(Object event, Object... args) {
            return String.format(Objects.toString(event), args).split("\n");
        }
        
        public static Logger create(PrintStream out) {
            return (trace, event, args) -> log(out, trace, event, args);
        }
        
        public static Logger create(PrintWriter out) {
            return (trace, event, args) -> log(out, trace, event, args);
        }
    }
}
