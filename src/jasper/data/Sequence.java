package jasper.data;

import jasper.util.Copyable;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

public interface Sequence<T> extends Copyable<Sequence<T>>, Iterable<T>, Serializable {
    public int size();
    
    public Iterable<T> forward();
    public Iterable<T> reverse();
    
    public default boolean includes(T t) {
        return Sequence.includes(this, t);
    }
    
    public default boolean excludes(T t) {
        return Sequence.excludes(this, t);
    }
    
    public static <T> String toString(Iterable<T> a) {
        return toString(a, "%s");
    }
    
    public static <T> String toString(Iterable<T> a, String f) {
        Iterator<T> i = a.iterator();
        
        StringBuilder s = new StringBuilder();
        String g = ", " + f;
        
        s.append("{");
        if (i.hasNext())
            s.append(String.format(f, i.next()));
        while (i.hasNext())
            s.append(String.format(g, i.next()));
        s.append("}");
        
        return s.toString();
    }
    
    public static <T> int count(T[] a, T t) {
        int n = 0;
        for (T u : a)
            if (Objects.equals(u, t))
                n++;
        return n;
    }
    
    public static <T> int index(T[] a, T t) {
        int i = 0;
        for (T u : a) {
            if (Objects.equals(u, t))
                return i;
            i++;
        }
        return -1;
    }
    
    public static <T> int count(Iterable<T> a, T t) {
        int n = 0;
        for (T u : a)
            if (Objects.equals(u, t))
                n++;
        return n;
    }
    
    public static <T> int index(Iterable<T> a, T t) {
        int i = 0;
        for (T u : a) {
            if (Objects.equals(u, t))
                return i;
            i++;
        }
        return -1;
    }
    
    public static <T> boolean includes(Iterable<T> a, T t) {
        for (T u : a)
            if (Objects.equals(u, t))
                return true;
        return false;
    }
    
    public static <T> boolean excludes(Iterable<T> a, T t) {
        for (T u : a)
            if (Objects.equals(u, t))
                return false;
        return true;
    }
    
    @SafeVarargs
    public static <T> boolean includesAll(Iterable<T> a, T... b) {
        for (T u : b)
            if (excludes(a, u))
                return false;
        return true;
    }
    
    @SafeVarargs
    public static <T> boolean includesAny(Iterable<T> a, T... b) {
        for (T u : b)
            if (includes(a, u))
                return true;
        return false;
    }
    
    @SafeVarargs
    public static <T> boolean excludesAll(Iterable<T> a, T... b) {
        for (T u : b)
            if (includes(a, u))
                return false;
        return true;
    }
    
    @SafeVarargs
    public static <T> boolean excludesAny(Iterable<T> a, T... b) {
        for (T u : b)
            if (excludes(a, u))
                return true;
        return false;
    }
    
    public static <T> boolean includesAll(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (excludes(a, u))
                return false;
        return true;
    }
    
    public static <T> boolean includesAny(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (includes(a, u))
                return true;
        return false;
    }
    
    public static <T> boolean excludesAll(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (includes(a, u))
                return false;
        return true;
    }
    
    public static <T> boolean excludesAny(Iterable<T> a, Iterable<T> b) {
        for (T u : b)
            if (excludes(a, u))
                return true;
        return false;
    }
    
}
