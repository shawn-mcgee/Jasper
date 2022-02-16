package jasper.util;

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

    public default T[] toArray(T[] a) { return Sequence.toArray(this, a); }

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

    public static <T> T[] toArray(Iterable<T> a, T[] t) {
        Iterator<T> i = a.iterator();
        for(int j = 0; j < t.length && i.hasNext(); j ++)
            t[j] = i.next();
        return t;
    }

    public static <T> int count(T[] a, T t) {
        int n = 0;
        for (T u : a)
            if (Objects.equals(u, t))
                n ++;
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
                n ++;
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

    public static <T> boolean includes(T[] a, T t) {
        for (T u : a)
            if (Objects.equals(u, t))
                return true;
        return false;
    }

    public static <T> boolean excludes(T[] a, T t) {
        for (T u : a)
            if (Objects.equals(u, t))
                return false;
        return true;
    }

    @SafeVarargs
    public static <T> boolean includesAll(T[] a, T... b) {
        for (T u : b)
            if (excludes(a, u))
                return false;
        return true;
    }

    @SafeVarargs
    public static <T> boolean includesAny(T[] a, T... b) {
        for (T u : b)
            if (includes(a, u))
                return true;
        return false;
    }

    @SafeVarargs
    public static <T> boolean excludesAll(T[] a, T... b) {
        for (T u : b)
            if (includes(a, u))
                return false;
        return true;
    }

    @SafeVarargs
    public static <T> boolean excludesAny(T[] a, T... b) {
        for (T u : b)
            if (excludes(a, u))
                return true;
        return false;
    }

    public static <T> boolean includesAll(T[] a, Iterable<T> b) {
        for (T u : b)
            if (excludes(a, u))
                return false;
        return true;
    }

    public static <T> boolean includesAny(T[] a, Iterable<T> b) {
        for (T u : b)
            if (includes(a, u))
                return true;
        return false;
    }

    public static <T> boolean excludesAll(T[] a, Iterable<T> b) {
        for (T u : b)
            if (includes(a, u))
                return false;
        return true;
    }

    public static <T> boolean excludesAny(T[] a, Iterable<T> b) {
        for (T u : b)
            if (excludes(a, u))
                return true;
        return false;
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

    public static <T> Iterable<T> forward(T[] a) {
        return forward(a, a.length);
    }

    public static <T> Iterable<T> reverse(T[] a) {
        return reverse(a, a.length);
    }

    public static <T> Iterable<T> forward(T[] a, int size) {
        return () -> new Iterator<T>() {
            int
                m =    0,
                n = size;

            @Override
            public boolean hasNext() {
                return m < n;
            }

            @Override
            public T next() {
                return a[m ++];
            }
        };
    }

    public static <T> Iterable<T> reverse(T[] a, int size) {
        return () -> new Iterator<T>() {
            int
                m =    0,
                n = size;

            @Override
            public boolean hasNext() {
                return m < n;
            }

            @Override
            public T next() {
                return a[-- n];
            }
        };
    }

    public static interface Stack<T> extends Sequence<T> {
        public T push(T t);
        public T peek();
        public T pull();

        public void clear();

        @Override
        public Stack<T> copy();

        public static <T> Stack<T> from(Deque<T> deque) {
            return new Stack<T>() {
                private static final long
                    serialVersionUID = 1L;

                @Override
                public T push(T t) {
                    return deque.pushTail(t);
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
                public Stack<T> copy() {
                    return Stack.from(deque.copy());
                }

                @Override
                public String toString() {
                    return deque.toString();
                }
            };
        }
    }

    public static interface Queue<T> extends Sequence<T> {
        public T push(T t);
        public T peek();
        public T pull();

        public void clear();

        @Override
        public Queue<T> copy();

        public static <T> Queue<T> from(Deque<T> deque) {
            return new Queue<T>() {
                private static final long
                    serialVersionUID = 1L;

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

                @Override
                public String toString() {
                    return deque.toString();
                }
            };
        }
    }

    public static interface Deque<T> extends Sequence<T> {
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