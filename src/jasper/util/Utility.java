package jasper.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

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
        if(!file.exists())
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
    
    private Utility() {
        // do nothing
    }
}
