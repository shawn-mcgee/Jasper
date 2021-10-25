package jasper.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static jasper.util.Copyable.copyOf;

public interface Array<T> extends Sequence<T> {
    
    public abstract T set(int i, T t);
    public abstract T get(int i     );
    
    public abstract int index(       T t);
    public abstract int index(int i, T t);
    
    public abstract T insert(       T t);
    public abstract T insert(int i, T t);
    public abstract T remove(T   t);
    public abstract T remove(int i);
    
    public abstract void resize(int n);
    
    @Override
    public Array<T> copy();
    
    class Deque<T> implements Array<T>, Sequence.Deque<T> {
        private static final long
            serialVersionUID = 1L;
        protected final transient Forward<T>
            forward = new Forward<>(this);
        protected final transient Reverse<T>
            reverse = new Reverse<>(this);
        
        protected Object[]
            a;
        protected int
            size,
            head,
            tail;
    
        public Deque() {
            this(0);
        }
    
        public Deque(int n) {
            int
                l = n > 15 ? n + 1 : 16,
                m = n >  0 ? n     :  0;
            a = new Object[l];
            head = l - 1;
            tail = m;
            size = m;
        }
    
        @SafeVarargs
        public Deque(T... t) {
            this(t.length);
    
            System.arraycopy(t, 0, a, 0, t.length);
        }
        
        @Override
        public int size() {
            return size;
        }
        
        @Override
        public Iterable<T> forward() {
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
            return i >= 0 && i < size ? Unsafe.cast(a[at(i)] = t) : null;
        }
    
        @Override
        public T get(int i) {
            return i >= 0 && i < size ? Unsafe.cast(a[at(i)]    ) : null;
        }
        
        @Override
        public int index(       T t) {
            return index(0, t);
        }
        
        @Override
        public int index(int i, T t) {
            for (int j = i; j < size; j++)
                if (Objects.equals(a[at(i)], t))
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
                if (i == 0)
                    return pushHead(t);
                else if (i == size)
                    return pushTail(t);
    
                if (head == tail)
                    increase();
    
                for (int j = size; j > i; j--) {
                    int
                        m = (j + head + 1) % a.length,
                        n = (j + head    ) % a.length;
                    a[m] = a[n];
                }
    
                size ++;
                tail = increment(tail);
                a[(i + head + 1) % a.length] = t;
    
                return t;
            } else
                return null;
        }
    
        @Override
        public T remove(T   t) {
            int i = index(t);
            return remove(i);
        }
    
        @Override
        public T remove(int i) {
            if (i >= 0 && i < size) {
                T t = Unsafe.cast(a[(i + head + 1) % a.length]);
    
                for (int j = i; j < size - 1; j++) {
                    int
                        m = (j + head + 1) % a.length,
                        n = (j + head + 2) % a.length;
                    a[m] = a[n];
                }
                size --;
                tail --;
                a[tail] = null;
    
                return t;
            } else
                return null;
        }
    
        @Override
        public void resize(int n) {
            int
                l = n > 7 ? n + 1 : 16,
                m = n > 0 ? n     :  0;
            Object[] b = new Object[l];
            for (int i = 0; i < m && i < size; i++)
                b[i] = a[at(i)];
            a    = b;
            head = l - 1;
            tail = m;
            size = m;
        }
    
        @Override
        public void clear() {
            resize(0);
        }
    
        @Override
        public T pushHead(T t) {
            if (head == tail)
                increase();
    
            size ++;
            a[head] = t;
            head = decrement(head);
    
            return t;
        }
    
        @Override
        public T peekHead() {
            if (size > 0) {
                return Unsafe.cast(a[      increment(head)]);
            } else
                return null;
        }
    
        @Override
        public T pullHead() {
            if (size > 0) {
                T t = Unsafe.cast(a[head = increment(head)]);
                a[head] = null;
                size --;
    
                return t;
            } else
                return null;
        }
    
        @Override
        public T pushTail(T t) {
            if (head == tail)
                increase();
    
            size++;
            a[tail] = t;
            tail = increment(tail);
    
            return t;
        }
    
        @Override
        public T peekTail() {
            if (size > 0) {
                return Unsafe.cast(a[      decrement(tail)]);
            } else
                return null;
        }
    
        @Override
        public T pullTail() {
            if (size > 0) {
                T t = Unsafe.cast(a[tail = decrement(tail)]);
                a[tail] = null;
                size--;
    
                return t;
            } else
                return null;
        }
    
    
        @Override
        public Array.Deque<T> copy() {
            Array.Deque<T> copy = new Array.Deque<>(size);
            int i = 0;
            for (T t : this)
                copy.a[i ++] = copyOf(t);
            copy.head = copy.a.length - 1;
            copy.tail = size;
            return copy;
        }
        
        @Override
        public String toString() {
            return Sequence.toString(this);
        }
        
        protected int at(int i) {
            int j;
            return (j = head + i + 1) >= a.length ? j - a.length : j;
        }
    
        protected int increment(int i) {
            int j;
            return (j = i + 1) >= a.length ?            0 : j;
        }
    
        protected int decrement(int i) {
            int j;
            return (j = i - 1) < 0         ? a.length - 1 : j;
        }
    
        protected void increase() {
            int
                m = a.length,
                n = a.length << 1;
            Object[] b = new Object[n];
            int
                h0 =     head + 1,
                h1 = m - head - 1;
            System.arraycopy(a, h0, b,  0,   h1);
            System.arraycopy(a,  0, b, h1, tail);
            head = n - 1;
            tail = m - 1;
            a = b;
        }
    
        protected void decrease() {
    
        }
        
        public static class Forward<T> implements Iterable<T> {
            protected final Array.Deque<T>
                a;
            
            public Forward(Array.Deque<T> a) {
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
                        return Unsafe.cast(a.a[a.at(m ++)]);
                    }
                };
            }
        }
        
        public static class Reverse<T> implements Iterable<T> {
            protected final Array.Deque<T>
                a;
            
            public Reverse(Array.Deque<T> a) {
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
                        return Unsafe.cast(a.a[a.at(-- n)]);
                    }
                };
            }
        }
    }
    
    class Stack<T> implements Array<T>, Sequence.Stack<T> {
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
        
        public Stack() {
            this(0);
        }
        
        public Stack(int n) {
            int
                l = n > 15 ? n + 1 : 16,
                m = n > 0  ? n     :  0;
            a = new Object[l];
            size = m;
        }
        
        @SafeVarargs
        public Stack(T... t) {
            this(t.length);
        
            System.arraycopy(t, 0, a, 0, t.length);
        }
        
        @Override
        public int size() {
            return size;
        }
        
        @Override
        public Iterable<T> forward() {
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
        public Array.Stack<T> copy() {
            Array.Stack<T> copy = new Array.Stack<>(size);
            for (int i = 0; i < size; i++)
                copy.a[i] = copyOf(a[i]);
            return copy;
        }
        
        @Override
        public String toString() {
            return Arrays.toString(a);
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
            protected final Array.Stack<T>
                a;
            
            public Forward(Array.Stack<T> a) {
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
            protected final Array.Stack<T>
                a;
            
            public Reverse(Array.Stack<T> a) {
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
}