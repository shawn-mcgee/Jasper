package jasper.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

public interface List<T> extends Copyable<List<T>>, Iterable<T>, Serializable {
    public int size();
    
    public Iterable<T> forward();
    public Iterable<T> reverse();
    
    public default boolean includes(T t) {
        return List.includes(this, t);
    }
    
    public default boolean excludes(T t) {
        return List.excludes(this, t);
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
    
    public static interface Stack<T> extends List<T> {
        public T push(T t);
        
        public T peek();
        
        public T pull();
        
        public void clear();
        
        @Override
        public Stack<T> copy();
        
        public static <T> Stack<T> from(final Deque<T> deque) {
            return new Stack<>() {
                
                @Override
                public T push(T t) {
                    return deque.pushHead(t);
                }
                
                @Override
                public T peek() {
                    return deque.peekHead();
                }
                
                @Override
                public T pull() {
                    return deque.pullHead();
                }
                
                @Override
                public void clear() {
                    deque.clear();
                }
                
                @Override
                public int size() {
                    return deque.size();
                }
                
                @Override
                public Iterable<T> forward() {
                    return deque.forward();
                }
                
                @Override
                public Iterable<T> reverse() {
                    return deque.reverse();
                }
                
                @Override
                public Iterator<T> iterator() {
                    return deque.iterator();
                }
                
                @Override
                public Stack<T> copy() {
                    return Stack.from(deque.copy());
                }
            };
        }
    }
    
    public static interface Queue<T> extends List<T> {
        public T push(T t);
        
        public T peek();
        
        public T pull();
        
        public void clear();
        
        @Override
        public Queue<T> copy();
        
        public static <T> Queue<T> from(final Deque<T> deque) {
            return new Queue<>() {
                
                @Override
                public T push(T t) {
                    return deque.pushHead(t);
                }
                
                @Override
                public T peek() {
                    return deque.peekTail();
                }
                
                @Override
                public T pull() {
                    return deque.pullTail();
                }
                
                @Override
                public void clear() {
                    deque.clear();
                }
                
                @Override
                public int size() {
                    return deque.size();
                }
                
                @Override
                public Iterable<T> forward() {
                    return deque.forward();
                }
                
                @Override
                public Iterable<T> reverse() {
                    return deque.reverse();
                }
                
                @Override
                public Iterator<T> iterator() {
                    return deque.iterator();
                }
                
                @Override
                public Queue<T> copy() {
                    return Queue.from(deque.copy());
                }
            };
        }
    }
    
    public static interface Deque<T> extends List<T> {
        public T pushHead(T t);
        
        public T peekHead();
        
        public T pullHead();
        
        public T pushTail(T t);
        
        public T peekTail();
        
        public T pullTail();
        
        public void clear();
        
        @Override
        public Deque<T> copy();
    }
}
