package jasper.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import static jasper.util.ObjectToString.objectToString;
import static jasper.util.StringToObject.stringToObject;

public final class Utility {
    
    public static <T> T copyOf(T t) {
        if (t instanceof Copyable) {
            Copyable<?> u = Unsafe.cast(t       );
            return          Unsafe.cast(u.copy());
        } else if (t != null)
            Debug.warn(new Object() { }, typeOf(t) + " is not of type jasper.util.Copyable");
        return t;
    }
    
    public static <T> Class<T> typeOf(T t) {
        return Unsafe.cast(t.getClass());
    }
    
    public static File requestFile(URL    path) {
        try {
            return new File(path.toURI()  );
        } catch (URISyntaxException use) {
            return new File(path.getPath());
        } catch(Exception e) {
            Debug.warn(new Object() {/* trace */}, "Unable to convert path '" + path + "' to file.");
        }
        return null;
    }
    
    public static File requestFile(String path) {
        try {
            return new File(path);
        } catch(Exception e) {
            Debug.warn(new Object() {/* trace */}, "Unable to convert path '" + path + "' to file.");
        }
        return null;
    }
    
    public static File requireFile(URL    path) {
        return requireFile(requestFile(path));
    }
    
    public static File requireFile(String path) {
        return requireFile(requestFile(path));
    }
    
    public static File requireFile(File file) {
        if(file != null && !file.exists())
            try {
                if(file.getParentFile() != null)
                    file.getParentFile().mkdirs();
                file.createNewFile();
            } catch(Exception e) {
                Debug.warn(new Object() {/* trace */}, "Unable to create file \"" + file + "\"");
            }
        return file;
    }
    
    
    public static void deleteFile(URL    path) {
    
    }
    
    public static void deleteFile(String path) {
    
    }
    
    public static void deleteFile(File file) {
    
    }
    
    public static Map<String, String> configure(Map<String, String> cfg, Object... args) {
        int
            n = args.length & 1,
            m = args.length - n;
        for(int i = 0; i < m; i += 2) {
            int
                a = i + 0,
                b = i + 1;
            setProperty(cfg, args[a], args[b]);
        }
        return cfg;
    }
    
    public static String setProperty(Map<String, String> cfg, Object key, Object val) {
        if(cfg != null) {
            String
                _key = key != null ? key.toString() : null,
                _val = val != null ? val.toString() : null;
            cfg.put(_key, _val);
            return        _val ;
        } else
            return        null ;
    }
    
    public static <OBJECT> String setProperty(Map<String, String> cfg, Object key, ObjectToString<OBJECT> o2s, OBJECT val            ) {
        return setProperty(cfg, key, objectToString(o2s, val, null));
    }
    
    public static <OBJECT> String setProperty(Map<String, String> cfg, Object key, ObjectToString<OBJECT> o2s, OBJECT val, String alt) {
        return setProperty(cfg, key, objectToString(o2s, val, alt ));
    }
    
    public static String getProperty(Map<String, String> cfg, Object key            ) {
        return getProperty(cfg, key, (Object)null);
    }
    
    public static String getProperty(Map<String, String> cfg, Object key, Object alt) {
        String
            _key = key != null ? key.toString() : null,
            _alt = alt != null ? alt.toString() : null;
        try {
            String _val = cfg.get(_key);
            return _val != null ? _val : _alt;
        } catch(Exception na) {
            return                       _alt;
        }
    }
    
    public static <OBJECT> OBJECT getProperty(Map<String, String> cfg, Object key, StringToObject<OBJECT> s2o            ) {
        return getProperty(cfg, key, s2o, null);
    }
    
    public static <OBJECT> OBJECT getProperty(Map<String, String> cfg, Object key, StringToObject<OBJECT> s2o, OBJECT alt) {
        String _key = key != null ? key.toString() : null;
        try {
            String _val = cfg.get(_key);
            return _val != null ? stringToObject(s2o, _val, alt) : alt;
        } catch(Exception na) {
            return                                                 alt;
        }
    }
    
    private Utility() {
        // do nothing
    }
}
