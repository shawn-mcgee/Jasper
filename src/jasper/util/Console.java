package jasper.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Objects;

public class Console {
    public static Logger
        info = Logger.create(System.out),
        warn = Logger.create(System.err);
    
    private Console() {
        // do nothing
    }
    
    public static void info() {
        info.log("Info", "");
    }
    
    public static void info(Object event) {
        info.log("Info", event);
    }
    
    public static void info(Object trace, Object event) {
        info.log(trace, event);
    }
    
    public static void warn() {
        warn.log("Warn", "");
    }
    
    public static void warn(Object event) {
        warn.log("Warn", event);
    }
    
    public static void warn(Object trace, Object event) {
        warn.log(trace, event);
    }
    
    public interface Logger {
        public void log(Object trace, Object event);
        
        public static void log(PrintStream out, Object trace, Object event) {
            String prefix;
            if (trace instanceof String)
                prefix = String.format("[%1$s]", trace);
            else {
                try {
                    String
                        _class = trace.getClass().getEnclosingMethod().getDeclaringClass().getName(),
                        _trace = trace.getClass().getEnclosingMethod().getName();
                    prefix = String.format("[%1$s.%2$s]", _class, _trace);
                } catch (Exception na) {
                    prefix = String.format("[%1$s]", LocalDateTime.now());
                }
            }
            for (String message : Objects.toString(event).split("\n"))
                out.printf("%1$s %2$s%n", prefix, message);
        }
        
        public static void log(PrintWriter out, Object trace, Object event) {
            String prefix;
            if (trace instanceof String)
                prefix = String.format("[%1$s]", trace);
            else {
                try {
                    String
                        _class = trace.getClass().getEnclosingMethod().getDeclaringClass().getName(),
                        _trace = trace.getClass().getEnclosingMethod().getName();
                    prefix = String.format("[%1$s.%2$s]", _class, _trace);
                } catch (Exception na) {
                    prefix = String.format("[%1$s]", LocalDateTime.now());
                }
            }
            for (String message : Objects.toString(event).split("\n"))
                out.printf("%1$s %2$s%n", prefix, message);
        }
        
        public static Logger create(PrintStream out) {
            return (trace, event) -> log(out, trace, event);
        }
        
        public static Logger create(PrintWriter out) {
            return (trace, event) -> log(out, trace, event);
        }
    }
}
