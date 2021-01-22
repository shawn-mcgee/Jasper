package jasper.util;

import java.util.Iterator;

public abstract class Array<T> implements List<T> {
    private static final long
        serialVersionUID = 1L;
    protected final transient Array.Forward<T>
        forward = new Array.Forward<>(this);
    protected final transient Array.Reverse<T>
        reverse = new Array.Reverse<>(this);
    protected Object[]
        a;
    protected int
        size;
    
    public Array() {
        this(0);
    }
    
    public Array(int n) {
        int
            l = n > 15 ? n + 1 : 16,
            m = n > 0  ? n     :  0;
        a = new Object[l];
        size = m;
    }
    
    @SafeVarargs
    public Array(T... t) {
        this(t.length);
        
        System.arraycopy(t, 0, a, 0, t.length);
    }
    
    public abstract T set(int i, T t);
    
    public abstract T get(int i);
    
    public abstract T insert(T t);
    
    public abstract T insert(int i, T t);
    
    public abstract T remove(T t);
    
    public abstract T remove(int i);
    
    public abstract int index(T t);
    
    public abstract int index(int i, T t);
    
    public abstract void resize(int n);
    
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Forward<T> forward() {
        return forward;
    }
    
    @Override
    public Reverse<T> reverse() {
        return reverse;
    }
    
    @Override
    public Iterator<T> iterator() {
        return forward.iterator();
    }
    
    @Override
    public abstract Array<T> copy();
    
    @Override
    public String toString() {
        return List.toString(this);
    }
    
    public static class Forward<T> implements Iterable<T> {
        protected final Array<T>
            array;
        
        public Forward(Array<T> array) {
            this.array = array;
        }
        
        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private int
                    a =          0,
                    b = array.size;
                
                @Override
                public boolean hasNext() {
                    return a < b;
                }
                
                @Override
                public T next() {
                    return array.get(a++);
                }
            };
        }
    }
    
    public static class Reverse<T> implements Iterable<T> {
        protected final Array<T>
            array;
        
        public Reverse(Array<T> array) {
            this.array = array;
        }
        
        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private int
                    a =          0,
                    b = array.size;
                
                @Override
                public boolean hasNext() {
                    return a < b;
                }
                
                @Override
                public T next() {
                    return array.get(--b);
                }
            };
        }
    }
}
