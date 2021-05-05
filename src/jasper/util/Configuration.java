package jasper.util;

import java.nio.file.Path;
import java.util.Map;

import static jasper.util.ObjectToString.objectToString;
import static jasper.util.StringToObject.stringToObject;

public final class Configuration {
    
    private Configuration() {
        // do nothing
    }
    
    public static <T extends Map<String, String>> T configure(T cfg, Object... args) {
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
        return getProperty(cfg, key, null);
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
    
    public static <OBJECT> OBJECT getPropertyAs(Map<String, String> cfg, Object key, StringToObject<OBJECT> s2o            ) {
        return getPropertyAs(cfg, key, s2o, null);
    }
    
    public static <OBJECT> OBJECT getPropertyAs(Map<String, String> cfg, Object key, StringToObject<OBJECT> s2o, OBJECT alt) {
        String _key = key != null ? key.toString() : null;
        try {
            String _val = cfg.get(_key);
            return _val != null ? stringToObject(s2o, _val, alt) : alt;
        } catch(Exception na) {
            return                                                 alt;
        }
    }
    
    public static <T extends Map<String, String>> T load(T cfg, Class<?> loader, String path) {
        return Configuration.fromString(cfg, Resource.readString(loader, path));
    }
    
    public static <T extends Map<String, String>> T load(T cfg, String path) {
        return Configuration.fromString(cfg, Resource.readString(path));
    }
    
    public static <T extends Map<String, String>> T load(T cfg, Path   path) {
        return Configuration.fromString(cfg, Resource.readString(path));
    }
    
    public static <T extends Map<String, String>> void save(T cfg, String path) {
        Resource.writeString(path, Configuration.toString(cfg));
    }
    
    public static <T extends Map<String, String>> void save(T cfg, Path   path) {
        Resource.writeString(path, Configuration.toString(cfg));
    }
    
    public static <T extends Map<String, String>> String toString(T cfg) {
        StringBuilder sb = new StringBuilder();
        cfg.forEach((key, val) -> {
            sb.append(key)
                .append(": ")
                .append(val )
                .append("\n");
        });
        return sb.toString();
    }
    
    public static <T extends Map<String, String>> T fromString(T cfg, String s) {
        if(s != null) {
            String[] t = (s + " ").split("\\n");
            for (String u: t) {
                if((u = u.strip()).startsWith("#") || u.startsWith("//"))
                    continue;
                int i = u.indexOf(":");
                if(i >= 0) {
                    String
                        u0 = u.substring(0, i).strip(),
                        u1 = u.substring(++ i).strip();
                    setProperty(cfg, u0, u1);
                }
            }
        }
        return cfg;
    }
}
