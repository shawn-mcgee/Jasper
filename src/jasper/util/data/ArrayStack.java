package jasper.util.data;

import jasper.util.Unsafe;

import java.util.Objects;

import static jasper.util.Utility.copyOf;

public class ArrayStack<T> extends Array<T> implements Serial.Stack<T> {
    private static final long
        serialVersionUID = 1L;

    public ArrayStack() {
        super();
    }

    public ArrayStack(int  n) {
        super(n);
    }

    @SafeVarargs
    public ArrayStack(T... t) {
        super(t);
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
    public T insert(       T t) {
        return insert(size, t);
    }

    @Override
    public T insert(int i, T t) {
        if(i >= 0 && i <= size) {
            if(i == size)
                return push(t);

            if(size >= a.length)
                increase();

            for(int j = size; j > i; j --)
                a[j] = a[j  - 1];
            size ++;

            return Unsafe.cast(a[i] = t);
        } else
            return                  null;
    }

    @Override
    public T remove(T   t) {
        return remove(index(t));
    }

    @Override
    public T remove(int i) {
        if(i >= 0 && i < size) {

            Object t = a[i];
            for(int j = i; j < size - 1; j ++)
                a[j] = a[j + 1];
            size --;

            return Unsafe.cast(t);
        } else
            return           null;
    }

    @Override
    public int index(       T t) {
        return index(0, t);
    }

    @Override
    public int index(int i, T t) {
        for(int j = i; j < size; j ++)
            if(Objects.equals(a[j], t))
                return j;
        return -1;
    }

    @Override
    public void resize(int n) {
        int
//            l = n > 15 ? n + 1 : 16,
            m = n >  0 ? n     :  0;
        Object[] b = new Object[n];
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
        if(size >= a.length)
            increase();
        return Unsafe.cast(a[size ++] = t);
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
        for(int i = 0; i < size; i ++)
            copy.a[i] = copyOf(a[i]);
        return copy;
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
}
