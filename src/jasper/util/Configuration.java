package jasper.util;

import java.util.Map;

import static jasper.util.ObjectToString.objectToString;
import static jasper.util.StringToObject.stringToObject;

public class Configuration {
    
    public static <CONFIG extends Map<String, String>> CONFIG configure(CONFIG cfg, Object... args) {
        for(int i = 0; i < args.length; i += 2) {
            int
                a = (i + 0),
                b = (i + 1);
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
    
    public static <CONFIG extends Map<String, String>> CONFIG parse(CONFIG cfg, String s, String... tags) {
        return cfg;
    }
}
