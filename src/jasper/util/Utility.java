package jasper.util;

public final class Utility {
    
    private Utility() {
        // do nothing
    }
    
    public static <T> Class<T> typeOf(T t) {
        return Unsafe.cast(t.getClass());
    }
    
    public static String[] parse(String s, String... tags) {
        String[]
            // split s at commas, append " " for edge case when string ends with comma
            t  = (s.trim() + " ").split(","),
            u0 = new String[t.length], // split labels
            u1 = new String[t.length]; // split values
        int
            l = tags.length, // cached length
            m =    t.length; // cached length
        
        // split t into u0 and u1, and count labeled values
        int i, j;
        int a0 = 0, a1; // number of labeled and unlabeled value
        for(i = 0; i < m; i ++) {
            // split t[i] at colons, append " " for edge case when string ends with colon
            String[] u = (t[i] + " ").split(":");
            if(u.length > 1) { // a label is being used     (e.g. label:value)
                u0[i] = u[0].trim();
                u1[i] = u[1].trim();
                a0 ++;
            } else             // a label is not being used (e.g.       value)
                u1[i] = u[0].trim();
        }
        a1 = m - a0;
        
        t = new String[l]; // recycle t
        
        // split tags into alias array
        String[][] alias = new String[l][0];
        for(i = 0; i < l; i ++) {
            // split tags[i] at pipes, append " " for edge case when string ends with pipe
            String[] a = (tags[i] + " ").split("\\|");
            for(j = 0; j < a.length; j ++)
                a[j] = a[j].trim();
            alias[i] = a;
        }
        
        // find, move, and count matching labels
        int b0 = 0, b1; // number of matched and unmatched tags
        for(i = 0; i < l; i ++)
b:          for(j = 0; j < m; j ++) {
//                if (u0[j] != null && u0[j].equals(tags[i])) {
                if(u0[j] != null) {
                    for(String tag: alias[i])
                        if(u0[j].equals(tag)) {
                            t[i] = u1[j];
                            u0[j] = null;
                            u1[j] = null;
                            b0 ++;
                            continue b;
                        }
                }
            }
        b1 = l - b0;
        
        // compute final array size
        String[] u = new String[
            l + // number of tags
            Math.max(a1 - b1, 0) + // number of remaining unlabeled values
            Math.max(a0 - b0, 0)   // number of remaining   labeled values
        ];
        
        // fill empty slots with unlabeled values
        j = 0;
        for(i = 0; i < l; i ++)
            if(t[i] != null)
                u[i] = t[i];
            else
                for(; j < m; j ++)
                    if(u0[j] == null && u1[j] != null) {
                        u[i] = u1[j];
                        u0[j] = null;
                        u1[j] = null;
                        break;
                    }
        
        // fill empty slots with remaining values
        j = 0;
        for(i = l; i < u.length; i ++)
            if(u[i] == null)
                for(; j < m; j ++)
                    if(u1[j] != null) {
                        u[i] = u1[j];
                        u0[j] = null;
                        u1[j] = null;
                        break;
                    }
        
        return u;
    }

    public static boolean isBlank(String string) {
        return string.trim().isEmpty();
    }
}
