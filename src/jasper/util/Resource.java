package jasper.util;

import java.io.*;
import java.util.Locale;
import java.util.Objects;

public class Resource implements Copyable<Resource>, Serializable {
    private static final long
        serialVersionUID = 1L;
    
    protected Class<?>
        from;
    protected String
        path;
    
    protected Resource() {
        // do nothing
    }
    
    public Resource(Resource resource) {
        this.from = resource.from;
        this.path = resource.path;
    }
    
    public Resource(String   resource) {
        String[] u = (resource + " ").split(":");
        String
            from = u.length > 1 ? u[0].trim() : null,
            path = u.length > 1 ? u[1].trim() : u[0].trim();
        try {
            if(from != null) {
                this.path = path;
                this.from = Class.forName(from);
            } else {
                this.path = path;
                this.from = null;
            }
        } catch(Exception na) {
            Debug.warn("jasper.util.Resource.fromString", na);
        }
    }
    
    public Resource(Class<?> from, String path) {
        this.from = from;
        this.path = path;
    }
    
    public Resource(String   from, String path) {
        try {
            if(from != null) {
                this.path = path;
                this.from = Class.forName(from);
            } else {
                this.path = path;
                this.from = null;
            }
        } catch(Exception na) {
            Debug.warn("jasper.util.Resource.fromString", na);
        }
    }
    
    public Class<?> from() {
        return from;
    }
    
    public String   path() {
        return path;
    }

    public boolean exists() {
        return Resource.exists(this);
    }

    public boolean create() {
        return Resource.create(this);
    }

    public boolean delete() {
        return Resource.delete(this);
    }

    public InputStream newInputStream() {
        return Resource.newInputStream(this);
    }

    public byte[] readBytes() {
        return Resource.readBytes(this);
    }

    public <T> T readObject() {
        return Resource.readObject(this);
    }

    public String readString() {
        return Resource.readString(this);
    }

    public OutputStream newOutputStream() {
        return Resource.newOutputStream(this);
    }

    public void writeBytes(byte[] b) {
        Resource.writeBytes(this, b);
    }

    public <T> void writeObject(T t) {
        Resource.writeObject(this, t);
    }

    public void writeString(Object o) {
        Resource.writeString(this, o);
    }
    
    @Override
    public Resource copy() {
        return new Resource(this);
    }
    
    @Override
    public String toString() {
        return Resource.toString(this);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Resource) {
            Resource b = (Resource)o;
            String
                s0 =   toString(),
                s1 = b.toString();
            return s0.equals(s1);
        } else
            return false;
    }
    
    public static String toString(Resource resource) {
        return Resource.toString(
            resource.from,
            resource.path
        );
    }
    
    public static String toString(Class<?> from, String path) {
        if(from != null)
            return from.getName() + ":" + path;
        else
            return                        path;
    }
    
    public static String toString(String   from, String path) {
        if(from != null)
            return from + ":" + path;
        else
            return              path;
    }
    
    public static Resource fromString(String s) {
        return new Resource(s);
    }
    
    public static boolean exists(Resource resource) {
        if(resource.from != null)
            return resource.from.getResource(resource.path) != null;
        else
            return new File(resource.path).exists();
    }
    
    public static boolean exists(String   resource) {
        return exists(new Resource(resource));
    }
    
    public static boolean exists(Class<?> from, String path) {
        return exists(new Resource(from, path));
    }
    
    public static boolean exists(String   from, String path) {
        return exists(new Resource(from, path));
    }
    
    public static boolean create(Resource resource) {
        if(resource.from != null)
                Debug.warn(new Object() { }, "Unable to create resource '" + resource + "'");
        else
            try {
                File file = new File(resource.path);
                if(!file.exists()) {
                    if (file.getParentFile() != null)
                        file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                return true;
            } catch (Exception na) {
                Debug.warn(new Object() {}, "Unable to create resource '" + resource + "'");
            }
        return false;
    }
    
    public static boolean create(String   resource) {
        return create(new Resource(resource));
    }
    
    public static boolean delete(Resource resource) {
        if(resource.from != null)
                Debug.warn(new Object() { }, "Unable to delete resource '" + resource + "'");
        else
            try {
                return new File(resource.path).delete();
            } catch(Exception na) {
                Debug.warn(new Object() { }, "Unable to delete resource '" + resource + "'");
            }
        return false;
    }
    
    public static boolean delete(String   resource) {
        return delete(new Resource(resource));
    }
    
    public static InputStream newInputStream(Resource resource) {
        if(resource.from != null)
            return resource.from.getResourceAsStream(resource.path);
        else try {
            return new               FileInputStream(resource.path);
        } catch(Exception na) {
            Debug.warn(new Object() { }, "Unable to open resource '" + resource + "'");
            return null;
        }
    }
    
    public static InputStream newInputStream(String   resource) {
        return newInputStream(new Resource(resource));
    }
    
    public static InputStream newInputStream(Class<?> from, String path) {
        try {
            if(from != null)
                return from.getResourceAsStream(path);
            else
                return new      FileInputStream(path);
        } catch(Exception na) {
            Debug.warn(new Object() { }, "Unable to open resource '" + toString(from, path) + "'");
        }
        return null;
    }
    
    public static InputStream newInputStream(String   from, String path) {
        try {
            if(from != null)
                return Class.forName(from).getResourceAsStream(path);
            else
                return new                     FileInputStream(path);
        } catch(Exception na) {
            Debug.warn(new Object() { }, "Unable to open resource '" + toString(from, path) + "'");
        }
        return null;
    }
    
    public static OutputStream newOutputStream(Resource resource, boolean append) {
        if(resource.from != null)
            Debug.warn(new Object() { }, "Unable to open resource '" + resource + "'");
        else try {
            File file = new File(resource.path);
            if(!file.exists()) {
                if( file.getParentFile() != null)
                    file.getParentFile().mkdirs();
                file.createNewFile();
            }
            return new FileOutputStream(file, append);
        } catch(Exception na) {
            Debug.warn(new Object() { }, "Unable to open resource '" + resource + "'");
        }
        return null;
    }
    
    public static OutputStream newOutputStream(String   resource, boolean append) {
        return newOutputStream(new Resource(resource), append);
    }
    
    public static OutputStream newOutputStream(Resource resource) {
        return newOutputStream(resource, false);
    }
    
    public static OutputStream newOutputStream(String   resource) {
        return newOutputStream(resource, false);
    }
    
    public static byte[] readBytes(Resource resource) {
        return readBytes(newInputStream(resource), toString(resource));
    }
    
    public static byte[] readBytes(String   resource) {
        return readBytes(new Resource(resource));
    }
    
    public static byte[] readBytes(Class<?> from, String path) {
        return readBytes(newInputStream(from, path), toString(from, path));
    }
    
    public static byte[] readBytes(String   from, String path) {
        return readBytes(newInputStream(from, path), toString(from, path));
    }
    
    public static void writeBytes(Resource resource, byte[] b) {
        writeBytes(newOutputStream(resource), b, toString(resource));
    }
    
    public static void writeBytes(String   resource, byte[] b) {
        writeBytes(new Resource(resource), b);
    }
    
    public static <T> T readObject(Resource resource) {
        return readObject(newInputStream(resource), toString(resource));
    }
    
    public static <T> T readObject(String   resource) {
        return readObject(new Resource(resource));
    }
    
    public static <T> T readObject(Class<?> from, String path) {
        return readObject(newInputStream(from, path), toString(from, path));
    }
    
    public static <T> T readObject(String   from, String path) {
        return readObject(newInputStream(from, path), toString(from, path));
    }
    
    public static <T> void writeObject(Resource resource, T t) {
        writeObject(newOutputStream(resource), t, toString(resource));
    }
    
    public static <T> void writeObject(String   resource, T t) {
        writeObject(new Resource(resource), t);
    }
    
    public static String readString(Resource resource) {
        return readString(newInputStream(resource), toString(resource));
    }
    
    public static String readString(String   resource) {
        return readString(new Resource(resource));
    }
    
    public static String readString(Class<?> from, String path) {
        return readString(newInputStream(from, path), toString(from, path));
    }
    
    public static String readString(String   from, String path) {
        return readString(newInputStream(from, path), toString(from, path));
    }
    
    public static void writeString(Resource resource, Object o) {
        writeString(newOutputStream(resource), o, toString(resource));
    }
    
    public static void writeString(String   resource, Object o) {
        writeString(new Resource(resource), o);
    }
    
    public static byte[] readBytes(InputStream from, String resource) {
        if(from != null)
            try(BufferedInputStream in = new BufferedInputStream(from)) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int    length;
                byte[] buffer = new byte[1024];
                while((length = in.read(buffer)) != -1)
                    baos.write(buffer, 0, length);
                baos.flush();
                return baos.toByteArray();
            } catch (Exception na) {
                Debug.warn(new Object() { }, "Unable to read bytes from resource '" + resource + "'");
            }
        return null;
    }
    
    public static void writeBytes(OutputStream to, byte[] b, String resource) {
        if(to != null)
            try(BufferedOutputStream out = new BufferedOutputStream(to)) {
                out.write(b);
                out.flush( );
            } catch (Exception na) {
                Debug.warn(new Object() { }, "Unable to write bytes to resource '" + resource + "'");
            }
    }
    
    public static <T> T readObject(InputStream from, String resource) {
        if(from != null)
            try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(from))) {
                return Unsafe.cast(in.readObject());
            } catch (Exception na) {
                Debug.warn(new Object() { }, "Unable to read from resource '" + resource + "'");
            }
        return null;
    }
    
    public static <T> void writeObject(OutputStream to, T t, String resource) {
        if(to != null)
            try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(to))) {
                out.writeObject(t);
                out.flush      ( );
            } catch (Exception na) {
                Debug.warn(new Object() { }, "Unable to write to resource '" + resource + "'");
            }
    }
    
    public static String readString(InputStream from, String resource) {
        if(from != null)
            try(BufferedReader in = new BufferedReader(new InputStreamReader(from))) {
                StringBuilder sb = new StringBuilder();
                int c;
                while((c = in.read()) != -1)
                    sb.append((char)c);
                return sb.toString();
            } catch(Exception na) {
                Debug.warn(new Object() { }, "Unable to read string from resource '" + resource + "'");
            }
        return null;
    }
    
    public static void writeString(OutputStream to, Object o, String resource) {
        if(to != null)
            try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(to))) {
                out.write(Objects.toString(o));
                out.flush(                   );
            } catch(Exception na) {
                Debug.warn(new Object() { }, "Unable to write string to resource '" + resource + "'");
            }
    }
    
    public static <T> T onImport(Importer<T> importer, Resource resource) {
        return importer.onImport(resource);
    }
    
    public static <T> T onImport(Importer<T> importer, String   resource) {
        return onImport(importer, new Resource(resource));
    }
    
    public static <T> T onImport(Importer<T> importer, Class<?> from, String path) {
        return onImport(importer, new Resource(from, path));
    }
    
    public static <T> T onImport(Importer<T> importer, String   from, String path) {
        return onImport(importer, new Resource(from, path));
    }
    
    public static <T> void onExport(Exporter<T> exporter, Resource resource, T t) {
        exporter.onExport(resource, t);
    }
    
    public static <T> void onExport(Exporter<T> exporter, String   resource, T t) {
        onExport(exporter, new Resource(resource), t);
    }
    
    public static interface Importer<T> {
        public T    onImport(Resource resource);
    }
    
    public static interface Exporter<T> {
        public void onExport(Resource resource, T t);
    }
}
