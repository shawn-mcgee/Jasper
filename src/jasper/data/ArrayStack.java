package jasper.data;

import jasper.util.Unsafe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static jasper.util.Utility.copyOf;

public class ArrayStack<T> implements Array<T>, Stack<T> {
    private static final long
        serialVersionUID = 1L;
    protected final transient Forward<T>
        forward = new Forward<>(this);
    protected final transient Reverse<T>
        reverse = new Reverse<>(this);
    
    protected Object[]
        a;
    protected int
        size;
    
    public ArrayStack() {
        this(0);
    }
    
    public ArrayStack(int n) {
        int
            l = n > 15 ? n + 1 : 16,
            m = n > 0  ? n     :  0;
        a = new Object[l];
        size = m;
    }
    
    @SafeVarargs
    public ArrayStack(T... t) {
        this(t.length);
    
        System.arraycopy(t, 0, a, 0, t.length);
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Forward<T> forward() {
        return forward;
    }
    
    @Override
    public Iterable<T> reverse() {
        return reverse;
    }
    
    @Override
    public Iterator<T> iterator() {
        return forward.iterator();
    }
    
    @Override
    public T set(int i, T t) {
        return i >= 0 && i < size ? Unsafe.cast(a[i] = t) : null;
    }
    
    @Override
    public T get(int i     ) {
        return i >= 0 && i < size ? Unsafe.cast(a[i]    ) : null;
    }
    
    @Override
    public int index(       T t) {
        return index(0, t);
    }
    
    @Override
    public int index(int i, T t) {
        for (int j = i; j < size; j++)
            if (Objects.equals(a[j], t))
                return j;
        return -1;
    }
    
    @Override
    public T insert(       T t) {
        return insert(size, t);
    }
    
    @Override
    public T insert(int i, T t) {
        if (i >= 0 && i <= size) {
            if (i == size)
                return push(t);
            
            if (size >= a.length)
                increase();
            
            for (int j = size; j > i; j--)
                a[j] = a[j - 1];
            size++;
            
            return Unsafe.cast(a[i] = t);
        } else
            return null;
    }
    
    @Override
    public T remove(T   t) {
        return remove(index(t));
    }
    
    @Override
    public T remove(int i) {
        if (i >= 0 && i < size) {
            
            Object t = a[i];
            for (int j = i; j < size - 1; j++)
                a[j] = a[j + 1];
            size--;
            
            return Unsafe.cast(t);
        } else
            return null;
    }
    
    @Override
    public void resize(int n) {
        int
            l = n > 15 ? n + 1 : 16,
            m = n >  0 ? n     :  0;
        Object[] b =  new Object[l];
        System.arraycopy(a, 0, b, 0, m);
        
        a    = b;
        size = m;
    }
    
    @Override
    public void clear() {
        resize(0);
    }
    
    @Override
    public T push(T t) {
        if (size >= a.length)
            increase();
        return Unsafe.cast(a[size++] = t);
    }
    
    @Override
    public T peek() {
        return size > 0 ? Unsafe.cast(a[size - 1]) : null;
    }
    
    @Override
    public T pull() {
        return size > 0 ? Unsafe.cast(a[ -- size]) : null;
    }
    
    @Override
    public ArrayStack<T> copy() {
        ArrayStack<T> copy = new ArrayStack<>(size);
        for (int i = 0; i < size; i++)
            copy.a[i] = copyOf(a[i]);
        return copy;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(a);
//        return Serial.toString(this);
    }
    
    protected void increase() {
        Object[] b = new Object[a.length + (a.length >> 1)];
        System.arraycopy(a, 0, b, 0, a.length);
        a = b;
    }
    
    protected void decrease() {
        Object[] b = new Object[a.length - (a.length >> 1)];
        System.arraycopy(a, 0, b, 0, b.length);
        a = b;
    }
    
    public static class Forward<T> implements Iterable<T> {
        protected final ArrayStack<T>
            a;
        
        public Forward(ArrayStack<T> a) {
            this.a = a;
        }
        
        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private int
                    m =      0,
                    n = a.size;
                
                @Override
                public boolean hasNext() {
                    return m < n;
                }
                
                @Override
                public T next() {
                    return Unsafe.cast(a.a[m ++]);
                }
            };
        }
    }
    
    public static class Reverse<T> implements Iterable<T> {
        protected final ArrayStack<T>
            a;
        
        public Reverse(ArrayStack<T> a) {
            this.a = a;
        }
        
        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                private int
                    m =      0,
                    n = a.size;
                
                @Override
                public boolean hasNext() {
                    return m < n;
                }
                
                @Override
                public T next() {
                    return Unsafe.cast(a.a[-- n]);
                }
            };
        }
    }
}
