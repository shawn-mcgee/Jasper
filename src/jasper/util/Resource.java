package jasper.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Objects;

import static java.nio.file.StandardOpenOption.APPEND;

public final class Resource {
    
    private Resource() {
        // do nothing
    }
    
    public static InputStream newInputStream(Class<?> loader, String path) {
        return loader.getResourceAsStream(path);
    }

    public static InputStream newInputStream(String path, OpenOption... options) {
        return newInputStream(Path.of(path), options);
    }

    public static InputStream newInputStream(Path   path, OpenOption... options) {
        try {
            return Files.newInputStream(path, options);
        } catch (IOException ioe){
            Debug.warn(new Object() { }, "Unable to open resource '" + info(path) + "'");
            return null;
        }
    }

    public static OutputStream newOutputStream(String path, OpenOption... options) {
        return newOutputStream(Path.of(path), options);
    }

    public static OutputStream newOutputStream(Path   path, OpenOption... options) {
        try {
            return Files.newOutputStream(path, options);
        } catch(IOException ioe) {
            Debug.warn(new Object() { }, "Unable to open resource '" + info(path) + "'");
            return null;
        }
    }
    
    public static byte[] readBytes(Class<?> loader, String path) {
        return readBytes(newInputStream(loader, path), info(loader, path));
    }
    
    public static byte[] readBytes(String path) {
        return readBytes(newInputStream(path), info(path));
    }
    
    public static byte[] readBytes(Path   path) {
        return readBytes(newInputStream(path), info(path));
    }
    
    public static void writeBytes(String path, byte[] raw) {
        writeBytes(newOutputStream(path), raw, info(path));
    }
    
    public static void writeBytes(Path   path, byte[] raw) {
        writeBytes(newOutputStream(path), raw, info(path));
    }
    
    public static <T> T readObject(Class<?> loader, String path) {
        return readObject(newInputStream(loader, path), info(path));
    }
    
    public static <T> T readObject(String path) {
        return readObject(newInputStream(path), info(path));
    }
    
    public static <T> T readObject(Path   path) {
        return readObject(newInputStream(path), info(path));
    }
    
    public static <T> void writeObject(String path, T t) {
        writeObject(newOutputStream(path), t, info(path));
    }
    
    public static <T> void writeObject(Path   path, T t) {
        writeObject(newOutputStream(path), t, info(path));
    }
    
    public static String readString(Class<?> loader, String path) {
        return readString(newInputStream(loader, path), info(loader, path));
    }
    
    public static String readString(String path) {
        return readString(newInputStream(path), info(path));
    }
    
    public static String readString(Path   path) {
        return readString(newInputStream(path), info(path));
    }
    
    public static void writeString(String path, Object o) {
        writeString(newOutputStream(path), o, info(path));
    }
    
    public static void writeString(Path   path, Object o) {
        writeString(newOutputStream(path), o, info(path));
    }
    
    public static void writeString(String path, Object o, boolean append) {
        writeString(append ? newOutputStream(path, APPEND) : newOutputStream(path), o, info(path));
    }
    
    public static void writeString(Path   path, Object o, boolean append) {
        writeString(append ? newOutputStream(path, APPEND) : newOutputStream(path), o, info(path));
    }
    
    public static void delete(String path) {
        delete(Path.of(path));
    }
    
    public static void delete(Path   path) {
        try {
            Files.delete(path);
        } catch (IOException ioe) {
            Debug.warn(new Object() { }, "Unable to delete resource '" + info(path) + "'");
        }
    }

    public static String info(Class<?> loader, String path) {
        return loader.getName() + " " + path;
    }

    public static String info(String path) {
        return Resource.info(Path.of(path));
    }

    public static String info(Path   path) {
        return Objects.toString(path);
    }
    
    protected static byte[] readBytes(InputStream from, String info) {
        try(BufferedInputStream in = new BufferedInputStream(from)) {
            return in.readAllBytes();
        } catch (Exception na) {
            Debug.warn(new Object() { }, "Unable to read bytes from resource '" + info + "'");
        }
        return null;
    }
    
    protected static void writeBytes(OutputStream to, byte[] raw, String info) {
        try(BufferedOutputStream out = new BufferedOutputStream(to)) {
            out.write(raw);
            out.flush(   );
        } catch (Exception na) {
            Debug.warn(new Object() { }, "Unable to write bytes to resource '" + info + "'");
        }
    }
    
    protected static <T> T readObject(InputStream from, String info) {
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(from))) {
            return Unsafe.cast(in.readObject());
        } catch (Exception na) {
            Debug.warn(new Object() { }, "Unable to read from resource '" + info + "'");
        }
        return null;
    }
    
    protected static <T> void writeObject(OutputStream to, T t, String info) {
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(to))) {
            out.writeObject(t);
            out.flush      ( );
        } catch (Exception na) {
            Debug.warn(new Object() { }, "Unable to write to resource '" + info + "'");
        }
    }
    
    protected static String readString(InputStream from, String info) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(from))) {
            StringBuilder sb = new StringBuilder();
            int c;
            while((c = in.read()) != -1)
                sb.append((char)c);
            return sb.toString();
        } catch(Exception na) {
            Debug.warn(new Object() { }, "Unable to read string from resource '" + info + "'");
        }
        return null;
    }
    
    protected static void writeString(OutputStream to, Object o, String info) {
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(to))) {
            out.write(Objects.toString(o));
            out.flush(                   );
        } catch(Exception na) {
            Debug.warn(new Object() { }, "Unable to write string to resource '" + info + "'");
        }
    }
}
