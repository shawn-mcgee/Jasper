package jasper.data;

import jasper.util.Unsafe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import static jasper.util.Utility.copyOf;

public class ArrayDeque<T> implements Array<T>, Deque<T> {
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

    public ArrayDeque() {
        this(0);
    }

    public ArrayDeque(int n) {
        int
            l = n > 15 ? n + 1 : 16,
            m = n >  0 ? n     :  0;
        a = new Object[l];
        head = l - 1;
        tail = m;
        size = m;
    }

    @SafeVarargs
    public ArrayDeque(T... t) {
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
    public ArrayDeque<T> copy() {
        ArrayDeque<T> copy = new ArrayDeque<>(size);
        int i = 0;
        for (T t : this)
            copy.a[i ++] = copyOf(t);
        copy.head = copy.a.length - 1;
        copy.tail = size;
        return copy;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(a);
//        return Serial.toString(this);
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
            h0 = head + 1,
            h1 = m - head - 1;
        System.arraycopy(a, h0, b, 0, h1);
        System.arraycopy(a, 0, b, h1, tail);
        head = n - 1;
        tail = m - 1;
        a = b;
    }

    protected void decrease() {

    }
    
    public static class Forward<T> implements Iterable<T> {
        protected final ArrayDeque<T>
            a;
        
        public Forward(ArrayDeque<T> a) {
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
        protected final ArrayDeque<T>
            a;
        
        public Reverse(ArrayDeque<T> a) {
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
